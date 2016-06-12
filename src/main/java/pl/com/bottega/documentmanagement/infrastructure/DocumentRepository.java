package pl.com.bottega.documentmanagement.infrastructure;

import pl.com.bottega.documentmanagement.domain.DocumentCriteria;
import pl.com.bottega.documentmanagement.domain.Document;
import pl.com.bottega.documentmanagement.domain.DocumentNumber;

/**
 * Created by Beata Iłowiecka on 12.06.2016.
 */
public interface DocumentRepository {

    void save(Document document);
    Document load(DocumentNumber docNr);
    Iterable<Document> find(DocumentCriteria documentCriteria);
}
