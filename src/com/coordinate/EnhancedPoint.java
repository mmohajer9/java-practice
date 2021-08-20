package com.coordinate;

import java.util.Objects;

public class EnhancedPoint {
    private int x;
    private int y;

    public EnhancedPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public EnhancedPoint() {
        this(0, 0);
    }

    // best practice: whenever you are overriding equals, override hashcode too.
    @Override
    public boolean equals(Object obj) {
        // perform a downcasting because changing the signature will not considered as
        // an override, and don't forget to check the instanceof relationship.
        if (!(obj instanceof EnhancedPoint))
            return false;

        if (this == obj)
            return true;

        var other = (EnhancedPoint) obj;
        return (this.x == other.x && this.y == other.y);
    }

    @Override
    public int hashCode() {
        // we want to generate hash code based on the content of the object
        // by default, it will generate hash code based on the reference address
        return Objects.hash(x, y);

    }
}
