package com.company.object;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="Modification",strict = false)
public class Modification {
    @Element(name="Modification_Name",required = false)
    public String name;
    @Element(name="Modification_Organization",required = false)
    public String organization;
    @Element(name="Modification_Date",required = false)
    public String date;
    @Element(name="Modification_Comment",required = false)
    public String coment;
}
