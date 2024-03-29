/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harmonic;

/**
 *
 * @author itarsi
 */
public class Diodes extends javax.swing.JDialog {

    /**
     * Creates new form Diodes
     */
    public Diodes(java.awt.Frame parent, boolean modal) {
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

        custom_panel = new javax.swing.JPanel();
        rsat_current_field = new javax.swing.JTextField();
        rsat_current_label = new javax.swing.JLabel();
        ok = new javax.swing.JButton();
        model_panel = new javax.swing.JPanel();
        model_label = new javax.swing.JLabel();
        warning_label = new javax.swing.JLabel();
        default_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        default_value_area = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Diode");

        custom_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Custom"));

        rsat_current_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rsat_current_fieldActionPerformed(evt);
            }
        });

        rsat_current_label.setText("RSat Current(nA)");

        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        model_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Model"));

        model_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/diode1.png"))); // NOI18N

        javax.swing.GroupLayout model_panelLayout = new javax.swing.GroupLayout(model_panel);
        model_panel.setLayout(model_panelLayout);
        model_panelLayout.setHorizontalGroup(
            model_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, model_panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(model_label, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        model_panelLayout.setVerticalGroup(
            model_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(model_label, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        warning_label.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        warning_label.setForeground(new java.awt.Color(205, 13, 13));

        javax.swing.GroupLayout custom_panelLayout = new javax.swing.GroupLayout(custom_panel);
        custom_panel.setLayout(custom_panelLayout);
        custom_panelLayout.setHorizontalGroup(
            custom_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(model_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(custom_panelLayout.createSequentialGroup()
                .addGroup(custom_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(custom_panelLayout.createSequentialGroup()
                        .addComponent(rsat_current_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rsat_current_field, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(custom_panelLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(custom_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(warning_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        custom_panelLayout.setVerticalGroup(
            custom_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(custom_panelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(custom_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rsat_current_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rsat_current_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(warning_label, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(model_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ok)
                .addContainerGap())
        );

        default_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Default"));

        default_value_area.setColumns(20);
        default_value_area.setRows(5);
        jScrollPane1.setViewportView(default_value_area);

        javax.swing.GroupLayout default_panelLayout = new javax.swing.GroupLayout(default_panel);
        default_panel.setLayout(default_panelLayout);
        default_panelLayout.setHorizontalGroup(
            default_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
        );
        default_panelLayout.setVerticalGroup(
            default_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(custom_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(default_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(custom_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(default_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        value=rsat_current_field.getText();
        if(value.equals(""))
        {
            warning_label.setText("Please enter a value!");
        }
        else
        {
            Diode d=new Diode();
            d.setValue(value);
            element=d;
            this.dispose();
        }
    }//GEN-LAST:event_okActionPerformed

    private void rsat_current_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rsat_current_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rsat_current_fieldActionPerformed
    public JElement getElement()
    {
        return element;
    }
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel custom_panel;
    private javax.swing.JPanel default_panel;
    private javax.swing.JTextArea default_value_area;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel model_label;
    private javax.swing.JPanel model_panel;
    private javax.swing.JButton ok;
    private javax.swing.JTextField rsat_current_field;
    private javax.swing.JLabel rsat_current_label;
    private javax.swing.JLabel warning_label;
    // End of variables declaration//GEN-END:variables
    private JElement element;
    private String value;
}
