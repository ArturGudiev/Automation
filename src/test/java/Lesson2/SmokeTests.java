package Lesson2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Artur on 04.05.2017.
 */
public class SmokeTests {
    @Test(dataProvider = "incorrectData", dataProviderClass = DataProviders.class)
    public void userTest(User user){
        //logInAs(user);
        System.out.println(user.getFirstName() + " " + user.getLastName());
    }

    @DataProvider
    public Object[][] correctData(){
        return new Object[][]{
                {1, "Roman"},
                {2, "Admin"},
                {3, "Harry"},
                {4, "Ron"},
                {5, "John"},
                {6, "Logan"},
        };
    }

   // @Test(dataProvider = "correctData")
    public void simpleTest(int num, String name){
        System.out.println(num +": " + name);
    }
}
