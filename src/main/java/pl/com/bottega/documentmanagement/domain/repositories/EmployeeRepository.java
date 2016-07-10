package pl.com.bottega.documentmanagement.domain.repositories;

import pl.com.bottega.documentmanagement.domain.Employee;
import pl.com.bottega.documentmanagement.domain.EmployeeId;

public interface EmployeeRepository {

    void save(Employee employee);

    Employee findByEmployeeId(EmployeeId employeeId);

    boolean isLoginOccupied(String login);

    Employee findByLoginAndPassword(String login, String hashedPassword);
}
