/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import activity.GymMemberClass;
import java.util.List;

/**
 *
 * @author Wang
 */
public interface MemberDAO {
    
    public void save(GymMemberClass gmc);
    public void update(GymMemberClass gmc);
    public void delete(GymMemberClass gmc);
    public GymMemberClass get(int id);
    public List<GymMemberClass> list();
    
}
