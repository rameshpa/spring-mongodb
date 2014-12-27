/*
 * MIT License 
 * Code created by Ramesh Parameswaran, repo in https://github.com/rameshpa/spring-mongodb
 */

package com.viz.mkt.dataserviceinterface;

import java.util.List;

import com.viz.mkt.domain.BaseModel;

public interface BaseDataService<T> {
	
	public T create(BaseModel bm);
	
	public T findById(String id);
	
	public List<T> findAll();
	
	public T update(BaseModel bm);
	
	public Boolean delete(BaseModel bm);

}
