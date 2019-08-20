package com.david.jaime.sonatype.numbertowords.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.david.jaime.sonatype.numbertowords.datastore.NumberNameRepository;

@RunWith(MockitoJUnitRunner.class)
public class NumberToWordsParserTest {
	
	private static final Integer ZERO_NUMBER = 0;
	private static final String ZERO = "Zero";
	private static final Integer NUMBER_TEN = 10;
	private static final String TEN = "Ten";
	private static final Integer NUMBER_HUNDRED = 101;
	private static final String ONE_HUNDRED_ONE = "One hundred one";
	private static final Integer EIGHTY_FIVE_NUMBER = 85;
	private static final String EIGHTY_FIVE = "Eighty five";
	private static final Integer NEGATIVE_FOURTY_SEVEN_NUMBER = -47;
	private static final String NEGATIVE_FOURTY_SEVEN = "Negative fourty seven";
	

	private NumberToWordsParser numberToWordsParser;
	
	private NumberNameRepository numberNameRepository;
	
	private DefaultNumberParser defaultNumberParser;
	
	@Mock
	private StrategySelector strategySelector;
	
	private SingleDigitParser singleDigitParser;
	
	private LessThanTwentyParser lessThanTwentyParser;

	private LessThanHundredParser lessThanHundredParser;
	
	
	@Before
	public void setup() {
		numberNameRepository = new NumberNameRepository();
		singleDigitParser = new SingleDigitParser(numberNameRepository);
		lessThanTwentyParser = new LessThanTwentyParser(numberNameRepository);
		lessThanHundredParser = new LessThanHundredParser(numberNameRepository);
		defaultNumberParser = new DefaultNumberParser(numberNameRepository);
		numberToWordsParser = new NumberToWordsParser(strategySelector);
	}
	
	@Test
	public void parseNumberToWordsTest() {
		Mockito.when(strategySelector.selectStrategy(NUMBER_TEN)).thenReturn(lessThanTwentyParser);
		final String parsedNumber = numberToWordsParser.parseNumberToWords(NUMBER_TEN);
		assertEquals(TEN, parsedNumber);
	}
	
	
	@Test
	public void parseLessThanHundredNumberToWordsTest() {
		Mockito.when(strategySelector.selectStrategy(EIGHTY_FIVE_NUMBER)).thenReturn(lessThanHundredParser);
		final String parsedNumber = numberToWordsParser.parseNumberToWords(EIGHTY_FIVE_NUMBER);
		assertEquals(EIGHTY_FIVE, parsedNumber);
	}
	
	
	@Test
	public void parseHundredNumberToWordsTest() {
		Mockito.when(strategySelector.selectStrategy(NUMBER_HUNDRED)).thenReturn(defaultNumberParser);
		final String parsedNumber = numberToWordsParser.parseNumberToWords(NUMBER_HUNDRED);
		assertEquals(ONE_HUNDRED_ONE, parsedNumber);
	}
	
	@Test
	public void parseNegativeLessThanHundredNumberToWordsTest() {
		Mockito.when(strategySelector.selectStrategy(NEGATIVE_FOURTY_SEVEN_NUMBER)).thenReturn(lessThanHundredParser);
		final String parsedNumber = numberToWordsParser.parseNumberToWords(NEGATIVE_FOURTY_SEVEN_NUMBER);
		assertEquals(NEGATIVE_FOURTY_SEVEN, parsedNumber);
	}
	
	
	@Test
	public void parseZeroNumberToWordsTest() {
		Mockito.when(strategySelector.selectStrategy(ZERO_NUMBER)).thenReturn(singleDigitParser);
		final String parsedNumber = numberToWordsParser.parseNumberToWords(ZERO_NUMBER);
		assertEquals(ZERO, parsedNumber);
	}
	
}
