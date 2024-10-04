package br.com.aluno.screenmatch;

import br.com.aluno.screenmatch.model.DadosEpisodio;
import br.com.aluno.screenmatch.model.DadosSerie;
import br.com.aluno.screenmatch.service.ConsumoAPI;
import br.com.aluno.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args){
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ConsumoAPI consumo = new ConsumoAPI();
		var json = consumo
				.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=82df851d");
		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

		System.out.println(" === // ===");

		json = consumo.obterDados("https://www.omdbapi.com/?t=gilmore+girls&Season=1&Episodes=1&apikey=82df851d");
		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio);

	}
}
