package br.com.oystr.bot;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.oystr.entity.Machine;

public class BotAgrofy implements Bot {
	private static final String XPATH_PRICE = "//*[@id=\"ProductInfo\"]/div[2]/span";
	private static final String XPATH_CITY = "//*[@id=\"pdp-body\"]/div[3]/div/div[2]/section[2]/span/span[1]/div[2]/div/ul/li[4]/span/ul/li";
	private static final String XPATH_WORKED_HOURS = "//*[@id=\"pdp-body\"]/div[3]/div/div[2]/section[2]/span/span[1]/div[2]/div/ul/li[10]/span/ul/li";
	private static final String XPATH_YEAR = "//*[@id=\"pdp-body\"]/div[3]/div/div[2]/section[2]/span/span[1]/div[2]/div/ul/li[8]/span/ul/li";
	private static final String XPATH_MAKE = "//*[@id=\"pdp-body\"]/div[3]/div/div[2]/section[2]/span/span[1]/div[2]/div/ul/li[6]/span/ul/li";
	private static final String XPATH_CONTRACT_TYPE = "//*[@id=\"pdp-body\"]/div[3]/div/div[2]/section[2]/span/span[1]/div[2]/div/ul/li[1]/span/ul/li";
	private static final String XPATH_MODEL = "//*[@id=\"pdp-body\"]/div[3]/div/div[2]/section[2]/span/span[1]/div[2]/div/ul/li[7]/span/ul/li";
	private static final String MAIN_PHOTO = "//*[@id=\"pdp-body\"]/div[3]";
	private static final String DIV_IMAGE_SLIDES = "//*[@id=\"pdp-body\"]/div[3]/div[1]/div/div/div/div[2]/div[1]/div";
	
	WebDriver driver;
	private Machine machine;

	public BotAgrofy(WebDriver driver) {
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
		machine.setContractType(findTextByXPath(XPATH_CONTRACT_TYPE));
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
		machine.setCity(findTextByXPath(XPATH_CITY));
		return this;
	}

	public Bot setPrice() {
		machine.setPrice(findTextByXPath(XPATH_PRICE));
		return this;
	}
	
	public Set<String>  findPictures() {
		getDriver().findElement(By.xpath(MAIN_PHOTO)).click();
		return findImagesByXPath(DIV_IMAGE_SLIDES);
	}
}
