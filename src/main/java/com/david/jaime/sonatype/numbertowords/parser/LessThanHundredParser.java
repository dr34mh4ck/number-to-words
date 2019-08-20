package com.david.jaime.sonatype.numbertowords.parser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.david.jaime.sonatype.numbertowords.datastore.NumberNameRepository;
import com.david.jaime.sonatype.numbertowords.interfaces.ParserStrategy;

/**
 * @author David
 * This parser in charge or parsing numbers in the range 20-99
 */
@Service
@Qualifier(LessThanHundredParser.BEAN_QUALIFIER)
public class LessThanHundredParser extends AbstractNumberToWordsParser implements ParserStrategy {

	public static final String BEAN_QUALIFIER = "lessThanHundredParser";

	@Autowired
	public LessThanHundredParser(final NumberNameRepository numberNameRepository) {
		super(numberNameRepository);
	}
	
	@Override
	public String parseNumberToWords(Integer number) {
		final StringBuilder result = new StringBuilder("");
		if(number < 0) {
			result.append(NumberNameRepository.NEGATIVE_NOTATION);
			result.append(NumberNameRepository.SEPARATOR);
			number = Math.abs(number);
		}
		List<Integer> numberDigits = getNumberDigits(number);
		result.append(getTensNames(numberDigits.get(0)));
		if( numberDigits.get(1).compareTo(NumberNameRepository.ONE) >= 0) {
			result.append(NumberNameRepository.SEPARATOR);
			result.append(getValuefromSingleDigit(numberDigits.get(1)));
		}
		return result.toString();
	}

	
	
}
