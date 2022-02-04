package com.JHarmonic.SElement;

import com.JHarmonic.SMath.Complex;
import com.JHarmonic.Util.ComponentDenominations;
import com.JHarmonic.Util.ComponentTerminals;

/**
 * @author 1sand0s
 *
 */
public class DCVoltage extends SElement {

    private double voltage;

    public DCVoltage() {
        denomination = ComponentDenominations.V;
        voltage = 0;
        terminals = new Terminals(2,
                new ComponentTerminals[] { ComponentTerminals.POS_NODE, ComponentTerminals.NEG_NODE });
    }

    @Override
    public double getValue() {
        return voltage;
    }

    @Override
    public void setValue(double value) {
        voltage = value;
    }

    @Override
    public double getVoltage(double[] result) {
        return voltage;
    }

    @Override
    public double getCurrent(double[] result) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void stampMatrix(Complex[][] G,
                            Complex[][] B,
                            Complex[][] C,
                            Complex[][] D,
                            Complex[][] z,
                            int iSourceIndex) {
        int posNode = terminals.getTerminal(ComponentTerminals.POS_NODE);
        int negNode = terminals.getTerminal(ComponentTerminals.NEG_NODE);
        
        B[posNode][iSourceIndex].add(new Complex(1, 0));
        B[negNode][iSourceIndex].add(new Complex(-1, 0));

        C[iSourceIndex][posNode].add(new Complex(1, 0));
        C[iSourceIndex][negNode].add(new Complex(-1, 0));

        z[G.length + iSourceIndex - 1][0].add(new Complex(voltage, 0));
    }
}
