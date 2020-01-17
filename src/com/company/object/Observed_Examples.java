package com.company.object;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="Observed_Examples",strict = false)
public class Observed_Examples {
    @ElementList(name="Observed_Example",inline = true, required = false)
    public List<Observed_Example> observed_example;

    public List<Observed_Example> getObserved_example() {
        return observed_example;
    }

    public void setObserved_example(List<Observed_Example> observed_example) {
        this.observed_example = observed_example;
    }
}
