package edu.umb.cs680.hw05.Login;

public class EncryptedString {
    private String pwd;
    public EncryptedString(String pwd){
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }
}