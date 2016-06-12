package pl.com.bottega.documentmanagement.api;

import pl.com.bottega.documentmanagement.domain.Document;
import pl.com.bottega.documentmanagement.domain.DocumentNumber;
import pl.com.bottega.documentmanagement.domain.DocumentNumberGenerator;
import pl.com.bottega.documentmanagement.infrastructure.DocumentRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Beata Iłowiecka on 12.06.2016.
 */
public class DocumentFlowProcess {

    private DocumentNumberGenerator documentNumberGenerator;
    private DocumentRepository documentRepository;
    private UserManager userManager;

    public DocumentNumber create(String title, String content) {
        //todo walidacja długości i innych właściwości parametrów
        checkNotNull(title);
        checkNotNull(content);
        DocumentNumber docNr = documentNumberGenerator.generate();
        Document document = new Document(docNr, title, content);
        documentRepository.save(document);
        return docNr;
    }

    public void change(DocumentNumber docNr, String newTitle, String newContent) {
        checkNotNull(docNr);
        checkNotNull(newTitle);
        checkNotNull(newContent);
        Document document = documentRepository.load(docNr);
        document.change(newTitle, newContent);
        documentRepository.save(document);
    }

    public void verify(DocumentNumber docNr) {
        checkNotNull(docNr);
        Document document = documentRepository.load(docNr);
        documentRepository.save(document);
    }

    public void publish(DocumentNumber docNr) {
        checkNotNull(docNr);
        Document document = documentRepository.load(docNr);
        document.verify(userManager.currentEmployee());
        documentRepository.save(document);
    }

    public void archive(DocumentNumber docNr) {
        checkNotNull(docNr);
    }

    public DocumentNumber createNewVersion(DocumentNumber docNr) {
        checkNotNull(docNr);
        return null;
    }
}
