package com.JHarmonic.SElement;

import com.JHarmonic.SMath.Complex;
import com.JHarmonic.Util.ComponentDenominations;
import com.JHarmonic.Util.ComponentTerminals;

/**
 * @author 1sand0s
 *
 */
public class Inductor extends SElement {

    private double inductance;

    public Inductor() {
        denomination = ComponentDenominations.L;
        inductance = 0;
        terminals = new Terminals(2,
                new ComponentTerminals[] { ComponentTerminals.POS_NODE, ComponentTerminals.NEG_NODE });
    }

    @Override
    public double getValue() {
        return inductance;
    }

    @Override
    public void setValue(double value) {
        inductance = value;
    }

    @Override
    public double getVoltage(double[] result) {
        // TODO Auto-generated method stub
        return 0;
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
        // TODO Auto-generated method stub

    }
}
