package com.JHarmonic.SElement;

import com.JHarmonic.Util.ComponentTerminals;
import com.JHarmonic.SMath.Complex;
import com.JHarmonic.Util.ComponentDenominations;

/**
 * @author 1sand0s
 *
 */
public class Capacitor extends SElement {

    private double capacitance;

    public Capacitor() {
        denomination = ComponentDenominations.C;
        capacitance = 0;
        terminals = new Terminals(2,
                new ComponentTerminals[] { ComponentTerminals.POS_NODE, ComponentTerminals.NEG_NODE });
    }

    @Override
    public double getValue() {
        return capacitance;
    }

    @Override
    public void setValue(double value) {
        capacitance = value;
    }

    @Override
    public double getVoltage(double[] result) {
        int[] nodes = terminals.getTerminals();

        return (result[nodes[0]] - result[nodes[1]]);
    }

    @Override
    public double getCurrent(double[] result) {
        return (getVoltage(result) * capacitance);
    }

    @Override
    public void stampMatrix(Complex[][] G,
                            Complex[][] B,
                            Complex[][] C,
                            Complex[][] D,
                            Complex[][] z,
                            int iSourceIndex) {
        // TODO Auto-generated method stub

    }
}
