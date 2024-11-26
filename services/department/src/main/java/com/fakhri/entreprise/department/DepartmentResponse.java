package com.fakhri.entreprise.department;

import com.fakhri.entreprise.Client.Employee;

import java.util.List;

public record DepartmentResponse(
         Integer id,
         String name,
         List<Employee> employees
) {
}
