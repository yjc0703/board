package board;

import org.springframework.boot.SpringApplication;

import board.config.AppConfig;
import board.config.DevConfig;

public class Application {

	public static void main(String[] args) {

		Class<?> config = AppConfig.class;

		for (String s : args) {
			if ("-d".equals(s)) {
				config = DevConfig.class;
			}
		}

		SpringApplication.run(config, args);
	}
	
	public static Class<?> getConfig() {
		return DevConfig.class;
	}
}
