package com.training.springcore.config;

import com.training.springcore.model.ApplicationInfo;
import com.training.springcore.service.CaptorService;
import com.training.springcore.service.CaptorServiceImpl;
import com.training.springcore.service.SiteService;
import com.training.springcore.service.SiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.util.Set;



@Configuration
@PropertySource("classpath:application.properties")
@Profile("!prod")
public class BigCorpApplicationDevConfig {

    @Autowired
    private Environment environment;

    @Bean
    public ApplicationInfo applicationInfo() {
        String name = environment.getRequiredProperty("bigcorp.name");
        Integer version = environment.getRequiredProperty("bigcorp.version", Integer.class);
        Set<String> emails = environment.getRequiredProperty("bigcorp.emails", Set.class);
        String webSiteUrl = environment.getRequiredProperty("bigcorp.webSiteUrl");

        return new ApplicationInfo(name, version, emails, webSiteUrl);
    }

    public SiteService siteService() {
        return new SiteServiceImpl(captorService());
    }


    public CaptorService captorService() {
        return new CaptorServiceImpl();
    }
}
