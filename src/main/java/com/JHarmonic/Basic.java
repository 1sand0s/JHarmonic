package com.JHarmonic;

import com.JHarmonic.GElement.*;

import java.awt.Dimension;
import javax.swing.*;

/**
 * @author 1sand0s
 * 
 */
public class Basic extends JDialog {

    public Basic(java.awt.Frame parent, boolean modal, int parentWidth, int parentHeight) {
        super(parent, modal);
        width = parentWidth;
        height = parentHeight;
        initComponents();
    }

    private void initComponents() {

        this.setPreferredSize(new Dimension((int)(0.5*width), (int)(height/3.0)));
        basic_panel = new JPanel();
        basic_chooser = new JComboBox<>();
        ok = new JButton();
        value_field = new JTextField();
        value_label = new JLabel();
        warning_label = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Basic");

        basic_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Basic Component"));
        basic_panel.setPreferredSize(new Dimension((int)(0.5*width), (int)(height/3.0)));
        basic_panel.setLayout(null);

        basic_chooser
                .setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Resistor", "Capacitor", "Inductor" }));
        basic_chooser.setSelectedIndex(-1);

        basic_panel.add(basic_chooser);
        basic_chooser.setBounds(this.getLocation().x, this.getLocation().y, (int)(0.5*width), (int)(height/4.0));

        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        basic_panel.add(ok);
        ok.setBounds(this.getLocation().x, this.getLocation().y, (int)(0.5*width), (int)(height/4.0));
        basic_panel.add(value_field);
        value_field.setBounds(60, 80, 80, 27);

        value_label.setText("Value");
        basic_panel.add(value_label);
        value_label.setBounds(10, 90, 39, 17);

        warning_label.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        warning_label.setForeground(new java.awt.Color(230, 17, 17));
        basic_panel.add(warning_label);
        warning_label.setBounds(20, 120, 110, 30);

        pack();
    }

    private void okActionPerformed(java.awt.event.ActionEvent evt) {
        value = value_field.getText();
        if (value.equals("")) {
            warning_label.setText("Please enter a value!");
        } else {
            if (chosen.equals("Resistor")) {
                element = new GResistor();
                element.setValue(value);
            } else if (chosen.equals("Capacitor")) {
                element = new GCapacitor();
                element.setValue(value);
            } else if (chosen.equals("Inductor")) {
                element = new GInductor();
                element.setValue(value);
            }
            this.dispose();
        }
    }

    public GElement getElement() {
        return element;
    }

    private JComboBox<String> basic_chooser;
    private JPanel basic_panel;
    private JButton ok;
    private JTextField value_field;
    private JLabel value_label;
    private JLabel warning_label;
    private String chosen;
    private String value;
    private GElement element;

    private int width;
    private int height;
}