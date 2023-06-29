package ke.kigen.departmentservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ke.kigen.departmentservices.models.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
}
