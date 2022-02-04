/**
 * 
 */
package com.JHarmonic.SElement;

import com.JHarmonic.Util.ComponentTerminals;
import com.JHarmonic.Util.UnitConversion;
import com.JHarmonic.Util.ComponentDenominations;
import com.JHarmonic.SMath.Complex;

/**
 * @author audi
 *
 */

public abstract class SElement {

    protected ComponentDenominations denomination;
    protected int id;
    protected Terminals terminals;

    /**
     * regular
     * 
     * @author 1sand0s
     * @return String : Id with appropriate denomination (R,C,L etc)
     * @since 1.0.0
     * @version 1.0.0
     */
    public String getId() {
        return (UnitConversion.convertComponentDenominationToString(denomination) + id);
    }

    /**
     * regular
     * 
     * @author 1sand0s
     * @return Double : Value of the component (Resistance, Capacitance etc)
     * @since 1.0.0
     * @version 1.0.0
     */
    public abstract double getValue();

    /**
     * regular
     * 
     * @author 1sand0s
     * @param val : Value to assign to the components (Resistance, Capacitance etc)
     * @since 1.0.0
     * @version 1.0.0
     */
    public abstract void setValue(double value);

    /**
     * regular
     * 
     * @author 1sand0s
     * @return Int : Id of the component as an integer
     * @since 1.0.0
     * @version 1.0.0
     */
    public int getId_Int() {
        return id;
    }

    /**
     * regular
     * 
     * @author 1sand0s
     * @return Int[] : Terminal indices (global)
     * @since 1.0.0
     * @version 1.0.0
     */
    public int[] getTerminalIndices() {
        return terminals.getTerminals();
    }

    /**
     * regular
     * 
     * @author 1sand0s
     * @return ComponentTerminals[] : Terminal names
     * @since 1.0.0
     * @version 1.0.0
     */
    public ComponentTerminals[] getTerminalNames() {
        return terminals.getTerminalNames();
    }

    /**
     * regular
     * 
     * @author 1sand0s
     * @return Int[] : Terminal indices (global)
     * @since 1.0.0
     * @version 1.0.0
     */
    public void setTerminalIndex(int index,
                                 ComponentTerminals terminal) {
        terminals.setTerminal(index, terminal);
    }

    /**
     * regular
     * 
     * @author 1sand0s
     * @param result : double array of results after solve
     * @return Double : get voltage
     * @since 1.0.0
     * @version 1.0.0
     */
    public abstract double getVoltage(double[] result);

    /**
     * regular
     * 
     * @author 1sand0s
     * @@param result : double array of results after solve
     * @return Double : get current
     * @since 1.0.0
     * @version 1.0.0
     */
    public abstract double getCurrent(double[] result);

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
    public abstract void stampMatrix(Complex[][] G,
                                     Complex[][] B,
                                     Complex[][] C,
                                     Complex[][] D,
                                     Complex[][] z,
                                     int iSourceIndex);
}
