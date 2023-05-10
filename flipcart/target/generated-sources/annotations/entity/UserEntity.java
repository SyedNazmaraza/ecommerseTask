package entity;

public class UserEntity {

	private String userName;
	private String userPass;
	private String watchListName;
	public String getWatchListName() {
		return watchListName;
	}
	public void setWatchListName(String watchListName) {
		this.watchListName = watchListName;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	@Override
	public String toString() {
		return "UserEntity [userName=" + userName + ", userPass=" + userPass + "]";
	}
	public UserEntity(String userName, String userPass) {
		super();
		this.userName = userName;
		this.userPass = userPass;
	}
	public UserEntity() {
		super();
	}
}
