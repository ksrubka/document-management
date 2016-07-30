package pl.com.bottega.documentmanagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Beata Iłowiecka on 30.07.2016.
 */

@Entity
public class Tag {

    @Id
    @GeneratedValue
    private Long id;
    private  String name;

    public Tag(String name) {
        this.name = name;
    }

    public Tag() {
    }
}
