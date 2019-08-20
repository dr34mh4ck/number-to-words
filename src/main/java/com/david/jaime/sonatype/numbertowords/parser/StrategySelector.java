package com.david.jaime.sonatype.numbertowords.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.david.jaime.sonatype.numbertowords.interfaces.ParserStrategy;

import lombok.AllArgsConstructor;

/**
 * @author David
 * This class returns an especific parsing strategy according to the number
 * that is going to be parsed.
 */
@Component
@AllArgsConstructor
public class StrategySelector {
	
	@Autowired
	@Qualifier(SingleDigitParser.BEAN_QUALIFIER)
	private ParserStrategy singleDigitParser;
	
	@Autowired
	@Qualifier(LessThanTwentyParser.BEAN_QUALIFIER)
	private ParserStrategy lessThanTwentyParser;
	
	@Autowired
	@Qualifier(LessThanHundredParser.BEAN_QUALIFIER)
	private ParserStrategy lessThanHundredParser;
	
	@Autowired
	@Qualifier(DefaultNumberParser.BEAN_QUALIFIER)
	private ParserStrategy defaultNumberParser;
	
	
	public ParserStrategy selectStrategy(final Integer number) {
		ParserStrategy selectedStrategy = null;
		switch(number.toString().length()) {
		case 1 :  selectedStrategy = singleDigitParser; break;
		case 2 :  selectedStrategy = number.intValue() < 20 ? lessThanTwentyParser : lessThanHundredParser ;  break;
		default:  selectedStrategy = defaultNumberParser; break;
		}
		return selectedStrategy;
	}
	
	

}
