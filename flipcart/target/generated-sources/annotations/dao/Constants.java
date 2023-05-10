package dao;

public class Constants {
	
	
	protected static final String ADD_USER = "insert into userdetails (username,userpass) values (?,?) ";
	
	
	protected static final String Add_WATCH_LIST = "insert into watchlist(username,products,watchlistname) values(?,?,?)";
	
	protected static final String GET_USER_NAME = "select * from userdetails where username= ?";
	
	protected static final String GET_DETAILS_FROM_WATCHLIST = " select * from watchlist where username=?";
	
	protected static final String GET_PRODUCTS_FROM_WATCHLIST = "select products from watchlist where username=? and watchlistname=?";
	
	
}
