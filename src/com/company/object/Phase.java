package com.company.object;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Phase",strict = false)
public class Phase {
    @Element(name="Phase",required = false)
    public String phase;

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }
}
