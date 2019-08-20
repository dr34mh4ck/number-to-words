package com.david.jaime.sonatype.numbertowords.datastore;

import org.springframework.stereotype.Repository;

/**
 * @author David
 * This class contains the number names, separators, negative notation etc
 * all the String representations and important numeric values.
 * Two arrays containing the number names from 0-19 and all the [20-30-40-50-60-70-80-90] names
 *
 */
@Repository
public class NumberNameRepository {
	
	public static final String NEGATIVE_NOTATION = "Negative";
	
	public static final String SEPARATOR = " ";
	
	private static final int INITIAL_NUMBER_SET_LIMIT = 19;
	
	private static final int TENS_NUMBER_SET_LIMIT = 9;
	
	public static final Integer ONE = new Integer(1); 
	
	public static final String AND = "and";
	
	public static final Integer ONE_BILLION = 1000000000;
	
	public static final Integer ONE_MILLION = 1000000;
	
	public static final Integer ONE_THOUSAND = 1000;
	
	public static final Integer ONE_HOUNDRED = 100;
	
	public static final String MIN_SUPPORTED_VALUE_TRADE_DIGIT = "seven";
	public static final String MIN_SUPPORTED_VALUE_REPLACE_DIGIT = "eight";
	
	
	private static final String[] INITIAL_NUMBER_SET = new String[] {"zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen",
            "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
	
	private static final String[] TENS_NUMBER_SET = new String[] { "", "", "twenty", "thirty", "fourty",
            "fifty", "sixty", "seventy", "eighty", "ninety" };

	
	public String getInitialNumberSetValue(int number) {
		String result = "";
		if(number <= INITIAL_NUMBER_SET_LIMIT && number >= 0) {
			result = INITIAL_NUMBER_SET[number];
		}
		return result;
	}
	
	public String getTensNumberName(int number) {
		String result = "";
		if(number <= TENS_NUMBER_SET_LIMIT && number >= 0) {
			result = TENS_NUMBER_SET[number];
		}
		return result;
	}
}
