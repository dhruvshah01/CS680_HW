package edu.umb.cs680.hw04;

public class LoggedIn implements State{
    private static final LoggedIn instance = new LoggedIn();
    private LoggedIn(){
     //Empty Constructor
    }


    public static LoggedIn getInstance(){
        return instance;
    }
    public void login(SecurityContext ctx, EncryptedString pwd){
        if (!ctx.isActive()){
            ctx.changeState(LoggedOut.getInstance());
            ctx.login(pwd);
        }
    }

    public void logout(SecurityContext ctx){
        ctx.changeState(LoggedOut.getInstance());
    }
}
