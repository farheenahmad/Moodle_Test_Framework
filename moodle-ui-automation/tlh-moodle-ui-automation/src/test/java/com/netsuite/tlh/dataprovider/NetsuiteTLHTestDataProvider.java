package com.netsuite.tlh.dataprovider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.dataprovider.BaseDataProvider;
import com.jayway.jsonpath.JsonPath;

public class NetsuiteTLHTestDataProvider {

	private static final String MAPPER_FILENAME = "src/test/resources/testdata/testdata-mapper.json";

	@DataProvider(name = "getData")
	public static Iterator<Object[]> getData(Method method) throws IOException {
		Test testAnnotation = method.getAnnotation(Test.class);
		String testDescription = testAnnotation.description();
		String testId = testDescription.split("::")[0].trim();
		String jsonQueryPath = "$.%s";
		String actualQueryPath = String.format(jsonQueryPath, testId);
		String testDataFileName = JsonPath.read(new File(MAPPER_FILENAME), actualQueryPath);
		Iterator<Object[]> testData = BaseDataProvider.getData(testDataFileName);
		return testData;
	}
}
