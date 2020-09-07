package com.automation.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample {
	
	@Test
	public void test()
	{
		int num1 =1;
		int num2 =1;
		int num3 = 10;
		
		String aString = String.valueOf(num1 + num2);
		
		Assert.assertEquals(num1  + num3 + "", aString);
	}

}
