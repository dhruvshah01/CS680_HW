package edu.umb.cs680.hw05.PrintingFramework;
import edu.umb.cs680.hw05.Login.*;
abstract public class PrintJobExecutor {
    public void execute(PrintJob job, SecurityContext ctx, EncryptedString pwd){
        try{
            doAuthentication(ctx, pwd);
            doAccessControl();
            doPrint(job, ctx, pwd);
        } catch (Exception ex){
            doErrorHandling(ex);
        }
    }

    protected abstract void doAuthentication(SecurityContext ctx, EncryptedString pwd);
    protected abstract void doAccessControl();
    protected abstract void doPrint(PrintJob job, SecurityContext ctx, EncryptedString pwd);
    protected abstract void doErrorHandling(Exception ex);
}
