package com.stte.spring.ioc;

/**
 * create by BloodFly at 2020/6/7
 */
public class Dao {

    private String dataSource = "dbcp";

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String toString() {
        return "Dao{" +
                "dataSource='" + dataSource + '\'' +
                '}';
    }
}
