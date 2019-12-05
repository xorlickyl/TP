package com.company.object;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="Observed_Example",strict = false)
public class Observed_Example {
    @Element(name="Reference",required = false)
    public String reference;
    @Element(name="Description",required = false)
    public String description;
    @Element(name="Link",required = false)
    public String link;
}
