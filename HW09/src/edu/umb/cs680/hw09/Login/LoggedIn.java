package edu.umb.cs680.hw09.Login;

public class LoggedIn implements State{
    private static final LoggedIn instance = new LoggedIn();
    private LoggedIn(){
        //Empty Constructor
    }


    public static LoggedIn getInstance(){
        return instance;
    }
    public void login(EncryptedString pwd, SecurityContext ctx, User user){
        if (!ctx.isActive()){
            ctx.changeState(LoggedOut.getInstance());
            ctx.login(pwd, user);
        }
    }

    public void logout(SecurityContext ctx){
        ctx.changeState(LoggedOut.getInstance());
    }

    public static void main(String[] args) {

    }
}
