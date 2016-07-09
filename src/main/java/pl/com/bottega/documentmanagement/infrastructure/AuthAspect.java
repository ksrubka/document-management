package pl.com.bottega.documentmanagement.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.documentmanagement.api.AuthRequiredException;
import pl.com.bottega.documentmanagement.api.UserManager;

/**
 * Created by Beata Iłowiecka on 09.07.2016.
 */
@Component("misio")
public class AuthAspect {

    private UserManager userManager;

    public AuthAspect(UserManager userManager) {
        this.userManager = userManager;
    }

    public void checkAuthentication() {
        if(!userManager.isAuthenticated()){
            throw new AuthRequiredException();
        }
    }
}
