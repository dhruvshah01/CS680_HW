package edu.umb.cs680.hw09.PrintingFramework;
import edu.umb.cs680.hw09.Login.*;
abstract public class PrintJobExecutor {
    public boolean execute(PrintJob job, SecurityContext ctx, EncryptedString pwd, User user) throws Exception {
        try{
            doAuthentication(user, pwd);
            doAccessControl();
            doPrint(job, ctx, pwd, user);
        } catch (Exception ex){
            doErrorHandling(ex);
            return false;
        }
        return true;
    }

    protected abstract void doAuthentication(User user, EncryptedString pwd) throws Exception;
    protected abstract void doAccessControl();
    protected abstract void doPrint(PrintJob job, SecurityContext ctx, EncryptedString pwd, User user) throws Exception;
    protected abstract void doErrorHandling(Exception ex);

    public static void main(String[] args) {

    }
}
