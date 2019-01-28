package com.framework.dataprovider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;

import net.minidev.json.JSONArray;

import com.framework.exceptions.NoDataAvailableInFile;
import com.jayway.jsonpath.JsonPath;

public class BaseDataProvider {
	public static Iterator<Object[]> getData(String filePath) throws IOException {
		JSONArray jsonArray = JsonPath.parse(new File(filePath)).json();
		Collection<Object[]> finalData = new ArrayList<Object[]>();
		Iterator<?> it = jsonArray.iterator();
		while (it.hasNext()) {
			finalData.add(new Object[] { it.next() });
		}
		return finalData.iterator();
	}

	public static LinkedHashMap<String, ?> getDataAsMap(String filePath) throws IOException, NoDataAvailableInFile {
		Iterator<Object[]> testData = BaseDataProvider.getData(filePath);
		LinkedHashMap<String, ?> dataMap = null;
		if (testData.hasNext()) {
			Object[] testData1 = testData.next();
			dataMap = (LinkedHashMap<String, ?>) testData1[0];
		} else {
			throw new NoDataAvailableInFile("No data available in given file :" + filePath);
		}

		return dataMap;
	}
}
