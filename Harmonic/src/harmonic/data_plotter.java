/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harmonic;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author itarsi
 */
public class data_plotter  
{
    File f=new File("/home/itarsi/Desktop/Design1.scp");
    public void do1() throws IOException
    {
        Scanner key=new Scanner(f);
        ArrayList<String>h=new ArrayList<String>();
        ArrayList<String>h2=new ArrayList<String>();
        ArrayList<String>h3=new ArrayList<String>();
        while(key.hasNextLine())
        {
            String h1=key.nextLine();
            StringTokenizer token=new StringTokenizer(h1);
            h.add(token.nextToken(" "));
            h2.add(token.nextToken(" "));
            h3.add(token.nextToken(" "));
        }
        for(int i=0;i<h.size();i++)
        {
            System.out.print(h2.get(i)+";");
        }
        System.out.println("");
        for(int i=0;i<h.size();i++)
        {
            System.out.print(h3.get(i)+";");
        }
        
    }
    
    
}
