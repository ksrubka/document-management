package pl.com.bottega.documentmanagement.domain.repositories;

import pl.com.bottega.documentmanagement.domain.Document;
import pl.com.bottega.documentmanagement.domain.DocumentNumber;

public interface DocumentRepository {

    void save(Document document);

    Document load(DocumentNumber documentNumber);

}
