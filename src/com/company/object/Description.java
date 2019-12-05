package com.company.object;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(name="Description", strict = false)
public class Description {
    @Text
    public String text;
}
