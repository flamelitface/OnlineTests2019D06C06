package com.acquisio.app.controller;

import com.acquisio.app.domain.Employee;
import com.acquisio.app.dto.EmployeeDTO;
import com.acquisio.app.repository.EmployeeRepository;
import com.timgroup.jgravatar.Gravatar;
import com.timgroup.jgravatar.GravatarDefaultImage;
import com.timgroup.jgravatar.GravatarRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping("/employees")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<EmployeeDTO> listEmployees() throws SQLException {
        Collection<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(this::mapEmployeeEntityToEmployeeDTO).collect(Collectors.toList());
    }

    private EmployeeDTO mapEmployeeEntityToEmployeeDTO(Employee employee) {
        return EmployeeDTO.builder()
                .setId(employee.getId())
                .setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName())
                .setEmail(employee.getEmail())
                .setSalary(employee.getSalary())
                .setAvatarUrl(generateGravatarUrl(employee.getEmail()))
                .build();
    }

    private String generateGravatarUrl(String employeeEmail) {
        Gravatar gravatar = new Gravatar()
                .setSize(50)
                .setRating(GravatarRating.GENERAL_AUDIENCES)
                .setDefaultImage(GravatarDefaultImage.IDENTICON);
        return gravatar.getUrl(employeeEmail);
    }
}
