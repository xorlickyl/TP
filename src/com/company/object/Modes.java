package com.company.object;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "Modes_Of_Introduction", strict = false)
public class Modes {
    @ElementList(name = "Introduction", inline = true, required = false)
    public List<Introduction> introduction;

    public void setIntroduction(List<Introduction> introduction) {
        this.introduction = introduction;
    }
}
