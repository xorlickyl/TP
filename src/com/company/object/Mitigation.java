package com.company.object;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.util.List;

@Root(name = "Mitigation", strict = false)
public class Mitigation {
    @ElementList(name="Phase",inline = true, required = false)
    public List<Phase> phase;
    @Element(name="Description",required = false)
    public Description description;
   @Element(name="Effectiveness", required = false)
   public String effectiveness;
    @Element(name="Strategy",required = false)
    public String strategy;

    public List<Phase> getPhase() {
        return phase;
    }

    public void setPhase(List<Phase> phase) {
        this.phase = phase;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getEffectiveness() {
        return effectiveness;
    }

    public void setEffectiveness(String effectiveness) {
        this.effectiveness = effectiveness;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }
}
