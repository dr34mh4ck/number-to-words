package com.david.jaime.sonatype.numbertowords.parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.david.jaime.sonatype.numbertowords.datastore.NumberNameRepository;

@RunWith(MockitoJUnitRunner.class)
public class StrategySelectorTest {
	
	private StrategySelector strategySelector;
	
	private NumberNameRepository numberNameRepository;
	
	private DefaultNumberParser defaultNumberParser;
	
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
		strategySelector = new StrategySelector(singleDigitParser, lessThanTwentyParser, lessThanHundredParser,
				defaultNumberParser);
	}
	
	@Test
	public void selectSingleDigitStrategy() {
		final Object selectedStrategy = strategySelector.selectStrategy(1);
		assertTrue(selectedStrategy instanceof SingleDigitParser);
		assertFalse(selectedStrategy instanceof LessThanHundredParser);
	}
	
	@Test
	public void selectLessThanTwentyStrategy() {
		final Object selectedStrategy = strategySelector.selectStrategy(15);
		assertTrue(selectedStrategy instanceof LessThanTwentyParser);
		assertFalse(selectedStrategy instanceof SingleDigitParser);
	}
	
	@Test
	public void selectLessThanHundredStrategy() {
		final Object selectedStrategy = strategySelector.selectStrategy(88);
		assertTrue(selectedStrategy instanceof LessThanHundredParser);
		assertFalse(selectedStrategy instanceof LessThanTwentyParser);
	}
	
	@Test
	public void selectDefaultStrategy() {
		final Object selectedStrategy = strategySelector.selectStrategy(1987);
		assertTrue(selectedStrategy instanceof DefaultNumberParser);
		assertFalse(selectedStrategy instanceof LessThanHundredParser);
	}

}
