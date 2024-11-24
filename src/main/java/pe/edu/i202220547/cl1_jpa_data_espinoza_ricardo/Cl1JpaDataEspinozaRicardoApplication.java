package pe.edu.i202220547.cl1_jpa_data_espinoza_ricardo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202220547.cl1_jpa_data_espinoza_ricardo.Entity.Country;
import pe.edu.i202220547.cl1_jpa_data_espinoza_ricardo.repository.CountryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class Cl1JpaDataEspinozaRicardoApplication implements CommandLineRunner {
	@Autowired
	CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataEspinozaRicardoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		/*ifPresentOrElse
		* */
//		Optional<Country> optional=countryRepository.findById("ARG");
//		optional.ifPresentOrElse(
//				(country) ->{
//					country.getCountryLanguages().forEach(System.out::println);
//				},
//				() -> {
//					System.out.println("No hay Resultados");
//				}
//
//		);
//
//		/*deleteAllbyId()
//		* */
//		List<String>  ids= List.of("COL","ARG");
//				ids.stream().filter((country)->{
//					return countryRepository.existsById(country);
//				}
//		).collect(Collectors.toList());
//		if(!ids.isEmpty()) {
//			countryRepository.deleteAllById(ids);
//		}else {
//			System.out.println("datos no existeen bd");
//		}

	}
}
