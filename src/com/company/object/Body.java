package com.company.object;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(name = "Body_Text", strict = false)
public class Body {
    @Text(required = false)
    public String text;

    public Body() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
