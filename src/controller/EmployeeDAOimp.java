/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import GymManagement_DB.GymManagementDB;
import activity.EmployeeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class EmployeeDAOimp implements EmployeeDAO{
    int deleteItem;
    @Override
    public void save(EmployeeClass empc) {
         try{
            Connection con =  GymManagementDB.getConnection();
            String sql = "INSERT INTO employee(employee_id, first_name, middle_name, surname, contact_no, birthday, "
                    + "email, gender, address, staff_role, shift, rate_per_hour, hours_worked, salary, profile_image) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            String sqlExist = "SELECT * FROM employee WHERE employee_id='" +empc.getEmployeeID()+"'";
            ResultSet rs = ps.executeQuery(sqlExist);
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Employee ID Already Exist"); 
            }            
            else{
                ps.setInt(1, empc.getEmployeeID());
                ps.setString(2, empc.getFirstName());
                ps.setString(3, empc.getMiddleName());
                ps.setString(4, empc.getLastName());
                ps.setString(5, empc.getContactNo());
                ps.setString(6, empc.getBirthday());
                ps.setString(7, empc.getEmail());
                ps.setString(8, empc.getGender());
                ps.setString(9, empc.getAddress());
                ps.setString(10, empc.getStaffRole());
                ps.setString(11, empc.getShift());
                ps.setDouble(12, empc.getRatePerHour());
                ps.setInt(13, empc.getHoursWorked());
                ps.setDouble(14, empc.getSalary());
                ps.setBytes(15, empc.getImage());

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Saved!");
            }
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        } 
    }

    @Override
    public void update(EmployeeClass empc) {
        try{
            Connection con =  GymManagementDB.getConnection();
            String sql = "UPDATE employee SET employee_id =?, first_name =?, middle_name =?, surname =?, contact_no =?, birthday =?,"
                    +" email =?, gender =?, address =?, staff_role =?, shift =?, rate_per_hour =?, hours_worked =?, salary =?, profile_image =? WHERE ID =?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, empc.getEmployeeID());
            ps.setString(2, empc.getFirstName());
            ps.setString(3, empc.getMiddleName());
            ps.setString(4, empc.getLastName());
            ps.setString(5, empc.getContactNo());
            ps.setString(6, empc.getBirthday());
            ps.setString(7, empc.getEmail());
            ps.setString(8, empc.getGender());
            ps.setString(9, empc.getAddress());
            ps.setString(10, empc.getStaffRole());
            ps.setString(11, empc.getShift());
            ps.setDouble(12, empc.getRatePerHour());
            ps.setInt(13, empc.getHoursWorked());
            ps.setDouble(14, empc.getTotal());
            ps.setBytes(15, empc.getImage());
            
            ps.setInt(16, empc.getId());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated!");
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void delete(EmployeeClass empc) {
        try {
           
        deleteItem = JOptionPane.showConfirmDialog(null, "Delete this item?", "Warning", JOptionPane.YES_NO_OPTION);
        
            if(deleteItem == JOptionPane.YES_OPTION){
                
                Connection con = GymManagementDB.getConnection();
                String sql = "delete from employee  WHERE id=?";
                PreparedStatement ps = con.prepareStatement(sql);  
                ps.setInt(1, empc.getId());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Deleted!");
            }

            
          
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }       
    }

    @Override
    public EmployeeClass get(int id) {
        EmployeeClass empc = new EmployeeClass();
        try {
            Connection con = GymManagementDB.getConnection();
            String sql = "SELECT * FROM employee WHERE ID=? OR employee_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                empc.setId(rs.getInt("ID"));
                empc.setEmployeeID(rs.getInt("employee_id"));
                empc.setFirstName(rs.getString("first_name"));
                empc.setMiddleName(rs.getString("middle_name"));
                empc.setLastName(rs.getString("surname"));
                empc.setContactNo(rs.getString("contact_no"));
                empc.setBirthday(rs.getString("birthday"));
                empc.setEmail(rs.getString("email"));
                empc.setGender(rs.getString("gender"));
                empc.setAddress(rs.getString("address"));
                empc.setStaffRole(rs.getString("staff_role"));
                empc.setShift(rs.getString("shift"));
                empc.setRatePerHour(rs.getDouble("rate_per_hour"));
                empc.setHoursWorked(rs.getInt("hours_worked"));
                empc.setTotal(rs.getDouble("salary"));
                empc.setImage(rs.getBytes("profile_image"));
 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return empc;
    }

    @Override
    public List<EmployeeClass> list() {
        List<EmployeeClass> list = new ArrayList<EmployeeClass>();
            try {
                Connection con = GymManagementDB.getConnection();
                String sql = "SELECT * FROM employee ";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();



                while(rs.next()){
                    EmployeeClass employee = new EmployeeClass();
                    employee.setId(rs.getInt("ID"));
                    employee.setEmployeeID(rs.getInt("employee_id"));
                    employee.setFirstName(rs.getString("first_name"));
                    employee.setMiddleName(rs.getString("middle_name"));
                    employee.setLastName(rs.getString("surname"));
                    employee.setContactNo(rs.getString("contact_no"));
                    employee.setBirthday(rs.getString("birthday"));
                    employee.setEmail(rs.getString("email"));
                    employee.setGender(rs.getString("gender"));
                    employee.setAddress(rs.getString("address"));
                    employee.setStaffRole(rs.getString("staff_role"));
                    employee.setShift(rs.getString("shift"));
                    employee.setRatePerHour(rs.getDouble("rate_per_hour"));
                    employee.setHoursWorked(rs.getInt("hours_worked"));
                    employee.setTotal(rs.getDouble("salary"));
                    

                    list.add(employee);
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error");
            }
                return list;
    }
    
}
