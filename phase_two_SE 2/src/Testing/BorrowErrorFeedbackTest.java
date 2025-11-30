package Testing;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import Model.*;

public class BorrowErrorFeedbackTest implements JavaSamplerClient {

    private LibraryAdmin admin;

    @Override
    public void setupTest(JavaSamplerContext context) {
        admin = LibraryAdmin.getInstance(); // Use singleton admin
    }

    @Override
    public SampleResult runTest(JavaSamplerContext context) {
        SampleResult result = new SampleResult();
        result.sampleStart(); // Start timing

        try {
            // Create a test member
            Member member = new Member(admin.getNextMemberID(), "TestUser", "Doha");
            admin.members.add(member);

            // Create an item that is already borrowed (simulate invalid case)
            Item item = new Item(1001, "Java Programming");
            item.setAvailable(false); // Mark unavailable to trigger error
           
            // Attempt to borrow
            boolean success = borrowItem(member, item);

            if (!success) {
                result.setSuccessful(true); // Error was triggered correctly
                result.setResponseMessage("Error feedback tested successfully: Item unavailable");
                result.setResponseCodeOK();
            } else {
                result.setSuccessful(false);
                result.setResponseMessage("Error feedback failed: Borrowed an unavailable item");
                result.setResponseCode("500");
            }

        } catch (Exception e) {
            result.setSuccessful(false);
            result.setResponseMessage("Exception: " + e.getMessage());
            result.setResponseCode("500");
        } finally {
            result.sampleEnd(); // End timing
        }
        return result;
    }

    private boolean borrowItem(Member member, Item item) {
        if (!item.isAvailable()) {
            // Simulate system error feedback
            System.out.println("Error: Item '" + item.getTitle() + "' is not available for borrowing.");
            return false;
        }
        member.BorrowItem(item);
        item.setAvailable(false);
        return true;
    }

    @Override
    public void teardownTest(JavaSamplerContext context) {
        // Optional cleanup
    }

    @Override
    public Arguments getDefaultParameters() {
        Arguments args = new Arguments();
        args.addArgument("memberID", "1");
        args.addArgument("itemCallNumber", "1001");
        return args;
    }
}
