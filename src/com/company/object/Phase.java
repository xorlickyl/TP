package com.company.object;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(name = "Phase", strict = false)
public class Phase {
    //@Element(name="Phase",required = false)
    @Text(required = false)
    public String phase;

    public Phase() {
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }
}
