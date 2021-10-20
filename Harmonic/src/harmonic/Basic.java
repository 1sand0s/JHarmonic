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
public class Basic extends javax.swing.JDialog {

    /**
     * Creates new form Basic
     */
    public Basic(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        basic_panel = new javax.swing.JPanel();
        basic_chooser = new javax.swing.JComboBox<>();
        model_panel = new javax.swing.JPanel();
        model_label = new javax.swing.JLabel();
        ok = new javax.swing.JButton();
        value_field = new javax.swing.JTextField();
        value_label = new javax.swing.JLabel();
        warning_label = new javax.swing.JLabel();
        value_panel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        value_list = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Basic");

        basic_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Basic Component"));
        basic_panel.setLayout(null);

        basic_chooser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Resistor", "Capacitor", "Inductor" }));
        basic_chooser.setSelectedIndex(-1);
        basic_chooser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                basic_chooserItemStateChanged(evt);
            }
        });
        basic_panel.add(basic_chooser);
        basic_chooser.setBounds(10, 40, 104, 27);

        model_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Component"));

        javax.swing.GroupLayout model_panelLayout = new javax.swing.GroupLayout(model_panel);
        model_panel.setLayout(model_panelLayout);
        model_panelLayout.setHorizontalGroup(
            model_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, model_panelLayout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(model_label, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        model_panelLayout.setVerticalGroup(
            model_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(model_label, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
        );

        basic_panel.add(model_panel);
        model_panel.setBounds(10, 150, 120, 100);

        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        basic_panel.add(ok);
        ok.setBounds(20, 260, 100, 29);
        basic_panel.add(value_field);
        value_field.setBounds(60, 80, 80, 27);

        value_label.setText("Value");
        basic_panel.add(value_label);
        value_label.setBounds(10, 90, 39, 17);

        warning_label.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        warning_label.setForeground(new java.awt.Color(230, 17, 17));
        basic_panel.add(warning_label);
        warning_label.setBounds(20, 120, 110, 30);

        value_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Values"));

        value_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(value_list);

        javax.swing.GroupLayout value_panelLayout = new javax.swing.GroupLayout(value_panel);
        value_panel.setLayout(value_panelLayout);
        value_panelLayout.setHorizontalGroup(
            value_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
        );
        value_panelLayout.setVerticalGroup(
            value_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(basic_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(value_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(basic_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(value_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void basic_chooserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_basic_chooserItemStateChanged
        chosen=evt.getItem().toString();
        if(chosen.equalsIgnoreCase("Resistor"))
        {
            model_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/resistor1.png")));
        }
        else if(chosen.equalsIgnoreCase("Capacitor"))
        {
            model_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/capacitor1.png")));

        }
        else if(chosen.equalsIgnoreCase("Inductor"))
        {
            model_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/inductor1.png")));
        }
    }//GEN-LAST:event_basic_chooserItemStateChanged

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        value=value_field.getText();
        if(value.equals(""))
        {
            warning_label.setText("Plese enter a value!");
        }
        else
        {
            if(chosen.equals("Resistor"))
            {
                element = new Resistor();
                element.setValue(value);
            }
            else if(chosen.equals("Capacitor"))
            {
                element = new Capacitor();
                element.setValue(value);
            }
            else if(chosen.equals("Inductor"))
            {
                element = new Inductor();
                element.setValue(value);
            }
            this.dispose();
        }
    }//GEN-LAST:event_okActionPerformed
    public JElement getElement()
    {
        return element;
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> basic_chooser;
    private javax.swing.JPanel basic_panel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel model_label;
    private javax.swing.JPanel model_panel;
    private javax.swing.JButton ok;
    private javax.swing.JTextField value_field;
    private javax.swing.JLabel value_label;
    private javax.swing.JList<String> value_list;
    private javax.swing.JPanel value_panel;
    private javax.swing.JLabel warning_label;
    // End of variables declaration//GEN-END:variables
    private String chosen;
    private String value;
    private JElement element;
}
