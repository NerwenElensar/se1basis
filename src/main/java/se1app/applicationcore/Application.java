package se1app.applicationcore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

	// @Bean
	// CommandLineRunner init(CustomerRepository customerRepository) {
	// return (evt) -> Arrays.asList(
	// "mueller,meier,schulze".split(","))
	// .forEach(
	// a -> {
	// customerRepository.save(new Customer(a));
	// });
	// }

	@Bean
	CommandLineRunner init(SpielRepository spieRepository) {
		Spiel spiel = new Spiel("Spiel Eins", "SuperTypen", "normal");
		List<String> list = Arrays.asList("Luke,Lea,Han,DarthVader".split(","));
		list.forEach(t -> {
			spiel.addTeilnehmer(new Teilnehmer(t));
		});
		spiel.addRunde(10);
		spiel.getRunden().forEach(runde -> {
			runde.addWuerfe(10);
		});
		return evt -> spieRepository.save(spiel);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
