package com.training.springcore;



import com.training.springcore.config.BigCorpApplicationConfig;
import com.training.springcore.model.ApplicationInfo;
import com.training.springcore.service.SiteService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class BigCorpApplication {

    public static void main(String[] args) {
        BigCorpApplication application = new BigCorpApplication();
        application.run();
    }

    public void run() {
        /* Avec la variable environnement */
        //ApplicationContext context = new AnnotationConfigApplicationContext(BigCorpApplicationConfig.class);


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod");
        context.registerBean(BigCorpApplicationConfig.class);
        context.refresh();

        ApplicationInfo applicationInfo = context.getBean(ApplicationInfo.class);

        System.out.println("==========================================================");
        System.out.println("Application [" + applicationInfo.getName() + "] - version : "
                + applicationInfo.getVersion());
        System.out.println("plus d'informations sur " + applicationInfo.getWebSiteUrl());
        System.out.println("==========================================================");

        SiteService siteService = context.getBean(SiteService.class);
        System.out.println(siteService.findById("siteA"));


        SiteService siteService1 = context.getBean(SiteService.class);
        System.out.println(siteService1.findById("siteA"));

    }
}
