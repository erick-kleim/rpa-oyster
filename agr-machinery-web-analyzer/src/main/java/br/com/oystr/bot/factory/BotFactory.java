package br.com.oystr.bot.factory;

import java.time.Duration;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import br.com.oystr.bot.Bot;
import br.com.oystr.bot.BotAgrofy;
import br.com.oystr.bot.BotMercadoMaquinas;
import br.com.oystr.bot.BotTratoresColheitadeiras;

public class BotFactory {
    public static Bot createBot(String url) {
        String website = identifyWebsite(url);
        
		return switch (website) {
            case "agrofy" -> new BotAgrofy(initializeWebDriver(url));
            case "tratoresecolheitadeiras" -> new BotTratoresColheitadeiras(initializeWebDriver(url));
            case "mercadomaquinas" -> new BotMercadoMaquinas(initializeWebDriver(url));
            default -> throw new IllegalArgumentException(
            		"No match bot for this website: " + website);
        };
    }

    private static String identifyWebsite(String url) {
    	try {
    		return url.split("/")[2].split("\\.")[1];
    	}catch (Exception e) {
    		throw new IllegalArgumentException(
					"Error when trying to get the website name from this url: " + url);
		}
    }
    
	private static WebDriver initializeWebDriver(String url) {
		ChromeOptions chromeOptions = initializeChromeOptions();
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		try {
			driver.get(url);
		} catch (Exception e) {
			driver.quit();
			throw new NotFoundException("Web page not found for url: " + url);
		}		
		return driver;
	}
    
    private static ChromeOptions initializeChromeOptions() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		return chromeOptions;
	}
}