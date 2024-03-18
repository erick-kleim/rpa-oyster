package br.com.oystr.bot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BotTest {
	private static final String URL = "https://www.bot.com.br";
    private Bot bot;
    private WebDriver mockDriver;
    
    @Before
    public void setUp() {
        mockDriver = mock(WebDriver.class);
        bot = new BotTratoresColheitadeiras(mockDriver);
    }

    @Test
    public void testFindTextByXPath_ElementNotFound() {
    	String xpath = "//div[@id='example']";
    	when(mockDriver.findElement(By.xpath(xpath))).thenReturn(null);
    	
    	String actualText = bot.findTextByXPath(xpath);
    	
    	assertEquals(Bot.STR_ELEMENT_NOT_FOUND, actualText);
    }
    
    
    @Test
    public void setUrl() {
    	String beforeSet = bot.getMachine().getUrl();
    	assertNull(beforeSet);

    	bot.setUrl(URL);
    	String afterSet = bot.getMachine().getUrl();
    	assertEquals(URL, afterSet);
	}

}