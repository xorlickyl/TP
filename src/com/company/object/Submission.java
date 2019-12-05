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
}
