/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Salmah Nansamba
 */
public class PiersEquation {
     int weeks = 0;
    int days = 0;
    boolean dyspnoea = false;
    double creatinine = 0;
    double platelets = 0;
    double ast = 0;
    double SpO2 = 0;
    double gestational_age = 0;
    double probability = 0;
    
    public PiersEquation(int Weeks, int Days, boolean Dyspnoea, double Creatinine, double Platelets, double Ast, double spO2){
        weeks = Weeks;
        days = Days;
        dyspnoea = Dyspnoea;
        creatinine = Creatinine;
        platelets = Platelets;
        ast = Ast;
        SpO2 = spO2;
    }
    
    private double get_gestational_age(){
        double age = 0;
        age = weeks + (days/7);
        return age;
    }
    
    public double get_probability(){
        double prob = 0;
        prob = 2.68 + equation_1() + equation_2() + equation_3();
        return prob;
    }
    
    private double equation_1(){
        double result = 0;
        int dys = 0;
        if(dyspnoea){dys = 1;}
        result = (-0.0541 * get_gestational_age()) + (1.23 * dys) + (-0.0271 * creatinine) + (0.0207 * platelets);
        return result;
    }
    
    private double equation_2(){
        double result = 0;
        result =(0.00004 * platelets * platelets) + (0.0101 * ast) + (-0.00000305 * ast * ast) + (0.00025 * creatinine * platelets) ;
        return result;
    }
    
    private double equation_3(){
        double result = 0;
        result =(-0.0000699 * platelets * ast) + (-0.00256 * platelets * SpO2);
        return result;
    }
    
    
}
