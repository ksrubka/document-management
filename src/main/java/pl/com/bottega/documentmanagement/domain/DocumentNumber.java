package pl.com.bottega.documentmanagement.domain;

import javax.persistence.Embeddable;

/**
 * Created by maciuch on 12.06.16.
 */
@Embeddable
public class DocumentNumber {

    private String number;

    public DocumentNumber(String number) {
        this.number = number;
    }

    public String toString() {
        return number;
    }

}
