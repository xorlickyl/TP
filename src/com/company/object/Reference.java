package com.company.object;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "Reference", strict = false)
public class Reference {
    @Attribute(name = "External_Reference_ID", required = false)
    public String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
