/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import GymManagement_DB.GymManagementDB;
import activity.InstructorClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author X79
 */
public class InstructorDAOImp implements InstructorDAO {
int deleteItem;
    @Override
    public void save(InstructorClass ic) {
        try{
            Connection con = GymManagementDB.getConnection();
            String sql = "INSERT INTO instructor( instructor_id, first_name, middle_name, last_name, contact_no, email, gender, birthday, address,"
                    + " instructor_duration, instructor_rate, total) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(sql);

            String sqlExist = "SELECT * FROM instructor WHERE instructor_id='" +ic.getInstructorID()+"'";
            ResultSet rs = ps.executeQuery(sqlExist);           
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Instructor ID Already Exist"); 
            }
            
            else{
                ps.setInt(1, ic.getInstructorID());
                ps.setString(2, ic.getFirstName());
                ps.setString(3, ic.getMiddleName());
                ps.setString(4, ic.getLastName()); 
                ps.setString(5, ic.getContactNo());
                ps.setString(6, ic.getEmail());
                ps.setString(7, ic.getGender());
                ps.setString(8, ic.getBirthday());
                ps.setString(9, ic.getAddress());
                ps.setDouble(10, ic.getDuration());
                ps.setDouble(11, ic.getRate());
                ps.setDouble(12, ic.getTotalRate());


                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Saved!");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error!");
        }      
    }

    @Override
    public void update(InstructorClass ic) {
        try{
            Connection con =  GymManagementDB.getConnection();
            String sql = "UPDATE instructor SET instructor_id = ?, first_name = ?, middle_name = ?, last_name = ?, contact_no = ?, "
                    + "email = ? , gender = ?, birthday = ?, address = ?, instructor_duration = ?, instructor_rate = ?, total = ? WHERE ID =?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, ic.getInstructorID());
            ps.setString(2, ic.getFirstName());
            ps.setString(3, ic.getMiddleName());
            ps.setString(4, ic.getLastName()); 
            ps.setString(5, ic.getContactNo());
            ps.setString(6, ic.getEmail());
            ps.setString(7, ic.getGender());
            ps.setString(8, ic.getBirthday());
            ps.setString(9, ic.getAddress());
            ps.setDouble(10, ic.getDuration());
            ps.setDouble(11, ic.getRate());
            ps.setDouble(12, ic.getTotalRate());
            ps.setInt(13, ic.getId());
            
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated!");
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void delete(InstructorClass ic) {
       try {
           
        deleteItem = JOptionPane.showConfirmDialog(null, "Delete this item?", "Warning", JOptionPane.YES_NO_OPTION);
        
            if(deleteItem == JOptionPane.YES_OPTION){
                
                Connection con = GymManagementDB.getConnection();
                String sql = "delete from instructor  WHERE id=?";
                PreparedStatement ps = con.prepareStatement(sql);  
                ps.setInt(1, ic.getId());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Deleted!");
            }
 
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        
    }

    @Override
    public InstructorClass get(int id) {
        InstructorClass ic = new InstructorClass();
        try {
            Connection con = GymManagementDB.getConnection();
            String sql = "SELECT * FROM instructor WHERE ID=? OR instructor_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ic.setId(rs.getInt("ID"));
                ic.setInstructorID(rs.getInt("instructor_id"));
                ic.setFirstName(rs.getString("first_name"));
                ic.setMiddleName(rs.getString("middle_name"));
                ic.setLastName(rs.getString("last_name"));
                ic.setContactNo(rs.getString("contact_no"));
                ic.setEmail(rs.getString("email"));
                ic.setGender(rs.getString("gender"));
                ic.setBirthday(rs.getString("birthday"));  
                ic.setAddress(rs.getString("address"));
                ic.setDuration(rs.getInt("instructor_duration"));
                ic.setRate(rs.getDouble("instructor_rate"));
                ic.setTotalRate(rs.getDouble("total"));
               
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return ic;
    }

    @Override
    public List<InstructorClass> list() {
         List<InstructorClass> list = new ArrayList<InstructorClass>();
            try {
                Connection con = GymManagementDB.getConnection();
                String sql = "SELECT * FROM instructor ";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while(rs.next()){
                    InstructorClass instructor = new InstructorClass();
                    instructor.setId(rs.getInt("ID"));
                    instructor.setInstructorID(rs.getInt("instructor_id"));
                    instructor.setFirstName(rs.getString("first_name"));
                    instructor.setMiddleName(rs.getString("middle_name"));
                    instructor.setLastName(rs.getString("last_name"));
                    instructor.setGender(rs.getString("gender"));
                    instructor.setBirthday(rs.getString("birthday"));
                    instructor.setAddress(rs.getString("address"));
                    instructor.setContactNo(rs.getString("contact_no"));
                    instructor.setEmail(rs.getString("email"));
                    instructor.setDuration(rs.getInt("instructor_duration"));
                    instructor.setRate(rs.getDouble("instructor_rate"));
                    instructor.setTotalRate(rs.getDouble("total"));
                    list.add(instructor);
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error");
            }
                return list;
    }
         
}
