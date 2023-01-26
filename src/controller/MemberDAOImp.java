/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import GymManagement_DB.GymManagementDB;
import activity.GymMemberClass;
import activity.PersonClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Wang
 */
public class MemberDAOImp implements MemberDAO{

    int deleteItem;
    @Override
    public void save(GymMemberClass gmc) {
         try {
            Connection con =  GymManagementDB.getConnection();
            String sql = "INSERT INTO member(member_id, first_name, middle_name, last_name, gender, birthday, "
                    + "address, contact_no, email, member_type, transaction_status, joining_date, renewal_date, fee) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            String sqlExist = "SELECT * FROM member WHERE member_id='" +gmc.getMemberID()+"'";
            ResultSet rs = ps.executeQuery(sqlExist);
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Member ID Already Exist"); 
            }
            else{
                ps.setInt(1, gmc.getMemberID());

                ps.setString(2, gmc.getFirstName());
                ps.setString(3, gmc.getMiddleName());
                ps.setString(4, gmc.getLastName());
                ps.setString(5, gmc.getGender());
                ps.setString(6, gmc.getBirthday());
                ps.setString(7, gmc.getAddress());
                ps.setString(8, gmc.getContactNo());
                ps.setString(9, gmc.getEmail());
                ps.setString(10, gmc.getMemberType());
                ps.setString(11, gmc.getTransactionStatus());
                ps.setString(12, gmc.getJoiningDate());
                ps.setString(13, gmc.getRenewalDate());
                ps.setDouble(14, gmc.getfee());

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Saved!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }        
    }

    @Override
    public void update(GymMemberClass gmc) {
      try {
            Connection con = GymManagementDB.getConnection();
            String sql = "UPDATE member SET member_id=?, first_name=?, middle_name=?, last_name=?, gender=?, birthday=?,"
                    + " address=?, contact_no=?, email=?, member_type=?, transaction_status=?, "
                    + "joining_date=?,  renewal_date=?, fee=? WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, gmc.getMemberID());
            ps.setString(2, gmc.getFirstName());
            ps.setString(3, gmc.getMiddleName());
            ps.setString(4, gmc.getLastName());
            ps.setString(5, gmc.getGender());
            ps.setString(6, gmc.getBirthday());
            ps.setString(7, gmc.getAddress());
            ps.setString(8, gmc.getContactNo());
            ps.setString(9, gmc.getEmail());
            ps.setString(10, gmc.getMemberType());
            ps.setString(11, gmc.getTransactionStatus());
            ps.setString(12, gmc.getJoiningDate());
            ps.setString(13, gmc.getRenewalDate());
            ps.setDouble(14, gmc.getfee());
            ps.setInt(15, gmc.getId());
            ps.executeUpdate();
 
        
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        } 
    }

    @Override
    public void delete(GymMemberClass gmc) {
       try {
           
        deleteItem = JOptionPane.showConfirmDialog(null, "Delete this item?", "Warning", JOptionPane.YES_NO_OPTION);
        
            if(deleteItem == JOptionPane.YES_OPTION){
                
                Connection con = GymManagementDB.getConnection();
                String sql = "delete from member  WHERE id=?";
                PreparedStatement ps = con.prepareStatement(sql);  
                ps.setInt(1, gmc.getId());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Deleted!");
            }

            
          
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }       
    }

    @Override
    public GymMemberClass get(int id) {
        
        GymMemberClass gcm = new GymMemberClass();
        try {
            Connection con = GymManagementDB.getConnection();
            String sql = "SELECT * FROM member WHERE ID=? OR member_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                gcm.setId(rs.getInt("ID"));
                gcm.setMemberID(rs.getInt("member_id"));
                gcm.setFirstName(rs.getString("first_name"));
                gcm.setMiddleName(rs.getString("middle_name"));
                gcm.setLastName(rs.getString("last_name"));
                gcm.setGender(rs.getString("gender"));
                gcm.setBirthday(rs.getString("birthday"));
                gcm.setAddress(rs.getString("address"));
                gcm.setContactNo(rs.getString("contact_no"));
                gcm.setEmail(rs.getString("email"));
                gcm.setMemberType(rs.getString("member_type"));
                gcm.setTransactionStatus(rs.getString("transaction_status"));
                gcm.setJoiningDate(rs.getString("joining_date"));
                gcm.setRenewalDate(rs.getString("renewal_date"));
                gcm.setFee(rs.getDouble("fee"));
 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return gcm;
    }

    @Override
    public List<GymMemberClass> list() {
        
        List<GymMemberClass> list = new ArrayList<GymMemberClass>();
            try {
                Connection con = GymManagementDB.getConnection();
                String sql = "SELECT * FROM member ";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();



                while(rs.next()){
                    GymMemberClass gymMember = new GymMemberClass();
                    gymMember.setId(rs.getInt("ID"));
                    gymMember.setMemberID(rs.getInt("member_id"));
                    gymMember.setFirstName(rs.getString("first_name"));
                    gymMember.setMiddleName(rs.getString("middle_name"));
                    gymMember.setLastName(rs.getString("last_name"));
                    gymMember.setGender(rs.getString("gender"));
                    gymMember.setBirthday(rs.getString("birthday"));
                    gymMember.setAddress(rs.getString("address"));
                    gymMember.setContactNo(rs.getString("contact_no"));
                    gymMember.setEmail(rs.getString("email"));
                    gymMember.setMemberType(rs.getString("member_type"));
                    gymMember.setTransactionStatus(rs.getString("transaction_status"));
                    gymMember.setJoiningDate(rs.getString("joining_date"));
                    gymMember.setRenewalDate(rs.getString("renewal_date"));
                    gymMember.setFee(rs.getDouble("fee"));

                    list.add(gymMember);
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error");
            }
                return list;
    }
    
}
