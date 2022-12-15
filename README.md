# DataBase-project4
**Part 1 (60%)**  
The server-side code is comprised of 1 Java Servlet and 7 Java Server Pages. You should abide by the
following guidelines in detail to ensure a smooth grading process for the GTAs.  
Create a folder named loyaltyfirst in the webapps folder of your Apache Tomcat Server. This folder should
contain all your JSP files and any resources you might need when developing the client application. It also
contains the WEB-INF/classes folder containing the .class and .java files of the Login Servlet. You are
required to develop the JDBC code to implement the following Java Server-side components. Your JDBC
code typcially follows the same exact steps as we did in the lectures. What changes is the query to send to
the database. Accordingly start by developing the SQL queries needed in each server component and then
build the JDBC code and test it from a browser session. A good convention to follow when you have a
response output from an SQL statement is to separtate the columns by a particular character and the rows
by another character to facilitate the process of parsing the response in the Android mobile app later. Use a
‘,’ to separate the columns and a ‘#’ to separate the rows.  
Java Servlets  
Login.java (5% for correct code, 2.5% for successful execution)  
Annotation reference name: /login  
Request input parameters: customer username and password  
Response output:  
- The String “Yes:cid” if the username and password combination is valid and exists in the LOGIN  
table in the database. cid is the customer id.  
- The String “No” if the username or password are incorrect  
URL format: http://127.0.0.1:8080/loyaltyfirst/login?user=certainuser&pass=certainpass  
**Java Server Pages**  
Info.jsp (5% for correct code, 2.5% for successful execution)  
Request input parameters: A customer id  
Response output: The customer name, the number of points collected by the customer.  
URL format: http://127.0.0.1:8080/loyaltyfirst/Info.jsp?cid=certaincid  
Transactions.jsp (5% for correct code, 2.5% for successful execution)  
Request input parameters: A customer id  
Response output: the transaction reference, transaction date, the transaction points, and amount for all the
transactions belonging to the specified customer id.  
URL format: http://127.0.0.1:8080/loyaltyfirst/Transactions.jsp?cid=certaincid  
TransactionDetails.jsp (5% for correct code, 2.5% for successful execution)  
Request input parameters: The transaction reference  
Response output: the transaction date, the transaction points, product names, product points, and quantities
belonging to the specified transaction reference  
URL format: http://127.0.0.1:8080/loyaltyfirst/TransactionDetails.jsp?tref=certaintref  
PrizeIds.jsp (5% for correct code, 2.5% for successful execution)  
Request input parameters: A customer id  
Response output: the distinct prize ids belonging to the specified customer id.  
URL format: http://127.0.0.1:8080/loyaltyfirst/PrizeIds.jsp?cid=certaincid  
RedemptionDetails.jsp (5% for correct code, 2.5% for successful execution)  
Request input parameters: a prize id and a customer id  
Response output: the prize description, the number of points needed, redemption date, and exchange center
name for the specified (prize id, customer id) pair.  
URL format:  
http://127.0.0.1:8080/loyaltyfirst/RedemptionDetails.jsp?prizeid=certainprizeid&cid=certaincid  
SupportFamilyIncrease.jsp (5% for correct code, 2.5% for successful execution)  
Request input parameters: A customer id and a transaction reference  
Response output: The family id of the specified customer id, the Percent of points to provide to the customer
family members, and the total number of points of the specified transaction reference.  
URL format: http://127.0.0.1:8080/loyaltyfirst/SupportFamilyIncrease.jsp?cid=certaincid&tref=certaintref
FamilyIncrease.jsp (5% for correct code, 2.5% for successful execution)  
Use an UPDATE SQL DML statement in this JSP file.  
Request input parameters: A family id, a customer id and the number of points to be added to the point
accounts of all the members of the specified family id (except the point account of the specified customer
id).  
Response output: A message indicating that the point accounts of the family members are updated
successfully.  
URL format: http://127.0.0.1:8080/loyaltyfirst/FamilyIncrease.jsp?fid=certain
familyid&cid=certaincid&npoints=certainnumberofpoints  
**Part 2 (30 %) [5% per activity]**  
In this part you will develop an Android client application project (name it LoyaltyFirst) to demonstrate a
small portion of your project operation. Due to the limited amount of time available, your app will consist
of few activities for testing the interaction of your server-side code with the database. The Figures provide
an idea of the UI anticipated for the activities and a specification of the server-side components that may
be used to support the implementation of those activities.  
![image](https://user-images.githubusercontent.com/71203848/207956886-2cbb8012-1a86-49f9-9972-90bc28dbe701.png)
![image](https://user-images.githubusercontent.com/71203848/207956893-e3fe38a1-b0d7-4108-a2b8-27f294c47d5c.png)
![image](https://user-images.githubusercontent.com/71203848/207956902-a8a51945-a830-4be3-bcc9-71a75e8f052e.png)
![image](https://user-images.githubusercontent.com/71203848/207956914-71ba7135-a059-42ce-9b46-41ce7838c526.png)
![image](https://user-images.githubusercontent.com/71203848/207956933-4d6340b3-3e89-4d7f-826e-47300aa4af88.png)
![image](https://user-images.githubusercontent.com/71203848/207956938-c628e386-ce84-49a0-9a9a-cbba0e02b6cb.png)
**Part 3 (10 %)**  
Each group will record a 15-min video demonstration of their application and post the video to YouTube
(or any video hosting service). A link to the video should be included in the vlink.txt file. Any broken link
or a link that is not accessible will result in a ZERO grade. Don’t upload the whole video file to
Blackboard. All the group members should participate in the project demonstration. The following is what
should be emphasized on in your video:  
1. The code of the different Server-side components (Servlet and JSPs) (2.5%)  
2. The Java code of the Android Activities (2.5%)  
3. Testing each of the Server-side components using a browser session (2.5%)  
4. Running the Android activities with the Android Studio emulator and demonstrating their functionality
and interaction with the Servlet and JSPs (2.5%)  



