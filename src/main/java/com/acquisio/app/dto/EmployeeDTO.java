package com.acquisio.app.dto;

import com.acquisio.app.domain.Employee;

public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int salary;

    private String url;

    public EmployeeDTO(String firstName, String lastName, String email, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static EmployeeDTOBuilder builder() {
        return new EmployeeDTOBuilder();
    }

    public static class EmployeeDTOBuilder {

        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private int salary;
        private String url;

        public EmployeeDTOBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public EmployeeDTOBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeDTOBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeDTOBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public EmployeeDTOBuilder setSalary(int salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeDTOBuilder setUrl(String url) {
            this.url = url;
            return this;
        }

        public EmployeeDTO build() {
            EmployeeDTO employeeDTO = new EmployeeDTO(this.firstName, this.lastName, this.email, this.salary);
            employeeDTO.setId(this.id);
            employeeDTO.setUrl(this.url);
            return employeeDTO;
        }


    }
}
