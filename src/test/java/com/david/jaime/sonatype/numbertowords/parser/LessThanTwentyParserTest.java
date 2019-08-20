package com.david.jaime.sonatype.numbertowords.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.david.jaime.sonatype.numbertowords.datastore.NumberNameRepository;

@RunWith(MockitoJUnitRunner.class)
public class LessThanTwentyParserTest {
	
	private static final String NEGATIVE_TEN = "Negative ten";

	private static final String TEN = "ten";

	private static final String ZERO = "zero";

	private static final String NINETEEN = "nineteen";
	private static final String NEGATIVE_NINETEEN = "Negative nineteen";
	
	private LessThanTwentyParser lessThanTwentyParser;
	
	private NumberNameRepository numberNameRepository;
	
	@Before
	public void setup() {
		numberNameRepository = new NumberNameRepository();
		lessThanTwentyParser = new LessThanTwentyParser(numberNameRepository);
	}
	
	@Test
	public void parseUpperLimitNumberToWords() {
		final Integer numberToParse = 19;
		final String parsedNumber = lessThanTwentyParser.parseNumberToWords(numberToParse);
		assertEquals(NINETEEN, parsedNumber);
	}
	
	@Test
	public void parseNegativeUpperLimitNumberToWords() {
		final Integer numberToParse = -19;
		final String parsedNumber = lessThanTwentyParser.parseNumberToWords(numberToParse);
		assertEquals(NEGATIVE_NINETEEN, parsedNumber);
	}
	
	@Test
	public void parseZeroNumberToWords() {
		final Integer numberToParse = 0;
		final String parsedNumber = lessThanTwentyParser.parseNumberToWords(numberToParse);
		assertEquals(ZERO, parsedNumber);
	}
	
	@Test
	public void parseTenToWords() {
		final Integer numberToParse = 10;
		final String parsedNumber = lessThanTwentyParser.parseNumberToWords(numberToParse);
		assertEquals(TEN, parsedNumber);
	}
	
	@Test
	public void parseNegativeTenToWords() {
		final Integer numberToParse = -10;
		final String parsedNumber = lessThanTwentyParser.parseNumberToWords(numberToParse);
		assertEquals(NEGATIVE_TEN, parsedNumber);
	}

}
