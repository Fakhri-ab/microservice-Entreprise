package com.fakhri.entreprise.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo repo;
    private final EmployeeMapper mapper;

    public Integer createEmployee(EmployeeRequest request) {
        var employee = repo.save(mapper.ToEmployee(request)) ;
        return employee.getId();
    }

    public List<EmployeeResponse> getAllEmployees() {
        return repo.findAll().stream().map(mapper::ToEmployeeResponse).collect(Collectors.toList());
    }

    public EmployeeResponse findById(Integer id) {
        return repo.findById(id).map(mapper::ToEmployeeResponse).orElseThrow(
                () -> new RuntimeException("Employee not found")
        );
    }

    public List<EmployeeResponse> findByDepartment(Long departmentId) {
        return repo.findByDepartmentId(departmentId).stream()
                .map(mapper::ToEmployeeResponse).collect(Collectors.toList());
    }
}
