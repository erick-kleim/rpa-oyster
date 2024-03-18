package br.com.oystr.bot;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import br.com.oystr.entity.Machine;

public class BotTratoresColheitadeiras implements Bot {
	private static final String VENDA = "Venda";
	private static final String XPATH_PRICE = "//*[@id=\"tab1\"]/div/div/div[1]/p[1]/strong";
	private static final String XPATH_CITY = "//*[@id=\"page-content\"]/div[2]/div/div[1]/div/div[2]/div[2]/ul/li[2]";
	private static final String XPATH_WORKED_HOURS = "//*[@id=\"tab1\"]/div/div/div[1]/p[10]/strong";
	private static final String XPATH_YEAR = "//*[@id=\"tab1\"]/div/div/div[1]/p[6]/strong";
	private static final String XPATH_MAKE = "//*[@id=\"tab1\"]/div/div/div[1]/p[3]/strong";
	private static final String XPATH_MODEL = "//*[@id=\"tab1\"]/div/div/div[1]/p[4]/strong";
	private static final String DIV_IMAGE_SLIDES = "//*[@id=\"gallery\"]/div/div";
	
	WebDriver driver;
	private Machine machine;

	public BotTratoresColheitadeiras(WebDriver driver) {
        this.driver = driver;
        machine = new Machine();
    }

	public Machine getMachine() {
		return machine;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public Bot setModel() {
		machine.setModel(findTextByXPath(XPATH_MODEL));
		return this;
	}

	public Bot setContractType() {
		machine.setContractType(VENDA);
		return this;
	}

	public Bot setMake() {
		machine.setMake(findTextByXPath(XPATH_MAKE));
		return this;
	}

	public Bot setYear() {
		machine.setYear(findTextByXPath(XPATH_YEAR));
		return this;
	}

	public Bot setWorkedHours() {
		machine.setWorkedHours(findTextByXPath(XPATH_WORKED_HOURS));
		return this;
	}

	public Bot setCity() {
		String element = findTextByXPath(XPATH_CITY);
		if(element.equals(STR_ELEMENT_NOT_FOUND))
			machine.setCity(element);
		
		machine.setCity(element.split("\n")[1]);
		return this;
	}

	public Bot setPrice() {
		machine.setPrice(findTextByXPath(XPATH_PRICE));
		return this;
	}

	public Set<String> findPictures() {
		return findImagesByXPath(DIV_IMAGE_SLIDES);
	}

}
