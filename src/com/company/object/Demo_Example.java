package com.company.object;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="Demonstrative_Examples",strict = false)
public class Demo_Example {
    @ElementList(name="Demonstrative_Example",inline = true, required = false)
    public List<Demo_Example_Into> demo_example_into;

    public List<Demo_Example_Into> getDemo_example_into() {
        return demo_example_into;
    }

    public void setDemo_example_into(List<Demo_Example_Into> demo_example_into) {
        this.demo_example_into = demo_example_into;
    }
}
