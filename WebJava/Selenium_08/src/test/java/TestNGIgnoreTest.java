import org.testng.annotations.Test;

public class TestNGIgnoreTest {
    @Test(enabled = false)
    public void testsetProperty() {
        System.out.println("Этот метод будет проигнорирован в момент проведения тестирования!");
    }
}
