# Spring MVC application for Andigital Test

This is a web application that uses Spring MVC and Hibernate.

(Technolgies and tools been used including: maven, JPA, json orm, jstl, spring mvc, hibernate, github, apache tomcat, heroku cloud deployment, heroku CI and so on...) 

## Running the application locally

First build with:

    $mvn clean install

Then run it with:

    $java -jar target/dependency/webapp-runner.jar target/*.war
    
## Way of building the APP

This is typical spring mvc app. 

In web.xml, a DispatcherServlet servlet to act as the front-controller to handle all the entire web request. Servlets in "controller" package will handle different request and response with relavent jsp page.

In the spring config file - applicationContext.xml, the viewResolver will find the file with following mechanism : prefix + view name + suffix, as well as setting up properties for JPA and postgre Database connection enviroment.

Under "service" package, there is "data access object" - SavedSearchResultService interface along with its implementation for database CURD.

"model" package, there are two type of model here, SearchResult is the Entity model for JPA, other objects are restful model for JSON ORM purpose (I am using jackson lib in this case, check pom.xml for dependencies).

"utility" package, here are only two main methods, 
* for retrieving lat and lng of a location using google's GEOCODE restful API in order to build FourSquare restful query
* query FourSquare restful API and build the JSON ORM using jackson lib.

Now let's talk about "V" of mvc, just couple of jsp under /andigitialtest/src/main/webapp/WEB-INF/jsp, pretty straight forward stuff, generate dynamic markups base on the listObjects provided by "C".

The "test" package, I only implemented couple of simple Junit test to test the restful functional and DB connection stuff (db tests doesnt work locally tho...)


## User's manual

I have deployed the app to heroku cloud already (hosting by AWS actually), here is the url:   
http://andigitialtest.herokuapp.com/
Yes, it is live! The interface is intuitive, enter the location (e.g London), and what you are looking for (e.g KFC), then you will get bunch of results, you can click "My favourite" to save it for later browse (as described above, postgre DB is being used for this app for storage). 


## Place Improve...

*Project structure can be seperated into a more clear details, e.g make seperate packages for DAO and its IMPL, seperate packages for JPA entity model and Restful model. Categroize different type of jsp, js, css...
*Proper Test suite to cover controller servelets (can use mockito lib to mock page context obj).


## The future...

Many things can be improved... E.g I was going to setup a user based registration, so each user is able to login with their own session (HttpSession), and have their own instance for saving "my favourite" venues (by setting up more complex entity relations e.g @many-to-many in hibernate).  I was also thinking about to build my own restful webservice servlet to serve json data, and then I can build an IOS app to consume the data and display saved favourite venues on iphone (I am IOS dev too).

  


