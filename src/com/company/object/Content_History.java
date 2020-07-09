package com.company.object;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "Content_History", strict = false)
public class Content_History {
    @ElementList(name = "Submission", inline = true, required = false)
    public List<Submission> submissionList;
    @ElementList(name = "Modification", inline = true, required = false)
    public List<Modification> modificationList;

    public List<Submission> getSubmissionList() {
        return submissionList;
    }

    public void setSubmissionList(List<Submission> submissionList) {
        this.submissionList = submissionList;
    }

    public List<Modification> getModificationList() {
        return modificationList;
    }

    public void setModificationList(List<Modification> modificationList) {
        this.modificationList = modificationList;
    }
}
