package Ilya;

import org.testng.annotations.Test;

public class TestNGTimeTest {
    @Test(timeOut = 1000)
    public void waitLongTime() throws Exception {
        Thread.sleep(1001);
    }
}
