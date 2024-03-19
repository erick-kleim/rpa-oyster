package br.com.oystr.bot;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.oystr.entity.Machine;

/*Builder Pattern*/
public interface Bot {
	public static final String STR_ELEMENT_NOT_FOUND = "";
	
	Machine getMachine();
	WebDriver getDriver();
	Bot setModel();
	Bot setContractType();
	Bot setMake();
	Bot setYear();
	Bot setWorkedHours();
	Bot setCity();
	Bot setPrice();

	default Bot setPictures() {
		getMachine().setPictures(findPictures());
		return this;
	}

	default Bot setUrl(String url) {
		getMachine().setUrl(url);
		return this;
	}

	Set<String> findPictures();

	default Machine fetch() {
		return buildMachine();
	}
	
	default Machine buildMachine() {
		return setUrl(getDriver().getCurrentUrl())
			.setModel()
			.setContractType()
			.setMake()
			.setYear()
			.setWorkedHours()
			.setCity()
			.setPrice()
			.setPictures()
				.build();
	}

	default Machine build() {
		return getMachine();
	}

	default String findTextByXPath(String xpath) {
		WebElement element;
		try {
		element = getDriver().findElement(By.xpath(xpath));
		}catch (Exception e) {
			return STR_ELEMENT_NOT_FOUND;
		}
		
		if (element == null)
			return STR_ELEMENT_NOT_FOUND;

		return element.getText();
	}

	default Set<String> findImagesByXPath(String xpath) {
		List<WebElement> imgs = getDriver()
				.findElement(By.xpath(xpath))
				.findElements(By.tagName("img"));

		Set<String> imageUrls = imgs.stream()
				.map(i -> i.getAttribute("src"))
				.collect(Collectors.toSet());

		return imageUrls;
	}
}
