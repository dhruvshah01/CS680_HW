package edu.umb.cs680.hw05.Login;

public class Authenticator {
    public static Boolean authenticate(User user, EncryptedString pwd){
            if (user.comparePassword(pwd)){
                return true;
            }
        return false;

    }
}
