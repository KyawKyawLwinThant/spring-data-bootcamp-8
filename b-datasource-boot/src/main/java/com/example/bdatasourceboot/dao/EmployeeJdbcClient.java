package com.example.bdatasourceboot.dao;

import com.example.bdatasourceboot.ds.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeJdbcClient {
    // E = MC^2 == Error = More Code
    private final JdbcClient jdbcClient;

    public List<Employee> findAllEmployees(){
        return jdbcClient.sql("select * from employee")
                .query(Employee.class)
                .list();
    }
}
