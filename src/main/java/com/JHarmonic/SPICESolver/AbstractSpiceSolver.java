/**
 * 
 */
package com.JHarmonic.SPICESolver;

import com.JHarmonic.SElement.SElement;
import com.JHarmonic.SMath.Complex;

import java.util.ArrayList;

/**
 * @author 1sand0s
 *
 */
public abstract class AbstractSpiceSolver {
    protected ArrayList<SElement> circuitElements;
    protected Complex G[][];
    protected Complex B[][];
    protected Complex C[][];
    protected Complex D[][];
    protected Complex x[];
    protected Complex b[];

    /**
     * regular
     * 
     * @author 1sand0s
     * @param
     * @return
     * @since
     * @version 1.0.0
     * @exception
     */
    public void addElement(SElement element) {
        circuitElements.add(element);
    }

    /**
     * regular
     * 
     * @author 1sand0s
     * @param
     * @return
     * @since
     * @version 1.0.0
     * @exception
     */
    public void removeElement(int index) {
        for (int j = 0; j < circuitElements.size(); j++)
            if (circuitElements.get(j).getId_Int() == index) {
                circuitElements.remove(j);
                break;
            }
    }

    /**
     * regular
     * 
     * @author 1sand0s
     * @param
     * @return
     * @since
     * @version 1.0.0
     * @exception
     */
    public abstract void solve();
}
