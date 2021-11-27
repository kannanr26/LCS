# LCS
Pre-requiste: Java 1.8, Maven (if not installed)

From Git Url we can clone or download the source code to the local host
Please refer Git_Code_download.png

1.To execute the application, please open new Command prompt and navigate to the lcs dirctory and run the below command    
mvn spring-boot:run 

2.To execute the JUnit testcases,once the application is up please open new Command prompt and navigate to the lcs dirctory and run the below command 
mvn test

3. Open browser -Use the URL http://localhost:8080/swagger-ui.html

Steps to execute swagger API - Please refer the Steps_to_execute_swagger.png
**i) Steps to execute Post lcs API**
1) Select Post /lcs 
2) Select Try it out
3) Paste the below text in Resquest body	
	{
	"setOfStrings": [
    {"value": "comcast"},
    {"value": "comcastic"},
    {"value": "broadcaster"}
	]
	}
4) Select Execute
5) We can observe the output in Responses -> server response

**ii) Steps to execute post lcs2 API**
1) Select Post /lcs2
2) Select Try it out
3) Paste the below text in Resquest body
{
  "setofStrings": {
    "values": [
     "comcast",
     "communicate",
     "commutation"
    ]
  }
}
4) Select Execute
5) We can observe the output in Responses -> server response
 
 
