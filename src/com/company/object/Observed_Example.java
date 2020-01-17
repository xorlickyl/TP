package com.company.object;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="Observed_Example",strict = false)
public class Observed_Example {
    @Element(name="Reference",required = false)
    public String reference;
    @Element(name="Description",required = false)
    public String description;
    @Element(name="Link",required = false)
    public String link;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
