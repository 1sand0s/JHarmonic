/**
 * 
 */
package com.JHarmonic.SPICESolver;

import com.JHarmonic.SElement.DCVoltage;
import com.JHarmonic.SElement.SElement;

/**
 * @author 1sand0s
 *
 */
public class DCSpiceSolver extends AbstractSpiceSolver {

    @Override
    public void solve() {
        int iSourceIndex = 0;
        for (int j = 0; j < circuitElements.size(); j++) {
            SElement element = circuitElements.get(j);
            element.stampMatrix(G, B, C, D, b, iSourceIndex);

            if (element instanceof DCVoltage)
                iSourceIndex++;
        }
    }
}
