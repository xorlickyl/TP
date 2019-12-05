package com.company.object;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "Consequence", strict = false)
public class Consequence {
    @ElementList(name = "Scope", inline = true, required = false)
    public List<Scope> scope;
    @ElementList(name = "Impact",inline = true, required = false)
    public List<Impacts> impact;
    @ElementList(name = "Note",inline = true, required = false)
    public List<Notes> note;

    public void setScope(List<Scope> scope) {
        this.scope = scope;
    }

    public void setImpact(List<Impacts> impact) {
        this.impact = impact;
    }

    public void setNote(List<Notes> note) {
        this.note = note;
    }
}
