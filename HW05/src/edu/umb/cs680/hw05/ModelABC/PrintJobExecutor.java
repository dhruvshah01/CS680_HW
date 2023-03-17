package edu.umb.cs680.hw05.ModelABC;
import edu.umb.cs680.hw05.Login.*;
import edu.umb.cs680.hw05.PrintingFramework.*;
public class PrintJobExecutor extends edu.umb.cs680.hw05.PrintingFramework.PrintJobExecutor{
    @Override
    protected void doAuthentication(User user, EncryptedString pwd) {

    }

    @Override
    protected void doAccessControl() {

    }

    @Override
    protected void doPrint(PrintJob job, SecurityContext ctx, EncryptedString pwd, User user) {
        job.doSomePrint();
    }

    @Override
    protected void doErrorHandling(Exception ex) {

    }

    public static void main(String[] args) {

    }
}
