package pl.com.bottega.documentmanagement.api;

import pl.com.bottega.documentmanagement.domain.DocumentNumber;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Beata Iłowiecka on 12.06.2016.
 */
public class DocumentFlowProcess {

    public DocumentNumber create(String title, String content) {
        //todo walidacja długości i innych właściwości parametrów
        checkNotNull(title);
        checkNotNull(content);
        return null;
    }

    public void change(DocumentNumber docNr, String newTitle, String newContent) {
        checkNotNull(docNr);
        checkNotNull(newTitle);
        checkNotNull(newContent);
    }

    public void verify(DocumentNumber docNr) {
        checkNotNull(docNr);
    }

    public void publish(DocumentNumber docNr) {
        checkNotNull(docNr);
    }

    public void archive(DocumentNumber docNr) {
        checkNotNull(docNr);
    }

    public DocumentNumber createNewVersion(DocumentNumber docNr) {
        checkNotNull(docNr);
        return null;
    }
}
