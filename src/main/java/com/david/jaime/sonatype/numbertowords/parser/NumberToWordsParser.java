package com.david.jaime.sonatype.numbertowords.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.david.jaime.sonatype.numbertowords.interfaces.NumberToWordsFacade;
import com.david.jaime.sonatype.numbertowords.interfaces.ParserStrategy;

import lombok.AllArgsConstructor;

/**
 * @author David
 * This parser is in charge of obtaining a parsing strategy and 
 * invoking the execution of the especific parser 
 *
 */
@Service
@AllArgsConstructor
public class NumberToWordsParser implements NumberToWordsFacade {
	
		
	@Autowired
	private StrategySelector strategySelector;
	

	@Override
	public String parseNumberToWords(Integer numberinput) {
		
		final StringBuilder numberInWords = new StringBuilder("");
		final ParserStrategy parserStrategy = strategySelector.selectStrategy(numberinput);
		numberInWords.append(parserStrategy.parseNumberToWords(numberinput));
		return StringUtils.capitalize(numberInWords.toString());
	}
	
	
	
	
	
	

}
