package com.company.object;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="Note",strict = false)
public class Notes {
    @Element(required = false)
    public String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
