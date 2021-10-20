/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harmonic;

import java.util.ArrayList;
import java.util.Map;


/**
 *
 * @author itarsi
 */
public class MNA_DC 
{
   String g1,b1,z1,d1;
   private int Source_Count;
   private boolean time_sim;
   private double[][] g,b,c,d,z,x;
   private Map<Integer,ArrayList<JNode>>mapper;
   MNA_DC(int Source_Count,boolean time_sim,Map<Integer,ArrayList<JNode>>mapper)
   {
        this.Source_Count=Source_Count;
        this.time_sim=time_sim;
        this.mapper=mapper;
   }
   
    public void compute_Gmatrix()
    {
        g1="[";
        g=new double[MainFrame2.Connector_Count-1][MainFrame2.Connector_Count-1];
        for(int i=0;i<MainFrame2.Connector_Count-1;i++)
        {
            for(int j=0;j<MainFrame2.Connector_Count-1;j++)
            {
                g[i][j]=0;
            }
        }
        for(int i=1;i<MainFrame2.Connector_Count-1;i++)
        {
            for(int j=1;j<MainFrame2.Connector_Count-1;j++)
            {
                ArrayList<JNode>node=mapper.get(j);
                for(int k=0;k<node.size();k++)
                {
                    if((node.get(k).getParentElement() instanceof Resistor || node.get(k).getParentElement() instanceof Capacitor) && (node.get(k).getParentElement().node_pair(node.get(k)).ID==i || node.get(k).ID==i))
                    {
                        if (i==j)
                            g[i][j]+=1/node.get(k).getParentElement().getValue();
                        else
                            g[i][j]-=1/node.get(k).getParentElement().getValue();
                    }
                    else if(node.get(k).getParentElement() instanceof Diode && (node.get(k).getParentElement().node_pair(node.get(k)).ID==i || node.get(k).ID==i)) 
                    {
                        if(time_sim)
                        {
                            if (i==j)
                                g[i][j]+=1/node.get(k).getParentElement().getValue();
                            else
                                g[i][j]-=1/node.get(k).getParentElement().getValue();
                        }
                    }
                }
            }
        } 
        for(int i=1;i<MainFrame2.Connector_Count-1;i++)
        {
            for(int j=1;j<MainFrame2.Connector_Count-1;j++)
            {
                g[j][i]=Math.abs(g[i][j])<10e-10?0:g[i][j];
                g1=g1+g[i][j];
                if(j<MainFrame2.Connector_Count-2)
                    g1=g1+",";
            }
            if(i<MainFrame2.Connector_Count-2)
                g1=g1+";";
        }
        g1=g1+"]";
        MainFrame2.message_area.append("G matrix "+g1+"\n");
    }
    public void compute_Bmatrix()
    {
        b1="[";
        b=new double[MainFrame2.Connector_Count-1][Source_Count+1];
        for(int i=0;i<MainFrame2.Connector_Count-1;i++)
        {
            for(int j=0;j<Source_Count+1;j++)
            {
                b[i][j]=0;
            }
        }
        int c=0;
        for(int j=1;j<MainFrame2.Connector_Count-1;j++)
        {
            ArrayList<JNode>node=mapper.get(j);
            for(int k=0;k<node.size();k++)
            {
                if(node.get(k).getParentElement() instanceof DCSource || node.get(k).getParentElement() instanceof ACSource || (node.get(k).getParentElement() instanceof Diode && !time_sim))
                {
                    JElement s=node.get(k).getParentElement();
                    if(s.getNode1().equals(node.get(k)))
                    {
                        b[j][(time_sim?s.getId_int()+1:s.getActualID()+1)]=1;
                    }
                    else
                    {
                        b[j][(time_sim?s.getId_int()+1:s.getActualID()+1)]=-1;
                    }
                }
            }
        }
        
        for(int i=1;i<MainFrame2.Connector_Count-1;i++)
        {
            for(int j=1;j<Source_Count+1;j++)
            {
                b1=b1+b[i][j];
                if(j<Source_Count-1)
                    b1=b1+",";
            }
            if(i<MainFrame2.Connector_Count-2)
                b1=b1+";";
        }
        b1=b1+"]";
        MainFrame2.message_area.append("B matrix "+b1+"\n");
    }
    public void compute_Zmatrix()
    {
        ArrayList<JElement>duplicate_source=new ArrayList<JElement>();
        z1="[";
        z=new double[MainFrame2.Connector_Count-1+Source_Count][(time_sim?2:MainFrame2.harmonic_count+1)];
        for(int i=0;i<MainFrame2.Connector_Count-1+Source_Count;i++)
        {
            for(int j=0;j<z[i].length;j++)
            {
               z[i][j]=0; 
            }
        }
        int c=MainFrame2.Connector_Count-1;
        
            for(int j=1;j<MainFrame2.Connector_Count-1;j++)
            {
                ArrayList<JNode>node=mapper.get(j);
                for(int k=0;k<node.size();k++)
                {
                    if(node.get(k).getParentElement() instanceof DCSource && !duplicate_source.contains(node.get(k).getParentElement()))
                    {
                        DCSource s=(DCSource)node.get(k).getParentElement();
                        duplicate_source.add(s);
                        z[c]=new double[]{0,s.getValue()};
                    }
                    else if(node.get(k).getParentElement() instanceof ACSource && !duplicate_source.contains(node.get(k).getParentElement()))
                    {
                        ACSource s=(ACSource)node.get(k).getParentElement();
                        duplicate_source.add(s);
                        z[c]=new double[]{0,s.getValue()};
                        c++;
                    }
                    else if(node.get(k).getParentElement() instanceof Diode && !duplicate_source.contains(node.get(k).getParentElement()))
                    {
                        Diode d=(Diode)node.get(k).getParentElement();
                        MatrixOperations mat=new MatrixOperations();
                        double d1=d.getDiodeCurrent()-d.getDiodeDrop()/d.getValue();
                        d1=Math.abs(d1)<10e-20?0:d1;
                        if(node.get(k).equals(d.getNode1()))
                        {
                            z[j]=mat.sumArray(z[j],new double[]{0,-(d1)},1);
                        }
                        else
                        {
                            z[j]=mat.sumArray(z[j],new double[]{0,(d1)},1);
                        }
                    }
                    else if(node.get(k).getParentElement() instanceof CurrentSource)
                    {
                        CurrentSource s=(CurrentSource)node.get(k).getParentElement();
                        if(node.get(k).equals(s.getNode1()))
                        {
                            z[j]=new double[]{0,-s.getValue()};
                        }
                        else
                        {
                            z[j]=new double[]{0,s.getValue()};
                        }
                    }
                    else if(node.get(k).getParentElement() instanceof Capacitor)
                    {
                        MatrixOperations mat=new MatrixOperations();
                        Capacitor s=(Capacitor)node.get(k).getParentElement();
                        if(node.get(k).equals(s.getNode1()))
                        {
                            z[j]=mat.sumArray(z[j],new double[]{0,(1/s.getValue())*s.getVoltage()},1);
                        }
                        else
                        {
                            z[j]=mat.sumArray(z[j],new double[]{0,-(1/s.getValue())*s.getVoltage()},1);
                        }
                    }
                }
            }
        for(int i=1;i<z.length;i++)
        {
           for(int j=1;j<z[i].length;j++)
           {
               z[i][j]=(Math.abs(z[i][j])<Math.pow(10,-10))?0:z[i][j];
               z1=z1+z[i][j];
               if(j<z[i].length-1)
                    z1=z1+",";
           }
           if(i<z.length-1)
                z1=z1+";";
        }
        z1=z1+"]";
        MainFrame2.message_area.append("Z vector "+z1+"\n");
    }
    public void compute_Dmatrix()
    {
        d1="[";
        d=new double[Source_Count+1][Source_Count+1];
        for(int i=1;i<Source_Count+1;i++)
        {
            for(int j=1;j<Source_Count+1;j++)
            {
                d[i][j]=0;
                d1=d1+d[i][j];
                if(j<Source_Count-1)
                    d1=d1+",";
            }
            if(i<Source_Count-1)
                d1=d1+";";
        }
        d1=d1+"]";
        MainFrame2.message_area.append("D matrix "+d1+"\n");
    }
    public void computeResult()
    {
        MainFrame2.message_area.append("\nSimulation Results\n");
        MatrixOperations mat=new MatrixOperations();
        double c[][]=mat.transpose(b);
        double A[][]=mat.matrixConcatenator(g, b, c, d);
        x=mat.computeLinearEquation(A, z);
    }
    public double[][] getResult()
    {
        return x;
    }
    public void setResult()
    {
        x=null;
    }
    public double[][] call()
    {
        compute_Gmatrix();
        compute_Bmatrix();
        compute_Zmatrix();
        compute_Dmatrix();
        computeResult();
        return x;
    }

    
    
}
