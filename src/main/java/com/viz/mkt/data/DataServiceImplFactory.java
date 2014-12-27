/*
 * MIT License 
 * Code created by Ramesh Parameswaran, repo in https://github.com/rameshpa/spring-mongodb
 */
package com.viz.mkt.data;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//import com.viz.mkt.dataserviceimplementation.*;

public class DataServiceImplFactory {

	public static Object getDataServiceImpl(String domainObjectTypeString) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException{
		
		Class dataServiceImplClass = Class.forName("com.viz.mkt.dataserviceimplementation." +  domainObjectTypeString + "DataServiceImpl");
//		Object dataServiceImplClassInstance =  dataServiceImplClass.newInstance();
//		return dataServiceImplClassInstance;
		
		Constructor constructor = dataServiceImplClass.getConstructor();
		Object dataServiceImplClassInstance = constructor.newInstance();
		return dataServiceImplClassInstance;
			
	}
}
