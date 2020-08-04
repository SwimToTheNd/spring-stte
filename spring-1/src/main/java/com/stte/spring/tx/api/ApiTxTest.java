package com.stte.spring.tx.api;

import com.stte.spring.jdbc.util.JdbcUtil;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * API编码方式实现Spring事务
 * create by BloodFly at 2020/7/4
 */
public class ApiTxTest {


    public static void main(String[] args) {
        DataSource dataSource = new DriverManagerDataSource(JdbcUtil.url, JdbcUtil.userName, JdbcUtil.passwd);
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(new DataSourceTransactionManager(dataSource));
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                    Connection connection = JdbcUtil.getConnection(false);
                Object savepoint = null;
                try {

                    {
                        PreparedStatement preparedStatement = connection.prepareStatement("insert into account (user_name,balance) value (?, ?)");
                        preparedStatement.setString(1, "花荣");
                        preparedStatement.setBigDecimal(2, new BigDecimal("44892.99"));
                        preparedStatement.executeUpdate();
                    }

                    // 设置保存点
                    savepoint = transactionStatus.createSavepoint();

                    {
                        PreparedStatement preparedStatement = connection.prepareStatement("insert into account (user_name,balance) value (?, ?)");
                        preparedStatement.setString(1, "钟奎");
                        preparedStatement.setBigDecimal(2, new BigDecimal("84892.99"));
                        preparedStatement.executeUpdate();
                    }

                    {
                        PreparedStatement preparedStatement = connection.prepareStatement("update account set balance = ? where user_name = ?");
                        preparedStatement.setBigDecimal(1, new BigDecimal("74772.99"));
                        preparedStatement.setString(2, "钟奎11");
                        Assert.isTrue(preparedStatement.executeUpdate() > 0, "未更新");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    System.out.println("更新失败。。。。。");
                    if (savepoint != null) {
                        transactionStatus.rollbackToSavepoint(savepoint);
                        System.out.println("回滚到保存点。。。。。");
                    } else {
                        transactionStatus.setRollbackOnly();
                    }
                    e.printStackTrace();
                }

                return null;
            }
        });

    }
}
