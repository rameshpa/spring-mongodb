/*
 * MIT License 
 * Code created by Ramesh Parameswaran, repo in https://github.com/rameshpa/spring-mongodb
 */

package com.viz.mkt.dataserviceimplementation;

import java.util.UUID;
import java.util.List;

//import org.springframework.data.mongodb.core.MongoOperations;
//import org.springframework.data.mongodb.core.MongoTemplate;


import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


//import com.mongodb.MongoClient;
//import com.viz.mkt.data.ConnectionFactory;
import com.viz.mkt.data.TemplateFactory;
import com.viz.mkt.data.Constants;
import com.viz.mkt.domain.BaseModel;
import com.viz.mkt.dataserviceinterface.BaseDataService;

public class BaseDataServiceImpl<T> implements BaseDataService<T> {

//	private MongoClient client;
//	private MongoOperations mongoOps;
	
//	public BaseDAL(){
//		MongoClient client = ConnectionFactory.CONNECTION.getClient();
//		this.mongoOps = new MongoTemplate(client,  Constants.DB_NAME);
//	}
	
	protected String collectionName;
	protected Class domainClass;
	
	public BaseDataServiceImpl() throws ClassNotFoundException{
		// this is always going to be of the form QuizDataServiceImpl or QuestionDataServiceImpl
		// collection name is obtained by getting the class name of this and replacing DataServiceImpl with null
		// to give us Quiz, Question etc and then lower casing to quiz, question etc
		// Domain class is obtained by removing the DataServiceImpl and creating a class from 
		// that string
	
//		String[] classNamePaths = this.getClass().getName().split(".");
//		String domainObjecttypeString = classNamePaths[classNamePaths.length-1];
//		domainObjecttypeString = domainObjecttypeString.replace("Controller", "");
		
		
		this.collectionName = this.getClass().getSimpleName().replace("DataServiceImpl", "").toLowerCase();
		this.domainClass =  Class.forName("com.viz.mkt.domain." +this.getClass().getSimpleName().replace("DataServiceImpl", ""));
	}
	
	
	@SuppressWarnings("unchecked")
	public T create(BaseModel bm){
		bm.setId(UUID.randomUUID().toString());
		
		//String collectionName = bm.getClass().getSimpleName().toLowerCase();
	
		TemplateFactory.TEMPLATE.getMongoTemplate().insert(bm, this.collectionName);
		return (T)bm;
	}
	
	@SuppressWarnings("unchecked")
	public T findById(String id){
		T obj = (T)
			TemplateFactory.TEMPLATE.getMongoTemplate().findOne(
				new Query(Criteria.where(this.collectionName + "Id").is(id)),
					this.domainClass, this.collectionName);	
		return obj;
	}
	
	public List<T> findAll(){
		@SuppressWarnings("unchecked")
		List<T> allObjs = 
			TemplateFactory.TEMPLATE.getMongoTemplate().findAll(this.domainClass, this.collectionName);
		return allObjs;
	}
	
	@SuppressWarnings("unchecked")
	public T update(BaseModel bm){
		bm.setId(UUID.randomUUID().toString());
		
		// String collectionName = bm.getClass().getSimpleName().toLowerCase();
		TemplateFactory.TEMPLATE.getMongoTemplate().insert(bm, this.collectionName);
		return (T)bm;
	}
	
	public Boolean delete(BaseModel bm){
		TemplateFactory.TEMPLATE.getMongoTemplate().remove(bm, this.collectionName);
		return true;
	}
		
	
	
	
	
}
