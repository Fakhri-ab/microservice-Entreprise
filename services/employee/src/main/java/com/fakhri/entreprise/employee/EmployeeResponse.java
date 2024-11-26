package com.fakhri.entreprise.employee;

public record EmployeeResponse(
        Integer id ,
        String name ,
        int age ,
        String position ,
        Long departmentId
) {
}
