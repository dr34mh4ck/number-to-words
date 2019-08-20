package com.david.jaime.sonatype.numbertowords.interfaces;

/**
 * @author David
 * defines operations that a parser strategy should follow
 */
public interface ParserStrategy {
	
	public String parseNumberToWords(Integer number) ;

}
