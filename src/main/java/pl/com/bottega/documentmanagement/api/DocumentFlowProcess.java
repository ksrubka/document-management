package pl.com.bottega.documentmanagement.api;

import pl.com.bottega.documentmanagement.domain.DocumentNumber;

/**
 * Created by Beata Iłowiecka on 12.06.2016.
 */
public class DocumentFlowProcess {

    public DocumentNumber create(String title, String content) {
        return null;
    }

    public void change(DocumentNumber docNr, String title, String newContent) {
    }

    public void verify(DocumentNumber docNr) {
    }

    public void publish(DocumentNumber docNr) {
    }

    public void archive(DocumentNumber documentNumber) {
    }

    public DocumentNumber createNewVersion(DocumentNumber docNr) {
        return null;
    }
}
