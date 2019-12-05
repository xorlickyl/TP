package com.company.object;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="References",strict = false)
public class References {
    @ElementList(name="Reference",inline = true, required = false)
    public List<Reference> referenceList;
}
