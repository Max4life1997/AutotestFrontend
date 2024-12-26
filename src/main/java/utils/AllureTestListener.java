package utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class AllureTestListener implements TestExecutionExceptionHandler {
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        AllureUtils.saveScreenshot();
        AllureUtils.attachLogs(throwable.getMessage());
        throw throwable;
    }
}
