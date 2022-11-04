package com.mycompany.app;

import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.List;

import org.apache.maven.model.building.ModelBuildingRequest;
import org.apache.maven.model.building.ModelProblemCollector;
import org.codehaus.plexus.interpolation.InterpolationPostProcessor;
import org.codehaus.plexus.interpolation.ValueSource;
import org.springframework.ui.Model;

// test for an issue where xlint errors are treated as error prone findings
public class Lift4698
{
    public void test() {
        AccessController.doPrivileged( action );

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
        }

        AccessController.doPrivileged(action );
    }
}

