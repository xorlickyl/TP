package com.company.object;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "Potential_Mitigations", strict = false)
public class Mitigations {
    @ElementList(name = "Mitigation", inline = true, required = false)
    public List<Mitigation> mitigation;

    public List<Mitigation> getMitigation() {
        return mitigation;
    }

    public void setMitigation(List<Mitigation> mitigation) {
        this.mitigation = mitigation;
    }

    @Override
    public String toString() {
        return "Mitigations{" +
                "mitigation=" + mitigation +
                '}';
    }
}
