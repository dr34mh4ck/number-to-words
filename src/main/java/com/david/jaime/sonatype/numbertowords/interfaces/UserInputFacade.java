package com.david.jaime.sonatype.numbertowords.interfaces;

import java.util.Scanner;

import com.david.jaime.sonatype.numbertowords.exceptions.NoNumericInputException;
import com.david.jaime.sonatype.numbertowords.exceptions.NumberOutOfRangeException;

/**
 * @author David
 * Defines operations that the user input mecanism should provide
 *
 */
public interface UserInputFacade {	
	
	public String readInput(final Scanner scanner);
	
	public boolean evaluateExitCondition(final String userInput); 

	public Integer evaluateUserInputIntegerValue(final String userInput);
	
	public boolean isNumberInValidRange(final String userInput) throws NumberOutOfRangeException;
	
	public boolean isInputANumericValue(final String userInput) throws NoNumericInputException;

}
