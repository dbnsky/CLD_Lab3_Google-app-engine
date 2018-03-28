# LAB 03: GOOGLE APP ENGINE
## Authors
 * Emmanuel Schmid
 * Wojciech Myszkorowski

## TASK 1 DEPLOYMENT OF A SIMPLE WEB APPLICATION

### What does the code HelloAppEngine.java ?
The file **HelloAppEngine.java** is a servlet which override the doGET method.
When someone access to the specific url **localhost:8080/hello**, the request is handle by the servlet which return a message.
The response is formated using **utf-8** and contain a plain text **Hello App Engine**.

### What does web.xml do ?
The mappings are needed by the web application server to route the incoming HTTP requests to the right Servlets.
In the servlet **HelloAppEngine.java**, the mapping between the route **/hello** and the servlet is done by an anotation **@WebServlet**.
Another way to map servlets with routes is to use the deployment descriptor **web.xml**. It normally contains information such as version, servlets mapping, encoding, etc.

### What information does appengine-web.xml contain?
An app Engine Java application uses the deployement description **web.xml** and the **appengine-web.xml**. This configuration file specify for exemple an application ID and an version identifier.

## TASK 2: DEVELOP A SERVLET THAT USES THE DATASTORE

### Copy the Servlet into the report.

### Copy a screenshot of the local and the App Engine console with the Datastore Viewer.


## TASK 3: TEST THE PERFORMANCE OF DATASTORE WRITES

### For each performance test copy a screenshot of the JMeter Graph Results listener and the App Engine Dashboard view into the report.

### What response times do you observe in the test tool for each Servlet?

### Compare the response times shown by the test tool and the App Engine console. Explain the difference.

### How much resources have you used running these tests?
From the Quota Details view of the console determine the non-zero resource quotas (Daily quota different from 0%). Explain each with a sentence. To get a sense of everything that is measured click on Show resources not in use.

### Let's suppose you become suspicious that the algorithm for the automatic scaling of instances is not working correctly. Imagine a way in which the algorithm could be broken. Which measures shown in the console would you use to detect this failure?
