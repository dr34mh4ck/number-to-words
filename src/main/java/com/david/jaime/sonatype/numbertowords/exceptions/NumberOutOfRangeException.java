package com.david.jaime.sonatype.numbertowords.exceptions;

/**
 * @author David
 * Is thrown whenever an input is out of the supported range
 * Supported range goes from java.Lang.Integer.MAX_VALUE and java.Lang.Integer.MIN_VALUE
 */
public class NumberOutOfRangeException extends Exception {

	private static final long serialVersionUID = -8183080096282670592L;
	
	private final static String CAUSE = "Number out of range"; 
	
	public NumberOutOfRangeException() {
		super(CAUSE);
	}

}
