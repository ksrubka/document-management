package pl.com.bottega.documentmanagement.api;

import com.google.common.collect.Iterables;
import pl.com.bottega.documentmanagement.domain.Document;
import pl.com.bottega.documentmanagement.domain.DocumentCriteria;
import pl.com.bottega.documentmanagement.domain.DocumentNumber;
import pl.com.bottega.documentmanagement.infrastructure.DocumentDto;
import pl.com.bottega.documentmanagement.infrastructure.DocumentRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Beata Iłowiecka on 12.06.2016.
 */
public class DocumentsCatalog {

    private DocumentRepository documentRepository;

    public DocumentDto get(DocumentNumber docNr) {
        checkNotNull(docNr);
        Document document = documentRepository.load(docNr);
        return document.export();
    }

    public Iterable<DocumentDto> find(DocumentCriteria documentCriteria) {
        checkNotNull(documentCriteria);
        Iterable<Document> documents = documentRepository.find(documentCriteria);
        // słaba wersja bez lambdy
        /*Collection<DocumentDto> returnValue = new ArrayList<>();
        for (Document document : documents)
            returnValue.add(document.export());
        return returnValue;*/

        //lepsza wersja z lambdą
        //return Iterables.transform(documents, (document) -> document.export());

        //jeszcze lepsza wersja - ale wszystkie działają tak samo w sensie wyniku
        return Iterables.transform(documents, Document::export);

    }
}
