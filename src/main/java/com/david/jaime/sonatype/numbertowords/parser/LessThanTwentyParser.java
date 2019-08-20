package com.david.jaime.sonatype.numbertowords.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.david.jaime.sonatype.numbertowords.datastore.NumberNameRepository;
import com.david.jaime.sonatype.numbertowords.interfaces.ParserStrategy;

/**
 * @author David
 * this parser is in charge of parsing number in the range 10-20
 */
@Service
@Qualifier(LessThanTwentyParser.BEAN_QUALIFIER)
public class LessThanTwentyParser extends AbstractNumberToWordsParser implements ParserStrategy {

	public static final String BEAN_QUALIFIER = "lessThanTwentyParser";
	
	@Autowired
	public LessThanTwentyParser(final NumberNameRepository numberNameRepository) {
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
		result.append(getLessThanTwentyValue(number));
		return result.toString();
	}

}
