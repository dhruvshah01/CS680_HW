package edu.umb.cs680.hw09.Login;

public class LoggedOut implements State{
    private static final LoggedOut instance = new LoggedOut();
    private LoggedOut(){
        //Empty Constructor
    }

    public static LoggedOut getInstance(){
        return instance;
    }

    public void login(EncryptedString pwd, SecurityContext ctx, User user){
        if (Authenticator.authenticate(user, pwd)){
            ctx.changeState(LoggedIn.getInstance());
        }
        else{
            throw new RuntimeException("False Password");
        }
    }

    public void logout(SecurityContext ctx){

    }

    public static void main(String[] args) {

    }
}

