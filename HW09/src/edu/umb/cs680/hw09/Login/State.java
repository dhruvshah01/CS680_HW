package edu.umb.cs680.hw09.Login;

public interface State {
    void login(EncryptedString pwd, SecurityContext ctx, User user);
    void logout(SecurityContext ctx);

    public static void main(String[] args) {

    }
}
