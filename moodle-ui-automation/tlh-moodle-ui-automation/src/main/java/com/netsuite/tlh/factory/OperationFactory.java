package com.netsuite.tlh.factory;

import com.netsuite.tlh.operations.IOperations;

public class OperationFactory {

	public static <T extends IOperations> T getOperation(Class<T> operationClass) throws InstantiationException,
			IllegalAccessException {
		return operationClass.newInstance();
	}

}
