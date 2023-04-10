package com.axis.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataOperation {
    private Connection conn;

    public DataOperation() throws SQLException {
        conn = Connect.getConnection();
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                int empId = rs.getInt("id");
                String empName = rs.getString("name");
                int empAge = rs.getInt("age");
                int empSalary = rs.getInt("salary");
                Employee emp = new Employee(empId, empName, empAge, empSalary);
                employees.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public void insertEmployee(Employee emp) {
        String sql = "INSERT INTO employees(id,name, age, salary) VALUES(?,?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, emp.getEmpId());
            stmt.setString(2, emp.getEmpName());
            stmt.setInt(3, emp.getEmpAge());
            stmt.setInt(4, emp.getEmpSalary());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Employee emp) {
        String sql = "UPDATE employees SET name=?, age=?, salary=? WHERE id=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, emp.getEmpName());
            stmt.setInt(2, emp.getEmpAge());
            stmt.setInt(3, emp.getEmpSalary());
            stmt.setInt(4, emp.getEmpId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int empId) {
        String sql = "DELETE FROM employees WHERE id=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, empId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
