package org.example;

import org.example.dao.EmployeeDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
yyyy-MM-dd
2024-03-25

dd-MM-yyyy
25-03-2024
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();
        EmployeeDao employeeDao=context.getBean(EmployeeDao.class);
        employeeDao.listEmails()
                .forEach(System.out::println);
    }
}