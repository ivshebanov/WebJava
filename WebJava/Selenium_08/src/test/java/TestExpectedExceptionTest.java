import org.testng.annotations.Test;

import java.util.List;

public class TestExpectedExceptionTest {
    @Test(expectedExceptions = NullPointerException.class)
    public void testNullPointerException() {
        List list = null;
        int size = list.size();
    }
}
