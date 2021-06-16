package gr.uoa.di.pcomp.IncludingRESTAPI;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class IncludingRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IncludingRestapiApplication.class, args);
	}

}
