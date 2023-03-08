package edu.umb.cs680.hw05.ModelXYZ;
import edu.umb.cs680.hw05.Login.*;
import edu.umb.cs680.hw05.PrintingFramework.*;
public class PrintJobExecutor extends edu.umb.cs680.hw05.PrintingFramework.PrintJobExecutor {
    @Override
    protected void doAuthentication(SecurityContext ctx, EncryptedString pwd) {
        if (Authenticator.authenticate(ctx, pwd)){
            System.out.println("Authenticated User");
        }else{
            throw new RuntimeException("Authentication Failed");
        }
    }

    @Override
    protected void doAccessControl() {

    }

    @Override
    protected void doPrint(PrintJob job, SecurityContext ctx, EncryptedString pwd) {
        if (ctx.getState() instanceof LoggedIn){
            job.doSomePrint();
        } else {
            System.out.println("User Not Logged In");
        }

    }

    @Override
    protected void doErrorHandling(Exception ex) {
        System.out.println("Wrong Password");
    }

    public static void main(String[] args) {

    }
}
