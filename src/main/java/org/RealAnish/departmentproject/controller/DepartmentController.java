package org.RealAnish.departmentproject.controller;

import jakarta.validation.Valid;
import org.RealAnish.departmentproject.entity.Department;
import org.RealAnish.departmentproject.error.DepartmentNotFoundException;
import org.RealAnish.departmentproject.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController
{
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments/")
    public Department saveDepartment(@Valid @RequestBody Department department)
    {
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments/")
    public List<Department> fetchDepartment()
    {

        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartment();
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId)
    {
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department)
    {
      return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/id/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
       return departmentService.fetchDepartmentById(departmentId);
    }
    @GetMapping("departments/name/{name}")
   public Department fetchDepartmentByName(@PathVariable("name") String departmentName)
   {
       return departmentService.fetchDepartmentByName(departmentName);
   }
}
