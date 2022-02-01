package com.JHarmonic.GElement;

import java.util.ArrayList;

/**
 * @author 1sand0s
 * 
 */
public class GNode extends javax.swing.JLabel {

    ArrayList<GNode> neighbours = new ArrayList<GNode>(0);
    ArrayList<GElement> elements = new ArrayList<GElement>(0);
    public int ID = -1;
}