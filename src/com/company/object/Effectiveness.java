package com.company.object;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="Effectiveness", strict = false)
public class Effectiveness {
    @Element(name="Effectiveness", required = false)
    public String text;
}
