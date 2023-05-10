package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
public class ContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext cxt = sce.getServletContext();
    	String url = cxt.getInitParameter("Dburl");
    	String user = cxt.getInitParameter("Dbid");
    	String pass = cxt.getInitParameter("Dbpass");
    	DataBase db = new DataBase(url,user,pass);
    	cxt.setAttribute("DataBase", db);    }
	
}
