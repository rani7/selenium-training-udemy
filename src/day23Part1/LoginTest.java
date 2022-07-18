package day23Part1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

	@Test
	void setup() //fail
	{
		Assert.assertTrue(false);
	}
	
	@Test //pass
	void loginByEmail()
	{
		Assert.assertTrue(true);
	}
	
	@Test(dependsOnMethods={"setup"})  //skipped
	void loginByFacebook()
	{
		Assert.assertTrue(true);
	}
}
