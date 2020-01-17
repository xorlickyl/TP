package com.company.object;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name="Language",strict = false)
public class Language {
    @Attribute(name="Class", required = false)
    public String name_class;
    @Attribute(name="Name", required = false)
    public String name;
    @Attribute(name="Prevalence", required = false)
    public String prevalence;

    public String getPrevalence() {
        return prevalence;
    }

    public void setPrevalence(String prevalence) {
        this.prevalence = prevalence;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName_class(String name_class) {
        this.name_class = name_class;
    }

    public String getName_class() {
        return name_class;
    }

    public String getName() {
        return name;
    }
}
