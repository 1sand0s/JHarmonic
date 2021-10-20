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
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JWindow;

/**
 *
 * @author itarsi
 */
public class Diode extends JElement 
{

    Diode_Dragger drag_handle=new Diode_Dragger();
    public Diode() {
        initComponents(xp1[4],xp2[4]);
        addMouseListener(drag_handle);
        addMouseMotionListener(drag_handle);
    }
    public JNode node_pair(JNode node)
    {
        if(node.equals(this.anode))
        {
            return this.cathode;
        }
        else
        {
            return this.anode;
        }
    }
    public Diode getDiode()
    {
        return this;
    }
    public JNode getNode1()
    {
        return this.anode;
    }
    public JNode getNode2()
    {
        return this.cathode;
    }
    public JNode getNode3()
    {
        return null;
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
        diode_label.setText("D"+MainFrame2.Diode_Count+" "+this.value);
    }
    public void setVt(double vt)
    {
        this.vt=vt;
    }
    public void setDiodeDrop(double diode_drop)
    {
        this.diode_drop=diode_drop;
    }
    public double getDiodeDrop()
    {
        return diode_drop;
    }
    public void setPhaseExpansion(int order_number)
    {
        phaseExpand=new double[order_number+1];
        for(int i=1;i<phaseExpand.length;i++)
        {
            phaseExpand[i]=MainFrame2.order_voltages[i-1];
            //phaseExpand[i]=Math.random();
        }
        phaseExpand2=new MatrixOperations().computeFFT(phaseExpand);
    }
    public void setPhaseExpansion(double voltage[])
    {
        phaseExpand=voltage;
        phaseExpand2=new MatrixOperations().computeFFT(phaseExpand);
    }
    public void setPhaseExpansion(Complex voltage[])
    {
        phaseExpand2=voltage;
    }
    public double[] getPhaseExpansion()
    {
        return phaseExpand;
    }
    public Complex[] getPhaseExpansion2()
    {
        return phaseExpand2;
    }
    public double getVt()
    {
        return vt;
    }
    public double getDiodeCurrent()
    {
        double d=sat_current*(Math.exp(diode_drop/vt)-1);
        return d;
    }
    public double[] getDiodeCurrent(double[] voltage)
    {
        double d[]=new double[voltage.length];
        for(int i=1;i<voltage.length;i++)
        {
            d[i]= sat_current*(Math.exp(voltage[i]/vt)-1);
        }
        return d;
    }
    public Complex[] getDiodeCurrent(Complex[] voltage)
    {
        Complex d[]=new Complex[voltage.length];
        for(int i=1;i<voltage.length;i++)
        {
            double real=sat_current*(Math.exp(voltage[i].getReal()/vt)*(Math.cos(voltage[i].getImaginary()/vt))-1);
            double imaginary=sat_current*Math.exp(voltage[i].getReal()/vt)*(Math.sin(voltage[i].getImaginary()/vt));
            d[i]= new Complex(real,imaginary);
        }
        return d;
    }
    public double getDiodeSatCurrent()
    {
        return sat_current;
    }

    @Override
    public boolean getScopeState() 
    {
        return cathode_mouse.getScope()|anode_mouse.getScope();
    }

    @Override
    public int getActualID() {
        return actual_id;
    }

    @Override
    public int getNode1Scope()
    {
        return anode_mouse.getScopeID();
    }

    @Override
    public int getNode2Scope() 
    {
        return cathode_mouse.getScopeID();
    }

    @Override
    public int getNode3Scope() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double[] getVoltageandCurrent(double[] result) 
    {
        double voltage=diode_drop;
        double current=getDiodeCurrent();
        return new double[]{voltage,current};
    }
    protected class Diode_Dragger extends MouseAdapter implements MouseMotionListener,MouseListener 
    {
        Window dragWindow = new JWindow() 
        {
            public void paint(Graphics g) 
            {
                super.paint(g);
                Diode.this.paint(g);
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
        public void mouseClicked(MouseEvent e)
        {
            if(MainFrame2.rotate_flag)
            {
                q++;
                poly=new Polygon((q%2==0)?xp1:xp2,(q%2==0)?yp1:yp2,xp1.length-1);
                cathode.removeMouseListener(cathode_mouse);
                cathode.removeMouseMotionListener(cathode_mouse);
                anode.removeMouseListener(anode_mouse);
                anode.removeMouseMotionListener(anode_mouse);
                initComponents((q%2==0)?xp1[4]:xp2[4],(q%2==0)?xp2[4]:xp1[4]);
                MainFrame2.rotate_flag=false;
                Diode.this.repaint();
            }
        }
    }              
                        
    private void initComponents(int cathode_bound,int anode_bound) {

        cathode = new JNode();
        anode = new JNode();
        diode_label = new javax.swing.JLabel("D"+id);

        setLayout(null);
        cathode_mouse=new MouseFunctions(cathode);
        anode_mouse=new MouseFunctions(anode);
        cathode.addMouseListener(cathode_mouse);
        cathode.addMouseMotionListener(cathode_mouse);
        add(cathode);
        System.out.println(cathode_bound+"   "+anode_bound);
        cathode.setBounds(cathode_bound,10,10,10);
        anode.addMouseListener(anode_mouse);
        anode.addMouseMotionListener(anode_mouse);
        add(anode);
        anode.setBounds(anode_bound,10,10,10);

        diode_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //diode_labelMouseClicked(evt);
            }
        });
        diode_label.setForeground(Color.WHITE);
        add(diode_label);
        diode_label.setBounds(10, 40, 60, 15);
        this.setOpaque(false);
        repaint();
    }                       

    private void diode_labelMouseClicked(java.awt.event.MouseEvent evt) {          
    }   
    public void paintComponent(Graphics g)
    {
        g.setColor((flag)?Color.GREEN:Color.WHITE);
        Graphics2D g2=(Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(2));
        g2.drawPolygon(poly);
        g2.drawLine(poly.xpoints[2],0,poly.xpoints[2],30);
        g2.drawLine(0,15,20,15);
        g2.drawLine(40,15,55,15);
        g.setColor(Color.YELLOW);
        g2.fillOval(0,10,10,10);
        g2.fillOval(50,10,10,10);
    }
    private int xp1[]=new int[]{20,20,40,20,50};
    private int yp1[]=new int[]{0,30,15,0,0};
    private int xp2[]=new int[]{40,40,20,40,0};
    private int yp2[]=new int[]{0,30,15,0,0};
    private Polygon poly=new Polygon(xp1,yp1,xp1.length-1);
    private JNode anode;
    private JNode cathode;
    private javax.swing.JLabel diode_label;
    private int id=MainFrame2.Diode_Count;
    private String value="";
    private MouseFunctions cathode_mouse;
    private MouseFunctions anode_mouse;
    private double diode_drop=0.7;
    private double sat_current=10*Math.pow(10,-12);
    private double vt=0.039;
    private int actual_id=MainFrame2.actual_source_count;
    private int q=0;
    private boolean flag=true;
    private double phaseExpand[];
    private Complex phaseExpand2[];
}

