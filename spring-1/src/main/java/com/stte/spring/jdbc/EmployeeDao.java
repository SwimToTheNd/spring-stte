package com.stte.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by BloodFly at 2020/6/25
 */
@Repository
public class EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int save(Employee employee) {
        String sql = "insert into employee (last_name, email, dpet_id) value (?, ?, ?)";
        int result = jdbcTemplate.update(sql, employee.getLastName(), employee.getEmail(), employee.getDpetId());
        return result;
    }

    public int[] batchSave2(List<Employee> employees) {
        StringBuilder sql = new StringBuilder("insert into employee (last_name, email, dpetId) values ");
        List<Object[]> args = new ArrayList<>();
        for (Employee employee : employees) {
            sql.append("(?,?,?),");
            Object[] arg = new Object[3];
            arg[0] = employee.getLastName();
            arg[1] = employee.getEmail();
            arg[2] = employee.getDpetId();
            args.add(arg);
        }
        sql.replace(sql.length() - 1, sql.length(), "");
        System.out.println("batchSave sql:" + sql.toString());
        return jdbcTemplate.batchUpdate(sql.toString(), args);
    }

    public int[] batchSave(List<Employee> employees) {
        String sql = new String("insert into employee (last_name, email, dpet_id) value (?, ?, ?) ");
        List<Object[]> args = new ArrayList<>();
        for (Employee employee : employees) {
            Object[] arg = new Object[3];
            arg[0] = employee.getLastName();
            arg[1] = employee.getEmail();
            arg[2] = employee.getDpetId();
            args.add(arg);
        }
        return jdbcTemplate.batchUpdate(sql, args);
    }

    public int delete(Employee employee) {
        String sql = "delete from employee where id = ?";
        return jdbcTemplate.update(sql, employee.getId());
    }

    /**
     * queryForObject查询单行
     *
     * @param id
     * @return
     */
    public Employee query(int id) {
        String sql = "select * from employee where id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    /**
     * query查询多行
     * @return
     */
    public List<Employee> queryList() {
        String sql = "select * from employee";
        List<Employee> employees = jdbcTemplate.query(sql, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setDpetId(resultSet.getString("dpet_id"));
                return employee;
            }
        });
        return employees;
    }

    /**
     * 在 SQL 语句中使用具名参数时, 可以在一个 Map 中提供参数值, 参数名为键
     * 也可以使用 SqlParameterSource 参数
     * 批量更新时可以提供 Map 或 SqlParameterSource 的数组
     * @param ids
     * @return
     */
    public List<Employee> queryIdIn(List<Integer> ids) {
        String sql = "select * from employee where id IN (:itemIds)";
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("itemIds", ids);
        List<Employee> result = namedParameterJdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(Employee.class));
        return  result;
    }

    public int[] batchSave3(List<Employee> employees) {
        String sql = new String("insert into employee (last_name, email, dpet_id) value (:lastName, :email, :dpetId) ");
        SqlParameterSource[] sqlParameterSources = new SqlParameterSource[employees.size()];
        for (int i = 0; i < employees.size(); i++) {
            sqlParameterSources[i] = new BeanPropertySqlParameterSource(employees.get(i));
        }
        return namedParameterJdbcTemplate.batchUpdate(sql, sqlParameterSources);
    }
}
