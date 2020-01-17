package com.company.object;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "Related_Weakness", strict = false)
public class Child_ID {
    @Attribute(name="CWE_ID", required = false)
    public int ID;

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }
}
