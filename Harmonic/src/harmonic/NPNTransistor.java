/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harmonic;

import com.sl.connector.JConnector;
import com.sl.line.ConnectLine;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JWindow;

/**
 *
 * @author itarsi
 */
public class NPNTransistor extends JElement {

    /**
     * Creates new form NPNTransistor1
     */
    NPNTransistor_Dragger drag_handle=new NPNTransistor_Dragger();
    public NPNTransistor() {
        initComponents();
        addMouseListener(drag_handle);
        addMouseMotionListener(drag_handle);
    }
    public JNode node_pair(JNode node)
    {
        if(node.equals(this.emitter))
        {
            return this.collector;
        }
        else
        {
            return this.emitter;
        }
    }
    public NPNTransistor getNPNTransistor()
    {
        return this;
    }
    public JNode getNode1()
    {
        return this.emitter;
    }
    public JNode getNode2()
    {
        return this.collector;
    }
    public JNode getNode3()
    {
        return this.base;
    }
    public String getId()
    {
        return "D"+this.id;
    }
    public int getId_int()
    {
        return this.id;
    }
    public double getValue()
    {
        return 1/((sat_current*Math.exp(diode_drop/vt))/vt);
    }
    public void setValue(String value)
    {
        this.value=value;
        diode_label.setText("D"+MainFrame2.Transistor_Count+" "+this.value);
    }
    public void setVt(double vt)
    {
        this.vt=vt;
    }
    public void setNPNTransistorDrop(double diode_drop)
    {
        this.diode_drop=diode_drop;
    }
    public double getNPNTransistorDrop()
    {
        return diode_drop;
    }
    public double getVt()
    {
        return vt;
    }
    public double getNPNTransistorCurrent()
    {
       return sat_current*Math.exp(diode_drop/vt);
    }
    public double getNPNTransistorSatCurrent()
    {
        return sat_current;
    }

    @Override
    public boolean getScopeState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double[] getPhaseExpansion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPhaseExpansion(int size) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getActualID() {
        return actual_id;
    }

    @Override
    public int getNode1Scope() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNode2Scope() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNode3Scope() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double[] getVoltageandCurrent(double[] result) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    protected class NPNTransistor_Dragger extends MouseAdapter implements MouseMotionListener,MouseListener 
    {
        Window dragWindow = new JWindow() 
        {
            public void paint(Graphics g) 
            {
                super.paint(g);
                NPNTransistor.this.paint(g);
            }
        };
        public void mouseDragged(MouseEvent e) 
        {
            javax.swing.JComponent jc =(javax.swing.JComponent)e.getSource();
            jc.setLocation(jc.getX()+e.getX()-25,jc.getY()+e.getY()-25);
            dragWindow.setLocation(jc.getLocation());
            getParent().repaint();
        }
        public void mouseEntered(MouseEvent e)
        {
            flag=false;
            repaint();
        }
        public void mouseExited(MouseEvent e)
        {
            flag=true;
            repaint();
        }
    }              
                        
    private void initComponents() {

        collector = new JNode();
        emitter = new JNode();
        diode_label = new javax.swing.JLabel("D"+id);

        setLayout(null);

        

        collector.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                collectorMouseMoved(evt);
            }
        });
        collector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                collectorMouseClicked(evt);
            }
        });
        add(collector);
        collector.setBounds(50,10,10,10);

        emitter.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                emitterMouseMoved(evt);
            }
        });
        emitter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emitterMouseClicked(evt);
            }
        });
        add(emitter);
        emitter.setBounds(0,10,10,10);

        diode_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                diode_labelMouseClicked(evt);
            }
        });
        add(diode_label);
        diode_label.setBounds(10, 40, 60, 15);
        this.setOpaque(false);
    }                    
    private void collectorMouseClicked(java.awt.event.MouseEvent evt) {                                     
        if(MainFrame2.flag_select)
            {
               
                MainFrame2.jselect.add(collector);
                if(MainFrame2.jselect.size()==2)
                {
                    collector.neighbour.add(MainFrame2.jselect.get(0));
                    MainFrame2.jselect.get(0).neighbour.add(collector);
                    if(MainFrame2.jselect.get(0).ID!=-1 || MainFrame2.jselect.get(1).ID!=-1)
                    {
                        MainFrame2.j.add(new JConnector(MainFrame2.jselect.get(0),MainFrame2.jselect.get(1),ConnectLine.LINE_ARROW_NONE,JConnector.CONNECT_LINE_TYPE_RECTANGULAR,Color.GREEN,MainFrame2.jselect.get(0).ID));
                        if(MainFrame2.jselect.get(0).ID==-1)
                        {
                            MainFrame2.jselect.get(0).ID=MainFrame2.jselect.get(1).ID;
                        }
                        else
                        {
                            MainFrame2.jselect.get(1).ID=MainFrame2.jselect.get(0).ID;
                        } 
                        
                    }
                    else
                    {
                        MainFrame2.j.add(new JConnector(MainFrame2.jselect.get(0),MainFrame2.jselect.get(1),ConnectLine.LINE_ARROW_NONE,JConnector.CONNECT_LINE_TYPE_RECTANGULAR,Color.GREEN,MainFrame2.Connector_Count));
                        MainFrame2.jselect.get(0).ID=MainFrame2.Connector_Count;
                        MainFrame2.jselect.get(1).ID=MainFrame2.Connector_Count++;
                    }
                    MainFrame2.drawing_panel.setConnectors(MainFrame2.j);
                    MainFrame2.flag_select=false;
                    MainFrame2.jselect.clear();
                    MainFrame2.drawing_panel.revalidate();
                    MainFrame2.drawing_panel.repaint();
                }
            }
        else if(!MainFrame2.flag_select)
        {
            MainFrame2.GND_node=(JOptionPane.showConfirmDialog(this,"Set this node as GND?","GND Node",JOptionPane.YES_NO_OPTION))==JOptionPane.YES_OPTION?this.collector:null;
        }
    }                                    

    private void emitterMouseClicked(java.awt.event.MouseEvent evt) {                                   
        if(MainFrame2.flag_select )
            {
               
                MainFrame2.jselect.add(emitter);
                if(MainFrame2.jselect.size()==2)
                {
                    emitter.neighbour.add(MainFrame2.jselect.get(0));
                    MainFrame2.jselect.get(0).neighbour.add(emitter);
                    if(MainFrame2.jselect.get(0).ID!=-1 || MainFrame2.jselect.get(1).ID!=-1)
                    {
                        MainFrame2.j.add(new JConnector(MainFrame2.jselect.get(0),MainFrame2.jselect.get(1),ConnectLine.LINE_ARROW_NONE,JConnector.CONNECT_LINE_TYPE_RECTANGULAR,Color.GREEN,MainFrame2.jselect.get(0).ID));
                        if(MainFrame2.jselect.get(0).ID==-1)
                        {
                            MainFrame2.jselect.get(0).ID=MainFrame2.jselect.get(1).ID;
                        }
                        else
                        {
                            MainFrame2.jselect.get(1).ID=MainFrame2.jselect.get(0).ID;
                        } 
                        
                    }
                    else
                    {
                        MainFrame2.j.add(new JConnector(MainFrame2.jselect.get(0),MainFrame2.jselect.get(1),ConnectLine.LINE_ARROW_NONE,JConnector.CONNECT_LINE_TYPE_RECTANGULAR,Color.GREEN,MainFrame2.Connector_Count));
                        MainFrame2.jselect.get(0).ID=MainFrame2.Connector_Count;
                        MainFrame2.jselect.get(1).ID=MainFrame2.Connector_Count++;
                    }
                    MainFrame2.drawing_panel.setConnectors(MainFrame2.j);
                    MainFrame2.flag_select=false;
                    MainFrame2.jselect.clear();
                    MainFrame2.drawing_panel.revalidate();
                    MainFrame2.drawing_panel.repaint();
                }
            }
        else if(!MainFrame2.flag_select)
        {
            MainFrame2.GND_node=(JOptionPane.showConfirmDialog(this,"Set this node as GND?","GND Node",JOptionPane.YES_NO_OPTION))==JOptionPane.YES_OPTION?this.emitter:null;
        }
    }                                  

    private void diode_labelMouseClicked(java.awt.event.MouseEvent evt) {                                        
        // TODO add your handling code here:
    }                          

    private void collectorMouseMoved(java.awt.event.MouseEvent evt) {                                   
        collector.setCursor(new Cursor(Cursor.WAIT_CURSOR));
    }                                  

                                    

    private void emitterMouseMoved(java.awt.event.MouseEvent evt) {                                 
        emitter.setCursor(new Cursor(Cursor.WAIT_CURSOR));
    }         
    public void paintComponent(Graphics g)
    {
        g.setColor((flag)?Color.GREEN:Color.WHITE);
        Graphics2D g2=(Graphics2D)g;
        g2.setStroke(new BasicStroke(2));
        g2.drawOval(15,0,30,30);
        g2.drawLine(20,0,20,30);
        g2.drawLine(20,0,40,15);
        g2.drawLine(20,30,40,15);
        g2.drawLine(40,0,40,30);
        g2.drawLine(0,15,20,15);
        g2.drawLine(40,15,55,15);
        g.setColor(Color.YELLOW);
        g2.fillOval(0,10,10,10);
        g2.fillOval(50,10,10,10);
    }

                                           
                 
    private JNode emitter;
    private JNode collector;
    private JNode base;
    private javax.swing.JLabel diode_label;
    private int actual_id=MainFrame2.actual_source_count;
    private int id=MainFrame2.Transistor_Count;
    private String value="";
    private double diode_drop=0.7;
    private double sat_current=10*Math.pow(10,-12);
    private double vt=0.039;
    private boolean flag=true;
}

