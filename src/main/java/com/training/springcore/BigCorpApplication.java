package com.training.springcore;


import com.training.springcore.model.Captor;
import com.training.springcore.model.MeasureStep;
import com.training.springcore.service.SiteService;
import com.training.springcore.service.measure.FixedMeasureService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class BigCorpApplication {

    public static void main(String[] args) {
        BigCorpApplication application = new BigCorpApplication();
        application.run();
    }

    public void run() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BigCorpApplicationConfig.class);
        System.out.println("Application startup");

        SiteService siteService = context.getBean(SiteService.class);
        System.out.println(siteService.findById("siteA"));

        SiteService siteService1 = context.getBean(SiteService.class);
        System.out.println(siteService1.findById("siteA"));

        FixedMeasureService fixedService = context.getBean(FixedMeasureService.class);
        System.out.println(fixedService.toString());
  


    }
}
