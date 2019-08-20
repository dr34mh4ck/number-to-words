package com.david.jaime.sonatype.numbertowords.enums;

/**
 * @author David
 * Enumerated structur to represent the scales name according to the 
 * number of digits present in the number 
 */
public enum NumberScaleEnum {
	
	UNITS(0,""),
	TENS(1,"%s"), //Tens names are very especific, so it needs to get formatted
	HUNDREDS(2,"hundred"),
	THOUSANDS(3,"thousand"),
	TEN_THOUNSANDS(4,"thousand"),
	HUNDRED_THOUSANDS(5,"thousand"),
	MILLION(6,"million"),
	TEN_MILLIONS(7,"million"),
	HUNDRED_MILLIONS(8,"million"),
	BILLION(9,"billion");
	
	public static final NumberScaleEnum[] SCALES = values();
	
	NumberScaleEnum(final int digitsToTheRight, final String scaleName) {
		this.digitsToTheRight = digitsToTheRight;
		this.scaleName = scaleName;
	}
	
	final int digitsToTheRight;
	final String scaleName;

	public static String getScaleNameFromDigitsToTheRight(final int digitsToTheRight) {
		NumberScaleEnum scaleFound = UNITS;
		for(final NumberScaleEnum scale : SCALES) {
			if(scale.digitsToTheRight == digitsToTheRight) {
				scaleFound = scale;
			}
		}
		return scaleFound.scaleName;
	}
	
}
