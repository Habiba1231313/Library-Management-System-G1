package Testing;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import Model.LibraryAdmin;
import Model.MembershipApplication;
import Model.MembershipCard;

public class RegistrationResponseTimeTest implements JavaSamplerClient {

    private LibraryAdmin admin;

    @Override
    public void setupTest(JavaSamplerContext context) {
        admin = LibraryAdmin.getInstance();
    }

    @Override
    public SampleResult runTest(JavaSamplerContext context) {
        SampleResult result = new SampleResult();
        result.sampleStart(); // Start timing

        try {
            // Simulate a single registration
            String name = "RTUser" + System.currentTimeMillis();
            String address = "Doha, Qatar";
            MembershipApplication app = new MembershipApplication(name, address);

            // Perform registration
            MembershipCard card = admin.registerNewMember(app);

            if (card != null) {
                result.setSuccessful(true);
                result.setResponseMessage("Registration completed under 3 seconds: " + name);
                result.setResponseCodeOK();
            } else {
                result.setSuccessful(false);
                result.setResponseMessage("Registration failed for: " + name);
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

    @Override
    public void teardownTest(JavaSamplerContext context) {
        // Nothing to clean up
    }

    @Override
    public Arguments getDefaultParameters() {
        return new Arguments();
    }
}
