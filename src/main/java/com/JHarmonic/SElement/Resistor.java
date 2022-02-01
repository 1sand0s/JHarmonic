package com.JHarmonic.SElement;

import com.JHarmonic.Util.ComponentTerminals;
import com.JHarmonic.SMath.Complex;
import com.JHarmonic.Util.ComponentDenominations;

/**
 * @author 1sand0s
 *
 */
public class Resistor extends SElement {

    private double resistance;

    public Resistor() {
        denomination = ComponentDenominations.R;
        resistance = 0;
        terminals = new Terminals(2,
                new ComponentTerminals[] { ComponentTerminals.POS_NODE, ComponentTerminals.NEG_NODE });
    }

    @Override
    public double getValue() {
        return resistance;
    }

    @Override
    public void setValue(double value) {
        resistance = value;
    }

    @Override
    public double getVoltage(double[] result) {
        int[] nodes = terminals.getTerminals();
        return (result[nodes[0]] - result[nodes[1]]);
    }

    @Override
    public double getCurrent(double[] result) {
        return getVoltage(result) / resistance;
    }

    @Override
    public void stampMatrix(Complex[][] G,
                            Complex[][] B,
                            Complex[][] C,
                            Complex[][] D,
                            Complex[] b,
                            int iSourceIndex) {
        int posNode = terminals.getTerminal(ComponentTerminals.POS_NODE);
        int negNode = terminals.getTerminal(ComponentTerminals.NEG_NODE);

        G[posNode][posNode].add(new Complex(1 / resistance, 0));
        G[negNode][negNode].add(new Complex(1 / resistance, 0));
        G[posNode][negNode].add(new Complex(-1 / resistance, 0));
        G[negNode][posNode].add(new Complex(-1 / resistance, 0));
    }
}
