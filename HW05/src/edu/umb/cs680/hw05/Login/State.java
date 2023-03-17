package edu.umb.cs680.hw05.Login;

public interface State {
    void login(EncryptedString pwd, SecurityContext ctx, User user);
    void logout(SecurityContext ctx);
}
