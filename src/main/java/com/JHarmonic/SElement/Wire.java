package com.JHarmonic.SElement;

import com.JHarmonic.Util.ComponentTerminals;

import java.util.ArrayList;

/**
 * @author 1sand0s
 *
 */
public class Wire {
    private ArrayList<SElement> elements;
    private ArrayList<ComponentTerminals> terminals;

    public Wire() {
        elements = new ArrayList<SElement>();
        terminals = new ArrayList<ComponentTerminals>();
    }

    /**
    * regular
    * @author 1sand0s
    * @param element : SElement to add
    * @param terminal : the terminal of the elment to add
    * @since 1.0.0
    * @version 1.0.0
    */
    public void addTerminal(SElement element, ComponentTerminals terminal) {
        elements.add(element);
        terminals.add(terminal);
    }

    /**
    * regular
    * @author 1sand0s
    * @param i : list index to remove
    * @since 1.0.0
    * @version 1.0.0
    */
    public void deleteNode(int i) {
        elements.remove(i);
        terminals.remove(i);
    }
}
