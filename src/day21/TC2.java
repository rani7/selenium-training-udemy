package day21;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC2 {

	@Test
	void m3()
	{
		System.out.println(" this is m3 from Testcase2");
	}
	
	@Test
	void m4()
	{
		System.out.println(" this is m4 from Testcase2");
	}
	
	@Test
	void m5()
	{
		System.out.println(" this is m5 from Testcase2");
	}
	
	@AfterTest
	void nn()
	{
		System.out.println("this is nn");
	}
}
