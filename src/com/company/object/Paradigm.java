package com.company.object;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "Paradigm", strict = false)
public class Paradigm {
    @Attribute(name="Name", required = false)
    public String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
