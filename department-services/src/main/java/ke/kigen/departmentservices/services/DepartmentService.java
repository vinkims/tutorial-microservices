package ke.kigen.departmentservices.services;

import ke.kigen.departmentservices.models.Department;

public interface DepartmentService {
    
    Department saveDepartment(Department department);

    Department getDepartmentById(Long departmentId);
}
