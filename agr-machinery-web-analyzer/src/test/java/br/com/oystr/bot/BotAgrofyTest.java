package br.com.oystr.bot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Sets;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BotAgrofyTest {
	private static final String HTTPS_IMG_1 = "https://imagens.mercadomaquinas.com.br/anuncios/img-1.jpeg";
	private static final String HTTPS_IMG_2 = "https://imagens.mercadomaquinas.com.br/anuncios/img-2.jpeg";
	private static final String HTTPS_IMG_3 = "https://imagens.mercadomaquinas.com.br/anuncios/img-3.jpeg";
	private BotAgrofy bot;
	private WebDriver driver;

	@BeforeEach
	public void setUp() {
		driver = mock(WebDriver.class);
		bot = new BotAgrofy(driver);
	}

	@Test
	public void testSetModel() {
		String expectedModel = "Model XYZ";
		WebElement element = mock(WebElement.class);
		when(driver.findElement(any())).thenReturn(element);
		when(element.getText()).thenReturn(expectedModel);

		bot.setModel();

		assertEquals(expectedModel, bot.getMachine().getModel());
	}

	@Test
	public void testSetContractType() {
		String expectedContractType = "Type ABC";
		WebElement element = mock(WebElement.class);
		when(driver.findElement(any())).thenReturn(element);
		when(element.getText()).thenReturn(expectedContractType);

		bot.setContractType();

		assertEquals(expectedContractType, bot.getMachine().getContractType());
	}

	@Test
	public void testSetMake() {
		String expectedMake = "Make XYZ";
		WebElement element = mock(WebElement.class);
		when(driver.findElement(any())).thenReturn(element);
		when(element.getText()).thenReturn(expectedMake);

		bot.setMake();

		assertEquals(expectedMake, bot.getMachine().getMake());
	}

	@Test
	public void testSetYear() {
		String expectedYear = "2020";
		WebElement element = mock(WebElement.class);
		when(driver.findElement(any())).thenReturn(element);
		when(element.getText()).thenReturn(expectedYear);

		bot.setYear();

		assertEquals(expectedYear, bot.getMachine().getYear());
	}

	@Test
	public void testSetWorkedHours() {
		String expectedWorkedHours = "2000";
		WebElement element = mock(WebElement.class);
		when(driver.findElement(any())).thenReturn(element);
		when(element.getText()).thenReturn(expectedWorkedHours);

		bot.setWorkedHours();

		assertEquals(expectedWorkedHours, bot.getMachine().getWorkedHours());
	}

	@Test
	public void testSetCity() {
		String expectedCity = "City XYZ";
		WebElement element = mock(WebElement.class);
		when(driver.findElement(any())).thenReturn(element);
		when(element.getText()).thenReturn(expectedCity);

		bot.setCity();

		assertEquals(expectedCity, bot.getMachine().getCity());
	}

	@Test
	public void testSetPrice() {
		String expectedPrice = "$10000";
		WebElement element = mock(WebElement.class);
		when(driver.findElement(any())).thenReturn(element);
		when(element.getText()).thenReturn(expectedPrice);

		bot.setPrice();

		assertEquals(expectedPrice, bot.getMachine().getPrice());
	}

	@Test
	public void testFindPictures() {
		mockRenderingAllImagesdivs();
		
		Set<String> actualPictures = bot.findPictures();

		Set<String> expectedPictures = Sets.newSet(HTTPS_IMG_1, HTTPS_IMG_2, HTTPS_IMG_3);
		assertEquals(expectedPictures, actualPictures);
	}

	private void mockRenderingAllImagesdivs() {
		WebElement mockElement = mock(WebElement.class);
		when(bot.getDriver().findElement(any())).thenReturn(mockElement);
		when(mockElement.findElements(By.tagName("img")))
			.thenReturn(Arrays.asList(mockElement,mockElement,mockElement));

		when(mockElement.getAttribute("src"))
		.thenReturn(HTTPS_IMG_1).thenReturn(HTTPS_IMG_2).thenReturn(HTTPS_IMG_3);
	}
}
