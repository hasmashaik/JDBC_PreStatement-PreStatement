package com_1.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class EmployeOperation_pre {
	    static Connection con = DBC1.getConnection();
	    static Scanner sc = new Scanner(System.in);

	    public static void addEmployee(Employeepre emp) {
	    	      //sql
	        String query = "INSERT INTO employee (empId, empName, empSalary, empAddress) values (?, ?, ?, ?)";
	        try {
	        PreparedStatement pst = con.prepareStatement(query);
	            pst.setInt(1, emp.getEmpId());
	            pst.setString(2, emp.getEmpName());
	            pst.setDouble(3, emp.getEmpSalary());
	            pst.setString(4, emp.getAddress());
	            pst.executeUpdate();
	            System.out.println("EMPLOYEE INSERTED SUCCESSFULLY .............");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void displayEmployes() {
	        String query = "select * from employee";
	        try {
	        	PreparedStatement pst = con.prepareStatement(query);
	            ResultSet rs = pst.executeQuery();
	            int count = 0;
	            System.out.println("ID    Name    Salary    Address");
	            while (rs.next()) {
	                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getDouble(3) + "  " + rs.getString(4));
	                count++;
	            }
	            if (count == 0) {
	                System.out.println("EMPLOYEE DETAILS NOT FOUND ...");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void updateEmployee(int empId) {
	        System.out.println("ENTER NEW EMPLOYEE NAME: ");
	        String empName = sc.next();
	        System.out.println("ENTER NEW EMPLOYEE SALARY: ");
	        double empSalary = sc.nextDouble();
	        System.out.println("ENTER NEW EMPLOYEE ADDRESS: ");
	        String empAddress = sc.next();

	        try {
	        	String query = "update employee set empName = ?, empSalary = ?, empAddress = ? WHERE empId = ?";
	        	PreparedStatement pst = con.prepareStatement(query);
	            pst.setString(1, empName);
	            pst.setDouble(2, empSalary);
	            pst.setString(3, empAddress);
	            pst.setInt(4, empId);
	            pst.executeUpdate();
	            System.out.println("EMPLOYEE UPDATED SUCCESSFULLY..........");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void deleteEmployee(int empId) {
	        String query = "delete from employee where empId = ?";
	        try (PreparedStatement pst = con.prepareStatement(query)) {
	            pst.setInt(1, empId);
	            pst.executeUpdate();
	            System.out.println("EMPLOYEE DELETED SUCCESSFULLY..........");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void SearchEmployee(int empId) {
	        try {
	        	String query = "select * from employee where empId = ?";
	        	PreparedStatement pst = con.prepareStatement(query);
	            pst.setInt(1, empId);
	            ResultSet rs = pst.executeQuery();
	            System.out.println("ID    Name     Salary     Address");
	            if (rs.next()) {
	                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getDouble(3) + "  " + rs.getString(4));
	            } else {
	                System.out.println("EMPLOYEE NOT FOUND ......");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}



