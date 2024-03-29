package org.RealAnish.departmentproject.service;

import org.RealAnish.departmentproject.entity.Department;
import org.RealAnish.departmentproject.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService
{
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartment();

    public void deleteDepartmentById(Long departmentId);

    public Department fetchDepartmentByName(String departmentName);


    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;
}
