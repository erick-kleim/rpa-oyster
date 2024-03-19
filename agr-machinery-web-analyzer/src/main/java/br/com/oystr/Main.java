package br.com.oystr;

import java.util.stream.Stream;

import org.openqa.selenium.NotFoundException;

import br.com.oystr.bot.Bot;
import br.com.oystr.bot.factory.BotFactory;
import br.com.oystr.entity.Machine;

public class Main {

	public static void main(String[] args) {
		Stream<String> urls = input(args);
		
		urls.forEach(url ->{
			Bot bot = null;
			
			try {
				bot = BotFactory.createBot(url);
				Machine machine = bot.fetch();
				showMachine(machine);
	        }
	        catch (NotFoundException e) {
	        	System.out.println(e.getRawMessage());
			}
			catch (Exception e) {
	        	System.out.println(e.getMessage());
	        } finally {
	        	if(bot != null)
	        		bot.getDriver().quit();
	        }
		});
	}

	private static Stream<String> input(String[] args) {
		if(args.length != 0)
			return  Stream.of(args);
		
		return hardCodedInput();
	}

	private static Stream<String> hardCodedInput() {
		return Stream.of(				
				"https://www.agrofy.com.br/trator-massey-ferguson-4292hd-ano-2015-usado-200035.html",
				"https://www.agrofy.com.br/trator-bh-224-4x4-valtra.html",
				"https://www.tratoresecolheitadeiras.com.br/veiculo/itaiopolis/sc/trator/massey-ferguson/mf-4275/2019/tracao-4x4/cabine-cabinado/agrocomercial-rudnik---landini/1127064",
				"https://www.tratoresecolheitadeiras.com.br/veiculo/artur-nogueira/sp/retro-escavadeira/randon/rd406/2020/tracao-4x4/cabine-fechada/dovigo-tratores/1167729",
				"https://www.mercadomaquinas.com.br/anuncio/229386-retro-escavadeira-case-580n-2019-belo-horizonte-mg",				
				"https://www.mercadomaquinas.com.br/anuncio/228231-retro-escavadeira-fiatallis-fb80-2-2001-aruja-sp"
				);
	}

	private static void showMachine(Machine machine) {
		System.out.println(machine);
	}
}


