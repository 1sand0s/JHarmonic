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
public class MNA_FD
{
   String g1,b1,z1,d1;
   private int Source_Count;
   private Complex[][] g,b,c,d,z,x;
   private Map<Integer,ArrayList<JNode>>mapper;
   MNA_FD(int Source_Count,Map<Integer,ArrayList<JNode>>mapper)
   {
        this.Source_Count=Source_Count;
        this.mapper=mapper;
   }
   
    public void compute_Gmatrix()
    {
        g1="[";
        g=new Complex[MainFrame2.Connector_Count-1][MainFrame2.Connector_Count-1];
        for(int i=1;i<g.length;i++)
        {
            for(int j=1;j<g[i].length;j++)
            {
                g[i][j]=new Complex();
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
                            g[i][j]=Complex.AddSub(g[i][j],new Complex(1/node.get(k).getParentElement().getValue(),0),1);
                        else
                            g[i][j]=Complex.AddSub(g[i][j],new Complex(1/node.get(k).getParentElement().getValue(),0),-1);
                        g[i][j]=Complex.removeRedundancy(g[i][j]);
                    }
                }
            }
        } 
        for(int i=1;i<MainFrame2.Connector_Count-1;i++)
        {
            for(int j=1;j<MainFrame2.Connector_Count-1;j++)
            {
                g[j][i]=g[i][j];
                g1=g1+(g[i][j].getReal()+" +j "+g[i][j].getImaginary());
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
        b=new Complex[MainFrame2.Connector_Count-1][Source_Count+1];
        int c=0;
        for(int i=0;i<b.length;i++)
        {
            for(int j=0;j<b[i].length;j++)
            {
               b[i][j]=new Complex(); 
            }
        }
        for(int j=1;j<MainFrame2.Connector_Count-1;j++)
        {
            ArrayList<JNode>node=mapper.get(j);
            for(int k=0;k<node.size();k++)
            {
                if(node.get(k).getParentElement() instanceof DCSource || node.get(k).getParentElement() instanceof ACSource || node.get(k).getParentElement() instanceof Diode)
                {
                    JElement s=node.get(k).getParentElement();
                    if(s.getNode1().equals(node.get(k)))
                    {
                        b[j][(s.getActualID()+1)]=new Complex(1,0);
                    }
                    else
                    {
                        b[j][(s.getActualID()+1)]=new Complex(-1,0);
                    }
                }
            }
        }
        
        for(int i=1;i<MainFrame2.Connector_Count-1;i++)
        {
            for(int j=1;j<Source_Count+1;j++)
            {
                b1=b1+(b[i][j].getReal());
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
        MatrixOperations mat=new MatrixOperations();
        z1="[";
        z=new Complex[MainFrame2.Connector_Count-1+Source_Count][(MainFrame2.harmonic_count+1)];
        for(int i=0;i<MainFrame2.Connector_Count-1+Source_Count;i++)
        {
            for(int j=0;j<z[i].length;j++)
            {
               z[i][j]=new Complex(); 
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
                        z[c]=s.getPhaseExpand2();
                    }
                    else if(node.get(k).getParentElement() instanceof ACSource && !duplicate_source.contains(node.get(k).getParentElement()))
                    {
                        ACSource s=(ACSource)node.get(k).getParentElement();
                        duplicate_source.add(s);
                        z[c]=s.getPhaseExpansion2();
                        c++;
                    }
                    else if(node.get(k).getParentElement() instanceof Diode && !duplicate_source.contains(node.get(k).getParentElement()))
                    {
                        Diode d=(Diode)node.get(k).getParentElement();
                        duplicate_source.add(d);
                        z[c]=d.getPhaseExpansion2();
                        c++;
                    }
                    /*else if(node.get(k).getParentElement() instanceof Capacitor)
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
                    }*/
                }
            }
        for(int i=1;i<z.length;i++)
        {
           for(int j=1;j<z[i].length;j++)
           {
               z[i][j]=Complex.removeRedundancy(z[i][j]);
               z1=z1+(z[i][j].getReal()+" +j "+z[i][j].getImaginary());
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
        d=new Complex[Source_Count+1][Source_Count+1];
        for(int i=1;i<Source_Count+1;i++)
        {
            for(int j=1;j<Source_Count+1;j++)
            {
                d[i][j]=new Complex();
                d1=d1+d[i][j].getReal();
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
        Complex c[][]=Complex.transpose(b);
        Complex A[][]=mat.matrixConcatenator(g, b, c, d);
        x=Complex.computeLinearEquation(A,Complex.transpose(z),true);
        
        /*for(int i=1;i<A.length;i++)
        {
            for(int j=1;j<A[i].length;j++)
            {
                System.out.print(A[i][j].getReal()+" A "+A[i][j].getImaginary()+" , ");
            }
            System.out.println("");
        }
        for(int i=1;i<x.length;i++)
        {
            for(int j=1;j<x[i].length;j++)
            {
                System.out.print(x[i][j].getReal()+" x "+x[i][j].getImaginary()+" , ");
            }
            System.out.println("");
        }*/
    }
    public Complex[][] getResult()
    {
        return x;
    }
    public void setResult()
    {
        x=null;
    }
    public Complex[][] call()
    {
        compute_Gmatrix();
        compute_Bmatrix();
        compute_Zmatrix();
        compute_Dmatrix();
        computeResult();
        return x;
    }

    
    
}
