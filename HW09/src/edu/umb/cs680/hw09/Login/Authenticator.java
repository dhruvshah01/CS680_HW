package edu.umb.cs680.hw09.Login;

public class Authenticator {
    public static Boolean authenticate(User user, EncryptedString pwd){
            if (user.comparePassword(pwd)){
                return true;
            }
        return false;

    }

    public static void main(String[] args) {

    }
}
