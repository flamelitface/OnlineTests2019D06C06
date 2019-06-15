package com.acquisio.basic.sql.question02;

import com.acquisio.util.dbutil.H2DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Write a query to extract all employees that are not assigned to any project.
 * -- The select should output those columns
 * -- |FirstName|LastName|DepartmentName|
 *
 * Here is the database schema to use.
 * <p>
 * employees                             projects
 * +---------------+---------+           +---------------+---------+
 * | id            | int     |<----+  +->| id            | int     |
 * | first_name    | varchar |     |  |  | title         | varchar |
 * | last_name     | varchar |     |  |  | start_date    | date    |
 * | salary        | int     |     |  |  | end_date      | date    |
 * | department_id | int     |--+  |  |  | budget        | int     |
 * +---------------+---------+  |  |  |  +---------------+---------+
 * |  |  |
 * departments                  |  |  |  employees_projects
 * +---------------+---------+  |  |  |  +---------------+---------+
 * | id            | int     |<-+  |  +--| project_id    | int     |
 * | name          | varchar |     +-----| employee_id   | int     |
 * +---------------+---------+           +---------------+---------+
 */
public class Extraction {
    public static void main(String[] args) throws SQLException {
        H2DBUtil.startDatabase();
        try {
            Extraction instance = new Extraction();
            instance.printNumberOfEmployeesPerProject();
        } finally {
            H2DBUtil.stopDatabase();
        }
    }

    private void printNumberOfEmployeesPerProject() throws SQLException {
        try (Connection conn = H2DBUtil.getConnection()) {
            String query = "select first_name as \"FirstName\", last_name as \"LastName\", name as \"DepartmentName\" from employees e " +
                    "INNER JOIN departments d " +
                    "ON e.department_id = d.id " +
                    "where e.id NOT IN (SELECT employee_id FROM employees_projects)";
            
            ResultSet resultSet = conn.createStatement().executeQuery(query);
            H2DBUtil.displayResultSet(resultSet);
        }
    }
}
