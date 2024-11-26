package com.fakhri.entreprise.employee;

import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {

    public Employee ToEmployee(EmployeeRequest request) {
        return Employee.builder().
                id(request.id()).
                name(request.name()).
                age(request.age()).
                position(request.position()).
                departmentId(request.departmentId()).
                build();
    }

    public EmployeeResponse ToEmployeeResponse(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getAge(),
                employee.getPosition(),
                employee.getDepartmentId()
        );
    }
}
