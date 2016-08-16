package pl.com.bottega.documentmanagement.api;

import org.junit.Test;

public class DocumentFlowProcessTest {

    @Test
    public void shouldCreateDocumentWhenUserIsLoggedInAndHasEditorRole() {

    }

    @Test
    public void shouldNotCreateDocumentWhenUserIsLoggedInAndDoNotHaveEditorRole() {

    }

    @Test
    public void shouldNotCreateDocumentWhenUserIsNotLoggedIn() {

    }

    @Test
    public void shouldNotCreateDocumentWhenTitleIsEmpty() {

    }

    @Test
    public void shouldNotCreateDocumentWhenContentIsEmpty() {

    }

    @Test
    public void shouldChangeDocumentWhenUserIsLoggedInAndHasEditorRole() {

    }

    @Test
    public void shouldNotChangeDocumentWhenUserIsLoggedInAndDoNotHasEditorRole() {

    }

    @Test
    public void shouldNotChangeDocumentWhenUserIsNotLoggedIn() { //todo ??? czy to jest sprawdzane w Document u DocumentFlowProcess?

    }

    @Test
    public void shouldNotChangeDocumentWhenNumberIsEmpty() {

    }

    @Test
    public void shouldNotChangeDocumentWhenTitleIsEmpty() {

    }

    @Test
    public void shouldNotChangeDocumentWhenContentIsEmpty() {

    }

    @Test
    public void shouldVerifyDocumentWhenUserIsLoggedInAndHasManagerRole() {

    }

    @Test
    public void shouldNotVerifyDocumentWhenUserDoNotHaveManagerRole() {

    }

    @Test
    public void shouldNotVerifyDocumentWhenUserIsNotLoggedIn() {

    }

    @Test
    public void shouldNotVerifyDocumentWhenNumberIsNull() {
    }


    @Test
    public void shouldArchiveDocumentWhenUserIsLoggedInAndHasEditorRole() {

    }

    @Test
    public void shouldNotArchiveDocumentWhenUserDoNotHaveEditorRole() {

    }

    @Test
    public void shouldFailArchiveDocumentWhenNumberIsNull() {

    }
}
