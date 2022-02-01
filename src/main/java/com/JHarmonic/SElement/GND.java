package com.JHarmonic.SElement;

import com.JHarmonic.SMath.Complex;
import com.JHarmonic.Util.ComponentDenominations;
import com.JHarmonic.Util.ComponentTerminals;

/**
 * @author 1sand0s
 *
 */
public class GND extends SElement {

    public GND() {
        denomination = ComponentDenominations.G;
        terminals = new Terminals(1, new ComponentTerminals[] { ComponentTerminals.GND });
    }

    @Override
    public double getValue() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setValue(double value) {
        // TODO Auto-generated method stub

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
                            Complex[] b,
                            int iSourceIndex) {
        int gndNode = terminals.getTerminal(ComponentTerminals.GND);

        for (int j = 0; j < G.length; j++) {
            G[gndNode][j].setReal(0);
            G[gndNode][j].setImaginary(0);

            G[j][gndNode].setReal(0);
            G[j][gndNode].setImaginary(0);
        }
    }
}
