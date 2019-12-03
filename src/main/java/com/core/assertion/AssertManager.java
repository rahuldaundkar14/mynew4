package com.core.assertion;

import org.junit.Assert;

public class AssertManager {
	
	public static boolean flag;
	public static String errorMsg;
	
	/**
	 * Verify Two String
	 * 
	 * @param String
	 *            - Text message to be displayed if fail
	 * @param String
	 *            - Expected String text
	 * @param String
	 *            - Actual String text
	 */
	public static void verifyTextEquals(String strExpected, String strActual, String strMsg) {
		flag = false ;
		try {
			Assert.assertEquals(strExpected, strActual);
		} catch (Error e) {
			flag = true;
			errorMsg = e.getMessage();
		}
	}
	
}
