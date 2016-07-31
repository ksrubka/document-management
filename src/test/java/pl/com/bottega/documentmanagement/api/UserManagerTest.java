package pl.com.bottega.documentmanagement.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import pl.com.bottega.documentmanagement.domain.Employee;
import pl.com.bottega.documentmanagement.domain.EmployeeId;
import pl.com.bottega.documentmanagement.domain.repositories.EmployeeRepository;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Beata Iłowiecka on 31.07.2016.
 */

@RunWith(MockitoJUnitRunner.class)
public class UserManagerTest {

    @Mock
    private EmployeeId anyEmployeId;
    @Mock
    private PasswordHasher passwordHasher;
    @Mock
    private EmployeeFactory employeeFactory;
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private Employee anyEmploye;

    private String occupiedLogin = "occupied login";
    private String availableLogin = "available login";
    private String anyPassword = "test";

    @Test
    public void shouldFailSignUpWhenLoginIsOccupied() {
        //given
        UserManager userManager = new UserManager(employeeRepository, employeeFactory, passwordHasher);
        //when(employeeRepository.findByEmployeeId(anyEmployeId)).thenReturn(null);
        when(employeeRepository.isLoginOccupied(occupiedLogin)).thenReturn(true);

        //when
        SignupResultDto signupResultDto = userManager.signup(occupiedLogin, anyPassword, anyEmployeId);

        //then
        assertFalse(signupResultDto.isSuccess());
        assertEquals("login is occupied", signupResultDto.getFailureReason());
    }

    @Test
    public void shouldSignUpEmployeeWhenIdAndLoginAreAvailable() {
        //given - setup userManagera
        UserManager userManager = new UserManager(employeeRepository, employeeFactory, passwordHasher);
        //zwracaj nulowego eployee kiedy wywołasz
        when(employeeRepository.findByEmployeeId(anyEmployeId)).thenReturn(null);
        when(employeeRepository.isLoginOccupied(availableLogin)).thenReturn(false);
        when(employeeFactory.create(availableLogin, anyPassword, anyEmployeId)).thenReturn(anyEmploye);

        //when - zapewnij warunki - kiedy sie zapytamy employeeRepo po id usera - to jest dostępny
        //stwórz stringa available login
        SignupResultDto signupResultDto = userManager.signup(availableLogin, anyPassword, anyEmployeId);

        //then - assercja isSucccess
        verify(employeeRepository).save(anyEmploye);
        assertTrue(signupResultDto.isSuccess());
        assertNull(signupResultDto.getFailureReason());
    }
}