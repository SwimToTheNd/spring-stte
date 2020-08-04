package com.stte.spring.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * 不推荐使用 JdbcDaoSupport, 而推荐直接使用 JdbcTempate 作为 Dao 类的成员变量
 * create by BloodFly at 2020/6/25
 */
public class EmployeeDaoSupport extends JdbcDaoSupport {

    public Employee get(Integer id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return getJdbcTemplate().queryForObject(sql, rowMapper, id);
    }

}
