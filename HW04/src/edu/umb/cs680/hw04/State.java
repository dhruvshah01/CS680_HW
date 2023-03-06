package edu.umb.cs680.hw04;

public interface State {
    void login(SecurityContext ctx, EncryptedString pwd);
    void logout(SecurityContext ctx);
}
