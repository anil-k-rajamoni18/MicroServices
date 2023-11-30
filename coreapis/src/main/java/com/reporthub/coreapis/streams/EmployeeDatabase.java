package com.reporthub.coreapis.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class EmployeeDatabase {

    public static List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();
        for(int i = 1; i<=10000000; i++) {
            Employee employee = new Employee(1, "employee"+i, "A", (double) new Random().nextInt(100 * 100));
            employeeList.add(employee);
        }

        return Objects.requireNonNull(employeeList);
    }
}
