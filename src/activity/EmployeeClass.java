/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activity;

import java.sql.Blob;

/**
 *
 * @author user
 */
public class EmployeeClass extends PersonClass{
    private int employeeID;
    private String staffRole;
    private String shift;
    private double ratePerHour;
    private int hoursWorked;
    private double salary;
    private double total;
    
    private byte[] image;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
    public int getEmployeeID(){
        return employeeID;
    }
    public void setEmployeeID(int employeeID){
        this.employeeID = employeeID;
    }
    public String getStaffRole(){
        return staffRole;
    }
    public void setStaffRole(String staffRole){
        this.staffRole = staffRole;
    }
    public String getShift(){
        return shift;
    }
    public void setShift(String shift){
        this.shift = shift;
    }
    public double getRatePerHour(){
        return ratePerHour;
    }
    public void setRatePerHour(double ratePerHour){
        this.ratePerHour = ratePerHour;
    }
    
    public int getHoursWorked(){
        return hoursWorked;
    }
    public void setHoursWorked(int hoursWorked){
        this.hoursWorked = hoursWorked;
    }
    public void ComputeSalary(){
        salary = ratePerHour * hoursWorked;
    }
    public double getSalary(){
        return salary;
    }
    public void setTotal(double total){
        this.salary = total;
        
    }
    public double getTotal(){
        return salary;
    }
    
}
