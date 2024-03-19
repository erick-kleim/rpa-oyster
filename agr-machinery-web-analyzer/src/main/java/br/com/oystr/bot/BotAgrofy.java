package br.com.oystr.bot;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.oystr.entity.Machine;

public class BotAgrofy implements Bot {
	private static final String XPATH_PRICE = "//*[@id=\"ProductInfo\"]/div[2]/span";
	private static final String KEY_CITY = "Cidade / Estado";
	private static final String KEY_WORKED_HOURS =  "Horas de Uso";
	private static final String KEY_YEAR = "Ano de fabricação";
	private static final String KEY_MAKE = "Marca";
	private static final String KEY_CONTRACT_TYPE =  "Tipo de Operação";
	private static final String KEY_MODEL = "Modelo";
	private static final String MAIN_PHOTO = "//*[@id=\"pdp-body\"]/div[3]";
	private static final String DIV_IMAGE_SLIDES = "//*[@id=\"pdp-body\"]/div[3]/div[1]/div/div/div/div[2]/div[1]/div";
	
	WebDriver driver;
	private Machine machine;
	
	Map<String, String> textInformations;

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
	
	public Machine fetch() {
		fetchTextInformations();
        return buildMachine();
    }

	private void fetchTextInformations() {
		String allData = findTextByXPath("//*[@id=\"pdp-body\"]/div[3]/div/div[2]/section[2]/span/span[1]/div[2]/div/ul");
		if(allData.equals(STR_ELEMENT_NOT_FOUND))
			allData = findTextByXPath("//*[@id=\"pdp-body\"]/div[3]/div/div[2]/section[3]/span/span[1]/div[2]/div");

		String[] array = allData.split("\n");

		textInformations = IntStream.range(0, array.length / 2).boxed()
                .collect(Collectors.toMap(i -> array[i * 2], i -> array[i * 2 + 1]));
	}

	public Bot setModel() {
		machine.setModel(textInformations.get(KEY_MODEL));
		return this;
	}

	public Bot setContractType() {
		machine.setContractType(textInformations.get(KEY_CONTRACT_TYPE));
		return this;
	}

	public Bot setMake() {
		machine.setMake(textInformations.get(KEY_MAKE));
		return this;
	}

	public Bot setYear() {
		machine.setYear(textInformations.get(KEY_YEAR));
		return this;
	}

	public Bot setWorkedHours() {
		machine.setWorkedHours(textInformations.get(KEY_WORKED_HOURS));
		return this;
	}

	public Bot setCity() {
		machine.setCity(textInformations.get(KEY_CITY));
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
