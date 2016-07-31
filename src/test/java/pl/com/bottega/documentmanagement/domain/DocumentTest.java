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
        Document document = new Document(anyNumber, content, title, anyEmployee);

        //when - verify document
        document.verify(anyEmployee);

        //then - check if its verified
        assertEquals(DocumentStatus.VERIFIED, document.status());
        assertEquals(anyEmployee, document.verificator());
        assertNotNull(document.verifiedAt());
    }
}
