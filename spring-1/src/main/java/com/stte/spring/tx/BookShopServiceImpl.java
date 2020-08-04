package com.stte.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * create by BloodFly at 2020/6/26
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    /**
     * @param username
     * @param isbn
     * @Transactional 注解来标注事务方法
     * <p>
     * 根据 Spring AOP 基于代理机制, 只能标注公有方法.可以在方法或者类级别上添加 @Transactional 注解.
     * 当把这个注解应用到类上时, 这个类中的所有公共方法都会被定义成支持事务处理的.
     * <p>
     * 添加事务注解
     * 1.使用 propagation 指定事务的传播行为, 即当前的事务方法被另外一个事务方法调用时
     * 如何使用事务, 默认取值为 REQUIRED, 即使用调用方法的事务
     * REQUIRES_NEW: 事务自己的事务, 调用的事务方法的事务被挂起.
     * <p>
     * 2.使用 isolation 指定事务的隔离级别, 最常用的取值为 READ_COMMITTED
     * <p>
     * 3.默认情况下 Spring 的声明式事务对所有的运行时异常进行回滚. 也可以通过对应的属性进行设置. 通常情况下去默认值即可.
     * 默认情况下只有未检查异常(RuntimeException和Error类型的异常)会导致事务回滚. 而受检查异常不会.
     * <p>
     * 4.使用 readOnly 指定事务是否为只读. 表示这个事务只读取数据但不更新数据, 这样可以帮助数据库引擎优化事务. 若真的是一个只读取数据库值的方法, 应设置 readOnly=true
     * <p>
     * 5.使用 timeout 指定强制回滚之前事务可以占用的时间.
     * 超时事务属性: 事务在强制回滚之前可以保持多久. 这样可以防止长期运行的事务占用资源.
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.REPEATABLE_READ,
            readOnly = false,
            noRollbackFor = AccountException.class,
            timeout = 3)
    @Override
    public void purchase(String username, String isbn) {

        // 测试timeout
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 查询书价
        double bookPrice = bookShopDao.findBookPriceByIsbn(isbn);
        System.out.println("书：" + isbn + " 价格：" + bookPrice);
        // 修改库存
        int result = bookShopDao.updateBookStock(isbn);
        System.out.println("减少库存update结果：" + result);
        // 减少余额
        result = bookShopDao.updateUserAccount(username, bookPrice);
        System.out.println("减少余额update结果：" + result);
    }
}
