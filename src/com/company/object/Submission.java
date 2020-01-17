package com.company.object;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="Submission",strict = false)
public class Submission {
    @Element(name="Submission_Name",required = false)
    public String name;
    @Element(name="Submission_Organization",required = false)
    public String organization;
    @Element(name="Submission_Date",required = false)
    public String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
