package edu.umb.cs680.hw05.Login;

public class SecurityContext {
    private static State state;
    private User user;
    private EncryptedString pwd;
    private boolean active;
    public SecurityContext(User user){
        this.user = user;
        this.state = LoggedOut.getInstance();

    }

    public void changeState(State newState){
        state = newState;
    }

    public void login(EncryptedString pwd, User user){
        state.login(pwd, this, user);
    }

    public void logout(){
        state.logout(this);
    }

    public boolean isActive(){
        return this.active;
    }

    public static State getState(){
        return state;
    }

    public static void main(String[] args) {
        String uname = "dhruvshah01";
        EncryptedString pwd = new EncryptedString("xyz");
        User user = new User(uname, pwd);
        SecurityContext ctx = new SecurityContext(user);
        ctx.login(pwd, user);
        System.out.println(String.valueOf(ctx.getState() instanceof LoggedIn));
        ctx.logout();
        System.out.println(String.valueOf(ctx.getState() instanceof LoggedOut));
    }
}
