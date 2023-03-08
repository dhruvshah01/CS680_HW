package edu.umb.cs680.hw05.Login;

public interface State {
    void login(SecurityContext ctx, EncryptedString pwd);
    void logout(SecurityContext ctx);
}
