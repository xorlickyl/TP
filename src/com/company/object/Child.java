package com.company.object;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "Related_Weaknesses", strict = false)
public class Child {

    @ElementList(name = "Related_Weakness", inline = true, required = false)
    public List<Child_ID> Child_id;

    public List<Child_ID> getChild_id() {
        return Child_id;
    }

    public void setChild_id(List<Child_ID> child_id) {
        Child_id = child_id;
    }
}
