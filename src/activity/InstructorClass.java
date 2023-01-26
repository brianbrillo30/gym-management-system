/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activity;

/**
 *
 * @author X79
 */
public class InstructorClass extends PersonClass {
   
    private int instructorID;
    private int duration;
    private double rate;
    private double total;

   
    
    public InstructorClass(){
        instructorID = 0;
        duration = 0;
        rate = 0;
        total = 0;
        }
 
    public void setInstructorID(int instructorID){
        this.instructorID = instructorID;
    }
    public int getInstructorID(){
        return instructorID;    
    }
    
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public int getDuration() {
        return duration;
    }
    
    public void setRate(double rate) {
        this.rate = rate;
    }
    public double getRate() {
        return rate;
    }
    
    public void ComputeTotal() {
        total = duration * rate ;    
    }

    public double getTotal() {
        return total;
    }
    
    public void setTotalRate(double totalRate){
        this.total = totalRate;   
    }
    
    public double getTotalRate(){
        return total;
    }

}
