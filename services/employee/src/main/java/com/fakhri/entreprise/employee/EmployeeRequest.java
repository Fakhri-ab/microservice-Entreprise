package com.fakhri.entreprise.employee ;

public record EmployeeRequest(
         Integer id ,
         String name ,
         Integer age ,
         String position ,
         Long departmentId
) {
}
