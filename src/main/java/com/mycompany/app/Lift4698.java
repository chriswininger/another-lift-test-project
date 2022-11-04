package com.mycompany.app;

import java.security.AccessController;
import java.security.PrivilegedAction;

// test for an issue where xlint errors are treated as error prone findings
public class Lift4698
{
    public void test() {
        System.out.println("much foo");

        Derived d = new Derived();
        Base b = (Base) d;

        // redundant cast, should trigger xlint
        Base c = (Base) new Base();
        System.out.println(b);
        System.out.println(c);
    }

    /*
        this should trigger a compiler warning about removing deprecated calls which is causing an issue

        https://github.com/chriswininger/maven/blob/a53a1aa232bc383baf055d884a7c66319d10d404/maven-model-builder/src/main/java/org/apache/maven/model/interpolation/StringSearchModelInterpolator.java#L94
     */
    void interpolateObject()
    {
        PrivilegedAction<Object> action = new PrivilegedAction<Object>() {
            @Override
            public Object run() {
                return null;
            }
        };

        AccessController.doPrivileged(action );
    }
}

