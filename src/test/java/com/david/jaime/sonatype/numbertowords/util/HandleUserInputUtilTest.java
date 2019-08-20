package com.david.jaime.sonatype.numbertowords.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.david.jaime.sonatype.numbertowords.exceptions.NoNumericInputException;

@RunWith(MockitoJUnitRunner.class)
public class HandleUserInputUtilTest {
	

	private static final String NUMBER_INPUT = "1234";
	private static final String EXIT = "exit";
	private HandleUserInputUtil handleUserInputUtil;
	
	@Before
	public void setup() {
		handleUserInputUtil = new HandleUserInputUtil();
	}
	
	@Test
	public void evaluateExitConditionTest() {
		assertFalse(handleUserInputUtil.evaluateExitCondition(EXIT));
	}
	
	@Test
	public void evaluateNegativeExitConditionTest() {
		assertTrue(handleUserInputUtil.evaluateExitCondition(NUMBER_INPUT));
	}
	
	@Test
	public void evaluateUserInputIntegerValueTest() {
		Integer integerInput = handleUserInputUtil.evaluateUserInputIntegerValue(NUMBER_INPUT);
		assertTrue(integerInput instanceof Integer);
	}
	
	@Test
	public void evaluateUserInputIntegerValueExceptionTest() {
		Integer integerInput = handleUserInputUtil.evaluateUserInputIntegerValue(EXIT);
		assertNull(integerInput);
	}
	
	@Test
	public void isNumberInValidRangeTest() {
		boolean isNumberInRange = false;
		try {
			isNumberInRange = handleUserInputUtil.isInputANumericValue(NUMBER_INPUT);
			assertTrue(isNumberInRange);
		} catch (NoNumericInputException e) {
			fail();
		}
	}
	
	@Test(expected = NoNumericInputException.class)
	public void isNumberInValidRangeExceptionTest() throws NoNumericInputException {
		boolean isNumberInRange = false;
		isNumberInRange = handleUserInputUtil.isInputANumericValue(EXIT);
		assertTrue(isNumberInRange);
	}
	
	@Test
	public void isInputANumericValueTest() {
		boolean isInputAnumericValue = false;
		try {
			isInputAnumericValue = handleUserInputUtil.isInputANumericValue(NUMBER_INPUT);
			assertTrue(isInputAnumericValue);
		} catch (NoNumericInputException e) {
			fail();
		}
	}
	
	@Test(expected = NoNumericInputException.class)
	public void isInputANumericValueExceptionTest() throws NoNumericInputException {
		boolean isNumberInRange = false;
		isNumberInRange = handleUserInputUtil.isInputANumericValue(EXIT);
		assertTrue(isNumberInRange);
	}

}
