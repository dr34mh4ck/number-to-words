package com.david.jaime.sonatype.numbertowords.parser;

import java.util.ArrayList;
import java.util.List;

import com.david.jaime.sonatype.numbertowords.datastore.NumberNameRepository;

/**
 * @author David
 * Abtract class that groups basic/common parser behavior
 *
 */
public class AbstractNumberToWordsParser {
	
	protected NumberNameRepository numberNameRepository;
		
	public AbstractNumberToWordsParser(final NumberNameRepository numberNameRepository) {
		this.numberNameRepository = numberNameRepository ;
	}
	
	protected String getValuefromSingleDigit(final Integer digit) {
			return numberNameRepository.getInitialNumberSetValue(digit);
	}
	
	protected String getLessThanTwentyValue(final Integer number) {
		return getValuefromSingleDigit(number);
	}
	
	protected String getTensNames(final Integer digit) {
		return numberNameRepository.getTensNumberName(digit);
	}
	
	protected List<Integer> getNumberDigits(Integer number) {
		final List<Integer> inputDigits = new ArrayList<>();
		if ( new Integer(0).compareTo(number) == 0) {
			inputDigits.add(number);
        } else {
            while (number > 0) {
            	inputDigits.add(0, (int) number % 10);
            	number = number / 10;
            }
        }
		return inputDigits;
	}
		
}
