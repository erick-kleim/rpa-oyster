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
	private static final String HTTPS_IMG_1 = "https://imagens.mercadomaquinas.com.br/anuncios/img-1.jpeg";
	private static final String HTTPS_IMG_2 = "https://imagens.mercadomaquinas.com.br/anuncios/img-2.jpeg";
	private static final String HTTPS_IMG_3 = "https://imagens.mercadomaquinas.com.br/anuncios/img-3.jpeg";
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
    
//    @Test
//    public void fetch() {
//    	Machine beforeFetch = bot.getMachine();
//    	assertEquals(new Machine(), beforeFetch);
//
//        when(mockBot.getDriver()).thenReturn(mockDriver);
//    	when(mockBot.getDriver().getCurrentUrl()).thenReturn("url");
//    	when(mockBot.findTextByXPath(anyString()))
//    		.thenReturn("model\nmodel");
//    	when(mockBot.findImagesByXPath(anyString()))
//    		.thenReturn(Sets.newSet(HTTPS_IMG_1));
//    	
//    	Machine afterFetch = bot.fetch();
//    	
//    	assertEquals(beforeFetch, afterFetch);
//    }

//  @Test
//  public void setPictures() {
//  	Set<String> siteImages = Sets.newSet(HTTPS_IMG_1,HTTPS_IMG_2,HTTPS_IMG_3);
//  	
//  	Set<String> beforeSet = bot.getMachine().getPictures();
//  	assertNull(beforeSet);
//
//  	when(bot.findPictures()).thenReturn(siteImages);
//  	bot.setPictures();
//  	Set<String> afterSet = bot.getMachine().getPictures();
//  	assertEquals(siteImages, afterSet);
//  }

}