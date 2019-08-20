package com.david.jaime.sonatype.numbertowords.exceptions;

/**
 * @author David
 * is Thrown whenever an input is not a valid numeric value
 */
public class NoNumericInputException extends Exception {

	private static final long serialVersionUID = 4213399633526785941L;
	
	private final static String CAUSE = "Input is not a number"; 
	
	public NoNumericInputException() {
		super(CAUSE);
	}
	
}
