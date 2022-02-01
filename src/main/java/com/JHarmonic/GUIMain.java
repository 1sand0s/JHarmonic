package com.JHarmonic;

import com.JHarmonic.GElement.GElement;

import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author 1sand0s
 * 
 */
public class GUIMain extends JFrame {

    public GUIMain() {
        gElements = new ArrayList<GElement>();
        initComponents();
    }

    private void initComponents() {

        width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        height = (int)(width*0.5);
        
        int message_width = width;
        int message_height = (int)(height/3.0);
        
        int componentPanel_width = (int)(width/8.0);
        int componentPanel_height = (int)(2*height/3.0);
        
        int button_height = (int)(componentPanel_height/8.0);
                
        message_panel = new JPanel();
        jScrollPane1 = new JScrollPane();
        message_area = new JTextArea();
        component_panel = new JPanel();
        basic = new JButton();
        sources = new JButton();
        diode = new JButton();
        transistor = new JButton();
        refresh = new JButton();
        harmonic_solve = new JButton();
        dc_solve = new JButton();
        ac_solve = new JButton();
        transient_solve = new JButton();
        stack = new JButton();
        simulation_panel = new JPanel();
        sim_speed = new JSlider();
        drawing_panel = new JPanel();
        menubar = new JMenuBar();
        jMenu1 = new JMenu();
        jMenu2 = new JMenu();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Circuit Solver");
        setPreferredSize(new java.awt.Dimension(width, height));
        setResizable(false);

        message_panel.setBorder(BorderFactory.createTitledBorder("Messages"));
        message_panel.setPreferredSize(new java.awt.Dimension(message_width,message_height));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(message_width,message_height));

        message_area.setColumns(20);
        message_area.setRows(5);
        message_area.setPreferredSize(new java.awt.Dimension(message_width,message_height));
        jScrollPane1.setViewportView(message_area);

        message_panel.add(jScrollPane1);

        component_panel.setBorder(BorderFactory.createTitledBorder("Components"));
        component_panel.setPreferredSize(new java.awt.Dimension(componentPanel_width, componentPanel_height));

        basic.setText("Basic");
        basic.setPreferredSize(new java.awt.Dimension(componentPanel_width, button_height));
        basic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basicActionPerformed(evt);
            }
        });
        component_panel.add(basic);

        sources.setText("Sources");
        sources.setPreferredSize(new java.awt.Dimension(componentPanel_width, button_height));
        sources.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourcesActionPerformed(evt);
            }
        });
        component_panel.add(sources);

        diode.setText("Diode ");
        diode.setPreferredSize(new java.awt.Dimension(componentPanel_width, button_height));
        diode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diodeActionPerformed(evt);
            }
        });
        component_panel.add(diode);

        transistor.setText("Transistor");
        transistor.setPreferredSize(new java.awt.Dimension(componentPanel_width, button_height));
        transistor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        component_panel.add(transistor);

        refresh.setText("Refresh");
        refresh.setPreferredSize(new java.awt.Dimension(componentPanel_width, button_height));
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        component_panel.add(refresh);

        harmonic_solve.setText("Harmonic");
        harmonic_solve.setPreferredSize(new java.awt.Dimension(componentPanel_width, button_height));
        harmonic_solve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harmonic_solveActionPerformed(evt);
            }
        });
        component_panel.add(harmonic_solve);

        dc_solve.setText("DC Analysis");
        dc_solve.setPreferredSize(new java.awt.Dimension(componentPanel_width, button_height));
        dc_solve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dc_solveActionPerformed(evt);
            }
        });
        component_panel.add(dc_solve);

        ac_solve.setText("AC Analysis");
        ac_solve.setPreferredSize(new java.awt.Dimension(componentPanel_width, button_height));
        ac_solve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ac_solveActionPerformed(evt);
            }
        });
        component_panel.add(ac_solve);

        transient_solve.setText("Transient");
        transient_solve.setPreferredSize(new java.awt.Dimension(componentPanel_width, button_height));
        transient_solve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transient_solveActionPerformed(evt);
            }
        });
        component_panel.add(transient_solve);

        stack.setText("Stack");
        stack.setPreferredSize(new java.awt.Dimension(componentPanel_width, button_height));
        stack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stackActionPerformed(evt);
            }
        });
        component_panel.add(stack);

        simulation_panel.setBorder(BorderFactory.createTitledBorder("Simulation Settings"));

        sim_speed.setOrientation(JSlider.VERTICAL);
        sim_speed.setBorder(BorderFactory.createTitledBorder("Sim Speed"));
        sim_speed.setPreferredSize(new java.awt.Dimension(componentPanel_width, componentPanel_height));
        sim_speed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sim_speedStateChanged(evt);
            }
        });
        simulation_panel.add(sim_speed);

        drawing_panel.setBackground(new java.awt.Color(14, 12, 9));
        drawing_panel.setBorder(BorderFactory.createTitledBorder(null, "Schematic", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(247, 237, 237))); // NOI18N
        drawing_panel.setForeground(new java.awt.Color(252, 245, 245));
        drawing_panel.setLayout(null);
        getContentPane().add(drawing_panel);

        menubar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                menubarKeyPressed(evt);
            }
        });

        jMenu1.setText("File");
        menubar.add(jMenu1);

        jMenu2.setText("Edit");
        menubar.add(jMenu2);

        setJMenuBar(menubar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(component_panel, GroupLayout.PREFERRED_SIZE, componentPanel_width, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(drawing_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(simulation_panel, GroupLayout.PREFERRED_SIZE, componentPanel_width, GroupLayout.PREFERRED_SIZE))
            .addComponent(message_panel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(component_panel, GroupLayout.DEFAULT_SIZE, componentPanel_height, Short.MAX_VALUE)
                    .addComponent(drawing_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(simulation_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(message_panel, GroupLayout.PREFERRED_SIZE, message_height, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }
    
    private void basicActionPerformed(java.awt.event.ActionEvent evt) {
        Basic b =  new Basic(this,true, width, height);
        b.setVisible(true);
    }

    private void sourcesActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void diodeActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void menubarKeyPressed(java.awt.event.KeyEvent evt) {

    }

    private void harmonic_solveActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void ac_solveActionPerformed(java.awt.event.ActionEvent evt) {
      
    }

    private void dc_solveActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void transient_solveActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void sim_speedStateChanged(javax.swing.event.ChangeEvent evt) {
        JSlider slider=(JSlider)evt.getSource();
    }

    private void stackActionPerformed(java.awt.event.ActionEvent evt) {
    }
 
    /*Menu Bar and its buttons*/
    private JMenuBar menubar;
    private JMenu jMenu1;
    private JMenu jMenu2;
    
    /*Component Panel and its buttons*/
    private JPanel component_panel;
    private JButton ac_solve;
    private JButton dc_solve;
    private JButton harmonic_solve;
    private JButton transient_solve;

    private JButton basic;
    private JButton diode;
    private JButton sources;
    private JButton transistor; 
    
    /*Simulation Panel and its buttons*/
    private JPanel simulation_panel;
    private JSlider sim_speed;

    /*Message Panel and its buttons*/
    private JPanel message_panel;
    private JScrollPane jScrollPane1;
    private JTextArea message_area;

    private JPanel drawing_panel;
    private JButton refresh;
    private JButton stack;
    
    private int width;
    private int height;
    
    private ArrayList<GElement> gElements;
}