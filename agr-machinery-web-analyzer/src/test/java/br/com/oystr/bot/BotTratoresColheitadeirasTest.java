package br.com.oystr.bot;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.util.collections.Sets;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class BotTratoresColheitadeirasTest {
	private static final String HTTPS_IMG_1 = "https://imagens.mercadomaquinas.com.br/anuncios/img-1.jpeg";
	private static final String HTTPS_IMG_2 = "https://imagens.mercadomaquinas.com.br/anuncios/img-2.jpeg";
	private static final String HTTPS_IMG_3 = "https://imagens.mercadomaquinas.com.br/anuncios/img-3.jpeg";
    private WebDriver driver;
    private BotTratoresColheitadeiras bot;

    @Before
    public void setUp() {
        driver = mock(WebDriver.class);
        bot = new BotTratoresColheitadeiras(driver);
    }

    private void mockElementWithText(String text) {
        WebElement element = mock(WebElement.class);
        when(driver.findElement(org.mockito.ArgumentMatchers.any())).thenReturn(element);
        when(element.getText()).thenReturn(text);
    }

    @Test
    public void testSetModel() {
        String expectedModel = "Model ABC";
        mockElementWithText(expectedModel);

        bot.setModel();

        assertEquals(expectedModel, bot.getMachine().getModel());
    }

    @Test
    public void testSetContractType() {
        bot.setContractType();
        assertEquals("Venda", bot.getMachine().getContractType());
    }

    @Test
    public void testSetMake() {
        String expectedMake = "MASSEY FERGUSON";
        mockElementWithText(expectedMake);

        bot.setMake();

        assertEquals(expectedMake, bot.getMachine().getMake());
    }

    @Test
    public void testSetYear() {
        String expectedYear = "2024";
        mockElementWithText(expectedYear);

        bot.setYear();

        assertEquals(expectedYear, bot.getMachine().getYear());
    }

    @Test
    public void testSetWorkedHours() {
        String expectedWorkedHours = "2000";
        mockElementWithText(expectedWorkedHours);

        bot.setWorkedHours();

        assertEquals(expectedWorkedHours, bot.getMachine().getWorkedHours());
    }

    @Test
    public void testSetCity() {
        String cityFieldPattern = "Endereço,n123\nCURITIBA/PR";
        mockElementWithText(cityFieldPattern);

        bot.setCity();

        assertEquals("CURITIBA/PR", bot.getMachine().getCity());
    }

    @Test
    public void testSetPrice() {
        String expectedPrice = "R$ 138.000,00";
        mockElementWithText(expectedPrice);

        bot.setPrice();

        assertEquals(expectedPrice, bot.getMachine().getPrice());
    }
    
    @Test
    public void testSetPictures() {
    	WebElement mockElement = mock(WebElement.class);
    	when(bot.getDriver().findElement(any())).thenReturn(mockElement);
		when(mockElement.findElements(By.tagName("img")))
			.thenReturn(Arrays.asList(mockElement,mockElement,mockElement));
		when(mockElement.getAttribute("src"))
			.thenReturn(HTTPS_IMG_1).thenReturn(HTTPS_IMG_2).thenReturn(HTTPS_IMG_3);

		Set<String> actualPictures = bot.findPictures();

		Set<String> expectedPictures = Sets.newSet(HTTPS_IMG_1, HTTPS_IMG_2, HTTPS_IMG_3);
		assertEquals(expectedPictures, actualPictures);
    }
}
