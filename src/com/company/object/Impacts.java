package com.company.object;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(name = "Impact", strict = false)
public class Impacts {

    // @Element(required = false)
    @Text(required = false)
    public String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
