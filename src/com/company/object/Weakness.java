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
    @Element(name="Background_Details", required = false)
    public Details details;
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

    public void setLikelihood_Of_Exploit(String likelihood_Of_Exploit) {
        Likelihood_Of_Exploit = likelihood_Of_Exploit;
    }

    public void setConsequences(Consequences consequences) {
        this.consequences = consequences;
    }

    public void setMitigations(Mitigations mitigations) {
        this.mitigations = mitigations;
    }

    public void setDemo_example(Demo_Example demo_example) {
        this.demo_example = demo_example;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public void setModes(Modes modes) {
        this.modes = modes;
    }

    public void setPlatforms(Platforms platforms) {
        this.platforms = platforms;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public void setExtended_Description(String extended_Description) {
        Extended_Description = extended_Description;
    }

    public void setChildren(Child children) {
        this.children = children;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return Description;
    }

    public String getExtended_Description() {
        return Extended_Description;
    }

    public Child getChildren() {
        return children;
    }

    public Platforms getPlatforms() {
        return platforms;
    }

    public Details getDetails() {
        return details;
    }

    public Modes getModes() {
        return modes;
    }

    public String getLikelihood_Of_Exploit() {
        return Likelihood_Of_Exploit;
    }

    public Consequences getConsequences() {
        return consequences;
    }

    public Mitigations getMitigations() {
        return mitigations;
    }

    public Demo_Example getDemo_example() {
        return demo_example;
    }

    public Observed_Examples getObserved_examples() {
        return observed_examples;
    }
}
