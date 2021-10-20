/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harmonic;

/**
 *
 * @author itarsi
 */
public class MatrixOperations 
{
    private double Q[][];
    private double R[][];
    private double A[][];
    public double[][] getQ()
    {
        return Q;
    }
    public double[][] getR()
    {
        return R;
    }
    public void computeQR(double A1[][])
    {
        Q=new double[A1.length][A1.length];
        R=new double[A1.length][A1.length];
        A=new double[A1.length][A1.length];
        for(int i=1;i<A.length;i++)
        {
            for(int j=1;j<A[i].length;j++)
            {
                A[j][i]=A1[i][j];
            }
        }
        double u[]=new double[A[1].length];
        double e[]=divideArraybyScalar(A[1],computeNorm(A[1]));
        Q[1]=e;
        for(int j=2;j<A.length;j++)
        {
            System.arraycopy(A[j],0,u,0, A[j].length);
            for(int i=j-1;i>0;i--)
            {
                u=sumArray(u,multiplyArraybyScalar(Q[i],dotProduct(A[j],Q[i])),-1);
            }
            e=divideArraybyScalar(u,computeNorm(u));
            Q[j]=e;
        }
        for(int j=1;j<Q.length;j++)
        {
            for(int i=j;i<Q.length;i++)
            {
                R[j][i]=dotProduct(A[i],Q[j]);
            }
        }
    }
    public double computeNorm(double c[])
    {
        double norm=0;
        for(int i=1;i<c.length;i++)
        {
            norm=norm+Math.pow(c[i],2);
        }
        norm=Math.sqrt(norm);
        return norm;
    }
    public double[] divideArraybyScalar(double u[],double s)
    {
        double d[]=new double[u.length];
        for(int j=0;j<u.length;j++)
        {
            d[j]=u[j]/s;
        }
        return d;
    }
    public void printMatrix(double mat[][])
    {
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                System.out.print(mat[i][j]+" , ");
            }
            System.out.println("");
        }
        System.out.println("\n");
    }
    public double dotProduct(double d1[],double d2[])
    {
        double d=0;
        for(int i=1;i<d1.length;i++)
        {
            d=d+d1[i]*d2[i];
        }
        return d;
    }
    public double[] multiplyArraybyScalar(double d1[],double s)
    {
        double d[]=new double[d1.length];
        for(int j=1;j<d1.length;j++)
        {
            d[j]=s*d1[j];
        }
        return d;
    }
    public double[][] transpose(double d1[][])
    {
        double d[][]=new double[d1[0].length][d1.length];
        for(int i=0;i<d1.length;i++)
        {
            for(int j=0;j<d1[0].length;j++)
            {
                d[j][i]=d1[i][j];
            }
        }
        return d;
    }
    public double[] sumArray(double d1[],double d2[],int sign)
    {
        double d[]=new double[d1.length];
        for(int i=1;i<d1.length;i++)
        {
            d[i]=d1[i]+sign*d2[i];
        }
        return d;
    }
    public double[][] multiplyMatrix(double d1[][], double d2[][])
    {
        double d[][]=new double[d1.length][d2.length];
        for(int i=0;i<d1.length;i++)
        {
            for(int j=0;j<d2.length;j++)
            {
                d[i][j]=dotProduct(d1[i],d2[j]);
            }
        }
        return d;
    }
    public double[][] computeLinearEquation(double A1[][],double z[][])
    {
        computeQR(A1);
        double x[][]=new double[z.length][z[0].length];
        double Y[][]=multiplyMatrix(Q,transpose(z));
        for(int k=1;k<x[0].length;k++)
        {
            for(int i=x.length-1;i>=1;i--)
            {
                double u=0;
                for(int j=i+1;j<x.length;j++)
                {
                    u=u-R[i][j]*x[j][k];
                }
                x[i][k]=Math.abs((Y[i][k]+u)/(R[i][i]))<Math.pow(10,-20)?0:(Y[i][k]+u)/(R[i][i]);
            }
        }
        return x;
    }
    public double[][] matrixConcatenator(double g[][],double b[][],double c[][], double d[][])
    {
        double x[][]=new double[g.length+c.length-1][g[0].length+b[0].length-1];
        for(int i=1;i<g.length;i++)
        {
            System.arraycopy(g[i], 1, x[i], 1, g[i].length-1);
            System.arraycopy(b[i], 1, x[i],g[i].length,b[i].length-1);
        }
        for(int i=1;i<c.length;i++)
        {
            System.arraycopy(c[i], 1, x[i+g.length-1], 1, c[0].length-1);
            System.arraycopy(d[i], 1, x[i+g.length-1], c[0].length,d[0].length-1);
        }
        return x;
    }
    public Complex[][] matrixConcatenator(Complex g[][],Complex b[][],Complex c[][],Complex d[][])
    {
        Complex x[][]=new Complex[g.length+c.length-1][g[1].length+b[1].length-1];
        for(int i=1;i<g.length;i++)
        {
            System.arraycopy(g[i], 1, x[i], 1, g[i].length-1);
            System.arraycopy(b[i], 1, x[i],g[i].length,b[i].length-1);
        }
        for(int i=1;i<c.length;i++)
        {
            System.arraycopy(c[i], 1, x[i+g.length-1], 1, c[1].length-1);
            System.arraycopy(d[i], 1, x[i+g.length-1], c[1].length,d[1].length-1);
        }
        return x;
    }
    public double maxArray(double d1[])
    {
        double d=d1[1];
        for(int i=2;i<d1.length;i++)
        {
            if(d1[i]>d)
            {
                d=d1[i];
            }
        }
        return d;
    }
    public double minArray(double d1[])
    {
        double d=d1[1];
        for(int i=2;i<d1.length;i++)
        {
            if(d1[i]<d)
            {
                d=d1[i];
            }
        }
        return d;
    }
    public int maxArray(int d1[])
    {
        int d=d1[1];
        for(int i=2;i<d1.length;i++)
        {
            if(d1[i]>d)
            {
                d=d1[i];
            }
        }
        return d;
    }
    public double[] dcStretch(double d[],int stretch)
    {
        double d1[]=new double[stretch];
        for(int i=0;i<stretch;i++)
        {
            d1[i]=d[1];
        }
        return d1;
    }
    public Complex[] computeFFT(double d[])
    {
        Complex d1[][]=MatrixOperations.dftMatrix(d.length-1);
        Complex d2[]=new Complex[d.length];
        for(int i=0;i<d1.length;i++)
        {
            d2[i+1]=Complex.AddSub(Complex.ScalarMultiply(d1[i],d),1);
        }
        return d2;
    }
    public Complex[] computeFFT(Complex d[])
    {
        Complex d1[][]=MatrixOperations.dftMatrix(d.length-1);
        Complex d2[]=new Complex[d.length];
        for(int i=0;i<d1.length;i++)
        {
            d2[i+1]=Complex.AddSub(Complex.Multiply(d1[i],d),1);
        }
        return d2;
    }
    public Complex[] computeIFFT(Complex d[])
    {
        Complex d1[][]=MatrixOperations.idftMatrix(d.length-1);
        Complex d2[]=new Complex[d.length];
        for(int i=0;i<d1.length;i++)
        {
            d2[i+1]=Complex.AddSub(Complex.Multiply(d1[i],d),1);
        }
        return d2;
    }
    public static Complex[][] dftMatrix(int size)
    {
        Complex d[][]=new Complex[size][size];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                double real=Math.cos(-2*Math.PI*i*j/size);
                real=Math.abs(real)<1e-7?0:real;
                double imag=Math.sin(-2*Math.PI*i*j/size);
                imag=Math.abs(imag)<1e-7?0:imag;
                d[i][j]=new Complex(real,imag);
            }
        }
        return d;
    }
    public static Complex[][] idftMatrix(int size)
    {
        Complex d[][]=new Complex[size][size];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                double real=Math.cos(2*Math.PI*i*j/size);
                real=Math.abs(real)<1e-7?0:real;
                double imag=Math.sin(2*Math.PI*i*j/size);
                imag=Math.abs(imag)<1e-7?0:imag;
                d[i][j]=new Complex(real/size,imag/size);
            }
        }
        return d;
    }
    public static double[][] eye(int size)
    {
        double d[][]=new double[size][size];
        for(int i=1;i<d.length;i++)
        {
            d[i][i]=1;
        }
        return d;
    }
    
}
class Complex
{
    private double real,imaginary;
    static Complex Yj;
    private static Complex[][] Ymat;
    Complex()
    {
        real=0;
        imaginary=0;
    }
    Complex(double real,double imaginary)
    {
        this.real=real;
        this.imaginary=imaginary;
    }
    public double getReal()
    {
        return real;
    }
    public double getImaginary()
    {
        return imaginary;
    }
    public void setReal(double real)
    {
        this.real=real;
    }
    public void setImaginary(double imaginary)
    {
        this.imaginary=imaginary;
    }
    public static Complex AddSub(Complex num[],int j)
    {
        Complex num2=new Complex();
        for(int i=1;i<num.length;i++)
        {
            num2.setReal(num2.getReal()+j*num[i].getReal());
            num2.setImaginary(num2.getImaginary()+j*num[i].getImaginary());
        }
        return num2;
    }
    public static Complex AddSub(Complex num,Complex num1,int j)
    {
        Complex num2=new Complex();
        num2.setReal(num.getReal()+j*num1.getReal());
        num2.setImaginary(num.getImaginary()+j*num1.getImaginary());
        return num2;
    }
    public static Complex[] AddSubArray(Complex num1[],Complex num2[],int j)
    {
        Complex num3[]=new Complex[num1.length];
        for(int i=1;i<num1.length;i++)
        {
            num3[i]= Complex.AddSub(num1[i],num2[i],j);
        }
        return num3;
    }
    public static Complex Multiply(Complex num1,Complex num2)
    {
        Complex num3=new Complex();
        num3.setReal(num1.getReal()*num2.getReal()-num1.getImaginary()*num2.getImaginary());
        num3.setImaginary(num1.getReal()*num2.getImaginary()+num1.getImaginary()*num2.getReal());
        return num3;
    }
    public static Complex[] Multiply(Complex num1[],Complex num2[])
    {
        Complex num3[]=new Complex[num2.length];
        for(int i=0;i<num1.length;i++)
        {
            num3[i+1]=new Complex();
            num3[i+1]=Complex.Multiply(num1[i], num2[i+1]);
        }
        return num3;
    }
    public static Complex[] Multiply(Complex num1[],Complex num2)
    {
        Complex num3[]=new Complex[num1.length];
        for(int i=1;i<num1.length;i++)
        {
            num3[i]=new Complex();
            num3[i]=Complex.Multiply(num1[i], num2);
        }
        return num3;
    }
    public static Complex ScalarAddSub(Complex num,double scalar)
    {
        Complex num1=new Complex();
        num1.setReal(num.getReal()+scalar);
        num1.setImaginary(num.getImaginary()+scalar);
        return num1;
    }
    public static Complex ScalarMultiply(Complex num,double scalar)
    {
        Complex num1=new Complex();
        num1.setReal(num.getReal()*scalar);
        num1.setImaginary(num.getImaginary()*scalar);
        return num1;
    }
    public static Complex[] ScalarMultiply(Complex num[],double scalar[])
    {
        Complex num1[]=new Complex[scalar.length];
        for(int i=0;i<num.length;i++)
        {
            num1[i+1]=new Complex();
            num1[i+1]=Complex.ScalarMultiply(num[i],scalar[i+1]);
        }
        return num1;
    }
    public static Complex[] ScalarMultiply(Complex num[],double scalar)
    {
        Complex num1[]=new Complex[num.length];
        for(int i=1;i<num.length;i++)
        {
            num1[i]=new Complex();
            num1[i]=Complex.ScalarMultiply(num[i],scalar);
        }
        return num1;
    }
    public static double computeAbs(Complex num)
    {
        double d;
        d=Math.hypot(num.getReal(),num.getImaginary());
        return d;
    }
    public static double[] computeAbs(Complex num[])
    {
        double d[]=new double[num.length];
        for(int i=1;i<d.length;i++)
        {
            d[i]=Complex.computeAbs(num[i]);
        }
        return d;
    }
    public static double computeNorm(Complex num[])
    {
        double d=0;
        for(int i=1;i<num.length;i++)
        {
            d=d+Math.pow(num[i].getReal(),2)+Math.pow(num[i].getImaginary(),2);
        }
        d=Math.sqrt(d);
        return d;
    }
    public static Complex[][] transpose(Complex d1[][])
    {
        Complex d[][]=new Complex[d1[1].length][d1.length];
        for(int i=1;i<d1.length;i++)
        {
            for(int j=1;j<d1[1].length;j++)
            {
                d[j][i]=new Complex();
                d[j][i].setReal(d1[i][j].getReal());
                d[j][i].setImaginary(d1[i][j].getImaginary());
            }
        }
        return d;
    }
    public static Complex conjugate(Complex num)
    {
        Complex num1=new Complex();
        num1.setReal(num.getReal());
        num1.setImaginary(-num.getImaginary());
        return num1;
    }
    public static Complex[][] conjugate(Complex num[][])
    {
        Complex num1[][]=new Complex[num.length][num.length];
        for(int i=1;i<num.length;i++)
        {
            for(int j=1;j<num.length;j++)
            {
                num1[i][j]=Complex.conjugate(num[i][j]);
            }
        }
        return num1;
    }
    public static Complex dotProduct(Complex num1[],Complex num2[])
    {
        Complex num=new Complex();
        for(int i=1;i<num1.length;i++)
        {
            num=Complex.AddSub(num,Complex.Multiply(num1[i],Complex.conjugate(num2[i])),1);
        }
        return num;
    }
    public static Complex[][][] computeQR(Complex A1[][])
    {
        Complex[][] Q,R,A;
        Q=new Complex[A1.length][A1.length];
        R=new Complex[A1.length][A1.length];
        A=new Complex[A1.length][A1.length];
        for(int i=1;i<A.length;i++)
        {
            for(int j=1;j<A[i].length;j++)
            {
                A[j][i]=new Complex();
                A[j][i].setReal(A1[i][j].getReal());
                A[j][i].setImaginary(A1[i][j].getImaginary());
            }
        }
        Complex u[]=new Complex[A[1].length];
        Complex e[]=Complex.ScalarMultiply(A[1],1/Complex.computeNorm(A[1]));
        Q[1]=e;
        for(int j=2;j<A.length;j++)
        {
            System.arraycopy(A[j],0,u,0, A[j].length);
            for(int i=j-1;i>0;i--)
            {
                Complex var=Complex.dotProduct(A[j],Q[i]);
                u=Complex.AddSubArray(u,Complex.Multiply(Q[i],Complex.dotProduct(A[j],Q[i])),-1);
            }
            e=Complex.ScalarMultiply(u,1/computeNorm(u));
            Q[j]=e;
        }
        for(int j=1;j<Q.length;j++)
        {
            for(int i=j;i<Q.length;i++)
            {
                R[j][i]=Complex.dotProduct(A[i],Q[j]);
            }
        }
        return new Complex[][][]{Q,R};
    }
    public static Complex[][] multiplyMatrix(Complex d1[][], Complex d2[][])
    {
        Complex d[][]=new Complex[d1.length][d2.length];
        for(int i=1;i<d1.length;i++)
        {
            for(int j=1;j<d2.length;j++)
            {
                d[i][j]=Complex.multiply(d1[i],d2[j]);
            }
        }
        return d;
    }
    public static Complex multiply(Complex num1[],Complex[] num2)
    {
        Complex num=new Complex();
        for(int i=1;i<num1.length;i++)
        {
            num=Complex.AddSub(num,Complex.Multiply(num1[i], num2[i]),1);
        }
        return num;
    }
    public static Complex divideComplex(Complex num1,Complex num2)
    {
        Complex num=new Complex();
        num=Complex.Multiply(num1,Complex.ScalarMultiply(Complex.conjugate(num2),1/Math.pow(Complex.computeAbs(num2),2)));
        return num;
    }
    public static Complex[][] computeLinearEquation(Complex A1[][],Complex z[][],boolean flag)
    {
        Complex[][][] QR=computeQR(A1);
        Complex[][] Q=Complex.conjugate(QR[0]);
        Complex[][] R=QR[1];
        Complex x[][]=new Complex[z[0].length][z.length];
        Complex Y[][]=Complex.multiplyMatrix(Q,z);
        for(int k=1;k<x[0].length;k++)
        {
            for(int i=x.length-1;i>=1;i--)
            {
                Complex u=new Complex();
                for(int j=i+1;j<x.length;j++)
                {
                    u=Complex.AddSub(u,Complex.Multiply(R[i][j],x[j][k]),-1);
                }
                x[i][k]=Complex.divideComplex(Complex.AddSub(Y[i][k],u,1),R[i][i]);
                x[i][k]=Complex.removeRedundancy(x[i][k]);
            }
        }
        if(flag){setAdmittance(Q,R);}
        return x;
    }
    public static Complex[][] eye(int size)
    {
        Complex d[][]=new Complex[size][size];
        for(int i=1;i<d.length;i++)
        {
            for(int j=1;j<d.length;j++)
            {
                if(i==j)
                    d[i][j]=new Complex(1,0);
                else
                    d[i][j]=new Complex(0,0);
            }
        }
        return d;
    }
    private static void setAdmittance(Complex[][] Q,Complex[][] R)
    {
        System.out.println(Q.length+" Q "+Q[1].length);
        Complex eye[][]=eye(Q.length);
        System.out.println(eye.length+" eye "+eye[1].length);
        Complex Y[][]=Complex.multiplyMatrix(Q,eye);
        System.out.println(Y.length+" Y "+Y[1].length);
        Complex x[][]=new Complex[Q.length][Q.length];
        for(int k=1;k<x[0].length;k++)
        {
            for(int i=x.length-1;i>=1;i--)
            {
                Complex u=new Complex();
                for(int j=i+1;j<x.length;j++)
                {
                    u=Complex.AddSub(u,Complex.Multiply(R[i][j],x[j][k]),-1);
                }
                x[i][k]=Complex.divideComplex(Complex.AddSub(Y[i][k],u,1),R[i][i]);
                x[i][k]=Complex.computeAbs(x[i][k])<1e-11?new Complex():x[i][k];
            }
        }
        Ymat=x;
    }
    public static Complex getAdmittance(int id)
    {
        System.out.println(Ymat.length+"  len "+Ymat[1].length);
        return Ymat[id][id];
    }
    public static Complex removeRedundancy(Complex d)
    {
        Complex d1=new Complex();
        d1.setReal(Math.abs(d.getReal())<1e-10?0:d.getReal());
        d1.setImaginary(Math.abs(d.getImaginary())<1e-10?0:d.getImaginary());
        return d1;
    }
}
