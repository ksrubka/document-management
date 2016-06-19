package pl.com.bottega.documentmanagement.domain.repositories;

import pl.com.bottega.documentmanagement.domain.Employee;
import pl.com.bottega.documentmanagement.domain.EmployeeId;

/**
 * Created by Beata Iłowiecka on 18.06.2016.
 */
public interface EmployeeRepository {

    void save(Employee employee);

    Employee findByEmployeeId(EmployeeId employeeId);

    boolean isLoginOccupied(String login);
}
