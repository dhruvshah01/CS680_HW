package edu.umb.cs680.hw04;

public class SecurityContext {
    private static State state;
    private User user;
    private EncryptedString pwd;
    private boolean active;
     public SecurityContext(User user, EncryptedString pwd){
         this.user = user;
         this.state = LoggedOut.getInstance();
         this.pwd = pwd;
         this.active = false;
     }

     public void changeState(State newState){
         state = newState;
     }

     public void login(EncryptedString pwd){
         state.login(this, pwd);
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
        User user = new User(uname);
        SecurityContext ctx = new SecurityContext(user, pwd);
        ctx.login(pwd);
        System.out.println(String.valueOf(ctx.getState() instanceof LoggedIn));
        ctx.logout();
        System.out.println(String.valueOf(ctx.getState() instanceof LoggedOut));
    }
}
