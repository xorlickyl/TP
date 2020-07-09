package com.company.object;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(name = "Example_Code", strict = false)
public class Example_Code {
    @Attribute(name = "Nature", required = false)
    public String nature;
    @Attribute(name = "Language", required = false)
    public String language;
    @Text(required = false)
    public String text;

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
