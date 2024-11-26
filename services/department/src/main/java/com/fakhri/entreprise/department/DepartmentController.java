package com.fakhri.entreprise.department;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService service ;

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody DepartmentRequest request) {
        return ResponseEntity.ok(service.createDepartment(request)) ;
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/with-employees/{departmentId}")
    public List<DepartmentResponse> getAllDepartmentswithEmployees(
            @PathVariable("departmentId") Integer departmentId
    ) {
        return ResponseEntity.ok(service.getAllDepartmentswithEmployees(departmentId)).getBody();
    }
}
