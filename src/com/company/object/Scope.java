package com.company.object;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(name = "Scope", strict = false)
public class Scope {

    //@Element(name="Scope",  required = false)
    @Text(required = false)
    public String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
