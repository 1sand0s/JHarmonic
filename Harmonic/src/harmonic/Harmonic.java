/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harmonic;

import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author itarsi
 */
public class Harmonic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new MainFrame2().setVisible(true);
              // try{
               //new data_plotter().do1();}catch(IOException e){}
               /*Complex zero=new Complex();
               Complex one=new Complex(1,1);
               Complex one2=new Complex(1,-1);
               Complex one3=new Complex(2,1);
               Complex mat[][]=new Complex[][]{{zero,zero,zero,zero},{zero,one,one,one2},{zero,one2,one,one},{zero,one2,one2,one2}};
               //Complex mat[][]=new Complex[][]{{zero,zero,zero},{zero,one,one2},{zero,one,one}};
               Complex mat2[][]=new Complex[][]{{zero,zero},{zero,new Complex(1,0)},{zero,new Complex(0,-1)},{zero,new Complex(3,-4)}};
               Complex mat3[][]=Complex.computeLinearEquation(mat, mat2);
               for (int i=1;i<mat3.length;i++)
               {
                   for(int j=1;j<mat3[1].length;j++)
                   {
                       System.out.print(mat3[i][j].getReal()+" +jer "+mat3[i][j].getImaginary());
                   }
                   System.out.println("");
               }Complex zero=new Complex();
               Complex one=new Complex(1,1);
               Complex one2=new Complex(1,-1);
               Complex one3=new Complex(2,1);
               Complex d[]=new Complex[]{zero,one,one,one3};
               Complex mat[]=new MatrixOperations().computeFFT(new double[]{0,0,10,0});
               for (int i=1;i<mat.length;i++)
               {
                       System.out.println(mat[i].getReal()+" +jer "+mat[i].getImaginary());
                  
               }*/
            }
        });
    }
    
}
