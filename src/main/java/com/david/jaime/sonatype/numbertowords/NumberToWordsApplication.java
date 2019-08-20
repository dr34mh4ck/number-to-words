package com.david.jaime.sonatype.numbertowords;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.david.jaime.sonatype.numbertowords.interfaces.UserInterfaceFacade;
import com.david.jaime.sonatype.numbertowords.userinterface.ReplInterface;

/**
 * @author David
 * Springboot command line runner application
 * when executed the 'run' method initializes the application context
 * then the REPL like interface is displayed in sonsole to the user 
 *
 */
@SpringBootApplication
public class NumberToWordsApplication implements CommandLineRunner {

	private static final String APLICATION_CONTEXT_LOADED = "AplicationContext loaded.";

	private static Logger LOG = LoggerFactory
		      .getLogger(NumberToWordsApplication.class);
	
	private static UserInterfaceFacade userInputFacade;
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(NumberToWordsApplication.class, args);
		userInputFacade = (UserInterfaceFacade) applicationContext.getBean(ReplInterface.BEAN_NAME);
		userInputFacade.presentUserInterface();
	}
	
	@Override
    public void run(String... args) {
		LOG.info(APLICATION_CONTEXT_LOADED);	
    }

}
