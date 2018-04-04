package heigvd.ch;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

@WebServlet(
	    name = "DatastoreWrite",
	    urlPatterns = {"/datastorewrite"}
	)
@SuppressWarnings("serial")
public class DatastoreWriteSimple extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                         throws ServletException, IOException {
		
    	 DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    	 
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter pw = response.getWriter();
        
        String kind = request.getParameter("_kind");
        String key = request.getParameter("_key");
        Entity book; //= null;
        Enumeration<String> parametersNames = request.getParameterNames();
        
        if(kind == null) {
        	 pw.println("Parameter _kind is missing !");
        	 return;
        } else if (key == null) {
        	book = new Entity(kind);
        } else {
        	book = new Entity(kind,key);
        }
                
        String currentParameterName;
        String currentParameterValue;
        while(parametersNames.hasMoreElements()) {
        	currentParameterName = parametersNames.nextElement();
        	
        	if(!currentParameterName.equals("_kind") || !currentParameterName.equals("_key")) {
            	currentParameterValue = request.getParameter(currentParameterName);
            	book.setProperty(currentParameterName, currentParameterValue);
        	}
               	
        }
		pw.println("Writing entity to datastore.");
		datastore.put(book);
    }
}
