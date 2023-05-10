package entity;

public class WatchListEntity {
	
	private String userName;
	private String products;
	private String watchListName;
	public String getUserName() {
		return userName;
	}
	public String getProducts() {
		return products;
	}
	public String getWatchlistname() {
		return watchListName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setProducts(String products) {
		this.products = products;
	}
	public void setWatchlistname(String watchlistname) {
		this.watchListName = watchlistname;
	}
	@Override
	public String toString() {
		return "WatchList [userName=" + userName + ", products=" + products + ", watchlistname=" + watchListName + "]";
	}
	public WatchListEntity(String userName, String products, String watchlistname) {
		super();
		this.userName = userName;
		this.products = products;
		this.watchListName = watchlistname;
	}
	public WatchListEntity() {
		super();
	}
	
	

}
