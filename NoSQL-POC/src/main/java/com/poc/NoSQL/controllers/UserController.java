package com.poc.NoSQL.controllers;


import com.poc.NoSQL.models.Department;
import com.poc.NoSQL.models.Faculty;
import com.poc.NoSQL.repos.DepartmentRepo;
import com.poc.NoSQL.repos.FacultyRepo;
import com.poc.NoSQL.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    FacultyRepo facultyRepo;

    @GetMapping("/save")
    public void save(){
        Faculty faculty = new Faculty();
        faculty.setId(UUID.randomUUID());
        faculty.setCreatedAt(LocalDateTime.now(ZoneId.of("Asia/Colombo")));
        faculty.setDeleted(false);
        faculty.setLastUpdate(LocalDateTime.now(ZoneId.of("Asia/Colombo")));
        faculty.setName("new");


        Department department =new Department();
        department.setId(UUID.randomUUID());
        department.setCreatedAt(LocalDateTime.now(ZoneId.of("Asia/Colombo")));
        department.setDeleted(false);
        department.setName("New Dep");
        department.setLastUpdate(LocalDateTime.now(ZoneId.of("Asia/Colombo")));
        department.setFaculty(faculty);
        department = departmentRepo.save(department);
        List<Department> departments = new ArrayList<>();
        departments.add(department);
        faculty.setDepartments(departments);
        faculty = facultyRepo.save(faculty);
    }

}
