package pl.com.bottega.documentmanagement.domain;

import pl.com.bottega.documentmanagement.infrastructure.DocumentDto;

/**
 * Created by Beata Iłowiecka on 12.06.2016.
 */
public class Document {

    public Document(DocumentNumber docNr, String title, String content) {

    }

    public void change(String newTitle, String newContent) {

    }

    public void verify(Employee employee) {

    }

    public DocumentDto export() {
        DocumentDto dto = new DocumentDto();
        //tu przepakowanie seterami i geterami pól document na dto
        return dto;
    }
}
