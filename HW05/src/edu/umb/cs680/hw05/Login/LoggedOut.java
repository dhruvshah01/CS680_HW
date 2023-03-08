package edu.umb.cs680.hw05.Login;

public class LoggedOut implements State{
    private static final LoggedOut instance = new LoggedOut();
    private LoggedOut(){
        //Empty Constructor
    }

    public static LoggedOut getInstance(){
        return instance;
    }

    public void login(SecurityContext ctx, EncryptedString pwd){
        if (Authenticator.authenticate(ctx, pwd)){
            ctx.changeState(LoggedIn.getInstance());
        }
        else{
            throw new RuntimeException("False Password");
        }
    }

    public void logout(SecurityContext ctx){

    }
}

