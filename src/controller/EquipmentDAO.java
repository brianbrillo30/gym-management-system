/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import activity.GymEquipmentClass;
import java.util.List;

/**
 *
 * @author Wang
 */
public interface EquipmentDAO {
    public void save(GymEquipmentClass gymEquipment);
    public void update(GymEquipmentClass gymEquipment);
    public void delete(GymEquipmentClass gymEquipment);
    public GymEquipmentClass get(int id);
    public List<GymEquipmentClass> list();
}
