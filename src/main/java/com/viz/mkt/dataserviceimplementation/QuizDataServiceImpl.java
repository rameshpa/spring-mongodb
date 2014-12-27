/*
 * MIT License 
 * Code created by Ramesh Parameswaran, repo in https://github.com/rameshpa/spring-mongodb
 */

package com.viz.mkt.dataserviceimplementation;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mongodb.MongoClient;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.viz.mkt.data.ConnectionFactory;
import com.viz.mkt.data.Constants;
import com.viz.mkt.domain.Quiz;
import com.viz.mkt.dataserviceinterface.QuizDataService;

public class QuizDataServiceImpl extends BaseDataServiceImpl<Quiz> implements QuizDataService  {
	
//	private MongoClient client;
//	private MongoOperations mongoOps;
//	
//	
	
	public QuizDataServiceImpl() throws ClassNotFoundException{
		super();
		//this.collectionName = this.getClass().getSimpleName().replace("DataServiceImpl", "").toLowerCase();
		//this.domainClass =  Class.forName(this.getClass().getSimpleName().replace("DataServiceImpl", ""));
	
//		MongoClient client = ConnectionFactory.CONNECTION.getClient();
//		this.mongoOps = new MongoTemplate(client,  Constants.DB_NAME);
	}
	
	// By default the collection name will be lower case of Domain name lower case
	// If you want something else, then override, otherwise no need to override
//	@Override
//	public String getCollectioName(){
//		return "quizzes";
//	}
	
	
//	public Quiz create(Quiz q){
//		q.setQuizId(UUID.randomUUID().toString());
//		this.mongoOps.insert(q, this.collectionName);
//		return q;
//	}
	
//	public Quiz update(Quiz q){
//		this.mongoOps.save(q, this.getCollectioName());
//		return q;
//	}
//	
//	public Boolean delete(Quiz q){
//		this.mongoOps.remove(q, this.getCollectioName());
//		return true;
//	}
//	
//	public List<Quiz> findAll(){
//		//List<Quiz> results = mongoOps.find(new Query(Criteria.where("excuses.excusename").is("biking")
//				 //), Quiz.class, collectionName );	
//		List<Quiz> results = mongoOps.findAll(Quiz.class, this.getCollectioName());
//		return results;
//		
//	}
//	
//	public Quiz findByQuizName(String quizName){
//		Quiz q1 = this.mongoOps.findOne(
//				new Query(Criteria.where("quizName").is(quizName)),
//				Quiz.class, this.getCollectioName());	
//		return q1;
//	}
//	
//	public Quiz findByQuizId(String id){
//		Quiz q1 = this.mongoOps.findOne(
//				new Query(Criteria.where("quizId").is(id)),
//				Quiz.class, this.getCollectioName());	
//		return q1;
//	}
}