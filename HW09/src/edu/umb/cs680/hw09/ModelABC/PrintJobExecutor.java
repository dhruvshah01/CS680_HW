package edu.umb.cs680.hw09.ModelABC;
import edu.umb.cs680.hw09.Login.*;
import edu.umb.cs680.hw09.PrintingFramework.*;
public class PrintJobExecutor extends edu.umb.cs680.hw09.PrintingFramework.PrintJobExecutor {
    @Override
    protected void doAuthentication(User user, EncryptedString pwd) throws Exception{
        if (Authenticator.authenticate(user, pwd)){
            System.out.println("Authenticated User");
        }
    }

    @Override
    protected void doAccessControl() {

    }

    @Override
    protected void doPrint(PrintJob job, SecurityContext ctx, EncryptedString pwd, User user) throws Exception {
        doAuthentication(user, pwd);
        if (ctx.getState() instanceof LoggedIn){
            job.execute();
        } else {

        }

    }

    @Override
    protected void doErrorHandling(Exception ex) {
        System.out.println("Wrong Password");
    }

    public static void main(String[] args) {

    }
}
