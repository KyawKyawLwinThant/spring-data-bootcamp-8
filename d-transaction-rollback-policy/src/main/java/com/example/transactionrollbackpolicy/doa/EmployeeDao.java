package com.example.transactionrollbackpolicy.doa;

import com.example.transactionrollbackpolicy.ds.Employee;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.List;

@Repository
public class EmployeeDao {
    private JdbcClient jdbcClient;
    public EmployeeDao(DataSource dataSource){
        jdbcClient=JdbcClient.create(dataSource);
    }
    public void deleteAllEmployee(){
        jdbcClient.sql("delete from employee")
                .update();
    }

    public List<Employee> listEmployee(){
        return jdbcClient.sql("select * from employee")
                .query(Employee.class)
                .list();
    }

    public void createEmployee(String firstName,
                               String lastName,
                               String email,
                               String phoneNumber,
                               Date startDate,
                              double salary){
//        if(salary < 0){
//            throw new IllegalArgumentException(salary + " must be greater than zero.");
//        }
        jdbcClient.sql("""
                insert into employee(first_name,last_name,email,phone_number,start_date,salary)
                values
                (?,?,?,?,?,?)
                """)
                .params(List.of(firstName,lastName,email,
                        phoneNumber,startDate,salary))
                .update();
    }
}
