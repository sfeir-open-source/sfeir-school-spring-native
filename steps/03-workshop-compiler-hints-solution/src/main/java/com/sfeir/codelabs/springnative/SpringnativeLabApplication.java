package com.sfeir.codelabs.springnative;

import com.sfeir.codelabs.springnative.config.CompilerHints;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

@SpringBootApplication
@ImportRuntimeHints(CompilerHints.class)
public class SpringnativeLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringnativeLabApplication.class, args);
	}

}
