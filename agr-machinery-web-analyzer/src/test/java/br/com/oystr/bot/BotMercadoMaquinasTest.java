package br.com.oystr.bot;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.util.collections.Sets;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BotMercadoMaquinasTest {
	private static final String HTTPS_IMG_1 = "https://imagens.mercadomaquinas.com.br/anuncios/img-1.jpeg";
	private static final String HTTPS_IMG_2 = "https://imagens.mercadomaquinas.com.br/anuncios/img-2.jpeg";
	private static final String HTTPS_IMG_3 = "https://imagens.mercadomaquinas.com.br/anuncios/img-3.jpeg";
	private static final String HTTPS_IMG_4 = "https://imagens.mercadomaquinas.com.br/anuncios/img-4.jpeg";
	private static final String HTTPS_IMG_5 = "https://imagens.mercadomaquinas.com.br/anuncios/img-5.jpeg";
	private static final String HTTPS_IMG_6 = "https://imagens.mercadomaquinas.com.br/anuncios/img-6.jpeg";
	private static final String HTTPS_IMG_7 = "https://imagens.mercadomaquinas.com.br/anuncios/img-7.jpeg";
	private static final String HTTPS_IMG_8 = "https://imagens.mercadomaquinas.com.br/anuncios/img-8.jpeg";
	private WebDriver driver;
	private BotMercadoMaquinas bot;

	@Before
	public void setUp() {
		driver = mock(WebDriver.class);
		bot = new BotMercadoMaquinas(driver);
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
		String expectedContractType = "Contract Type XYZ";
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
		WebElement elementMock = mock(WebElement.class);
		when(bot.getDriver().findElement(any(By.class))).thenReturn(elementMock);
		mockRenderingOfFiveDivImages(elementMock);
		mockCollectionOfSrcTagValues(elementMock);

		bot.setPictures();

		Set<String> expectedPictures = Sets.newSet(HTTPS_IMG_1, HTTPS_IMG_2, HTTPS_IMG_3, HTTPS_IMG_4,
				HTTPS_IMG_5,HTTPS_IMG_6, HTTPS_IMG_7, HTTPS_IMG_8);
		Set<String> machinePictures = bot.getMachine().getPictures();
		assertEquals(8, machinePictures.size());
		assertEquals(expectedPictures, machinePictures);
	}

	private void mockCollectionOfSrcTagValues(WebElement elementMock) {
		when(elementMock.getAttribute("src"))
			.thenReturn(HTTPS_IMG_1).thenReturn(HTTPS_IMG_2).thenReturn(HTTPS_IMG_3).thenReturn(HTTPS_IMG_4).thenReturn(HTTPS_IMG_5)
			.thenReturn(HTTPS_IMG_4).thenReturn(HTTPS_IMG_5).thenReturn(HTTPS_IMG_6).thenReturn(HTTPS_IMG_7).thenReturn(HTTPS_IMG_8);
	}

	private void mockRenderingOfFiveDivImages(WebElement elementMock) {		
		when(elementMock.findElement(any(By.class)))
			.thenReturn(elementMock);
		when(elementMock.findElements(By.tagName("img")))
			.thenReturn(Arrays.asList(elementMock,elementMock,elementMock,elementMock,elementMock));
	}
}