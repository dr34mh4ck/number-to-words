package com.david.jaime.sonatype.numbertowords.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.david.jaime.sonatype.numbertowords.datastore.NumberNameRepository;

@RunWith(MockitoJUnitRunner.class)
public class SingleDigitParserTest {
	
	private SingleDigitParser singleDigitParser;
	
	private NumberNameRepository numberNameRepository;
	
	private static final String ZERO = "zero";
	private static final String ONE = "one";
	private static final String TWO = "two";
	private static final String THREE = "three";
	private static final String FOUR = "four";
	private static final String FIVE = "five";
	private static final String SIX = "six";
	private static final String SEVEN = "seven";
	private static final String EIGHT = "eight";
	private static final String NINE = "nine";
	private static final String NEGATIVE_SEVEN = "Negative seven";
	private static final String NEGATIVE_EIGHT = "Negative eight";
	private static final String NEGATIVE_NINE = "Negative nine";
	
	@Before
	public void setup() {
		numberNameRepository = new NumberNameRepository();
		singleDigitParser = new SingleDigitParser(numberNameRepository);
	}
	
	@Test
	public void parseZeroTest(){
		assertEquals(ZERO, singleDigitParser.parseNumberToWords(0));
	}
	
	@Test
	public void parseOneTest(){
		assertEquals(ONE, singleDigitParser.parseNumberToWords(1));
	}
	
	@Test
	public void parseTwoTest(){
		assertEquals(TWO, singleDigitParser.parseNumberToWords(2));
	}
	
	@Test
	public void parseThreeTest(){
		assertEquals(THREE, singleDigitParser.parseNumberToWords(3));
	}
	
	@Test
	public void parseFourTest(){
		assertEquals(FOUR, singleDigitParser.parseNumberToWords(4));
	}
	
	@Test
	public void parseFiveTest(){
		assertEquals(FIVE, singleDigitParser.parseNumberToWords(5));
	}
	
	@Test
	public void parseSisTest(){
		assertEquals(SIX, singleDigitParser.parseNumberToWords(6));
	}
	
	@Test
	public void parseSevenTest(){
		assertEquals(SEVEN, singleDigitParser.parseNumberToWords(7));
	}
	
	@Test
	public void parseEightTest(){
		assertEquals(EIGHT, singleDigitParser.parseNumberToWords(8));
	}
	
	@Test
	public void parseNineTest(){
		assertEquals(NINE, singleDigitParser.parseNumberToWords(9));
	}
	
	@Test
	public void parseNegativeSevenTest(){
		assertEquals(NEGATIVE_SEVEN, singleDigitParser.parseNumberToWords(-7));
	}
	
	@Test
	public void parseNegativeEightTest(){
		assertEquals(NEGATIVE_EIGHT, singleDigitParser.parseNumberToWords(-8));
	}
	
	@Test
	public void parseNegativeNineTest(){
		assertEquals(NEGATIVE_NINE, singleDigitParser.parseNumberToWords(-9));
	}


}
