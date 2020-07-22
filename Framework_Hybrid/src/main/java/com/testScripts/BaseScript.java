package com.testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.components.BaseComponent;

public class BaseScript 
{
	BaseComponent comp=new BaseComponent();

	@Test(description="Oracle Login",priority = 1)
	public void ApplicationLaunch() throws Exception
	{
			comp.LaunchApp();
			comp.loginOracle();
			Assert.assertEquals(true, false);
			comp.selectSlot("Saturday");
			comp.clickOnInstant();	
			comp.lanchDemoApp();
	}
}
