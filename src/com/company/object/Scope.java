package com.company.object;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="Scope",strict = false)
public class Scope {

    @Element(required = false)
    public String text;

    public void setText(String text) {
        this.text = text;
    }
}
