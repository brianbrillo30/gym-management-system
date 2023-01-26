/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import activity.EmployeeClass;
import java.util.List;

/**
 *
 * @author user
 */
public interface EmployeeDAO {
    public void save(EmployeeClass empc);
    public void update(EmployeeClass empc);
    public void delete(EmployeeClass empc);
    public EmployeeClass get(int id);
    public List<EmployeeClass> list();
    
}
