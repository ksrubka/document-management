package pl.com.bottega.documentmanagement.api;

/**
 * Created by Beata Iłowiecka on 30.07.2016.
 */
public class DocumentSearchResults {

    private Iterable<DocumentDto> documents;
    private int perPage, pageNumber, totalPages;

    public DocumentSearchResults(Iterable<DocumentDto> documents,
                                 int perPage,
                                 int pageNumber,
                                 int totalPages) {
        this.documents = documents;
        this.perPage = perPage;
        this.pageNumber = pageNumber;
        this.totalPages = totalPages;
    }

    public Iterable<DocumentDto> getDocuments() {
        return documents;
    }

    public void setDocuments(Iterable<DocumentDto> documents) {
        this.documents = documents;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
