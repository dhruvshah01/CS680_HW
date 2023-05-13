package edu.umb.cs680.hw09;
import edu.umb.cs680.hw09.PrintingFramework.*;
import edu.umb.cs680.hw09.Login.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrintJobExecutorTest {

    @Test
    public void ModelABCPositiveTest(){
        PrintJob job = new PrintJob();

        EncryptedString pwd = new EncryptedString("xyz");
        User user = new User("dhruvshah01", pwd);
        SecurityContext ctx = new SecurityContext(user);
        ctx.login(pwd, user);
        PrintJobExecutor printJobExecutor = new edu.umb.cs680.hw09.ModelABC.PrintJobExecutor();
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
        PrintJobExecutor printJobExecutor = new edu.umb.cs680.hw09.ModelABC.PrintJobExecutor();
        try {
            assertFalse(printJobExecutor.execute(job, null, null, null));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
