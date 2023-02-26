package utils;

import lombok.SneakyThrows;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static utils.AllureLogger.attachScreenshot;

public class UiTestListener extends TestListenerAdapter {

    @SneakyThrows
    @Override
    public void onTestSuccess(ITestResult result) {
        attachScreenshot();
    }

    @SneakyThrows
    @Override
    public void onTestSkipped(ITestResult result) {
        attachScreenshot();
    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {
        attachScreenshot();
    }
}