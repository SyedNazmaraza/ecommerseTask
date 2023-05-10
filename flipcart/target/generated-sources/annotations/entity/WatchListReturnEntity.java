package entity;

public class WatchListReturnEntity {
	
	private String products;
	private String watchListName;
	@Override
	public String toString() {
		return "WatchListReturnEntity [products=" + products + ", watchListName=" + watchListName + "]";
	}
	public String getProducts() {
		return products;
	}
	public String getWatchListName() {
		return watchListName;
	}
	public void setProducts(String products) {
		this.products = products;
	}
	public void setWatchListName(String watchListName) {
		this.watchListName = watchListName;
	}
	public WatchListReturnEntity(String watchListName, String  products) {
		super();
		this.products = products;
		this.watchListName = watchListName;
	}
	

}
