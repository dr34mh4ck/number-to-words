package com.david.jaime.sonatype.numbertowords.datastore;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NumberNameRepositoryTest {

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
	private static final String TEN = "ten";
	private static final String ELEVEN = "eleven";
	private static final String TWELVE = "twelve";
	private static final String THIRTHEEN = "thirteen";
	private static final String FOURTHEEN = "fourteen";
	private static final String FIFTEEN = "fifteen";
	private static final String SIXTEEN = "sixteen";
	private static final String SEVENTEEN = "seventeen";
	private static final String EIGHTEEN = "eighteen";
	private static final String NINETEEN = "nineteen";
	private static final String EMPTY_STRING = "";
	private static final String TWENTY = "twenty";
	private static final String THIRTY = "thirty";
	private static final String FOURTY = "fourty";
	private static final String FIFTY = "fifty";
	private static final String SIXTY = "sixty";
	private static final String SEVENTY = "seventy";
	private static final String EIGHTY = "eighty";
	private static final String NINETY = "ninety";

	
	
	@Before
	public void setup() {
		numberNameRepository = new NumberNameRepository();
	}
	
	@Test
	public void initialNumberSetContainsNumberZeroTest() {
		assertTrue(numberNameRepository.getInitialNumberSetValue(0).equals(ZERO));
	}
	
	
	@Test
	public void initialNumberSetContainsNumberOneTest() {
		assertTrue(numberNameRepository.getInitialNumberSetValue(1).equals(ONE));
	}
	
	@Test
	public void initialNumberSetContainsNumberTwoTest() {
		assertTrue(numberNameRepository.getInitialNumberSetValue(2).equals(TWO));
	}
	
	@Test
	public void initialNumberSetContainsNumberThreeTest() {
		assertTrue(numberNameRepository.getInitialNumberSetValue(3).equals(THREE));
	}
	
	@Test
	public void initialNumberSetContainsNumberFourTest() {
		assertTrue(numberNameRepository.getInitialNumberSetValue(4).equals(FOUR));
	}
	
	@Test
	public void initialNumberSetContainsNumberFiveTest() {
		assertTrue(numberNameRepository.getInitialNumberSetValue(5).equals(FIVE));
	}
	
	@Test
	public void initialNumberSetContainsNumberSixTest() {
		assertTrue(numberNameRepository.getInitialNumberSetValue(6).equals(SIX));
	}
	
	@Test
	public void initialNumberSetContainsNumberSevenTest() {
		assertTrue(numberNameRepository.getInitialNumberSetValue(7).equals(SEVEN));
	}
	
	@Test
	public void initialNumberSetContainsNumberEightTest() {
		assertTrue(numberNameRepository.getInitialNumberSetValue(8).equals(EIGHT));
	}
	
	@Test
	public void initialNumberSetContainsNumberNineTest() {
		assertTrue(numberNameRepository.getInitialNumberSetValue(9).equals(NINE));
	}
	
	@Test
	public void initialNumberSetContainsNumberTenTest() {
		assertTrue(numberNameRepository.getInitialNumberSetValue(10).equals(TEN));
	}
	
	@Test
	public void initialNumberSetContainsNumberElevenTest() {
		assertTrue(numberNameRepository.getInitialNumberSetValue(11).equals(ELEVEN));
	}
	
	@Test
	public void initialNumberSetContainsNumberTwelveTest() {
		assertTrue(numberNameRepository.getInitialNumberSetValue(12).equals(TWELVE));
	}
	
	@Test
	public void initialNumberSetContainsNumberThirtheenTest() {
		assertTrue(numberNameRepository.getInitialNumberSetValue(13).equals(THIRTHEEN));
	}
	
	@Test
	public void initialNumberSetContainsNumberFourtheenTest() {
		assertTrue(numberNameRepository.getInitialNumberSetValue(14).equals(FOURTHEEN));
	}
	
	@Test
	public void initialNumberSetContainsNumberFifteenTest() {
		assertTrue(numberNameRepository.getInitialNumberSetValue(15).equals(FIFTEEN));
	}
	
	@Test
	public void initialNumberSetContainsNumberSixteenTest() {
		assertTrue(numberNameRepository.getInitialNumberSetValue(16).equals(SIXTEEN));
	}
	
	@Test
	public void initialNumberSetContainsNumberSeventeenTest() {
		assertTrue(numberNameRepository.getInitialNumberSetValue(17).equals(SEVENTEEN));
	}
	
	@Test
	public void initialNumberSetContainsNumberEighteenTest() {
		assertTrue(numberNameRepository.getInitialNumberSetValue(18).equals(EIGHTEEN));
	}
	
	@Test
	public void initialNumberSetContainsNumberNineteenTest() {
		assertTrue(numberNameRepository.getInitialNumberSetValue(19).equals(NINETEEN));
	}
	
	@Test
	public void initialNumberSetReturnsEmptyStringWhenValueNotFoundTest() {
		assertTrue(numberNameRepository.getInitialNumberSetValue(21).equals(EMPTY_STRING));
		assertTrue(numberNameRepository.getInitialNumberSetValue(-10).equals(EMPTY_STRING));
		assertTrue(numberNameRepository.getInitialNumberSetValue(200).equals(EMPTY_STRING));
		assertTrue(numberNameRepository.getInitialNumberSetValue(-1).equals(EMPTY_STRING));
	}
	
	@Test
	public void tensNumberSetReturnsEmptyStringForZeroDigitsTest() {
		assertTrue(numberNameRepository.getTensNumberName(0).equals(EMPTY_STRING));
	}
	
	@Test
	public void tensNumberSetReturnsEmptyStringForTenDigitsTest() {
		assertTrue(numberNameRepository.getTensNumberName(1).equals(EMPTY_STRING));
	}
	
	@Test
	public void tensNumberSetContainsNumberTwentyTest() {
		assertTrue(numberNameRepository.getTensNumberName(2).equals(TWENTY));
	}
	
	@Test
	public void tensNumberSetContainsNumberThirtyTest() {
		assertTrue(numberNameRepository.getTensNumberName(3).equals(THIRTY));
	}
	
	@Test
	public void tensNumberSetContainsNumberFourtyTest() {
		assertTrue(numberNameRepository.getTensNumberName(4).equals(FOURTY));
	}
	
	@Test
	public void tensNumberSetContainsNumberFiftyTest() {
		assertTrue(numberNameRepository.getTensNumberName(5).equals(FIFTY));
	}
	
	@Test
	public void tensNumberSetContainsNumberSixtyTest() {
		assertTrue(numberNameRepository.getTensNumberName(6).equals(SIXTY));
	}
	
	@Test
	public void tensNumberSetContainsNumberSeventyTest() {
		assertTrue(numberNameRepository.getTensNumberName(7).equals(SEVENTY));
	}
	
	@Test
	public void tensNumberSetContainsNumberEightyTest() {
		assertTrue(numberNameRepository.getTensNumberName(8).equals(EIGHTY));
	}
	
	@Test
	public void tensNumberSetContainsNumberNinetyTest() {
		assertTrue(numberNameRepository.getTensNumberName(9).equals(NINETY));
	}
	
	@Test
	public void tensNumberSetReturnsEmptyStringWhenValueNotFoundTest() {
		assertTrue(numberNameRepository.getTensNumberName(61).equals(EMPTY_STRING));
		assertTrue(numberNameRepository.getTensNumberName(100).equals(EMPTY_STRING));
		assertTrue(numberNameRepository.getTensNumberName(1).equals(EMPTY_STRING));
		assertTrue(numberNameRepository.getTensNumberName(0).equals(EMPTY_STRING));
		assertTrue(numberNameRepository.getTensNumberName(-30).equals(EMPTY_STRING));
		assertTrue(numberNameRepository.getTensNumberName(-90).equals(EMPTY_STRING));
		assertTrue(numberNameRepository.getTensNumberName(10).equals(EMPTY_STRING));
		assertTrue(numberNameRepository.getTensNumberName(230).equals(EMPTY_STRING));
		assertTrue(numberNameRepository.getTensNumberName(19).equals(EMPTY_STRING));
	}
	
}
