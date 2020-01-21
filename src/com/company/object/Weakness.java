package com.company.object;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Weakness", strict = false)
public class Weakness {

    @Attribute(name = "ID", required = false)
    public int ID;
    @Attribute(name="Name",  required = false)
    public String name;

    @Element(name="Description",  required = false)
    public String Description;
    @Element(name="Extended_Description",  required = false)
    public String Extended_Description;
    @Element(name = "Related_Weaknesses", required=false)
    public Child children;
    @Element(name = "Applicable_Platforms", required = false)
    public Platforms platforms;
    @Element(name = "Modes_Of_Introduction", required = false)
    public Modes modes;
    @Element(name = "Likelihood_Of_Exploit", required = false)
    public String Likelihood_Of_Exploit;
    @Element(name = "Common_Consequences",required = false)
    public Consequences consequences;
    @Element(name="Potential_Mitigations", required = false)
    public Mitigations mitigations;
    @Element(name="Demonstrative_Examples", required = false)
    public Demo_Example demo_example;
    @Element(name="Observed_Examples",required = false)
    public Observed_Examples observed_examples;
    @Element(name="References",required = false)
    public References references;
    @Element(name="Content_History",required = false)
    public Content_History content_history;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getExtended_Description() {
        return Extended_Description;
    }

    public void setExtended_Description(String extended_Description) {
        Extended_Description = extended_Description;
    }

    public Child getChildren() {
        return children;
    }

    public void setChildren(Child children) {
        this.children = children;
    }

    public Platforms getPlatforms() {
        return platforms;
    }

    public void setPlatforms(Platforms platforms) {
        this.platforms = platforms;
    }

    public Modes getModes() {
        return modes;
    }

    public void setModes(Modes modes) {
        this.modes = modes;
    }

    public String getLikelihood_Of_Exploit() {
        return Likelihood_Of_Exploit;
    }

    public void setLikelihood_Of_Exploit(String likelihood_Of_Exploit) {
        Likelihood_Of_Exploit = likelihood_Of_Exploit;
    }

    public Consequences getConsequences() {
        return consequences;
    }

    public void setConsequences(Consequences consequences) {
        this.consequences = consequences;
    }

    public Mitigations getMitigations() {
        return mitigations;
    }

    public void setMitigations(Mitigations mitigations) {
        this.mitigations = mitigations;
    }

    public Demo_Example getDemo_example() {
        return demo_example;
    }

    public void setDemo_example(Demo_Example demo_example) {
        this.demo_example = demo_example;
    }

    public Observed_Examples getObserved_examples() {
        return observed_examples;
    }

    public void setObserved_examples(Observed_Examples observed_examples) {
        this.observed_examples = observed_examples;
    }

    public References getReferences() {
        return references;
    }

    public void setReferences(References references) {
        this.references = references;
    }

    public Content_History getContent_history() {
        return content_history;
    }

    public void setContent_history(Content_History content_history) {
        this.content_history = content_history;
    }
}
