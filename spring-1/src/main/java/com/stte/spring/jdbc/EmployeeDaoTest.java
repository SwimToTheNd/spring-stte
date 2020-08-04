package com.stte.spring.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * create by BloodFly at 2020/6/25
 */
public class EmployeeDaoTest {

    private ApplicationContext context;

    {
        context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
    }

    @Test
    public void testSave() {
        EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
        Employee employee = new Employee();
        employee.setLastName("林冲");
        employee.setEmail("lingchong@qq.com");
        employee.setDpetId(UUID.randomUUID().toString());
        int result = employeeDao.save(employee);
        System.out.println("save result: " + result);
    }

    @Test
    public void testBatchSave() {
        EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("宋江", "shongjiang@11.com", UUID.randomUUID().toString()));
        employees.add(new Employee("张飞", "zhangfei@11.com", UUID.randomUUID().toString()));
        int[] result = employeeDao.batchSave(employees);
        System.out.println("save result: " + Arrays.toString(result));
    }

    @Test
    public void testBatchSave3() {
        EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("关羽", "guanyu@22.com", UUID.randomUUID().toString()));
        employees.add(new Employee("刘备", "liubei@33.com", UUID.randomUUID().toString()));
        int[] result = employeeDao.batchSave3(employees);
        System.out.println("save result: " + Arrays.toString(result));
    }

    @Test
    public void testDelete() {
        EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
        Employee employee = new Employee();
        employee.setId(10);
        int result = employeeDao.delete(employee);
        System.out.println(result);
    }
    @Test
    public void testQuery() {
        EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
        Employee employee = employeeDao.query(10);
        System.out.println(employee);
    }

    @Test
    public void testQueryList() {
        EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
        List<Employee> employees = employeeDao.queryList();
        System.out.println(employees);
    }

    @Test
    public void queryIdIn() {
        EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
        List<Employee> employees = employeeDao.queryIdIn(Arrays.asList(8, 9));
        System.out.println(employees);
    }
}
