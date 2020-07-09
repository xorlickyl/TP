package com.company.object;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

//@Element(name = "Weaknesses")
@Root(name = "Weaknesses", strict = false)
public class Weaknesses {
    @ElementList(name = "Weakness", inline = true, required = false)
    public List<Weakness> Weakness;

    public List<Weakness> getWeakness() {
        return Weakness;
    }

    public void setWeakness(List<Weakness> weakness) {
        Weakness = weakness;
    }
}
