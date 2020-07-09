package com.company.object;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root(name = "Weakness_Catalog", strict = false)
public class Weakness_Catalog {
    @Element(name = "Weaknesses", required = false)
    public Weaknesses Weaknesses;

    public Weaknesses getWeaknesses() {
        return Weaknesses;
    }

    public void setWeaknesses(Weaknesses weaknesses) {
        this.Weaknesses = weaknesses;
    }

}
