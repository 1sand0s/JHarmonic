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
public class Capacitor extends JElement {

    /**
     * Creates new form Capacitor
     */
    Capacitor_Dragger drag_handle=new Capacitor_Dragger();
    public Capacitor() {
        initComponents();
        addMouseListener(drag_handle);
        addMouseMotionListener(drag_handle);
    }
    public JNode node_pair(JNode node)
    {
        if(node.equals(this.cap_node1))
        {
            return this.cap_node2;
        }
        else
        {
            return this.cap_node1;
        }
    }
    public JNode getNode1()
    {
        return this.cap_node1;
    }
    public JNode getNode2()
    {
        return this.cap_node2;
    }
    public JNode getNode3()
    {
        return null;
    }
    public String getId()
    {
        return "C"+this.id;
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
        else if(value.charAt(val1.length()-1)=='p')
        {
            val=Double.parseDouble(val1.substring(0,val1.length()-1))*Math.pow(10,-12);
        }
        else
        {
            val=Double.parseDouble(val1.substring(0,val1.length()));
        }
        return MainFrame2.tstep/val;
    }
    public void setValue(String value)
    {
        this.value=value;
        cap_label.setText("C"+id+" "+this.value);
    }
    public void setVoltage(double voltage)
    {
        this.voltage=voltage;
    }
    public double getVoltage()
    {
        return this.voltage;
    }
    public int getId_int()
    {
        return this.id;
    }

    @Override
    public boolean getScopeState() 
    {
        return cap1_mouse.getScope()|cap2_mouse.getScope();
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
        return id;
    }

    @Override
    public int getNode1Scope() 
    {
        return cap1_mouse.getScopeID();
    }

    @Override
    public int getNode2Scope() 
    {
        return cap2_mouse.getScopeID();
    }

    @Override
    public int getNode3Scope() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double[] getVoltageandCurrent(double[] result) 
    {
        double voltage=result[cap_node1.ID]-result[cap_node2.ID];
        double current = voltage*getValue();
        return new double[]{voltage,current};
    }
    protected class Capacitor_Dragger extends MouseAdapter implements MouseMotionListener,MouseListener
    {
        Window dragWindow = new JWindow() 
        {
            public void paint(Graphics g) 
            {
                super.paint(g);
                Capacitor.this.paint(g);
            }
        };
        public void mouseDragged(MouseEvent e) 
        {
            javax.swing.JComponent jc =(javax.swing.JComponent)e.getSource();
            jc.setLocation(jc.getX()+e.getX()-10,jc.getY()+e.getY()-25);
            dragWindow.setLocation(jc.getLocation());
            getParent().repaint();
        }
        public void mouseEntered(MouseEvent e)
        {
            flag=false;
            Capacitor.this.repaint();
        }
        public void mouseExited(MouseEvent e)
        {
            flag=true;
            Capacitor.this.repaint();
        }
    }          
                        
    private void initComponents() {

        cap_back = new javax.swing.JLabel();
        cap_node2 = new JNode();
        cap_node1 = new JNode();
        cap_label = new javax.swing.JLabel();

        setLayout(null);
        cap1_mouse=new MouseFunctions(cap_node1);
        cap2_mouse=new MouseFunctions(cap_node2);
        cap_node1.addMouseListener(cap1_mouse);
        cap_node1.addMouseMotionListener(cap1_mouse);
        add(cap_node1);
        cap_node1.setBounds(0,10,10,10);
        
        cap_node2.addMouseListener(cap2_mouse);
        cap_node2.addMouseMotionListener(cap2_mouse);
        add(cap_node2);
        cap_node2.setBounds(50,10,10,10);

        cap_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cap_labelMouseClicked(evt);
            }
        });
        cap_label.setForeground(Color.WHITE);
        add(cap_label);
        cap_label.setBounds(5,30,50,20);
        this.setOpaque(false);
    }                 

   
    private void cap_labelMouseClicked(java.awt.event.MouseEvent evt) {                                       
        if(!MainFrame2.flag_select)
        {
            value=JOptionPane.showInputDialog("Enter Capacitance Value");
            cap_label.setText("C"+id+" "+value);
        }
    }                                      

    
    public void paintComponent(Graphics g)
    {
        g.setColor((flag)?Color.GREEN:Color.WHITE);
        Graphics2D g2=(Graphics2D)g;
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(25,0,25,30);
        g2.drawLine(32,0,32,30);
        g2.drawLine(0,15,25,15);
        g2.drawLine(32,15,55,15);
        g2.setColor(Color.YELLOW);
        g2.fillOval(0,10,10,10);
        g2.fillOval(50,10,10,10);
    }


    private boolean flag=true;
    private javax.swing.JLabel cap_back;
    private javax.swing.JLabel cap_label;
    private JNode cap_node1;
    private JNode cap_node2;
    private String value="0";
    private MouseFunctions cap1_mouse;
    private MouseFunctions cap2_mouse;
    private int id=MainFrame2.Capacitor_Count;
    private double voltage=1e-3;
}

