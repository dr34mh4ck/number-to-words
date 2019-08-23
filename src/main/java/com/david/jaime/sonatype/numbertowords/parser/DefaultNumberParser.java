package com.david.jaime.sonatype.numbertowords.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		final String parsedNumber =  doParseNumberToWords(number);
		return addAndConjunction(parsedNumber, number);
	}

	public String doParseNumberToWords(Integer number) {
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
			 result.append( doParseNumberToWords(number / NumberNameRepository.ONE_BILLION) );
			 result.append(  NumberNameRepository.SEPARATOR );
			 result.append(NumberScaleEnum.getScaleNameFromDigitsToTheRight(9));
			 result.append(  NumberNameRepository.SEPARATOR );
			 result.append(doParseNumberToWords(number % NumberNameRepository.ONE_BILLION));
			if (dealingWithMinSupportedValue) {
				return result.replace(result.lastIndexOf(NumberNameRepository.MIN_SUPPORTED_VALUE_TRADE_DIGIT),
						result.length(), NumberNameRepository.MIN_SUPPORTED_VALUE_REPLACE_DIGIT).toString();
			}
			 return result.toString();		
		} else if(number.intValue() >= NumberNameRepository.ONE_MILLION) {
			 result.append( doParseNumberToWords(number / NumberNameRepository.ONE_MILLION) );
			 result.append(  NumberNameRepository.SEPARATOR );
			 result.append(NumberScaleEnum.getScaleNameFromDigitsToTheRight(6));
			 result.append(  NumberNameRepository.SEPARATOR );
			 result.append( doParseNumberToWords(number % NumberNameRepository.ONE_MILLION) );
			 return result.toString();	
		} else if(number.intValue() >= NumberNameRepository.ONE_THOUSAND) {
			 result.append( doParseNumberToWords(number / NumberNameRepository.ONE_THOUSAND) );
			 result.append(  NumberNameRepository.SEPARATOR );
			 result.append(NumberScaleEnum.getScaleNameFromDigitsToTheRight(3));
			 result.append(  NumberNameRepository.SEPARATOR );
			 result.append( doParseNumberToWords(number % NumberNameRepository.ONE_THOUSAND) );
			 return result.toString();	
		} else if(number.intValue() >= NumberNameRepository.ONE_HOUNDRED) {
			 result.append( doParseNumberToWords(number / NumberNameRepository.ONE_HOUNDRED) );
			 result.append(  NumberNameRepository.SEPARATOR );
			 result.append(NumberScaleEnum.getScaleNameFromDigitsToTheRight(2));
			 result.append(  NumberNameRepository.SEPARATOR );
			 result.append( doParseNumberToWords(number % NumberNameRepository.ONE_HOUNDRED) );
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
		if(number >= 20) {
			parserStrategy = new LessThanHundredParser(numberNameRepository);
		}else if(number >= 10) {
			parserStrategy = new LessThanTwentyParser(numberNameRepository);
		} else if (number < 10) {
			parserStrategy = new SingleDigitParser(numberNameRepository);
		}
		result.append(parserStrategy.parseNumberToWords(number));
		return result.toString();
	}
	
	private String addAndConjunction(final String numberInWords, Integer number) {
		number = Math.abs(number);
		final Map<Integer,Integer> andConjuctionIndex = evaluateAndConjunctionIndex(number);
		final StringBuilder result = new StringBuilder("");
		if(!andConjuctionIndex.isEmpty()) {
			String digitToPreceedWord = "";
			ParserStrategy parserStrategy = null;
			for(final Map.Entry<Integer, Integer> entry : andConjuctionIndex.entrySet() ) {
				final Integer digitToPreceedAnd = Integer
						.valueOf(number.toString().substring(number.toString().length() - entry.getValue().intValue()));
				if(digitToPreceedAnd > 19) {
					parserStrategy = new LessThanHundredParser(numberNameRepository);
				}else {
					parserStrategy = new SingleDigitParser(numberNameRepository);
				}
				digitToPreceedWord = parserStrategy.parseNumberToWords(digitToPreceedAnd);
				break;
			}
			result.append(numberInWords.substring(0, numberInWords.lastIndexOf(digitToPreceedWord) ));
			result.append(NumberNameRepository.AND);
			result.append(NumberNameRepository.SEPARATOR);
			result.append(numberInWords.substring(numberInWords.lastIndexOf(digitToPreceedWord)));
		}else {
			result.append(numberInWords);
		}
		return result.toString();
	}
	
	private Map<Integer,Integer> evaluateAndConjunctionIndex(final Integer number) {
		final Map<Integer,Integer> digitAndIndexMap = new HashMap<>();
		Integer andConjuctionIndex = -1;
		Integer digitToPreceedWithAnd = -1;
		List<Integer> digits = getNumberDigits(number);
		if(digits.size() >= 3) {
			if(digits.get(digits.size()-1) > 0 ) {
				andConjuctionIndex = 1;
				digitToPreceedWithAnd = digits.get(digits.size()-1);
			}
			if(digits.get(digits.size()-2) > 0 ) {
				andConjuctionIndex = 2;
				digitToPreceedWithAnd = digits.get(digits.size()-2);
			}
		}		
		if(andConjuctionIndex > 0) {
			digitAndIndexMap.put(digitToPreceedWithAnd, andConjuctionIndex);
		}
		return digitAndIndexMap;
	}
	
}
