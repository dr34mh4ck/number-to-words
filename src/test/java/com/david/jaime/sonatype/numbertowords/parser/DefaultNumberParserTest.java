package com.david.jaime.sonatype.numbertowords.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.david.jaime.sonatype.numbertowords.datastore.NumberNameRepository;

@RunWith(MockitoJUnitRunner.class)
public class DefaultNumberParserTest {
	
	private DefaultNumberParser defaultNumberParser;
	
	private NumberNameRepository numberNameRepository;
	
	private static final String TEST_ONE_EXPECTED_VALUE = "two hundred and fifty six";
	private static final String TEST_ONE_EXPECTED_NEGATIVE_VALUE = "Negative two hundred and fifty six";
	private static final String TEST_TWO_EXPECTED_VALUE = "fifty six thousand three hundred and fourty five";
	private static final String TEST_TWO_EXPECTED_NEGATIVE_VALUE = "Negative fifty six thousand three hundred and fourty five";
	private static final String TEST_THREE_EXPECTED_VALUE = "two million five hundred sixty seven thousand eight hundred and ninety";
	private static final String TEST_THREE_EXPECTED_NEGATIVE_VALUE = "Negative two million five hundred sixty seven thousand eight hundred and ninety";
	private static final String TEST_FOUR_EXPECTED_VALUE = "one billion nine hundred eighty seven million eight hundred ninety thousand two hundred and thirty five";
	private static final String TEST_FOUR_EXPECTED_NEGATIVE_VALUE = "Negative one billion nine hundred eighty seven million eight hundred ninety thousand two hundred and thirty five";
	private static final String TEST_MAX_SUPPORTED_VALUE = "two billion one hundred fourty seven million four hundred eighty three thousand six hundred and fourty seven";
	private static final String TEST_MIN_SUPPORTED_VALUE = "Negative two billion one hundred fourty seven million four hundred eighty three thousand six hundred fourty eight";
	

	@Before
	public void setup() {
		numberNameRepository = new NumberNameRepository();
		defaultNumberParser = new DefaultNumberParser(numberNameRepository);
	}
	
	@Test
	public void parseHundredNumberToWordsTest() {
		final Integer numberToParse = 256;
		final String parsedNumber = defaultNumberParser.parseNumberToWords(numberToParse);
		assertEquals(TEST_ONE_EXPECTED_VALUE, parsedNumber);
	}
	
	@Test
	public void parseNegativeHundredNumberToWordsTest() {
		final Integer numberToParse = -256;
		final String parsedNumber = defaultNumberParser.parseNumberToWords(numberToParse);
		assertEquals(TEST_ONE_EXPECTED_NEGATIVE_VALUE, parsedNumber);
	}
	
	@Test
	public void parseThousandNumberToWordsTest() {
		final Integer numberToParse = 56345;
		final String parsedNumber = defaultNumberParser.parseNumberToWords(numberToParse);
		assertEquals(TEST_TWO_EXPECTED_VALUE, parsedNumber);
	}
	
	@Test
	public void parseNegativeThousandNumberToWordsTest() {
		final Integer numberToParse = -56345;
		final String parsedNumber = defaultNumberParser.parseNumberToWords(numberToParse);
		assertEquals(TEST_TWO_EXPECTED_NEGATIVE_VALUE, parsedNumber);
	}
	
	@Test
	public void parseMillionNumberToWordsTest() {
		final Integer numberToParse = 2567890;
		final String parsedNumber = defaultNumberParser.parseNumberToWords(numberToParse);
		assertEquals(TEST_THREE_EXPECTED_VALUE, parsedNumber);
	}
	
	@Test
	public void parseNegativeMillionNumberToWordsTest() {
		final Integer numberToParse = -2567890;
		final String parsedNumber = defaultNumberParser.parseNumberToWords(numberToParse);
		assertEquals(TEST_THREE_EXPECTED_NEGATIVE_VALUE, parsedNumber);
	}
	
	@Test
	public void parseBillionNumberToWordsTest() {
		final Integer numberToParse = 1987890235;
		final String parsedNumber = defaultNumberParser.parseNumberToWords(numberToParse);
		assertEquals(TEST_FOUR_EXPECTED_VALUE, parsedNumber);
	}
	
	@Test
	public void parseNegativeBillionNumberToWordsTest() {
		final Integer numberToParse = -1987890235;
		final String parsedNumber = defaultNumberParser.parseNumberToWords(numberToParse);
		assertEquals(TEST_FOUR_EXPECTED_NEGATIVE_VALUE, parsedNumber);
	}
	
	@Test
	public void parseMaxSupportedValueToWordsTest() {
		final String parsedNumber = defaultNumberParser.parseNumberToWords(Integer.MAX_VALUE);
		assertEquals(TEST_MAX_SUPPORTED_VALUE, parsedNumber);
	}
	
	@Test
	public void parseMinSupportedValueToWordsTest() {
		final String parsedNumber = defaultNumberParser.parseNumberToWords(Integer.MIN_VALUE);
		assertEquals(TEST_MIN_SUPPORTED_VALUE, parsedNumber);
	}
	

}
