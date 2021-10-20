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
import java.awt.RenderingHints;
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
public class Resistor extends JElement {

    /**
     * Creates new form Resistor
     */
    Resistor_Dragger drag_handle=new Resistor_Dragger();
    public Resistor() 
    {
        initComponents();
        addMouseListener(drag_handle);
        addMouseMotionListener(drag_handle);
        
    }
    public Resistor getResistor()
    {
        return this;
    }
    public JNode node_pair(JNode node)
    {
        if(node.equals(this.resistor_node1))
        {
            return this.resistor_node2;
        }
        else
        {
            return this.resistor_node1;
        }
    }
    public JNode getNode1()
    {
        return this.resistor_node1;
    }
    public int getNode1Scope()
    {
        return node1_mouse.getScopeID();
    }
    public JNode getNode2()
    {
        return this.resistor_node2;
    }
    public int getNode2Scope()
    {
        return node2_mouse.getScopeID();
    }
    public JNode getNode3()
    {
        return null;
    }
    public int getNode3Scope()
    {
        return 0;
    }
    public String getId()
    {
        return "R"+this.id;
    }
    public double getValue()
    {
        double val=0;
        String val1=value;
        if(value.charAt(val1.length()-1)=='k')
        {
            val=Double.parseDouble(val1.substring(0,val1.length()-1))*Math.pow(10,3);
        }
        else if(value.charAt(val1.length()-1)=='m')
        {
            val=Double.parseDouble(val1.substring(0,val1.length()-1))*Math.pow(10,6);
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
        resistor_value.setText("R"+id+" "+this.value);
    }
    public int getId_int()
    {
        return this.id;
    }
    @Override
    public boolean getScopeState() 
    {
        return node1_mouse.getScope()|node2_mouse.getScope();
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
    public double[] getVoltageandCurrent(double[] result)
    {
        double voltage=result[resistor_node1.ID]-result[resistor_node2.ID];
        double current=voltage/getValue();
        return new double[]{voltage,current};
    }
    protected class Resistor_Dragger extends MouseAdapter implements MouseMotionListener,MouseListener
    {
        Window dragWindow = new JWindow() 
        {
            public void paint(Graphics g) 
            {
                super.paint(g);
                Resistor.this.paint(g);
            }
        };
        public void mouseDragged(MouseEvent e) 
        {
            javax.swing.JComponent jc =(javax.swing.JComponent)e.getSource();
            jc.setLocation(jc.getX()+e.getX()-30,jc.getY()+e.getY()-5);
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

        resistor_node1 = new JNode();
        resistor_node2 = new JNode();
        resistor_value=new javax.swing.JLabel(id+" "+value);

        setLayout(null);
        node1_mouse=new MouseFunctions(resistor_node1);
        node2_mouse=new MouseFunctions(resistor_node2);
        resistor_node2.addMouseListener(node2_mouse);
        resistor_node2.addMouseMotionListener(node2_mouse);
        add(resistor_node2);
        resistor_node2.setBounds(65, 8, 10, 10);

        
        resistor_node1.addMouseListener(node1_mouse);
        resistor_node1.addMouseMotionListener(node1_mouse);
        add(resistor_node1);
        resistor_node1.setBounds(0, 8, 10, 10);

        resistor_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resistor_valueMouseClicked(evt);
            }
        });
        resistor_value.setForeground(Color.WHITE);
        add(resistor_value);
        resistor_value.setBounds(15, 20, 60, 15);
        this.setOpaque(false);
    }                

          

    private void resistor_valueMouseClicked(java.awt.event.MouseEvent evt) {                                            
        if(!MainFrame2.flag_select)
        {
            value=JOptionPane.showInputDialog("Enter Resistance Value");
            resistor_value.setText("R"+id+" "+value);
        }
    }         
    public void paintComponent(Graphics g)
    {
        g.setColor((flag)?Color.GREEN:Color.WHITE);
        Graphics2D g2=(Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(2));
        g2.drawRect(20,5,35,15);
        g2.drawLine(0,13,20,13);
        g2.drawLine(55,13,75,13);
        g.setColor(Color.YELLOW);
        g2.fillOval(0,8,10,10);
        g2.fillOval(65,8,10,10);
    }

    private JNode resistor_node1;
    private JNode resistor_node2;
    private javax.swing.JLabel resistor_value;
    private String value="0";
    private int id = MainFrame2.Resistor_Count;
    private boolean flag=true;
    private MouseFunctions node1_mouse;
    private MouseFunctions node2_mouse;
}

