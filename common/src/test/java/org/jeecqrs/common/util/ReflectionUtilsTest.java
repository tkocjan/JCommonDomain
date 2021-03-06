package org.jeecqrs.common.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 */
public class ReflectionUtilsTest {
    
    @Test
    public void testFindUniqueMethod() throws Exception {
        Derived d = new Derived();
        Method m = ReflectionUtils.findUniqueMethod(Derived.class, Annotation1.class,
                new Object[] { String.class, Integer.class });
        m.invoke(d, new Object[] { "Hello, World", 42 });

        m = ReflectionUtils.findUniqueMethod(Derived.class, Annotation2.class,
                new Object[] { String.class });
        m.invoke(d, new Object[] { "StringString" });

        m = ReflectionUtils.findUniqueMethod(Derived.class, Annotation3.class,
                new Object[] { String.class, Long.class, List.class });
        m.invoke(d, new Object[] { "StringString" , 46l, new ArrayList<Object>()});
    }

    @Test
    public void testFindUniqueMethodWrongParams() {
        try {
            ReflectionUtils.findUniqueMethod(Derived.class, Annotation2.class,
                    new Object[]{String.class, Long.class, Integer.class});
            fail("Should have failed by now");
        } catch (Exception e) {
            // ok
        }
    }

    @Test
    public void testFindUniqueMethodNonexistent() {
        try {
            ReflectionUtils.findUniqueMethod(Derived.class, Annotation4.class, new Object[]{});
            fail("Should have failed by now");
        } catch (Exception e) {
            // ok
        }
    }

    @Test
    public void testFindAnnotatedMethodOrFail() {
        assertNotNull(ReflectionUtils.findAnnotatedMethodOrFail(Derived.class, Annotation1.class));
        try {
            ReflectionUtils.findAnnotatedMethodOrFail(Derived.class, Annotation4.class);
            fail("Should have failed by now");
        } catch (Exception e) {
            // ok
        }
    }

    @Test
    public void testFindAnnotatedMethod() {
        assertNotNull(ReflectionUtils.findAnnotatedMethod(Derived.class, Annotation1.class));
        assertEquals(ReflectionUtils.findAnnotatedMethod(Derived.class, Annotation4.class), null);
        assertEquals(ReflectionUtils.findAnnotatedMethod(Base.class, Annotation3.class), null);
    }

}
