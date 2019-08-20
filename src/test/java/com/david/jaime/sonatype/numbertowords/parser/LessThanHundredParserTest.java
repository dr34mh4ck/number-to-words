package com.david.jaime.sonatype.numbertowords.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.david.jaime.sonatype.numbertowords.datastore.NumberNameRepository;

@RunWith(MockitoJUnitRunner.class)
public class LessThanHundredParserTest {
	
	private static final String EMPTY_STRING = "";
	private static final String TEST_ONE_EXPECTED_VALUE = "ninety nine";
	private static final String TEST_ONE_EXPECTED_NEGATIVE_VALUE = "Negative ninety nine";
	private static final String TWENTY = "twenty";
	private static final String NEGATIVE_TWENTY = "Negative twenty";
	
	
	private LessThanHundredParser lessThanHundredParser;
	
	private NumberNameRepository numberNameRepository;
	
	@Before
	public void setup() {
		numberNameRepository = new NumberNameRepository();
		lessThanHundredParser = new LessThanHundredParser(numberNameRepository);
	}
	
	@Test
	public void parseMoreThanTwoDigitsNumberToWords() {
		final Integer numberToParse = 100;
		final String parsedNumber = lessThanHundredParser.parseNumberToWords(numberToParse);
		assertEquals(EMPTY_STRING, parsedNumber);
	}

	@Test
	public void parseUpperBoundaryNumberToWords() {
		final Integer numberToParse = 99;
		final String parsedNumber = lessThanHundredParser.parseNumberToWords(numberToParse);
		assertEquals(TEST_ONE_EXPECTED_VALUE, parsedNumber);
	}
	
	@Test
	public void parseNegativeUpperBoundaryNumberToWords() {
		final Integer numberToParse = -99;
		final String parsedNumber = lessThanHundredParser.parseNumberToWords(numberToParse);
		assertEquals(TEST_ONE_EXPECTED_NEGATIVE_VALUE, parsedNumber);
	}
	
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void parseZeroNumberToWords() {
		final Integer numberToParse = 0;
		lessThanHundredParser.parseNumberToWords(numberToParse);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void parseOneDigitNumberToWords() {
		final Integer numberToParse = 9;
		lessThanHundredParser.parseNumberToWords(numberToParse);
	}
	
	@Test
	public void parseLowerBoundaryNumberToWords() {
		final Integer numberToParse = 20;
		final String parsedNumber = lessThanHundredParser.parseNumberToWords(numberToParse);
		assertEquals(TWENTY, parsedNumber);
	}
	
	@Test
	public void parseNegativeLowerBoundaryNumberToWords() {
		final Integer numberToParse = -20;
		final String parsedNumber = lessThanHundredParser.parseNumberToWords(numberToParse);
		assertEquals(NEGATIVE_TWENTY, parsedNumber);
	}
	
	
}
