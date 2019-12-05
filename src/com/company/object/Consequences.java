package com.company.object;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "Common_Consequences", strict = false)
public class Consequences {
    @ElementList(name = "Consequence",inline = true,required = false)
    public List<Consequence> consequence;

    public void setConsequence(List<Consequence> consequence) {
        this.consequence = consequence;
    }
}
