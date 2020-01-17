package com.company.object;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="Introduction",strict = false)
public class Introduction {
    @Element(name="Phase", required = false)
    public String phase;

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }
}
