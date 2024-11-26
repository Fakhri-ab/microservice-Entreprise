package com.fakhri.entreprise.department;

import com.fakhri.entreprise.Client.EmployeeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepo repo ;
    private final DepartmentMapper mapper ;
    private final EmployeeClient employeeClient ;

    public Integer createDepartment(DepartmentRequest request) {
        var department = repo.save(mapper.ToDepartment(request)) ;
        return department.getId() ;
    }

    public List<Department> getAll() {
        return repo.findAll();
    }

    public List<DepartmentResponse> getAllDepartmentswithEmployees(Integer departmentId) {

        var department = repo.findById(departmentId) ;
        var employees = employeeClient.findByDepartment(departmentId);
        return Collections.singletonList(new DepartmentResponse(
                department.get().getId(),
                department.get().getName(),
                employees
        ));
    }
}
