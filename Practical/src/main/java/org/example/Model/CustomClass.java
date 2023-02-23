package org.example.Model;

import java.util.Objects;

public class CustomClass {
    public String name;
    public CustomClass(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        CustomClass c = (CustomClass) obj;
        return this.name.equals(c.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
