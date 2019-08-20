package com.david.jaime.sonatype.numbertowords.util;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.david.jaime.sonatype.numbertowords.exceptions.NoNumericInputException;
import com.david.jaime.sonatype.numbertowords.exceptions.NumberOutOfRangeException;
import com.david.jaime.sonatype.numbertowords.interfaces.UserInputFacade;

/**
 * @author David
 * This class is in charge of handling the user input, receiving input and validating input 
 */
@Component
public class HandleUserInputUtil implements UserInputFacade {
	
	private static final String ASK_FOR_INPUT = ">> Please input a number: ";
	
	private static final String EXIT = "exit";
	
	private static final String INPUT_ERROR = ">> Error: the input must be a valid numeric value!";
	
	private static Logger LOG = LoggerFactory
		      .getLogger(HandleUserInputUtil.class);
	
	@Override
	public String readInput(final Scanner scanner) {
		String input = "";
		LOG.info(ASK_FOR_INPUT);
		input = scanner.next();
		return input;
	}
	
	@Override
	public boolean evaluateExitCondition(final String userInput) {
		return userInput.isEmpty() || !EXIT.equalsIgnoreCase(userInput);
	}

	@Override
	public Integer evaluateUserInputIntegerValue(final String userInput) {
		Integer userInputValue = null;
		try {
			userInputValue = Integer.parseInt(userInput);
		}catch(NumberFormatException exception) {
			LOG.error(INPUT_ERROR);
		}
		return userInputValue;
	}
	
	@Override
	public boolean isNumberInValidRange(final String userInput) throws NumberOutOfRangeException {
		boolean isNumberInRange = true;
		final Long maxValueLong = Long.parseLong( String.valueOf(Integer.MAX_VALUE));
		final Long minValueLong = Long.parseLong( String.valueOf(Integer.MIN_VALUE));
		final Long userValueLong = Long.parseLong( userInput );
		isNumberInRange = (userValueLong.compareTo(maxValueLong) <= 0) && (userValueLong.compareTo(minValueLong) >= 0) ;
		if(!isNumberInRange) {
			throw new NumberOutOfRangeException();
		}
		return isNumberInRange;		
	}

	@Override
	public boolean isInputANumericValue(String userInput) throws NoNumericInputException {
		boolean isInputANumbericValue = false;
		try {
			Long.parseLong(userInput);
			isInputANumbericValue = true;
		} catch (NumberFormatException exception) {
			throw new NoNumericInputException();
		}
		return isInputANumbericValue;
	}
}
