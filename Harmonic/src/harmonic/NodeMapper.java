/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harmonic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author itarsi
 */
public class NodeMapper 
{
   private Map<Integer,ArrayList<JNode>>mapper=new HashMap<Integer,ArrayList<JNode>>();
   private ArrayList<JNode>node_distribution=new ArrayList<JNode>();
   private ArrayList<JElement>container;
   private JNode GND_node;
   NodeMapper(ArrayList<JElement>container,JNode GND_node)
   {
       this.container=container;
       this.GND_node=GND_node;
   }
   public void Update_node()
   {
        JNode node=GND_node;
        for(int i=0;i<=container.size();i++)
        {
            for(int j=0;j<container.size();j++)
            {
                if(container.get(j).getNode1().ID==i)
                {
                    node_distribution.add(container.get(j).getNode1());
                }
                else if(container.get(j).getNode2().ID==i)
                {
                    node_distribution.add(container.get(j).getNode2());
                }
            }
            mapper.put(i, node_distribution);
            node_distribution=new ArrayList<JNode>();
        }
        node_distribution=mapper.get(node.ID);
        node.ID=0;
        for(int i=0;i<node_distribution.size();i++)
        {
            node_distribution.get(i).ID=0;
        }
    }
    public Map<Integer,ArrayList<JNode>> getNodeMap()
    {
        return mapper;
    }
    public JNode GND_node()
    {
        return GND_node;
    }
    public void printNodeList(javax.swing.JTextArea message_area)
    {
        System.out.println("Netlist for the following schematic is\n\n");
        for(int i=0;i<container.size();i++)
        {
            System.out.println(container.get(i).getNode1().ID+"   "+container.get(i).getId()+"   "+container.get(i).getNode2().ID+"\n");
        }
       System.out.println("\n");
    }
}
