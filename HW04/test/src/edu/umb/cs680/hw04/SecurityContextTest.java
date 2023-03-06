package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class SecurityContextTest {
    @Test
    public void validateSecurityContext(){
        String username = "dhruvshah01";
        EncryptedString pwd = new EncryptedString("xyz");
        User user = new User(username);
        SecurityContext ctx= new SecurityContext(user, pwd);
        assertTrue(ctx.getState() instanceof LoggedOut);
        ctx.login(pwd);
        assertTrue(ctx.getState() instanceof LoggedIn);
    }

    @Test
    public void validateInstanceOfLogout(){
        String username = "dhruvshah01";
        EncryptedString pwd = new EncryptedString("xyz");
        User user = new User(username);
        SecurityContext ctx= new SecurityContext(user, pwd);
        ctx.login(pwd);
        ctx.logout();
        assertEquals(true, ctx.getState() instanceof LoggedOut);
    }

    @Test
    public void validateInstanceOfLogin(){
        String username = "dhruvshah01";
        EncryptedString pwd = new EncryptedString("xyz");
        User user = new User(username);
        SecurityContext ctx= new SecurityContext(user, pwd);
        ctx.login(pwd);
        assertEquals(true, ctx.getState() instanceof LoggedIn);
    }
}
