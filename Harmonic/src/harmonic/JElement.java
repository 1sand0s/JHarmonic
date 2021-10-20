/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harmonic;

import javax.swing.ImageIcon;

/**
 *
 * @author itarsi
 */
public abstract class JElement extends javax.swing.JPanel
{
    
    public abstract JNode node_pair(JNode node);
    
    public abstract JNode getNode1();
    
    public abstract JNode getNode2();
    
    public abstract JNode getNode3();
    
    public abstract String getId();
    
    public abstract double getValue();
    
    public abstract void setValue(String val);
    
    public abstract int getId_int();
    
    public abstract boolean getScopeState();
    
    public abstract int getNode1Scope();
    
    public abstract int getNode2Scope();
    
    public abstract int getNode3Scope();
    
    public abstract double[] getPhaseExpansion();
    
    public abstract void setPhaseExpansion(int size);
    
    public abstract int getActualID();
    
    public abstract double[] getVoltageandCurrent(double result[]);
}
