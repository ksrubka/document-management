package pl.com.bottega.documentmanagement.api;

import pl.com.bottega.documentmanagement.domain.DocumentNumber;
import pl.com.bottega.documentmanagement.domain.Employee;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Beata Iłowiecka on 12.06.2016.
 */
public class ReadingConfirmator {

    public void confirm(DocumentNumber docNr) {
        checkNotNull(docNr);
    }

    public void confirmFor(DocumentNumber docNr, Employee forEmployee) {
        checkNotNull(docNr);
        checkNotNull(forEmployee);
        //user potwierdzający forEmployee będzie brany z bieżącej sesji dlatego nie dajemy go do parametrów
    }
}
