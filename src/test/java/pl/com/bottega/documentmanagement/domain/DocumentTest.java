package pl.com.bottega.documentmanagement.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.mock;

/**
 * Created by Beata Iłowiecka on 31.07.2016.
 */

@RunWith(MockitoJUnitRunner.class)
public class DocumentTest {

    @Mock
    private DocumentNumber anyNumber;
    @Mock
    private Employee anyEmployee;

    private String content = "testowa zawartość  dokumnetu";
    private String title = "testowy tytuł gęśla jaźń";
    private String changedTitle = "changed title";
    private String changedContent = "changed content";
    private final static long EPS = 2 * 1000L;
    private Document document = new Document(anyNumber, content, title, anyEmployee);

    @Test
    public void shouldCreateDocumentWithInitialState() {
        //given
        DocumentNumber documentNumber = new DocumentNumber("testowy numer");
        Employee employee = new Employee("testowy login", "testowe hasło", new EmployeeId(123456L));

        //when
        Document document = new Document(documentNumber, content, title, employee);

        //then
        assertEquals(documentNumber, document.number());
        assertEquals(content, document.content());
        assertEquals(title, document.title());
        assertEquals(employee, document.creator());
        assertFalse(document.deleted());
        assertEquals(DocumentStatus.DRAFT, document.status());
    }

    @Test
    public void shouldCreateDocumentWithInitialStateWithMockitoMockMethod() {
        //given
        DocumentNumber documentNumber = mock(DocumentNumber.class);
        Employee employee = mock(Employee.class);

        //when
        Document document = new Document(documentNumber, content, title, employee);

        //then
        assertEquals(documentNumber, document.number());
        assertEquals(content, document.content());
        assertEquals(title, document.title());
        assertEquals(employee, document.creator());
        assertFalse(document.deleted());
        assertEquals(DocumentStatus.DRAFT, document.status());
    }

    @Test
    public void shouldCreateDocumentWithInitialStateWithMockitoMockAnnotation() {
        //given

        //when
        Document document = new Document(anyNumber, content, title, anyEmployee);

        //then
        assertEquals(anyNumber, document.number());
        assertEquals(content, document.content());
        assertEquals(title, document.title());
        assertEquals(anyEmployee, document.creator());
        assertFalse(document.deleted());
        assertEquals(DocumentStatus.DRAFT, document.status());
    }

    @Test
    public void shouldVerifyDocument() {
        //given - have document and verifier

        //when - verify document
        document.verify(anyEmployee);

        //then - check if its verified
        assertEquals(DocumentStatus.VERIFIED, document.status());
        assertEquals(anyEmployee, document.verificator());
        assertTrue(Math.abs(new Date().getTime() - document.verifiedAt().getTime()) < EPS);
    }

    @Test
    public void shouldFailVerifyingDocumentWithoutVerificator() {
        try {
            document.verify(null);
        } catch (IllegalArgumentException ex) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    @Test
    public void shouldEditDocument() {
        document.change(changedTitle, changedContent);
        assertEquals(changedTitle, document.title());
        assertEquals(changedContent, document.content());
    }

    @Test
    public void shouldFailChangingDocumentGivingEmptyTitle() {
        try {
            document.change("", changedContent);
        } catch (IllegalArgumentException ex) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    @Test
    public void shouldFailChangingDocumentGivingEmptyContent() {
        try {
            document.change(changedTitle, "");
        } catch (IllegalArgumentException ex) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    @Test
    public void shouldFailChangingDocumentGivingEmptyTitleAndContent() {
        try {
            document.change("", "");
        } catch (IllegalArgumentException ex) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    @Test
    public void shouldDeleteDocument() {
        document.delete(anyEmployee);
        assertTrue(document.deleted());
        assertEquals(anyEmployee, document.deletor());
    }

    @Test
    public void shouldFailDeletingDocumentWithoutDeletor() {
        try {
            document.delete(null);
        } catch (IllegalArgumentException ex) {
            return;
        }
        fail("IllegalArgumentException expected");
    }
}
