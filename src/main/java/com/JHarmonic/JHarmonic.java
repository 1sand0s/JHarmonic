package com.JHarmonic;

import com.JHarmonic.SElement.*;
import com.JHarmonic.Util.ComponentTerminals;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JFrame;

/**
 *
 * @author 1sand0s
 */
public class JHarmonic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, UnsupportedLookAndFeelException {
//        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GUIMain().setVisible(true);
//            }
//        });

        DCVoltage source = new DCVoltage();
        Resistor r1 = new Resistor();
        Resistor r2 = new Resistor();
        GND g1 = new GND();
        
        Wire w1 = new Wire();
        Wire w2 = new Wire();
        Wire w3 = new Wire();
        
        source.setValue(10);
        r1.setValue(100);
        r2.setValue(100);
        
        w1.addTerminal(source, ComponentTerminals.POS_NODE);
        w1.addTerminal(r1, ComponentTerminals.POS_NODE);
        
        w2.addTerminal(r1, ComponentTerminals.NEG_NODE);
        w2.addTerminal(r2, ComponentTerminals.POS_NODE);
        
        w3.addTerminal(r2, ComponentTerminals.NEG_NODE);
        w3.addTerminal(source, ComponentTerminals.NEG_NODE);
        w3.addTerminal(g1, ComponentTerminals.GND);

    }
}
