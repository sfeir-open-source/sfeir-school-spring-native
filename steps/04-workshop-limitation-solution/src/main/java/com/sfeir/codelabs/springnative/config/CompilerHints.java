package com.sfeir.codelabs.springnative.config;

import com.sfeir.codelabs.springnative.http.HeatlhSpringResource;
import com.sfeir.codelabs.springnative.service.MessageService;
import org.springframework.aop.SpringProxy;
import org.springframework.aop.framework.Advised;
import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.core.DecoratingProxy;

import java.lang.reflect.Method;

public class CompilerHints implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        //step 1 : http interface
        hints.proxies().registerJdkProxy(HeatlhSpringResource.class, SpringProxy.class, Advised.class, DecoratingProxy.class);
        //step 2 : reflection
        try {
            Class<?> messageServiceClass = Class.forName(MessageService.class.getName());
            Method method = messageServiceClass.getDeclaredMethod("secretMessage");
            hints.reflection().registerMethod(method, ExecutableMode.INVOKE);
            hints.reflection().registerConstructor(messageServiceClass.getDeclaredConstructor(), ExecutableMode.INVOKE);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            System.err.println("Error while registering reflection hints: " + e.getMessage());
        }
        //step 3 : resource
        hints.resources().registerPattern("test.txt");
    }
}
