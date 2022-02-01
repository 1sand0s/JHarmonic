package com.JHarmonic.GElement;

import com.JHarmonic.SElement.SElement;
import com.JHarmonic.Util.UnitConversion;

/**
 * @author 1sand0s
 * 
 */
public abstract class GElement extends javax.swing.JPanel {

    protected SElement element;
    protected boolean componentHighlight = false;

    /**
     * regular
     * 
     * @author 1sand0s
     * @return String : Id with appropriate denomination (R,C,L etc)
     * @since 1.0.0
     * @version 1.0.0
     */
    public String getId() {
        return element.getId();
    }

    /**
     * regular
     * 
     * @author 1sand0s
     * @return Double : Value of the component (Resistance, Capacitance etc)
     * @since 1.0.0
     * @version 1.0.0
     */
    public double getValue() {
        return element.getValue();
    }

    /**
     * regular
     * 
     * @author 1sand0s
     * @param val : Value to assign to the components (Resistance, Capacitance etc)
     * @since 1.0.0
     * @version 1.0.0
     */
    public void setValue(String value) {
        element.setValue(UnitConversion.convertMetricPrefixToValue(value));
    }

    /**
     * regular
     * 
     * @author 1sand0s
     * @return Int : Id of the component as an integer
     * @since 1.0.0
     * @version 1.0.0
     */
    public int getId_Int() {
        return element.getId_Int();
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
    public double getVoltage(double[] result) {
        return element.getVoltage(result);
    }

    /**
     * regular
     * 
     * @author 1sand0s
     * @@param result : double array of results after solve
     * @return Double : get current
     * @since 1.0.0
     * @version 1.0.0
     */
    public double getCurrent(double[] result) {
        return element.getCurrent(result);
    }

    /**
     * regular
     * 
     * @author 1sand0s
     * @return GNode[] : Node IDs of all nodes the GElement is connected to
     * @since 1.0.0
     * @version 1.0.0
     */
    public abstract GNode[] getNodes();
}
