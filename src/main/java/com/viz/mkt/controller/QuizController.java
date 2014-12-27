
/*
 * MIT License 
 * Code created by Ramesh Parameswaran, repo in https://github.com/rameshpa/spring-mongodb
 */

package com.viz.mkt.controller;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.viz.mkt.data.DataServiceImplFactory;
import com.viz.mkt.dataserviceinterface.QuizDataService;
import com.viz.mkt.domain.Quiz;

@Controller
@RequestMapping("/quizzes")
public class QuizController {
	
	private QuizDataService quizDataService;
	
	public QuizController() throws NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		// Use factory instead of DI via Spring to avoid Spring configuration nightmare
		// Loose coupling between Controller and Data layer, ability for test suites to call Controller 
		// methods without creating Data layer objects in test suite and
		// minimal Spring bureaucracy and configuration nightmares to deal with
		
//		String[] classNamePaths = this.getClass().getName().split(".");
//		String domainObjecttypeString = classNamePaths[classNamePaths.length-1];
//		domainObjecttypeString = domainObjecttypeString.replace("Controller", "");
		
		String domainObjecttypeString = this.getClass().getSimpleName().replace("Controller", "");
		this.quizDataService = (QuizDataService)DataServiceImplFactory.getDataServiceImpl(domainObjecttypeString);
	}
	
	@RequestMapping("/showquiz")
    public ModelAndView showQuiz() {
    	Quiz q = new Quiz("Learning Quiz");
        return new ModelAndView("quiz/showquiz", "q", q);
    }
	
	@RequestMapping("/getall")
	public ModelAndView getAll() {
		List<Quiz> allQuizzes = quizDataService.findAll();
		
		ModelAndView model = new ModelAndView("quiz/all");
		model.addObject("lists", allQuizzes);
 
		return model;
	}
	
//	@RequestMapping("/getbyname")
//	public ModelAndView getByName(String name) {
//		Quiz quizFound = quizDal.findByQuizName(name);
//		return new ModelAndView("quiz/showquiz", "q", quizFound);
//	}
	
	@RequestMapping("/getbyid")
	public ModelAndView getById(@RequestParam String id) {
		Quiz quizFound = quizDataService.findById(id);
		return new ModelAndView("quiz/showquiz", "q", quizFound);
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView create(){
		ModelAndView model = new ModelAndView("quiz/create");
 
		model.addObject("quizEntity", new Quiz());
		return model;
	}
 
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView create(@ModelAttribute Quiz q
//			@RequestParam String name
//			@RequestParam String password,
//			@RequestParam String firstName,
//			@RequestParam String lastName,
//			@RequestParam Integer role
			) {
 
//		Role newRole = new Role();
//		newRole.setRole(role);
		
		//Quiz newQuiz = new Quiz();
		
		//newQuiz.setQuizName(name);
//		newUser.setPassword(password);
//		newUser.setFirstName(firstName);
//		newUser.setLastName(lastName);
//		newUser.setRole(newRole);
		
		quizDataService.create(q);
		
		return new ModelAndView("quiz/showquiz", "q", q);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ModelAndView update(
			@RequestParam String id,
			@RequestParam String name
//			@RequestParam String lastName,
//			@RequestParam Integer role
			) {
 
//		Role existingRole = new Role();
//		existingRole.setRole(role);
		Quiz existingQuiz = quizDataService.findById(id);
		
		if (existingQuiz == null) {
			return null;
		}
		
		existingQuiz.setQuizName(name);
//		existingUser.setFirstName(firstName);
//		existingUser.setLastName(lastName);
//		existingUser.setRole(existingRole);
		
		quizDataService.update(existingQuiz);
		return new ModelAndView("quiz/showquiz", "q", existingQuiz);
	}
	
	@RequestMapping(value="/delete")
	public ModelAndView delete(
			@RequestParam String id) {
 
		Quiz existingQuiz = new Quiz();
		existingQuiz.setQuizId(id);
		
		quizDataService.delete(existingQuiz);
		return new ModelAndView("quiz/deletesuccess", "q", null);
	}
    
}
