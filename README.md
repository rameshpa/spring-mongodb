spring-mongodb by uhance.com (Author: Ramesh Parameswaran)
==========================================================

Extensible Data access layer for Spring MVC with MongoDB using MongoTemplate. 
Base CRUD methods automatically available to any domain objects and advanced developers have the ability to add more common methods that are automatically available to all domain objects.

Background
While writing an app for Spring with Mongo, I was horrified at the complexity of configuration that this entailed. 
I was also puzzled by the lack of consistent documentation and code that actually works. I found several examples of code online that clearly could not work.

So, I wrote this data layer to use Spring's awesome built in MVC for web apps and the powerful MongoTemplate without some of the other headaches of Spring data access for Mongo

Design principles
I've kept the concepts of 
- loose coupling between the Controller and the data access. 
- Factory implementation and Interface contracts between controller and data layer. 
- If you want to change the implementation later to some other DB, just change the implementations
- No need for developers to repeat code for basic data methods, simple inheritance from a base object should get you basic CRUD

Who is this code for
Both advanced and basic developers can use this.
Beginner developers can simply create their own Domain objects (there is an example Quiz domain object in the code that you can use)

Advanced developers can use this to create more methods in the base classes that are automatically available to all inherited domain classes.

How to try
git clone this repo and copy it over to your project
Create Mongo db collection in mongo db command line called quiz (not needed if you create a quiz first via the UI below)
Try the application by typing in localhost:8080/mkt/quizzes/getall (You have to set up Tomcat or other server, I have not included those instructions)

How to code with it
Create a new domain object such as Person in domain package similar to QUiz. Create getter and setter methods, in particular, dont forget to create the method setId 
Create PersonDataService similar to QuizDataService in package dataservice
Create PersonDataServiceImpl similar to QUixDataServiceImpl in package dataserviceimplementation
Create your views in src.main.webapp/WEB-INF/views/person
Create PersonController in controller package similar to QuizController
Create collection in mongodb called person
Be sure to follow the same naming conventions used for Quiz

