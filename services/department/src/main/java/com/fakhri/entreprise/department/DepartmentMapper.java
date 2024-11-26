package com.fakhri.entreprise.department;

import org.springframework.stereotype.Service;

@Service
public class DepartmentMapper {

    public Department ToDepartment(DepartmentRequest request){
        return Department.builder()
                .id(request.id())
                .name(request.name())
                .build();
    }
}
