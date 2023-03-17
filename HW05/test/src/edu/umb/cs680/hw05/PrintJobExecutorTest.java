package edu.umb.cs680.hw05;
import edu.umb.cs680.hw05.PrintingFramework.*;
import edu.umb.cs680.hw05.Login.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrintJobExecutorTest {

    @Test
    public void ModelABCPositiveTest(){
        PrintJob job = new PrintJob();
        EncryptedString pwd = new EncryptedString("xwz");
        User user = new User("dhruvshah01", pwd);
        SecurityContext ctx = new SecurityContext(user);
        ctx.login(pwd, user);
        PrintJobExecutor printJobExecutor = new edu.umb.cs680.hw05.ModelABC.PrintJobExecutor();
        try {
            assertTrue(printJobExecutor.execute(job, ctx, pwd, user));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void ModelABCNegativeTest(){
        PrintJob job = new PrintJob();

        EncryptedString pwd = new EncryptedString("xyz");
        User user = new User("dhruvshah01", pwd);
        SecurityContext ctx = new SecurityContext(user);
        PrintJobExecutor printJobExecutor = new edu.umb.cs680.hw05.ModelABC.PrintJobExecutor();
        try {
            assertTrue(printJobExecutor.execute(job, null, null, null));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void ModelXYZPositiveTest(){
        PrintJob job = new PrintJob();

        EncryptedString pwd = new EncryptedString("xyz");
        User user = new User("dhruvshah01", pwd);
        SecurityContext ctx = new SecurityContext(user);
        ctx.login(pwd, user);
        PrintJobExecutor printJobExecutor = new edu.umb.cs680.hw05.ModelXYZ.PrintJobExecutor();
        try {
            assertTrue(printJobExecutor.execute(job, ctx, pwd, user));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void ModelXYZNegativeTest(){
        PrintJob job = new PrintJob();

        EncryptedString pwd = new EncryptedString("xyz");
        User user = new User("dhruvshah01", pwd);
        SecurityContext ctx = new SecurityContext(user);
        PrintJobExecutor printJobExecutor = new edu.umb.cs680.hw05.ModelXYZ.PrintJobExecutor();
        try {
            assertFalse(printJobExecutor.execute(job, null, null, null));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
