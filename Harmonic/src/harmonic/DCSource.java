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
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;
import javax.swing.JWindow;

/**
 *
 * @author itarsi
 */
public class DCSource extends JElement {

    /**
     * Creates new form Source
     */
    Source_Dragger drag_handle=new Source_Dragger();
    public DCSource() 
    {
        initComponents(c1,c2);
        addMouseListener(drag_handle);
        addMouseMotionListener(drag_handle);
    }
    public JNode node_pair(JNode node)
    {
        if(node.equals(this.positive_node))
        {
            return this.negative_node;
        }
        else
        {
            return this.positive_node;
        }
    }
    public JNode getNode1()
    {
        return this.positive_node;
    }
    public JNode getNode2()
    {
        return this.negative_node;
    }
    public JNode getNode3()
    {
        return null;
    }
    public String getId()
    {
        return "V"+this.id;
    }
    public int getId_int()
    {
        return this.id;
    }
    public double getValue()
    {
        return Double.parseDouble(value);
    }
    public DCSource getSource()
    {
        return this;
    }
    public void setValue(String value)
    {
        this.value=value;
        DC_value.setText("V"+id+" "+this.value);
    }
    public void setPhaseExpansion(int order_number)
    {
        System.out.println(order_number);
        phaseExpand=new double[order_number+1];
        double source_freq=0;
        double fundamental_freq=MainFrame2.fundamental_freq;
        int harmonic_multiple=1;
        phaseExpand[harmonic_multiple]=this.getValue();
        phaseExpand2=new MatrixOperations().computeFFT(phaseExpand);
    }
    public double[] getPhaseExpansion()
    {
        return phaseExpand;
    }
    public Complex[] getPhaseExpand2()
    {
        return phaseExpand2;
    }
    @Override
    public boolean getScopeState() 
    {
        return positive_mouse.getScope()|negative_mouse.getScope();
    }

    @Override
    public int getActualID() {
        return actual_id;
    }

    @Override
    public int getNode1Scope() 
    {
        return positive_mouse.getScopeID();
    }

    @Override
    public int getNode2Scope() 
    {
        return negative_mouse.getScopeID();
    }

    @Override
    public int getNode3Scope() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double[] getVoltageandCurrent(double[] result) 
    {
        double voltage=result[positive_node.ID]-result[negative_node.ID];
        double current=result[getId_int()+MainFrame2.Connector_Count-1];
        return new double[]{voltage,current};
    }
    protected class Source_Dragger extends MouseAdapter implements MouseMotionListener,MouseListener 
    {
        Window dragWindow = new JWindow() 
        {
            public void paint(Graphics g) 
            {
                super.paint(g);
                DCSource.this.paint(g);
            }
        };
        public void mouseDragged(MouseEvent e) 
        {
            javax.swing.JComponent jc =(javax.swing.JComponent)e.getSource();
            jc.setLocation(jc.getX()+e.getX()-20,jc.getY()+e.getY()-20);
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
        public void mouseClicked(MouseEvent e)
        {
            if(MainFrame2.rotate_flag)
            {
                q++;
                positive_node.removeMouseListener(positive_mouse);
                positive_node.removeMouseMotionListener(positive_mouse);
                negative_node.removeMouseListener(negative_mouse);
                negative_node.removeMouseMotionListener(negative_mouse);
                positive_node_bound=(q%2==0)?0:50;
                negative_node_bound=(q%2==0)?50:0;
                initComponents(c1=(q%2==0)?25:32,c2=(q%2==0)?32:25);
                MainFrame2.rotate_flag=false;
                DCSource.this.repaint();
            }
        }
    }
                         
    private void initComponents(int c1,int c2) 
    {
        DC_value = new javax.swing.JLabel("V"+id+" "+value);
        positive_node = new JNode();
        negative_node = new JNode();
        setLayout(null);
        positive_mouse=new MouseFunctions(positive_node);
        negative_mouse=new MouseFunctions(negative_node);
        positive_node.addMouseListener(positive_mouse);
        positive_node.addMouseMotionListener(positive_mouse);
        add(positive_node);
        positive_node.setBounds(positive_node_bound,10,10,10);
        negative_node.addMouseListener(negative_mouse);
        negative_node.addMouseMotionListener(negative_mouse);
        add(negative_node);
        
        negative_node.setBounds(negative_node_bound,10,10,10);

        DC_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DC_valueMouseClicked(evt);
            }
        });
        DC_value.setForeground(Color.WHITE);
        add(DC_value);
        DC_value.setBounds(10, 35, 49, 17);
        this.setOpaque(false);
    }                  
    
    private void DC_valueMouseClicked(java.awt.event.MouseEvent evt) {                                      
        if(!MainFrame2.flag_select)
        {
            value=JOptionPane.showInputDialog("Enter Voltage");
            DC_value.setText(id+" "+value);
        }
    }           
    public void paintComponent(Graphics g)
    {
        g.setColor((flag)?Color.GREEN:Color.WHITE);
        Graphics2D g2=(Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(c1,0,c1,30);
        g2.drawLine(c2,5,c2,25);
        g2.drawLine(0,15,25,15);
        g2.drawLine(32,15,55,15);
        g2.setColor(Color.YELLOW);
        g2.fillOval(0,10,10,10);
        g2.fillOval(50,10,10,10);
    }
    private int c1=25,c2=32;
    private int q=0;
    private int negative_node_bound=50;
    private int positive_node_bound=0;
    private boolean flag1=true;
    private javax.swing.JLabel DC_value;
    private JNode negative_node;
    private JNode positive_node;   
    private String value="0";
    private MouseFunctions positive_mouse;
    private MouseFunctions negative_mouse;
    private int actual_id=MainFrame2.actual_source_count;
    private int id=MainFrame2.Source_Count;
    private double phaseExpand[];
    private Complex phaseExpand2[];
    private boolean flag=true;
}

