/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import activity.InstructorClass;
import java.util.List;

/**
 *
 * @author X79
 */
public interface InstructorDAO {
    public void save(InstructorClass ic);
    public void update(InstructorClass ic);
    public void delete(InstructorClass ic);
    public InstructorClass get(int id);
    public List<InstructorClass> list();
    
}
