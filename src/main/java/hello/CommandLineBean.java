package hello;

import java.util.List;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CommandLineBean {
	private final ApplicationArguments arguments;

	public CommandLineBean(ApplicationArguments applicationArguments) {
		this.arguments = applicationArguments;
	}
	
	@PostConstruct
	public void init() {
		log.info("source = {}", List.of(arguments.getSourceArgs()));
		log.info("optionNames = {}", List.of(arguments.getOptionNames()));
		Set<String> optionNames = arguments.getOptionNames();
		for (String optionName : optionNames) {
			log.info("option {} = {}", optionName, arguments.getOptionValues(optionName));
		}
	}
}

