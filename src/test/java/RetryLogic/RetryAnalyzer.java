package listeners;


import org.testng.IRetryAnalyzer;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int MAX_RETRY_COUNT = 3; // Define the maximum number of retries

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess() && retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            return true; // Retry the test if it has failed
        }
        return false; // Stop retrying after max retries or if test passed
    }
}
