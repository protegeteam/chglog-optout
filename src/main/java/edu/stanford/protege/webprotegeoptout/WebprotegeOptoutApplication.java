package edu.stanford.protege.webprotegeoptout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WebprotegeOptoutApplication implements CommandLineRunner {

	@Autowired
	private OptOutDataRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(WebprotegeOptoutApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<OptOutItem> optOutItemList = new ArrayList<>();
		optOutItemList.add(new OptOutItem("abcde", "Test Project", false));
		optOutItemList.add(new OptOutItem("fkdkd", "Test Project 2", false));
		var optOutInfo = new OptOutInfo("123", "M Horridge", "matthew.horridge@stanford.edu", "", optOutItemList);
		repository.save(optOutInfo);
		var optOutInfo2 = new OptOutInfo("234", "Joe Bloggs", "joe.bloggs@google.com", "", optOutItemList);
		repository.save(optOutInfo2);
	}
}

