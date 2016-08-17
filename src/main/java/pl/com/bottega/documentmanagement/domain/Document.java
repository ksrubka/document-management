package pl.com.bottega.documentmanagement.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by maciuch on 12.06.16.
 */
@Entity
public class Document {

    @Id
    @GeneratedValue
    private Long id;
    private DocumentNumber documentNumber;
    private String content;
    private String title;

    private boolean deleted;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt, verifiedAt, updatedAt;

    @Enumerated(EnumType.STRING)
    private DocumentStatus status;

    @ManyToOne
    private Employee creator, verificator;

    @ManyToOne
    private Employee deletor;

    @ManyToMany(cascade=CascadeType.ALL)
    private Set<Tag> tags;

    private Document() {
    }

    public Document(DocumentNumber documentNumber, String content, String title, Employee creator) {
        this.documentNumber = documentNumber;
        this.content = content;
        this.title = title;
        this.creator = creator;
        this.status = DocumentStatus.DRAFT;
        this.createdAt = new Date();
        this.deleted = false;
    }

    public void change(String title, String content) {
        checkArgument(!title.equals(""));
        checkArgument(!content.equals(""));
        this.title = title;
        this.content = content;
        this.status = DocumentStatus.DRAFT;
        this.updatedAt = new Date();
    }

    public void verify(Employee verifier) {
        checkArgument(verifier != null);
        this.verificator = verifier;
        this.status = DocumentStatus.VERIFIED;
        this.verifiedAt = new Date();
    }

    public void tag(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Tag> tags() {
        return  tags;
    }

    public void confirm(Employee conirmator) {

    }

    public void confirm(Employee confirmator, Employee forEmployee) {

    }

    public void delete(Employee deletor) {
        checkArgument(deletor != null);
        this.deletor = deletor;
        this.deleted = true;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Document{");
        sb.append("id=").append(id);
        sb.append(", content='").append(content).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", createdAt=").append(createdAt);
        sb.append(", creator=").append(creator);
        sb.append('}' + "\n");
        return sb.toString();
    }

    public String content() {
        return content;
    }

    public String title() {
        return title;
    }

    public DocumentNumber number() {
        return documentNumber;
    }

    public boolean deleted() {
        return deleted;
    }

    public Employee deletor() {
        return deletor;
    }

    public DocumentStatus status() {
        return status;
    }

    public Employee creator() {
        return creator;
    }

    public Employee verificator() {
        return verificator;
    }

    public Date verifiedAt() {
        return verifiedAt;
    }
}
