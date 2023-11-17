package myapp.tests;

import myapp.utilities.Driver;
import org.testng.annotations.Test;

public class Class {
    @Test
    public void test(){
        Driver.getDriver().get("https://www.google.com");
    }
    @Test
    public void test2(){
       Driver.getDriver().get("www.google.com");
    }
}
