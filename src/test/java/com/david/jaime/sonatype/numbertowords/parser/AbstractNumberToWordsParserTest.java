package com.david.jaime.sonatype.numbertowords.parser;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.david.jaime.sonatype.numbertowords.datastore.NumberNameRepository;

@RunWith(MockitoJUnitRunner.class)
public class AbstractNumberToWordsParserTest {
	
	private static final String ZERO = "zero";
	private static final String NINE = "nine";
	private static final String TWELVE = "twelve";
	private static final String TWENTY = "twenty";
	private static final String SIXTY = "sixty";
	private static final String NINETY = "ninety";
	private static final String EMPTY_STRING = "";
	
	private AbstractNumberToWordsParser abstractParser;
	
	private NumberNameRepository numberNameRepository;
	
	@Before
	public void setup(){
		numberNameRepository = new NumberNameRepository();
		abstractParser = new AbstractNumberToWordsParser(numberNameRepository);
	}
	
	@Test
	public void getValuefromSingleDigitTest() {
		assertTrue(abstractParser.getValuefromSingleDigit(0).equals(ZERO));
		assertTrue(abstractParser.getValuefromSingleDigit(9).equals(NINE));
		assertTrue(abstractParser.getValuefromSingleDigit(12).equals(TWELVE));
	}
	
	@Test
	public void getValuefromSingleDigitWrongInputTest() {
		assertTrue(abstractParser.getValuefromSingleDigit(20).equals(EMPTY_STRING));
	}
	
	@Test
	public void getTensNamesTest() {
		assertTrue(abstractParser.getTensNames(2).equals(TWENTY));
		assertTrue(abstractParser.getTensNames(6).equals(SIXTY));
		assertTrue(abstractParser.getTensNames(9).equals(NINETY));
	}

	@Test
	public void getTensNamesWrongInputTest() {
		assertTrue(abstractParser.getTensNames(20).equals(EMPTY_STRING));
		assertTrue(abstractParser.getTensNames(22).equals(EMPTY_STRING));
		assertTrue(abstractParser.getTensNames(61).equals(EMPTY_STRING));
		assertTrue(abstractParser.getTensNames(95).equals(EMPTY_STRING));
	}
	
	@Test
	public void getNumberDigitsTest() {
		List<Integer> numberDigits = abstractParser.getNumberDigits(123456);
		assertTrue(numberDigits.get(0).compareTo(new Integer(1))==0);
		assertTrue(numberDigits.get(1).compareTo(new Integer(2))==0);
		assertTrue(numberDigits.get(2).compareTo(new Integer(3))==0);
		assertTrue(numberDigits.get(3).compareTo(new Integer(4))==0);
		assertTrue(numberDigits.get(4).compareTo(new Integer(5))==0);
		assertTrue(numberDigits.get(5).compareTo(new Integer(6))==0);
	}
	
	@Test
	public void getZeroNumberDigitsTest() {
		List<Integer> numberDigits = abstractParser.getNumberDigits(0);
		assertTrue(numberDigits.get(0).compareTo(new Integer(0))==0);

	}
}
