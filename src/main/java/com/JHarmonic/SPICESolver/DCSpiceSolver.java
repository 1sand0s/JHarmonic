/**
 * 
 */
package com.JHarmonic.SPICESolver;

import com.JHarmonic.SElement.DCVoltage;
import com.JHarmonic.SElement.SElement;
import com.JHarmonic.SElement.Wire;
import com.JHarmonic.SMath.ComplexMatrixOperations;
import com.JHarmonic.SMath.Complex;

import java.util.ArrayList;

/**
 * @author 1sand0s
 *
 */
public class DCSpiceSolver extends AbstractSpiceSolver {

    /**
     * 
     */
    public DCSpiceSolver() {
        circuitElements = new ArrayList<SElement>();
        wires = new ArrayList<Wire>();
    }

    @Override
    public void solve() {
        int vSourceIndex = 0;

        G = new Complex[wires.size()][wires.size()];
        B = new Complex[wires.size()][iVSource + iISource];
        C = new Complex[iVSource + iISource][wires.size()];
        D = new Complex[iVSource + iISource][iVSource + iISource];
        z = new Complex[wires.size() + iVSource + iISource - 1][1];

        numberNodes();

        ComplexMatrixOperations.initializeMatrices(G);
        ComplexMatrixOperations.initializeMatrices(B);
        ComplexMatrixOperations.initializeMatrices(C);
        ComplexMatrixOperations.initializeMatrices(D);
        ComplexMatrixOperations.initializeMatrices(z);

        for (int j = 0; j < circuitElements.size(); j++) {
            SElement element = circuitElements.get(j);
            element.stampMatrix(G, B, C, D, z, vSourceIndex);

            if (element instanceof DCVoltage)
                vSourceIndex++;
        }
        Complex A[][] = ComplexMatrixOperations.matrixConcatenator(G, B, C, D);

        x = ComplexMatrixOperations.computeLinearEquation(A, z);
    }
}
