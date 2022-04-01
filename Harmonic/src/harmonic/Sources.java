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
public class Sources extends javax.swing.JDialog {

    /**
     * Creates new form Sources
     */
    public Sources(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        dc_panel = new javax.swing.JPanel();
        magnitude_dc_text = new javax.swing.JTextField();
        magnitude_label = new javax.swing.JLabel();
        dc_model = new javax.swing.JPanel();
        dc_label = new javax.swing.JLabel();
        ac_button = new javax.swing.JButton();
        dc_button = new javax.swing.JButton();
        warning_label = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ampere = new javax.swing.JLabel();
        ampere_value = new javax.swing.JTextField();
        ac_panel = new javax.swing.JPanel();
        magnitude_text = new javax.swing.JTextField();
        dcoffset_text = new javax.swing.JTextField();
        frequency_text = new javax.swing.JTextField();
        phase_text = new javax.swing.JTextField();
        magnitude = new javax.swing.JLabel();
        dc_offset = new javax.swing.JLabel();
        frequency = new javax.swing.JLabel();
        phase = new javax.swing.JLabel();
        model_panel = new javax.swing.JPanel();
        model_label = new javax.swing.JLabel();
        current = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        dc_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("DC"));

        magnitude_label.setText("Magnitude(V)");

        dc_model.setBorder(javax.swing.BorderFactory.createTitledBorder("Model"));

        dc_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cell1.png"))); // NOI18N

        javax.swing.GroupLayout dc_modelLayout = new javax.swing.GroupLayout(dc_model);
        dc_model.setLayout(dc_modelLayout);
        dc_modelLayout.setHorizontalGroup(
            dc_modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dc_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dc_modelLayout.setVerticalGroup(
            dc_modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dc_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ac_button.setText("AC");
        ac_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ac_buttonActionPerformed(evt);
            }
        });

        dc_button.setText("DC");
        dc_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dc_buttonActionPerformed(evt);
            }
        });

        warning_label.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        warning_label.setForeground(new java.awt.Color(241, 14, 14));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Current Source"));

        ampere.setText("Magnitude(A)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ampere)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ampere_value, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ampere)
                    .addComponent(ampere_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dc_panelLayout = new javax.swing.GroupLayout(dc_panel);
        dc_panel.setLayout(dc_panelLayout);
        dc_panelLayout.setHorizontalGroup(
            dc_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dc_panelLayout.createSequentialGroup()
                .addGroup(dc_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dc_model, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dc_panelLayout.createSequentialGroup()
                        .addGroup(dc_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dc_panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(magnitude_label)
                                .addGap(18, 18, 18)
                                .addComponent(magnitude_dc_text, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(35, 35, 35))
            .addGroup(dc_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dc_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(warning_label, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dc_panelLayout.createSequentialGroup()
                        .addComponent(dc_button, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ac_button, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dc_panelLayout.setVerticalGroup(
            dc_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dc_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dc_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(magnitude_dc_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(magnitude_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warning_label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dc_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dc_button)
                    .addComponent(ac_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dc_model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ac_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("AC"));

        dcoffset_text.setText("0");

        phase_text.setText("0");

        magnitude.setText("Magnitude(V)");

        dc_offset.setText("DC Offset(V)");

        frequency.setText("Frequency(Hz)");

        phase.setText("Phase(Degree)");

        model_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Model"));

        model_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ac.png"))); // NOI18N

        javax.swing.GroupLayout model_panelLayout = new javax.swing.GroupLayout(model_panel);
        model_panel.setLayout(model_panelLayout);
        model_panelLayout.setHorizontalGroup(
            model_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, model_panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(model_label, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        model_panelLayout.setVerticalGroup(
            model_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(model_label, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        current.setText("Current Source");
        current.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ac_panelLayout = new javax.swing.GroupLayout(ac_panel);
        ac_panel.setLayout(ac_panelLayout);
        ac_panelLayout.setHorizontalGroup(
            ac_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ac_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ac_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dc_offset)
                    .addComponent(magnitude)
                    .addComponent(frequency)
                    .addComponent(phase))
                .addGap(12, 12, 12)
                .addGroup(ac_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phase_text)
                    .addComponent(frequency_text)
                    .addComponent(dcoffset_text, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(magnitude_text))
                .addContainerGap())
            .addComponent(model_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ac_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(current)
                .addGap(43, 43, 43))
        );
        ac_panelLayout.setVerticalGroup(
            ac_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ac_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ac_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(magnitude_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(magnitude))
                .addGap(18, 18, 18)
                .addGroup(ac_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dcoffset_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dc_offset))
                .addGap(18, 18, 18)
                .addGroup(ac_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(frequency_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(frequency))
                .addGap(18, 18, 18)
                .addGroup(ac_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phase_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phase))
                .addGap(18, 18, 18)
                .addComponent(current)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(model_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dc_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ac_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dc_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ac_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ac_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ac_buttonActionPerformed
        String magnitude=magnitude_text.getText();
        String frequency=frequency_text.getText();
        if(magnitude.equals(""))
        {
            warning_label.setText("Please enter AC Magnitude !");
        }
        else
        {
            flag=false;
            double d = Double.parseDouble(magnitude);
            s1=new ACSource();
            s1.setFrequency(frequency);
            s1.setValue(d+"");
            this.dispose();
        }
    }//GEN-LAST:event_ac_buttonActionPerformed

    private void dc_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dc_buttonActionPerformed
        String magnitude=magnitude_dc_text.getText();
        if(magnitude.equals(""))
        {
            warning_label.setText("Please enter DC Magnitude !");
        }
        else
        {
            flag=true;
            s=new DCSource();
            s.setValue(magnitude);
            this.dispose();
        }
    }//GEN-LAST:event_dc_buttonActionPerformed

    private void currentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentActionPerformed
        String magnitude=ampere_value.getText();
        if(magnitude.equals(""))
        {
            warning_label.setText("Please enter Ampere !");
        }
        else
        {
            flag=true;
            s2=new CurrentSource();
            s2.setValue(magnitude);
            this.dispose();
        }
    }//GEN-LAST:event_currentActionPerformed
    public JElement getElement()
    {
        return (s==null?(s1==null?s2:s1):s);
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ac_button;
    private javax.swing.JPanel ac_panel;
    private javax.swing.JLabel ampere;
    private javax.swing.JTextField ampere_value;
    private javax.swing.JButton current;
    private javax.swing.JButton dc_button;
    private javax.swing.JLabel dc_label;
    private javax.swing.JPanel dc_model;
    private javax.swing.JLabel dc_offset;
    private javax.swing.JPanel dc_panel;
    private javax.swing.JTextField dcoffset_text;
    private javax.swing.JLabel frequency;
    private javax.swing.JTextField frequency_text;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel magnitude;
    private javax.swing.JTextField magnitude_dc_text;
    private javax.swing.JLabel magnitude_label;
    private javax.swing.JTextField magnitude_text;
    private javax.swing.JLabel model_label;
    private javax.swing.JPanel model_panel;
    private javax.swing.JLabel phase;
    private javax.swing.JTextField phase_text;
    private javax.swing.JLabel warning_label;
    // End of variables declaration//GEN-END:variables
    private DCSource s;
    private ACSource s1;
    private CurrentSource s2;
    private boolean flag=true;
}