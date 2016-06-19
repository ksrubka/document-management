package pl.com.bottega.documentmanagement.domain;

import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Beata Iłowiecka on 18.06.2016.
 */
@Service
public class ISODocumentNumberGenerator implements DocumentNumberGenerator {

    @Override
    public DocumentNumber generate() {
        return new DocumentNumber("ISO-" + UUID.randomUUID().toString());
    }
}
