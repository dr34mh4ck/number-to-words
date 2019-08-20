package com.david.jaime.sonatype.numbertowords.userinterface;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.jaime.sonatype.numbertowords.exceptions.NoNumericInputException;
import com.david.jaime.sonatype.numbertowords.exceptions.NumberOutOfRangeException;
import com.david.jaime.sonatype.numbertowords.interfaces.NumberToWordsFacade;
import com.david.jaime.sonatype.numbertowords.interfaces.UserInputFacade;
import com.david.jaime.sonatype.numbertowords.interfaces.UserInterfaceFacade;

import lombok.AllArgsConstructor;

/**
 * @author David
 * presents a simple REPL interface in charge of
 * - Reading the input
 * - Evaluating the input
 * - Printing results
 * - Looping these steps.    
 */
@Component
@AllArgsConstructor
public class ReplInterface implements UserInterfaceFacade {
	
	private static final String NOT_IN_RANGE_INPUT = ">> The input is out of the supported range, please input a number between {} and {}";

	private static final String NO_NUMERIC_INPUT_ERROR = ">> The input is not a valid number, please input a numberic value";

	private static final String BYE = "Bye!";

	private static final String ALLOWED_NUMBER_TYPE = ">> Only whole numbers are supported (in the mentioned range)";

	private static final String EXIT_INSTRUCTIONS = ">> To exit, please type 'exit' anytime.";

	private static final String NUMERIC_RANGE_SUPPORTED = ">> The supported numeric range goes from {} to {}";

	private static final String NUMBER_TO_WORDS_GREETING = ">> Welcome! this program parse your numeric input to it's equivalent in words";

	public final static String BEAN_NAME = "replInterface";
	
	private static Logger LOG = LoggerFactory
		      .getLogger(ReplInterface.class);
	
	@Autowired
	private UserInputFacade userInputFacade;
	
	@Autowired
	private NumberToWordsFacade numberToWordsFacade;
	

	@Override
	public void presentUserInterface() {
		
		explainUserInterface();
		provideLoopInput();
		
	}
	
	private void explainUserInterface() {
		LOG.info(NUMBER_TO_WORDS_GREETING);
		LOG.info(NUMERIC_RANGE_SUPPORTED, Integer.MIN_VALUE, Integer.MAX_VALUE);
		LOG.info(ALLOWED_NUMBER_TYPE);
		LOG.info(EXIT_INSTRUCTIONS);	
	}
	
	private void provideLoopInput() {
		boolean askForInput = true;
		final Scanner scanner = new Scanner(System.in);
		while(askForInput) {
			final String userInput = userInputFacade.readInput(scanner);
			askForInput = userInputFacade.evaluateExitCondition(userInput);
			if(askForInput) {
				if(!validateInput(userInput)) {
					continue;
				}
				final Integer inputNumericValue = userInputFacade.evaluateUserInputIntegerValue(userInput);
				System.out.println( parseNumberToWords(inputNumericValue) );
			}
		}
		scanner.close();
		LOG.info(BYE);
	}
	
	private boolean validateInput(final String userInput) {
		boolean validInput = true;
		try {
			validInput = userInputFacade.isInputANumericValue(userInput);
			validInput = userInputFacade.isNumberInValidRange(userInput);
		} catch(final NoNumericInputException exception) {
			LOG.info(NO_NUMERIC_INPUT_ERROR,
					Integer.MIN_VALUE, Integer.MAX_VALUE);
			validInput = false;
		} catch(final NumberOutOfRangeException exception) {
			LOG.info(NOT_IN_RANGE_INPUT,
					Integer.MIN_VALUE, Integer.MAX_VALUE);
			validInput = false;
		}
		return validInput;
	}
	
	private String parseNumberToWords(Integer inputNumericValue) {
		String result = "";
		try {
			result = numberToWordsFacade.parseNumberToWords(inputNumericValue);
		} catch(Exception e) {
			LOG.error("An exception happened while parsing the Number.");
		}
		return result;
	}
	
	
	
	
	
	

}
