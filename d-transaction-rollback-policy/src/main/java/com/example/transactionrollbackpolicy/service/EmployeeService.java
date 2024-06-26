package com.example.transactionrollbackpolicy.service;

import com.example.transactionrollbackpolicy.doa.EmployeeDao;
import com.example.transactionrollbackpolicy.ds.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeDao employeeDao;

    public void deleteAllEmployee(){
        employeeDao.deleteAllEmployee();
    }

    public List<Employee> listAllEmployees(){
        return employeeDao.listEmployee();
    }

    private void create5Employees(){
        employeeDao.createEmployee("John","Doe",
                "john@gmail.com","55-555-55",
                Date.valueOf("2023-03-22"),2000);
        employeeDao.createEmployee("John","William",
                "william@gmail.com","55-555-55",
                Date.valueOf("2023-03-22"),3000);
        employeeDao.createEmployee("John","Updike",
                "updike@gmail.com","55-555-55",
                Date.valueOf("2023-03-22"),2500);
        employeeDao.createEmployee("John","Williamson",
                "williamson@gmail.com","55-555-55",
                Date.valueOf("2023-03-22"),4000);
        employeeDao.createEmployee("Thomas","Hardy",
                "thomas@gmail.com","55-555-55",
                Date.valueOf("2023-03-22"),3500);



    }
    @Transactional
    public void creteEmployeeWithTransaction()throws InterruptedException{
        create5Employees();
        throw new InterruptedException();
    }

    public void createEmployeeWithoutTransaction(){
        create5Employees();
    }
}
