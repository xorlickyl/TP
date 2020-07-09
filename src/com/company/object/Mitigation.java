package com.company.object;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.util.List;

@Root(name = "Mitigation", strict = false)
public class Mitigation {
    @ElementList(name = "Phase", inline = true, required = false)
    public List<Phase> phase;
    @Element(name = "Description", required = false)
    public String description;
    @Element(name = "Effectiveness", required = false)
    public String effectiveness;
    @Element(name = "Strategy", required = false)
    public String strategy;

    public Mitigation() {
    }

    public List<Phase> getPhase() {
        return phase;
    }

    public void setPhase(List<Phase> phase) {
        this.phase = phase;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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

    @Override
    public String toString() {
        return "Mitigation{" +
                "phase=" + phase +
                ", description=" + description +
                ", effectiveness='" + effectiveness + '\'' +
                ", strategy='" + strategy + '\'' +
                '}';
    }
}
