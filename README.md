In the command prompt Go to the project directory [MailAuthSystem].
Create jar file using mvn clean package
Go the directory MailAuthSystem/target/
Execute the command java -jar MailSystem-0.0.1-SNAPSHOT.jar
In the browser go to, http://localhost:8080/departments/
	The list of departments will be listed.
	In the list of department click on one of the department, to send the mail to its template.
For the manage approval go to, http://localhost:8080/authorize
	The list of mail id of the selected template will be listed.
	Here you can accept or Reject the mailId, If mailId status is already changed by any other managers status has been already changed message will be displayed.
