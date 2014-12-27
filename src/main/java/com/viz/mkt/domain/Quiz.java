/*
 * MIT License 
 * Code created by Ramesh Parameswaran, repo in https://github.com/rameshpa/spring-mongodb
 */

package com.viz.mkt.domain;

import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Quiz extends BaseModel {

		private String quizName;
		
		@Id
		private String quizId;
		
		public Quiz(){
			
		}
		
		public Quiz(String name){
			this.setQuizName(name);
		}
		
		@Override
		public void setId(String id1) {
			this.quizId = id1;
		}

		public String getQuizName() {
			return quizName;
		}

		public void setQuizName(String name) {
			this.quizName = name;
		}

		public String getQuizId() {
			return quizId;
		}

		public void setQuizId(String id1) {
			this.quizId = id1;
		}
		
		
		
		
}