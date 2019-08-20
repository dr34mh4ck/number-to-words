package com.david.jaime.sonatype.numbertowords.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.david.jaime.sonatype.numbertowords.datastore.NumberNameRepository;
import com.david.jaime.sonatype.numbertowords.enums.NumberScaleEnum;
import com.david.jaime.sonatype.numbertowords.interfaces.ParserStrategy;

/**
 * @author David
 * The default number parser is in charge of parsing any number greater than 99
 *
 */
@Service
@Qualifier(DefaultNumberParser.BEAN_QUALIFIER)
public class DefaultNumberParser extends AbstractNumberToWordsParser implements ParserStrategy {

	public static final String BEAN_QUALIFIER = "defaultNumberParser";
	
	
	@Autowired
	public DefaultNumberParser(final NumberNameRepository numberNameRepository) {
		super(numberNameRepository);
	}

	@Override
	public String parseNumberToWords(Integer number) {
		final StringBuilder result = new StringBuilder("");
		boolean dealingWithMinSupportedValue = false;
		if(number < 0) {
			if(number.intValue() == Integer.MIN_VALUE) {
				number = Integer.MAX_VALUE;
				dealingWithMinSupportedValue = true;
			}else {
				number =  Math.abs(number);
			}
			result.append(NumberNameRepository.NEGATIVE_NOTATION);
			result.append(  NumberNameRepository.SEPARATOR );
		}
		if(number.intValue() >= NumberNameRepository.ONE_BILLION) {
			 result.append( parseNumberToWords(number / NumberNameRepository.ONE_BILLION) );
			 result.append(  NumberNameRepository.SEPARATOR );
			 result.append(NumberScaleEnum.getScaleNameFromDigitsToTheRight(9));
			 result.append(  NumberNameRepository.SEPARATOR );
			result.append(parseNumberToWords(number % NumberNameRepository.ONE_BILLION));
			if (dealingWithMinSupportedValue) {
				return result.replace(result.lastIndexOf(NumberNameRepository.MIN_SUPPORTED_VALUE_TRADE_DIGIT),
						result.length(), NumberNameRepository.MIN_SUPPORTED_VALUE_REPLACE_DIGIT).toString();
			}
			 return result.toString();		
		} else if(number.intValue() >= NumberNameRepository.ONE_MILLION) {
			 result.append( parseNumberToWords(number / NumberNameRepository.ONE_MILLION) );
			 result.append(  NumberNameRepository.SEPARATOR );
			 result.append(NumberScaleEnum.getScaleNameFromDigitsToTheRight(6));
			 result.append(  NumberNameRepository.SEPARATOR );
			 result.append( parseNumberToWords(number % NumberNameRepository.ONE_MILLION) );
			 return result.toString();	
		} else if(number.intValue() >= NumberNameRepository.ONE_THOUSAND) {
			 result.append( parseNumberToWords(number / NumberNameRepository.ONE_THOUSAND) );
			 result.append(  NumberNameRepository.SEPARATOR );
			 result.append(NumberScaleEnum.getScaleNameFromDigitsToTheRight(3));
			 result.append(  NumberNameRepository.SEPARATOR );
			 result.append( parseNumberToWords(number % NumberNameRepository.ONE_THOUSAND) );
			 return result.toString();	
		} else if(number.intValue() >= NumberNameRepository.ONE_HOUNDRED) {
			 result.append( parseNumberToWords(number / NumberNameRepository.ONE_HOUNDRED) );
			 result.append(  NumberNameRepository.SEPARATOR );
			 result.append(NumberScaleEnum.getScaleNameFromDigitsToTheRight(2));
			 result.append(  NumberNameRepository.SEPARATOR );
			 result.append( parseNumberToWords(number % NumberNameRepository.ONE_HOUNDRED) );
			 return result.toString();	
		}
		return handleTwoDigitNumberLeft(number);
	}
	
	private String handleTwoDigitNumberLeft(final Integer number) {
		final StringBuilder result = new StringBuilder("");
		if(number.intValue() == 0) {
			return "";
		}
		ParserStrategy parserStrategy = null;
		if(number > 20) {
			parserStrategy = new LessThanHundredParser(numberNameRepository);
		}else if(number >= 10) {
			parserStrategy = new LessThanTwentyParser(numberNameRepository);
		} else if (number < 10) {
			parserStrategy = new SingleDigitParser(numberNameRepository);
		}
		result.append(parserStrategy.parseNumberToWords(number));
		return result.toString();
	}
	
}
