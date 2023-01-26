/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import GymManagement_DB.GymManagementDB;
import activity.GymEquipmentClass;
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
public class EquipmentDAOImp implements EquipmentDAO{
    
    int deleteItem;
    @Override
    public void save(GymEquipmentClass gymEquipment) {
         try {
            Connection con =  GymManagementDB.getConnection();
            String sql = "INSERT INTO gym_equipment(equipment_name, equipment_type, quantity) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, gymEquipment.getEquipmentName());
            ps.setString(2, gymEquipment.getEquipmentType());
            ps.setInt(3, gymEquipment.getQuantity());
  
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }          
    }

    @Override
    public void update(GymEquipmentClass gymEquipment) {
      try {
            Connection con = GymManagementDB.getConnection();
            String sql = "UPDATE gym_equipment SET equipment_name=?,equipment_type=?, quantity=? WHERE equipment_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, gymEquipment.getEquipmentName());
            ps.setString(2, gymEquipment.getEquipmentType());
            ps.setInt(3, gymEquipment.getQuantity());
            ps.setInt(4, gymEquipment.getEquipmentID());

            ps.executeUpdate();
 
        
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        } 
    }

    @Override
    public void delete(GymEquipmentClass gymEquipment) {
       try {
           
        deleteItem = JOptionPane.showConfirmDialog(null, "Delete this item?", "Warning", JOptionPane.YES_NO_OPTION);
        
            if(deleteItem == JOptionPane.YES_OPTION){
                
                Connection con = GymManagementDB.getConnection();
                String sql = "delete from gym_equipment  WHERE equipment_id=?";
                PreparedStatement ps = con.prepareStatement(sql);  
                ps.setInt(1, gymEquipment.getEquipmentID());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Deleted!");
            }

            
          
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public GymEquipmentClass get(int id) {
        GymEquipmentClass gec = new GymEquipmentClass();
        try {
            Connection con = GymManagementDB.getConnection();
            String sql = "SELECT * FROM gym_equipment WHERE equipment_id=? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                gec.setEquipmentID(rs.getInt("equipment_id"));
                gec.setEquipmentName(rs.getString("equipment_name"));
                gec.setEquipmentType(rs.getString("equipment_type"));
                gec.setQuantity(rs.getInt("quantity"));
 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return gec;
    }

    @Override
    public List<GymEquipmentClass> list() {
        
        List<GymEquipmentClass> list = new ArrayList<GymEquipmentClass>();
            try {
                Connection con = GymManagementDB.getConnection();
                String sql = "SELECT * FROM gym_equipment ";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();



                while(rs.next()){
                    GymEquipmentClass gec = new GymEquipmentClass();
                    gec.setEquipmentID(rs.getInt("equipment_id"));
                    gec.setEquipmentName(rs.getString("equipment_name"));
                    gec.setEquipmentType(rs.getString("equipment_type"));
                    gec.setQuantity(rs.getInt("quantity"));


                    list.add(gec);
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error");
            }
                return list;
    }
    
}
