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
//				"a:a"
//				,
//				"https://www.noexiste.com.br/trator-massey-ferguson-4292hd-ano-2015-usado-200035.html"
//				,
//				"https://www.agrofy.erro"
//				,
				"https://www.agrofy.com.br/trator-massey-ferguson-4292hd-ano-2015-usado-200035.html"
				,
				"https://www.tratoresecolheitadeiras.com.br/veiculo/itaiopolis/sc/trator/massey-ferguson/mf-4275/2019/tracao-4x4/cabine-cabinado/agrocomercial-rudnik---landini/1127064"
				,
				"https://www.mercadomaquinas.com.br/anuncio/229386-retro-escavadeira-case-580n-2019-belo-horizonte-mg"
				);
	}

	private static void showMachine(Machine machine) {
		System.out.println(machine);
	}
}

//		"www.agrofy.com.br/trator-massey-ferguson-4292hd-ano-2015-usado-200035.html"
//		"https://www.agrofy.com.br/trator-mahindra-6075-novo-80cv-4x4-4cilindros.html"
//		"https://www.tratoresecolheitadeiras.com.br/veiculo/uberlandia/mg/plataforma-colheitadeira/gts/flexer-xs-45/2023/45-pes/draper/triamaq-tratores/1028839"
//		"https://www.tratoresecolheitadeiras.com.br/veiculo/uberlandia/mg/plataforma-colheitadeira/gts/produttiva-1250/2022/caracol/12-linhas/triamaq-tratores/994257"
//		"https://www.mercadomaquinas.com.br/anuncio/218193-escavadeira-caterpillar-320c-2006-aruja-sp"
//		"https://www.mercadomaquinas.com.br/anuncio/214554-pa-carregadeira-caterpillar-950h-2012-curitiba-pr"
//		"https://www.mercadomaquinas.com.br/anuncio/229386-retro-escavadeira-case-580n-2019-belo-horizonte-mg"


