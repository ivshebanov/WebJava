package Ilya;

import org.testng.annotations.Test;

public class TestNGDependencyTest {
//    @Test
//    public void initEnvironmentTest() {
//        System.out.println("This is initEnvironmentTest");
//    }
//
//    @Test(dependsOnMethods={"initEnvironmentTest"})
//    public void testmethod() {
//        System.out.println("This is testmethod");
//    }


    @Test(groups = { "init" })
    public void initEnvironmentTest1() {
        System.out.println("This is initEnvironmentTest1");
    }

    @Test(groups = { "init" })
    public void initEnvironmentTest2() {
        System.out.println("This is initEnvironmentTest2");
    }

    @Test(dependsOnGroups={"init"})
    public void testmethod() {
        System.out.println("This is testmethod");
    }
}
