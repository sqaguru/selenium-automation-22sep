package seleniumtests;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

import org.testng.IAnnotationTransformer;
import org.testng.IExecutionListener;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.IListenersAnnotation;
import org.testng.annotations.ITestAnnotation;
import org.testng.reporters.IReporterConfig;
import org.testng.xml.XmlSuite;

public class TestNGListener implements IAnnotationTransformer, IInvokedMethodListener, ITestListener, ISuiteListener,
		IExecutionListener, IReporter {

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		IReporter.super.generateReport(xmlSuites, suites, outputDirectory);
	}

	@Override
	public IReporterConfig getConfig() {
		// TODO Auto-generated method stub
		return IReporter.super.getConfig();
	}

	@Override
	public void onExecutionStart() {
		// TODO Auto-generated method stub
		IExecutionListener.super.onExecutionStart();
	}

	@Override
	public void onExecutionFinish() {
		System.out.println("test execution finished");
		IExecutionListener.super.onExecutionFinish();
	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println("test suite started");
		ISuiteListener.super.onStart(suite);
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		IInvokedMethodListener.super.beforeInvocation(method, testResult);
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		IInvokedMethodListener.super.afterInvocation(method, testResult);
	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
		// TODO Auto-generated method stub
		IInvokedMethodListener.super.beforeInvocation(method, testResult, context);
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
		// TODO Auto-generated method stub
		IInvokedMethodListener.super.afterInvocation(method, testResult, context);
	}

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
		System.out.println(testMethod.toString());
		IAnnotationTransformer.super.transform(annotation, testClass, testConstructor, testMethod);
	}

	@Override
	public void transform(IConfigurationAnnotation annotation, Class testClass, Constructor testConstructor,
			Method testMethod) {
		// TODO Auto-generated method stub
		IAnnotationTransformer.super.transform(annotation, testClass, testConstructor, testMethod);
	}

	@Override
	public void transform(IDataProviderAnnotation annotation, Method method) {
		// TODO Auto-generated method stub
		IAnnotationTransformer.super.transform(annotation, method);
	}

	@Override
	public void transform(IFactoryAnnotation annotation, Method method) {
		// TODO Auto-generated method stub
		IAnnotationTransformer.super.transform(annotation, method);
	}

	@Override
	public void transform(IListenersAnnotation annotation, Class<?> testClass) {
		// TODO Auto-generated method stub
		IAnnotationTransformer.super.transform(annotation, testClass);
	}

}
