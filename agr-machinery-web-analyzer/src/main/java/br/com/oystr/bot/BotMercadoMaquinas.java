package br.com.oystr.bot;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.oystr.entity.Machine;

public class BotMercadoMaquinas implements Bot {
	private static final String XPATH_PRICE = "//*[@id=\"ad-details\"]/div[1]/div[1]/div/div[2]/div/div/span";
	private static final String XPATH_CITY = "//*[@id=\"ad-details\"]/div[1]/div[1]/div/div[2]/div/ul/li[7]/span[2]";
	private static final String XPATH_WORKED_HOURS = "//*[@id=\"ad-details\"]/div[1]/div[1]/div/div[3]/div[3]/ul[5]/li/span[2]";
	private static final String XPATH_YEAR = "//*[@id=\"ad-details\"]/div[1]/div[1]/div/div[2]/div/ul/li[6]/span[2]";
	private static final String XPATH_MAKE = "//*[@id=\"ad-details\"]/div[1]/div[1]/div/div[2]/div/ul/li[4]/span[2]/a";
	private static final String XPATH_CONTRACT_TYPE = "//*[@id=\"ad-details\"]/div[1]/div[1]/div/div[2]/div/ul/li[1]/span";
	private static final String XPATH_MODEL = "//*[@id=\"ad-details\"]/div[1]/div[1]/div/div[2]/div/ul/li[5]/span[2]/a";
	private static final String MAIN_PHOTO = "//*[@id=\"ad-main-photo\"]";
	private static final String DIV_IMAGE_SLIDES = "//*[@id=\"blueimp-gallery\"]/div[1]";
	private static final String ICON_CHEVRON_RIGTH = "//*[@id=\"blueimp-gallery\"]/a[2]/i";
	
	WebDriver driver;
	private Machine machine;

	public BotMercadoMaquinas(WebDriver driver) {
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
	
	/*
	 * Este site possibilita no maximo 8 imagens por anuncio, e o carrossel de exibição 
	 * das imagens carrega apenas 5 imagens por vez, por este motivo é necessário andar
	 * 3 fotos para o lado para todas serem carregadas.
	 * */
	public Set<String> findPictures() {
		getDriver().findElement(By.xpath(MAIN_PHOTO)).click();
		Set<String> pictures = findImagesByXPath(DIV_IMAGE_SLIDES);
		getDriver().findElement(By.xpath(ICON_CHEVRON_RIGTH)).click();
		getDriver().findElement(By.xpath(ICON_CHEVRON_RIGTH)).click();
		getDriver().findElement(By.xpath(ICON_CHEVRON_RIGTH)).click();
		pictures.addAll(findImagesByXPath(DIV_IMAGE_SLIDES));
		return pictures;
	}
	
}
