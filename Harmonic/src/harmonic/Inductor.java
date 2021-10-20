/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harmonic;

import com.sl.connector.JConnector;
import com.sl.line.ConnectLine;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
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
public class Inductor extends JElement {

    /**
     * Creates new form Inductor
     */
    Inductor_Dragger drag_handle=new Inductor_Dragger();
    public Inductor() {
        initComponents();
        addMouseListener(drag_handle);
        addMouseMotionListener(drag_handle);
    }
    public JNode node_pair(JNode node)
    {
        if(node.equals(this.ind_node1))
        {
            return this.ind_node2;
        }
        else
        {
            return this.ind_node1;
        }
    }
    public JNode getNode1()
    {
        return this.ind_node1;
    }
    public JNode getNode2()
    {
        return this.ind_node2;
    }
    public JNode getNode3()
    {
        return null;
    }
    public String getId()
    {
        return this.id;
    }
    public double getValue()
    {
        double val=0;
        String val1=value;
        if(value.charAt(val1.length()-1)=='u')
        {
            val=Double.parseDouble(val1.substring(0,val1.length()-1))*Math.pow(10,-6);
        }
        else if(value.charAt(val1.length()-1)=='n')
        {
            val=Double.parseDouble(val1.substring(0,val1.length()-1))*Math.pow(10,-9);
        }
        else if(value.charAt(val1.length()-1)=='m')
        {
            val=Double.parseDouble(val1.substring(0,val1.length()-1))*Math.pow(10,-3);
        }
        else
        {
            val=Double.parseDouble(val1.substring(0,val1.length()));
        }
        return val;
    }
    public void setValue(String value)
    {
        this.value=value;
        ind_label.setText(id+" "+this.value);
    }
    public int getId_int()
    {
        return this.id_int;
    }
    public void setModelImage(ImageIcon icon)
    {
        
    }
    public int getActualID()
    {
        return this.id_int;
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
    protected class Inductor_Dragger extends MouseAdapter implements MouseMotionListener,MouseListener
    {
        Window dragWindow = new JWindow() 
        {
            public void paint(Graphics g) 
            {
                super.paint(g);
                Inductor.this.paint(g);
            }
        };
        public void mouseDragged(MouseEvent e) 
        {
            javax.swing.JComponent jc =(javax.swing.JComponent)e.getSource();
            jc.setLocation(jc.getX()+e.getX()-10,jc.getY()+e.getY()-5);
            dragWindow.setLocation(jc.getLocation());
            getParent().repaint();
        }
        public void mouseEntered(MouseEvent e)
        {
            inductor_back.setIcon(new ImageIcon(getClass().getResource("/icons/inductor.png")));
        }
        public void mouseExited(MouseEvent e)
        {
            inductor_back.setIcon(new ImageIcon(getClass().getResource("/icons/inductor2.png")));
        }
    }                          
    private void initComponents() {

        inductor_back = new javax.swing.JLabel();
        ind_node2 = new JNode();
        ind_node1 = new JNode();
        ind_label = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(null);

        

        ind_node2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ind_node2MouseMoved(evt);
            }
        });
        ind_node2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ind_node2MouseClicked(evt);
            }
        });
        add(ind_node2);
        ind_node2.setBounds(27, 4, 3, 4);

        ind_node1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ind_node1MouseMoved(evt);
            }
        });
        ind_node1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ind_node1MouseClicked(evt);
            }
        });
        add(ind_node1);
        ind_node1.setBounds(0, 4, 3, 4);

        ind_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ind_labelMouseClicked(evt);
            }
        });
        ind_label.setForeground(Color.WHITE);
        add(ind_label);
        ind_label.setBounds(0, 10, 30, 17);
        inductor_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/inductor2.png"))); // NOI18N
        add(inductor_back);
        inductor_back.setBounds(0, 0, 30, 10);
    }                    

    private void ind_node2MouseClicked(java.awt.event.MouseEvent evt) {                                       
         if(MainFrame2.flag_select)
                {
                    MainFrame2.jselect.add(ind_node2);
                    if(MainFrame2.jselect.size()==2)
                    {
                        ind_node2.neighbour.add(MainFrame2.jselect.get(0));
                        MainFrame2.jselect.get(0).neighbour.add(ind_node2);
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
                        System.out.println(MainFrame2.Connector_Count);
                        MainFrame2.drawing_panel.setConnectors(MainFrame2.j);
                        MainFrame2.flag_select=false;
                        MainFrame2.jselect.clear();
                        MainFrame2.drawing_panel.revalidate();
                        MainFrame2.drawing_panel.repaint();
                    }
                }
                else
                {
                    MainFrame2.GND_node=(JOptionPane.showConfirmDialog(null,"Set this node as GND?","GND Node",JOptionPane.YES_NO_OPTION))==JOptionPane.YES_OPTION?ind_node2:null;
                }
    }                                      

    private void ind_node2MouseMoved(java.awt.event.MouseEvent evt) {
            ind_node2.setCursor(new Cursor(Cursor.WAIT_CURSOR));

    }                                    

    private void ind_node1MouseClicked(java.awt.event.MouseEvent evt) {                                       
        if(MainFrame2.flag_select)
                {
                    MainFrame2.jselect.add(ind_node1);
                    if(MainFrame2.jselect.size()==2)
                    {
                        ind_node1.neighbour.add(MainFrame2.jselect.get(0));
                        MainFrame2.jselect.get(0).neighbour.add(ind_node1);
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
                        System.out.println(MainFrame2.Connector_Count);
                        MainFrame2.drawing_panel.setConnectors(MainFrame2.j);
                        MainFrame2.flag_select=false;
                        MainFrame2.jselect.clear();
                        MainFrame2.drawing_panel.revalidate();
                        MainFrame2.drawing_panel.repaint();
                    }
                }
                else
                {
                    MainFrame2.GND_node=(JOptionPane.showConfirmDialog(null,"Set this node as GND?","GND Node",JOptionPane.YES_NO_OPTION))==JOptionPane.YES_OPTION?ind_node1:null;
                }
    }                                      

    private void ind_node1MouseMoved(java.awt.event.MouseEvent evt) {    
            ind_node1.setCursor(new Cursor(Cursor.WAIT_CURSOR));
      
    }                                    

    private void ind_labelMouseClicked(java.awt.event.MouseEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

                 
    private javax.swing.JLabel ind_label;
    private JNode ind_node1;
    private JNode ind_node2;
    private javax.swing.JLabel inductor_back;     
    String value="0";
    String id="L"+MainFrame2.Inductor_Count;
    int id_int = MainFrame2.Inductor_Count;
}

