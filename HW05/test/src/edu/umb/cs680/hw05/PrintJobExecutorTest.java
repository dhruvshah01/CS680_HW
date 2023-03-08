package edu.umb.cs680.hw05;
import edu.umb.cs680.hw05.PrintingFramework.*;
import edu.umb.cs680.hw05.Login.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrintJobExecutorTest {
    @Test
    public void ModelABCTest(){
        PrintJob job = new PrintJob();
        User user = new User("dhruvshah01");
        EncryptedString pwd = new EncryptedString("xyz");
        SecurityContext ctx = new SecurityContext(user, pwd);
        PrintJobExecutor printJobExecutor = new edu.umb.cs680.hw05.ModelABC.PrintJobExecutor();
        printJobExecutor.execute(job, ctx, pwd);
    }

    @Test
    public void ModelXYZPositiveTest(){
        PrintJob job = new PrintJob();
        User user = new User("dhruvshah01");
        EncryptedString pwd = new EncryptedString("xyz");
        SecurityContext ctx = new SecurityContext(user, pwd);
        ctx.login(pwd);
        PrintJobExecutor printJobExecutor = new edu.umb.cs680.hw05.ModelXYZ.PrintJobExecutor();
        printJobExecutor.execute(job, ctx, pwd);
    }

    @Test
    public void ModelXYZNegativeTest(){
        PrintJob job = new PrintJob();
        User user = new User("dhruvshah01");
        EncryptedString pwd = new EncryptedString("xyz");
        SecurityContext ctx = new SecurityContext(user, pwd);
        PrintJobExecutor printJobExecutor = new edu.umb.cs680.hw05.ModelXYZ.PrintJobExecutor();
        printJobExecutor.execute(job, null, null);
    }

}
