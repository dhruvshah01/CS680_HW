package edu.umb.cs680.hw05.Login;

public class User {
    private String uname;
    private EncryptedString pwd;

    public User(String uname, EncryptedString pwd){
        this.uname = uname;
        this.pwd = pwd;
    }
    public boolean comparePassword(EncryptedString pwd) {
        if (this.pwd.getPwd().equals(pwd.getPwd())) {
            return true;
        }

        return false;
    }
}
