package com.company.object;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "Applicable_Platforms", strict = false)
public class Platforms {
    @ElementList(name = "Language", inline = true, required = false)
    public List<Language> language;
    @Element(name = "Paradigm", required = false)
    public Paradigm paradigm;
    @ElementList(name = "Technology", inline = true, required = false)
    public List<Technology> technology;

    public void setLanguage(List<Language> language) {
        this.language = language;
    }

    public void setParadigm(Paradigm paradigm) {
        this.paradigm = paradigm;
    }

    public void setTechnology(List<Technology> technology) {
        this.technology = technology;
    }

    public List<Language> getLanguage() {
        return language;
    }

    public Paradigm getParadigm() {
        return paradigm;
    }

    public List<Technology> getTechnology() {
        return technology;
    }
}
