package Ilya;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestExpectedExceptionTest extends Assert {
    @Test(expectedExceptions = NullPointerException.class)
    public void testNullPointerException() {
        List list = null;
        int size = list.size();
    }
}
