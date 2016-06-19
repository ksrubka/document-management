package pl.com.bottega.documentmanagement.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.com.bottega.documentmanagement.api.DocumentFlowProcess;
import pl.com.bottega.documentmanagement.api.UserManager;
import pl.com.bottega.documentmanagement.domain.DocumentNumber;
import pl.com.bottega.documentmanagement.domain.EmployeeId;

/**
 * Created by Beata Iłowiecka on 18.06.2016.
 */
public class CreateDocument {

    public static void main(String[] args) {

        //kontener czyta konfigurację - jest konfigurowalną fabryką
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] {"application.xml"});
        UserManager userManager = applicationContext.getBean("userManager", UserManager.class);
        userManager.signUp("mietek", "123456", new EmployeeId(777L));
        userManager.login("mietek", "123456");
        DocumentFlowProcess documentFlowProcess = applicationContext.getBean("documentFlowProcess", DocumentFlowProcess.class);
        DocumentNumber documentNumber = documentFlowProcess.create("my doc", "trala la");
        System.out.println(documentNumber);
    }
}
