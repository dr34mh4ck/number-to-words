package com.david.jaime.sonatype.numbertowords.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.david.jaime.sonatype.numbertowords.datastore.NumberNameRepository;
import com.david.jaime.sonatype.numbertowords.interfaces.ParserStrategy;

/**
 * @author David
 * This parser is in charge of parsing number in the range 0-9
 */
@Service
@Qualifier(SingleDigitParser.BEAN_QUALIFIER)
public class SingleDigitParser extends AbstractNumberToWordsParser implements ParserStrategy {
	
	public static final String BEAN_QUALIFIER = "singleDigitParser";
	
	@Autowired
	public SingleDigitParser(final NumberNameRepository numberNameRepository) {
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
		result.append(getValuefromSingleDigit(number));
		return result.toString();
	}

}
