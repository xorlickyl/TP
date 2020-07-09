package com.company.object;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "Technology", strict = false)
public class Technology {
    @Attribute(name = "Name", required = false)
    public String server;

    public void setServer(String server) {
        this.server = server;
    }

    public String getServer() {
        return server;
    }
}
