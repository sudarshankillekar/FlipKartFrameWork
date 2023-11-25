package com.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {
	private static int maximumAttempts=1;
	private static int count =1;
//	@Override
//	public boolean retry(ITestResult result) {
//		// TODO Auto-generated method stub
//		if (count<=maximumAttempts) {
//			count +=1;
//			return true;
//		}
//		return false;
//	}
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		return false;
	}

}
