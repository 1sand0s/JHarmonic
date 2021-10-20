/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harmonic;

import com.sl.connector.ConnectorContainer;
import com.sl.connector.JConnector;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.UIManager;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author itarsi
 */
public class MainFrame2 extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame2
     */
    public MainFrame2() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        message_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        message_area = new javax.swing.JTextArea();
        component_panel = new javax.swing.JPanel();
        basic = new javax.swing.JButton();
        sources = new javax.swing.JButton();
        diode = new javax.swing.JButton();
        transistor = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        harmonic_solve = new javax.swing.JButton();
        dc_solve = new javax.swing.JButton();
        ac_solve = new javax.swing.JButton();
        transient_solve = new javax.swing.JButton();
        stack = new javax.swing.JButton();
        simulation_panel = new javax.swing.JPanel();
        sim_speed = new javax.swing.JSlider();
        drawing_panel = new com.sl.connector.ConnectorContainer();
        menubar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Circuit Solver");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(911, 620));
        setResizable(false);

        message_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Messages"));
        message_panel.setMinimumSize(new java.awt.Dimension(800, 250));
        message_panel.setPreferredSize(new java.awt.Dimension(800, 250));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(this.getWidth(),110));

        message_area.setColumns(20);
        message_area.setRows(5);
        message_area.setMaximumSize(new java.awt.Dimension(this.getWidth(),110));
        message_area.setMinimumSize(new java.awt.Dimension(this.getWidth(),110));
        message_area.setPreferredSize(new java.awt.Dimension(this.getWidth(),110));
        jScrollPane1.setViewportView(message_area);

        message_panel.add(jScrollPane1);

        component_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Components"));
        component_panel.setMaximumSize(new java.awt.Dimension(70, 284));
        component_panel.setMinimumSize(new java.awt.Dimension(70, 350));
        component_panel.setPreferredSize(new java.awt.Dimension(70, 350));

        basic.setText("Basic");
        basic.setMaximumSize(new java.awt.Dimension(90, 29));
        basic.setMinimumSize(new java.awt.Dimension(90, 29));
        basic.setPreferredSize(new java.awt.Dimension(90, 29));
        basic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basicActionPerformed(evt);
            }
        });
        component_panel.add(basic);

        sources.setText("Sources");
        sources.setMaximumSize(new java.awt.Dimension(90, 29));
        sources.setMinimumSize(new java.awt.Dimension(90, 29));
        sources.setPreferredSize(new java.awt.Dimension(90, 29));
        sources.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourcesActionPerformed(evt);
            }
        });
        component_panel.add(sources);

        diode.setText("Diode ");
        diode.setMaximumSize(new java.awt.Dimension(90, 29));
        diode.setMinimumSize(new java.awt.Dimension(90, 29));
        diode.setPreferredSize(new java.awt.Dimension(90, 29));
        diode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diodeActionPerformed(evt);
            }
        });
        component_panel.add(diode);

        transistor.setText("Transistor");
        transistor.setMaximumSize(new java.awt.Dimension(90, 29));
        transistor.setMinimumSize(new java.awt.Dimension(90, 29));
        transistor.setPreferredSize(new java.awt.Dimension(90, 29));
        transistor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transistorActionPerformed(evt);
            }
        });
        component_panel.add(transistor);

        refresh.setText("Refresh");
        refresh.setMaximumSize(new java.awt.Dimension(90, 29));
        refresh.setMinimumSize(new java.awt.Dimension(90, 29));
        refresh.setPreferredSize(new java.awt.Dimension(90, 29));
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        component_panel.add(refresh);

        harmonic_solve.setText("Harmonic");
        harmonic_solve.setMaximumSize(new java.awt.Dimension(90, 29));
        harmonic_solve.setMinimumSize(new java.awt.Dimension(90, 29));
        harmonic_solve.setPreferredSize(new java.awt.Dimension(90, 29));
        harmonic_solve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harmonic_solveActionPerformed(evt);
            }
        });
        component_panel.add(harmonic_solve);

        dc_solve.setText("DC Analysis");
        dc_solve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dc_solveActionPerformed(evt);
            }
        });
        component_panel.add(dc_solve);

        ac_solve.setText("AC Analysis");
        ac_solve.setMaximumSize(new java.awt.Dimension(90, 29));
        ac_solve.setMinimumSize(new java.awt.Dimension(90, 29));
        ac_solve.setPreferredSize(new java.awt.Dimension(90, 29));
        ac_solve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ac_solveActionPerformed(evt);
            }
        });
        component_panel.add(ac_solve);

        transient_solve.setText("Transient");
        transient_solve.setMaximumSize(new java.awt.Dimension(90, 29));
        transient_solve.setPreferredSize(new java.awt.Dimension(90, 29));
        transient_solve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transient_solveActionPerformed(evt);
            }
        });
        component_panel.add(transient_solve);

        stack.setText("Stack");
        stack.setMaximumSize(new java.awt.Dimension(90, 29));
        stack.setMinimumSize(new java.awt.Dimension(90, 29));
        stack.setPreferredSize(new java.awt.Dimension(90, 29));
        stack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stackActionPerformed(evt);
            }
        });
        component_panel.add(stack);

        simulation_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Simulation Settings"));

        sim_speed.setOrientation(javax.swing.JSlider.VERTICAL);
        sim_speed.setBorder(javax.swing.BorderFactory.createTitledBorder("Sim Speed"));
        sim_speed.setMaximumSize(new java.awt.Dimension(100, 32767));
        sim_speed.setMinimumSize(new java.awt.Dimension(100, 59));
        sim_speed.setPreferredSize(new java.awt.Dimension(100, 223));
        sim_speed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sim_speedStateChanged(evt);
            }
        });
        simulation_panel.add(sim_speed);

        drawing_panel.setBackground(new java.awt.Color(14, 12, 9));
        drawing_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Schematic", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(247, 237, 237))); // NOI18N
        drawing_panel.setForeground(new java.awt.Color(252, 245, 245));
        im = drawing_panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);

        am = drawing_panel.getActionMap();

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "w");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_R,0), "r");
        am.put("w", new ArrowAction("w"));
        am.put("r", new ArrowAction("r"));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(component_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(drawing_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(simulation_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(message_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(component_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                    .addComponent(drawing_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(simulation_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(message_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void basicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basicActionPerformed
        Basic b =  new Basic(this,true);
        b.setVisible(true);
        try{
            JElement l=b.getElement();
            if(l instanceof Resistor)
            {
                Resistor_Count++;
                l.setLocation(200, 100);
                l.setSize(75,50);
                l.setVisible(true);
            }
            else if(l instanceof Capacitor)
            {
                Capacitor_Count++;
                l.setLocation(200, 100);
                l.setSize(60,50);
                l.setVisible(true);
            }
            else if(l instanceof Inductor)
            {
                Inductor_Count++;
                l.setLocation(200, 100);
                l.setSize(35,30);
                l.setVisible(true);
            }
            j_dragger.add(l);
            drawing_panel.add(l);
            drawing_panel.revalidate();
            drawing_panel.repaint();
            pack();
           
        }catch(NullPointerException e)
        {
            
        }
    }//GEN-LAST:event_basicActionPerformed

    private void sourcesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourcesActionPerformed
        Sources s =  new Sources(this,true);
        s.setVisible(true);
        try{
            JElement l=(JElement)s.getElement();
            l.setLocation(200, 100);
            l.setSize(65,65);
            l.setVisible(true);
            j_dragger.add(l);
            drawing_panel.add(l);
            drawing_panel.revalidate();
            drawing_panel.repaint();
            pack();
            if(l instanceof DCSource)
            {
                Source_Count++;
                actual_source_count++;
            }
            if(l instanceof ACSource)
            {
                ACSource ac=(ACSource)l;
                minFrequency=ac.getFrequency()<minFrequency?ac.getFrequency():minFrequency;
                Source_Count++;
                AC_Count++;
                actual_source_count++;
            }
            else if(l instanceof CurrentSource)
            {
                
            }
        }catch(NullPointerException e)
        {
            
        }
        
    }//GEN-LAST:event_sourcesActionPerformed

    private void diodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diodeActionPerformed
        Diodes d =  new Diodes(this,true);
        d.setVisible(true);
        try{
            Diode l=(Diode)d.getElement();
            l.setLocation(200, 100);
            l.setSize(70,75);
            l.setVisible(true);
            j_dragger.add(l);
            drawing_panel.add(l);
            drawing_panel.revalidate();
            drawing_panel.repaint();
            pack();
            Diode_Count++;
            actual_source_count++;
        }catch(NullPointerException e)
        {
            
        }
    }//GEN-LAST:event_diodeActionPerformed

    private void transistorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transistorActionPerformed
        Transistor t =new Transistor(this,true);
        t.setVisible(true);
    }//GEN-LAST:event_transistorActionPerformed

    private void menubarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_menubarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_menubarKeyPressed

    private void harmonic_solveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harmonic_solveActionPerformed
        tstart=0;
        HarmonicBalancer h=new HarmonicBalancer(this,true);
        h.setVisible(true);
        order_voltages=h.getOrderVoltages();
        harmonic_count=order_voltages.length;
        fundamental_freq=h.getFundamentalFrequency();
        for(int i=0;i<j_dragger.size();i++)
        {
            if(j_dragger.get(i) instanceof DCSource || j_dragger.get(i) instanceof ACSource || j_dragger.get(i) instanceof Diode)
            {
                JElement j=j_dragger.get(i);
                j.setPhaseExpansion(harmonic_count);
            }
        }
        NodeMapper mapnode=new NodeMapper(j_dragger,GND_node);
        mapnode.Update_node();
        Map<Integer,ArrayList<JNode>>mapper=mapnode.getNodeMap();
        mapnode.printNodeList(message_area);
        t=new Timer(simulation_speed,new ActionListener()
        {
            
        MNA_FD m=new MNA_FD(actual_source_count,mapper);
        int c;
        MatrixOperations mat=new MatrixOperations();
        Complex temp2[][]=new Complex[MainFrame2.Connector_Count-1+Source_Count][harmonic_count+1];
        public void actionPerformed(ActionEvent e){
        temp2=m.call();if(c==Diode_Count){t.stop();};c=0;
        for(int i=0;i<j_dragger.size();i++)
        {
            if(j_dragger.get(i) instanceof Diode)
            {
                Diode d=(Diode)j_dragger.get(i);
                Complex temp[]=temp2[d.getActualID()+MainFrame2.Connector_Count-1];
                Complex ilinear[]=new Complex[temp.length];
                ilinear=temp;
                Complex inlinear[]=(d.getDiodeCurrent(mat.computeIFFT(d.getPhaseExpansion2())));
                for(int k=1;k<inlinear.length;k++)
                {
                    System.out.println(inlinear[k].getReal()+"  ,inlinear  "+inlinear[k].getImaginary());
                }
                inlinear=Complex.ScalarMultiply(mat.computeFFT(inlinear),-1);
                Complex[] kcl_error=Complex.AddSubArray(ilinear,inlinear,1);
                System.out.println(Complex.computeNorm(kcl_error)+" KCL"+i);
                if(Complex.computeNorm(kcl_error)<5e-3)
                {
                    c++;
                }
                Complex voltage2[]=d.getPhaseExpansion2();
                Complex jacobian[][]=new Complex[harmonic_count+1][harmonic_count+1];
                for(int j=1;j<jacobian.length;j++)
                {
                    jacobian[j]=Complex.Multiply(MatrixOperations.idftMatrix(harmonic_count)[j-1],Complex.ScalarMultiply(inlinear,1/d.getVt()));
                    jacobian[j][j]=Complex.AddSub(jacobian[j][j],Complex.getAdmittance(d.getActualID()+MainFrame2.Connector_Count-1),1);
                }
                jacobian=Complex.transpose(jacobian);
                Complex rhs[]=new Complex[jacobian.length];
                for(int j=1;j<jacobian.length;j++)
                {
                    rhs[j]=Complex.AddSub(Complex.multiply(jacobian[j],voltage2),kcl_error[j],-1);
                }
                Complex voltage3[][]=Complex.computeLinearEquation(jacobian,new Complex[][]{new Complex[rhs.length],rhs},false);
                Complex voltage4[]=mat.computeIFFT(Complex.transpose(voltage3)[1]);
                Complex vol5[]=Complex.transpose(voltage3)[1];
               /* for(int k=1;k<vol5.length;k++)
                {
                    vol5[k].setReal(vol5[k].getReal()>1?0.8:vol5[k].getReal());
                    vol5[k].setImaginary(vol5[k].getImaginary()>1?0.8:vol5[k].getImaginary());
                    vol5[k].setReal(vol5[k].getReal()<-1e10?0:vol5[k].getReal());
                    vol5[k].setImaginary(vol5[k].getImaginary()<-1e10?0:vol5[k].getImaginary());
                        //System.out.println(Complex.computeAbs(vol5[k])+"    final "+i);
                }*/
                for(int k=1;k<vol5.length;k++)
                {
                    vol5[k]=Complex.removeRedundancy(vol5[k]);
                    System.out.println(vol5[k].getReal()+" final "+vol5[k].getImaginary()+"  "+i);
                }
                d.setPhaseExpansion(vol5);
            }
        }}
        });t.start();
        /*t= new Timer(simulation_speed,new ActionListener()
        {
            double temp2[][]=new double[MainFrame2.Connector_Count-1+Source_Count][harmonic_count+1];
            MatrixOperations mat=new MatrixOperations();
            double temp[][]=new double[temp2.length][temp2[0].length];
            int k=0;
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                    temp2=m.call();
                    k++;
                    int c=0;
                    System.out.println(scope_count);
                    for(int i=0;i<j_dragger.size();i++)
                    {
                        if(j_dragger.get(i) instanceof Diode)
                        {
                            Diode d=(Diode)j_dragger.get(i);
                            JNode anode=d.getNode1();
                            JNode cathode=d.getNode2();  System.out.println(i+"  "+c+"  "+((temp2[anode.ID][1]-temp2[cathode.ID][1])-(temp[anode.ID][1]-temp[cathode.ID][1])));
                            if(Math.abs((temp2[anode.ID][1]-temp2[cathode.ID][1])-(temp[anode.ID][1]-temp[cathode.ID][1]))<diode_accuracy)
                            {
                                c++;
                            }
                        }
                    }
                    if(c==Diode_Count)
                    {
                        double y[][]=mat.transpose(temp2);
                        message_area.append("\n");
                        for(int i=1;i<y.length;i++)
                        {
                            for(int j=1;j<y[i].length;j++)
                            {
                                message_area.append(y[i][j]+" ");
                            }
                            message_area.append("\n");
                        }
                    }
                    else
                    {
                        temp=temp2;
                        for(int i=0;i<j_dragger.size();i++)
                        {
                            if(j_dragger.get(i) instanceof Diode)
                            {
                                Diode d=(Diode)j_dragger.get(i);
                                JNode anode = d.getNode1();
                                JNode cathode=d.getNode2();
                                d.setDiodeDrop(temp[anode.ID][1]-temp[cathode.ID][1]);
                            }
                        }
                    }
            }
        });
        t.start();   */
    }//GEN-LAST:event_harmonic_solveActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
       drawing_panel.removeAll();
       j_dragger.clear();
       Connector_Count=1;
       Resistor_Count=0;
       Source_Count=0;
       Diode_Count=0;
       actual_source_count=0;
       jselect.clear();
       j.clear();
       fundamental_freq=0;
       drawing_panel.revalidate();
       drawing_panel.repaint();
    }//GEN-LAST:event_refreshActionPerformed

    private void ac_solveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ac_solveActionPerformed
        NodeMapper mapnode=new NodeMapper(j_dragger,GND_node);
        mapnode.Update_node();
        Map<Integer,ArrayList<JNode>>mapper=mapnode.getNodeMap();
        mapnode.printNodeList(message_area);
        double temp2[][];
        m=new MNA_DC(Source_Count,true,mapper);
        //temp2=m.call();
    }//GEN-LAST:event_ac_solveActionPerformed

    private void dc_solveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dc_solveActionPerformed
        NodeMapper mapnode=new NodeMapper(j_dragger,GND_node);
        mapnode.Update_node();
        tstart=0;
        Map<Integer,ArrayList<JNode>>mapper=mapnode.getNodeMap();
        mapnode.printNodeList(message_area);
        m=new MNA_DC(Source_Count,true,mapper);
        scope_list=new double[2*MainFrame2.Connector_Count];
        DecimalFormat format = new DecimalFormat("#.00");
        int[][] voltage3=new int[2*MainFrame2.Connector_Count][300];
        int[][] current3=new int[2*MainFrame2.Connector_Count][300];
        double[][] voltage4=new double[2*MainFrame2.Connector_Count][300];
        double[][] current4=new double[2*MainFrame2.Connector_Count][300];
        for(int i=0;i<voltage3.length;i++)
        {
            for(int j=0;j<voltage3[i].length;j++)
            {
                voltage3[i][j]=drawing_panel.getHeight()-60;
                current3[i][j]=drawing_panel.getHeight()-60;
            }
        }
        int[][] current1=new int[MainFrame2.Connector_Count-1][300];
        t= new Timer(simulation_speed,new ActionListener()
        {
            double temp2[][]=new double[MainFrame2.Connector_Count-1+Source_Count][2];
            MatrixOperations mat=new MatrixOperations();
            double temp[][]=new double[temp2.length][temp2[0].length];
            int k=0;
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                    drawing_panel.set_tstart(String.format("%5.3e",tstart));
                    drawing_panel.setScopeCount(scope_count);
                    drawing_panel.setVoltage(voltage3);
                    drawing_panel.setCurrent(current3);
                    drawing_panel.setMaxVoltages(scope_list);
                    drawing_panel.repaint();
                    temp2=m.call();
                    k++;
                    int c=0;
                    for(int i=0;i<j_dragger.size();i++)
                    {
                        if(j_dragger.get(i) instanceof Diode)
                        {
                            Diode d=(Diode)j_dragger.get(i);
                            JNode anode=d.getNode1();
                            JNode cathode=d.getNode2(); 
                            if(Math.abs((temp2[anode.ID][1]-temp2[cathode.ID][1])-(temp[anode.ID][1]-temp[cathode.ID][1]))<diode_accuracy)
                            {
                                c++;
                            }
                        }
                        else if(j_dragger.get(i) instanceof Capacitor && tstep2==tstep)
                        {
                            Capacitor c1=(Capacitor)j_dragger.get(i);
                            c1.setVoltage(temp2[c1.getNode1().ID][1]-temp2[c1.getNode2().ID][1]);
                        }
                    }
                    tstep2=10;
                    if(c==Diode_Count)
                    {
                        double y[][]=mat.transpose(temp2);
                        message_area.append("\n");
                        for(int i=1;i<y.length;i++)
                        {
                            for(int j=1;j<y[i].length;j++)
                            {
                                message_area.append(y[i][j]+" ");
                            }
                            message_area.append("\n");
                        }
                        for(int i=0;i<j_dragger.size();i++)
                        {
                            if(j_dragger.get(i).getScopeState() )//&& j_dragger.get(i) instanceof Resistor)
                            {
                                JElement r=j_dragger.get(i);
                                int scope_id=r.getNode1Scope()==0?r.getNode2Scope():r.getNode1Scope();
                                double val[]=r.getVoltageandCurrent(y[1]);
                                System.arraycopy(voltage3[scope_id],0,voltage3[scope_id],1,voltage3[scope_id].length-1);
                                System.arraycopy(voltage4[scope_id],0,voltage4[scope_id],1,voltage4[scope_id].length-1);
                                System.arraycopy(current3[scope_id],0,current3[scope_id],1,current3[scope_id].length-1);
                                System.arraycopy(current4[scope_id],0,current4[scope_id],1,current4[scope_id].length-1);
                                double y0=drawing_panel.getHeight()-110;
                                double y1=drawing_panel.getHeight()-10;
                                voltage4[scope_id][0]=val[0];
                                current4[scope_id][0]=val[1];
                                double max=mat.maxArray(voltage4[scope_id]);
                                double min=mat.minArray(voltage4[scope_id]);
                                double max2=mat.maxArray(current4[scope_id]);
                                double min2=mat.minArray(current4[scope_id]);
                                scope_list[scope_id]=Math.abs(max)>Math.abs(min)?max:min;
                                double id=Math.abs(max2)>Math.abs(min2)?max2:min2;
                                voltage3[scope_id][0]=(int)(y0+(y1-y0)/2+2*val[0]);
                                current3[scope_id][0]=(int)(y0+(y1-y0)/2+10*val[1]/id);
                            }
                        }
                        tstart=tstart+tstep;
                        tstep2=tstep;
                    }
                    else
                    {
                        temp=temp2;
                        for(int i=0;i<j_dragger.size();i++)
                        {
                            if(j_dragger.get(i) instanceof Diode)
                            {
                                Diode d=(Diode)j_dragger.get(i);
                                JNode anode = d.getNode1();
                                JNode cathode=d.getNode2();
                                d.setDiodeDrop(temp[anode.ID][1]-temp[cathode.ID][1]>1?0.8:temp[anode.ID][1]-temp[cathode.ID][1]);
                            }
                        }
                    }
            }
        });
        t.start();   
    }//GEN-LAST:event_dc_solveActionPerformed

    private void transient_solveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transient_solveActionPerformed
        
    }//GEN-LAST:event_transient_solveActionPerformed

    private void sim_speedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sim_speedStateChanged
        JSlider slider=(JSlider)evt.getSource();
        simulation_speed=slider.getValue();
        if(t!=null)
        {
            t.setDelay(simulation_speed);
        }
    }//GEN-LAST:event_sim_speedStateChanged

    private void stackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stackActionPerformed
        drawing_panel.setStack((stack1)?0:1);
        stack1=!stack1;
        
    }//GEN-LAST:event_stackActionPerformed
    public int getNodeCount()
    {
        return Connector_Count-2;
    }
    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ac_solve;
    private javax.swing.JButton basic;
    private javax.swing.JPanel component_panel;
    private javax.swing.JButton dc_solve;
    private javax.swing.JButton diode;
    public static com.sl.connector.ConnectorContainer drawing_panel;
    private javax.swing.JButton harmonic_solve;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menubar;
    public static javax.swing.JTextArea message_area;
    private javax.swing.JPanel message_panel;
    private javax.swing.JButton refresh;
    private javax.swing.JSlider sim_speed;
    private javax.swing.JPanel simulation_panel;
    private javax.swing.JButton sources;
    private javax.swing.JButton stack;
    private javax.swing.JButton transient_solve;
    private javax.swing.JButton transistor;
    // End of variables declaration//GEN-END:variables
    private InputMap im;
    private ActionMap am;
    private MNA_DC m;
    private double diode_accuracy=0.00001;
    private boolean time_sim=false;
    private double minFrequency=1e6;
    private int simulation_speed=10;
    private Timer t;
    static double[] order_voltages=new double[1];
    private double[] scope_list;
    private boolean stack1=true;
    static double tstep=1e-4;
    private double tstep2=tstep;
    static int harmonic_count=0;
    static int scope_count=1;
    static int AC_Count=0;
    static int Connector_Count=1;
    static int Resistor_Count=0;
    static int Source_Count=0;
    static int Diode_Count=0;
    static int Transistor_Count=0;
    static int actual_source_count=0;
    static int Capacitor_Count=0;
    static int Inductor_Count=0;
    static ArrayList<JElement> j_dragger =new ArrayList<JElement>();
    static ArrayList<JNode> jselect = new ArrayList<JNode>(2);;
    static boolean flag_select=false;
    static ArrayList<JConnector> j=new ArrayList<JConnector>();
    static JNode GND_node;
    static double fundamental_freq=0;
    static double tstart=0;
    static boolean rotate_flag=false;
    static double step_size=1;
        
}
class ArrowAction extends AbstractAction {

    private String cmd;

    public ArrowAction(String cmd) {
        this.cmd = cmd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (cmd.equalsIgnoreCase("w")) {
            MainFrame2.flag_select=true;
        } 
        else if(cmd.equalsIgnoreCase("r"))
        {
            MainFrame2.rotate_flag=true;
        }
    }

    
}