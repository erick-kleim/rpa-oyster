package br.com.oystr.bot.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

import br.com.oystr.bot.Bot;
import br.com.oystr.bot.BotAgrofy;
import br.com.oystr.bot.BotMercadoMaquinas;
import br.com.oystr.bot.BotTratoresColheitadeiras;

class BotFactoryTest {

	@Test
	public void testCreateBotAgrofy() {
		String url = "https://www.agrofy.com.br";
		Bot bot = BotFactory.createBot(url);
		assertNotNull(bot);
		assertTrue(bot instanceof BotAgrofy);
		
		String name = bot.getDriver().findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div[1]/a/span[1]")).getText();
		assertEquals("Agrofy", name);
		
		bot.getDriver().quit();
	}

	@Test
	public void testCreateBotTratoresColheitadeiras() {
		String url = "https://www.tratoresecolheitadeiras.com.br";
		Bot bot = BotFactory.createBot(url);
		assertNotNull(bot);
		assertTrue(bot instanceof BotTratoresColheitadeiras);
		bot.getDriver().quit();
	}

	@Test
	public void testCreateBotMercadoMaquinas() {
		String url = "https://www.mercadomaquinas.com.br";
		Bot bot = BotFactory.createBot(url);
		assertNotNull(bot);
		assertTrue(bot instanceof BotMercadoMaquinas);
		bot.getDriver().quit();
	}

	@Test
	public void testCreateBotInvalidUrl() {
		String url = "https://www.invalidurl.com";
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			BotFactory.createBot(url);
		});

		Assertions.assertEquals("No match bot for this website: invalidurl", thrown.getMessage());

	}

	@Test
	public void testCreateBotUrlParserInvalid() {
		String url = "https://https://www.agrofy.com";
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			BotFactory.createBot(url);
		});
		
		Assertions.assertEquals("Error when trying to get the website name from this url: " + url,
				thrown.getMessage());
		
	}

	@Test
	public void testCreateBotUrlNotFound() {
		String url = "https://www.agrofy.com.gg";
		
		NotFoundException thrown = assertThrows(NotFoundException.class, () -> {
			BotFactory.createBot(url);
		});
		
		Assertions.assertEquals("Web page not found for url: " + url,
				thrown.getRawMessage());
		
	}

}
