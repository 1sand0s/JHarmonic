/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harmonic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author itarsi
 */
public class Transistor extends javax.swing.JDialog {
    public Transistor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }                         
    private void initComponents() {

        transistor_summary = new javax.swing.JPanel();
        transistor_details = new javax.swing.JLabel();
        ok_button = new javax.swing.JButton();
        transistor_type = new javax.swing.JPanel();
        jscrollpane = new javax.swing.JScrollPane();
        transistor_item = new javax.swing.JList<>();
        transistor_image = new javax.swing.JPanel()
        {
            public void paintComponent(Graphics g)
            {
               if(!transistor_item.isSelectionEmpty())
               {
                    Graphics2D g2=(Graphics2D)g;
                    g2.setColor(Color.BLACK);
                    g2.setStroke(new BasicStroke(3));
                    g2.drawOval(50,10,50,50);
                    g2.drawLine(85,20,85,50);
                    g2.drawLine(70,15,85,25);
                    g2.drawLine(70,55,85,45);
                    g2.drawLine(70,15,70,0);
                    g2.drawLine(70,55,70,70);
                    if(npn)
                    {
                        g2.drawLine(75,45,80,55);
                        g2.drawLine(75,45,70,55);
                        g2.drawLine(70,55,80,55);
                    }
                    else
                    {
                        g2.drawLine(70,45,75,60);
                        g2.drawLine(70,45,80,50);
                        g2.drawLine(75,60,80,50);
                    }
                    g2.drawLine(85,35,110,35);
                }
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        transistor_summary.setBorder(javax.swing.BorderFactory.createTitledBorder("Summary"));

        ok_button.setText("OK");
        ok_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ok_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout transistor_summaryLayout = new javax.swing.GroupLayout(transistor_summary);
        transistor_summary.setLayout(transistor_summaryLayout);
        transistor_summaryLayout.setHorizontalGroup(
            transistor_summaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(transistor_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(transistor_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(transistor_summaryLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(ok_button, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        transistor_summaryLayout.setVerticalGroup(
            transistor_summaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transistor_summaryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transistor_details, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transistor_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addComponent(ok_button)
                .addContainerGap())
        );

        transistor_type.setBorder(javax.swing.BorderFactory.createTitledBorder("Transistors"));

        transistor_item.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "2N222", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        transistor_item.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                transistor_itemValueChanged(evt);
            }
        });
        jscrollpane.setViewportView(transistor_item);

        javax.swing.GroupLayout transistor_typeLayout = new javax.swing.GroupLayout(transistor_type);
        transistor_type.setLayout(transistor_typeLayout);
        transistor_typeLayout.setHorizontalGroup(
            transistor_typeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jscrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );
        transistor_typeLayout.setVerticalGroup(
            transistor_typeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jscrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(transistor_summary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transistor_type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(transistor_summary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(transistor_type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                  

    private void ok_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void transistor_itemValueChanged(javax.swing.event.ListSelectionEvent evt) {    
        npn=false;
        transistor_image.repaint();
    }                                            

                     
    private javax.swing.JScrollPane jscrollpane;
    private javax.swing.JButton ok_button;
    private javax.swing.JLabel transistor_details;
    private javax.swing.JPanel transistor_image;
    private javax.swing.JList<String> transistor_item;
    private javax.swing.JPanel transistor_summary;
    private javax.swing.JPanel transistor_type;    
    private boolean npn=true;
}

