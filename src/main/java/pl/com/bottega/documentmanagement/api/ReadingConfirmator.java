package pl.com.bottega.documentmanagement.api;

import pl.com.bottega.documentmanagement.domain.DocumentNumber;
import pl.com.bottega.documentmanagement.domain.Employee;

/**
 * Created by Beata Iłowiecka on 12.06.2016.
 */
public class ReadingConfirmator {

    public void confirm(DocumentNumber documentNumber) {
    }

    public void confirmFor(DocumentNumber documentNumber, Employee forEmployee) {
        //user potwierdzający forEmployee  będzie brany z bieżącej sesji dlatego nie dajemy go do parametrów
    }
}
