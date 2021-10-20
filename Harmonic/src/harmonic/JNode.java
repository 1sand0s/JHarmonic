/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harmonic;

import java.util.ArrayList;

/**
 *
 * @author itarsi
 */
public class JNode extends javax.swing.JLabel{
    
    ArrayList<JNode> neighbour=new ArrayList<JNode>();
    public int ID=-1;
    
    public JElement getParentElement()
    {
        return (JElement)this.getParent();
    }
    
    
    
}
