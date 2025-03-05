package practice.test;

import org.testng.annotations.Test;

public class DebugTest {
    @Test
	public int add(int a, int b) {
        System.out.println("Inside add() method"); 
        return a + b; 
    }

    // Test case to debug
    @Test
    public void testAddition() {
        System.out.println("Test case started"); 

        int result = add(5, 7); 
        System.out.println("Addition result: " + result); 

        int finalValue = result * 2;
        System.out.println("Final Value: " + finalValue); 

       
}
}
