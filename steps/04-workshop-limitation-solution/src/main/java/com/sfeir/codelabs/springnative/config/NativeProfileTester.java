package com.sfeir.codelabs.springnative.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.logging.Logger;

@Configuration
@Profile("dev")
public class NativeProfileTester {

    public NativeProfileTester() {
        Logger.getLogger("NativeProfileTester").info("Doing some dev profile stuff");
    }
}
