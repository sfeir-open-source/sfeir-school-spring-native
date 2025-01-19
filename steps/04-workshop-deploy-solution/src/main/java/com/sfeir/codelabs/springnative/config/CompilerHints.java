package com.sfeir.codelabs.springnative.config;

import com.sfeir.codelabs.springnative.http.HeatlhSpringResource;
import org.springframework.aop.SpringProxy;
import org.springframework.aop.framework.Advised;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.core.DecoratingProxy;

public class CompilerHints implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        //step 1 : http interface
        hints.proxies().registerJdkProxy(HeatlhSpringResource.class, SpringProxy.class, Advised.class, DecoratingProxy.class);
        //step 2 :
    }
}
