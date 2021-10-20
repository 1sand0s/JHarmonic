package harmonic;

import com.sl.connector.JConnector;
import com.sl.line.ConnectLine;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

class MouseFunctions extends MouseAdapter implements MouseListener,MouseMotionListener
{
    private JNode node;
    private boolean scope_flag=false;
    private int scope_id=0;
    MouseFunctions(JNode node)
    {
        this.node=node;
    }
    MouseFunctions(JNode node,int scope_id)
    {
        this.node=node;
        this.scope_id=scope_id;
    }
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        if(e.getButton()==1)
        {
            if(MainFrame2.flag_select)
            {
                MainFrame2.jselect.add(node);
                if(MainFrame2.jselect.size()==2)
                {
                    node.neighbour.add(MainFrame2.jselect.get(0));
                    MainFrame2.jselect.get(0).neighbour.add(node);
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
                MainFrame2.GND_node=(JOptionPane.showConfirmDialog(node.getParentElement(),"Set this node as GND?","GND Node",JOptionPane.YES_NO_OPTION))==JOptionPane.YES_OPTION?this.node:null;
            }
        }
        else if(e.getButton()==3)
        {
            new Options(this).show(e.getComponent(),e.getX(),e.getY());
        }
    }
    public void setScope(boolean scope_state)
    {
        this.scope_flag=scope_state;
    }
    public void setScopeID(int scope_id)
    {
        this.scope_id=scope_id;
    }
    public int getScopeID()
    {
        return this.scope_id;
    }
    public boolean getScope()
    {
        return this.scope_flag;
    }
    @Override
    public void mouseMoved(MouseEvent e) 
    {
        node.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
    }
    public void mouseEntered(MouseEvent e)
    {
        MainFrame2.drawing_panel.setScopeHiglight(scope_id);
    }
    public void mouseExited(MouseEvent e)
    {
        MainFrame2.drawing_panel.setScopeHiglight(0);
    }
}
class Options extends JPopupMenu
{
    JMenuItem scope_on=new JMenuItem("Scope on");
    JMenuItem scope_off=new JMenuItem("Scope Off");
    
    Options(MouseFunctions mouse)
    {
        scope_on.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                mouse.setScope(true);
                mouse.setScopeID(MainFrame2.scope_count);
                MainFrame2.scope_count++;
            }
        });
        scope_off.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                mouse.setScope(false);
                mouse.setScopeID(0);
                MainFrame2.scope_count--;
            }
        });
        this.add(scope_on);
        this.add(scope_off);
    }
}