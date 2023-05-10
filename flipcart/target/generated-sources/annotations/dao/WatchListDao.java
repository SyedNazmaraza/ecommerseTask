package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.WatchListEntity;

public class WatchListDao {
	
	
	public String addProducts(Connection c , WatchListEntity watchlist){
		try {
			PreparedStatement preparedStatement = c.prepareStatement(Constants.GET_USER_NAME);
			try {
				preparedStatement.setString(1, watchlist.getUserName());
				ResultSet rs = preparedStatement.executeQuery();
				try {
					if(rs.next()) {
						if(rs.getString("username").equals(watchlist.getUserName()) && checkWatchList(c, watchlist)){   			
							PreparedStatement preparedStatement2 = c.prepareStatement(Constants.Add_WATCH_LIST);
							preparedStatement2.setString(1, watchlist.getUserName());
							preparedStatement2.setString(2,watchlist.getProducts());
							preparedStatement2.setString(3, watchlist.getWatchlistname());
							preparedStatement2.execute();
							return "Done";
						}
					}
				}
				finally {
					rs.close();
				}
			}
			finally {
				preparedStatement.close();
			}
		}
		catch(SQLException s) {
			s.printStackTrace();
		}
		return "UserName Not Exist or Details Already Presented";
	}
	
	
	
	public boolean checkWatchList(Connection c, WatchListEntity watchlist) throws SQLException {
		PreparedStatement preparedStatement = c.prepareStatement(Constants.GET_DETAILS_FROM_WATCHLIST);
		try {
			preparedStatement.setString(1, watchlist.getUserName());
			ResultSet rs = preparedStatement.executeQuery();
			try {
				boolean b = true;
				while(rs.next()) {
					if(rs.getString("products").equals(watchlist.getProducts()) && rs.getString("watchlist").equals(watchlist.getWatchlistname())) {
						b=false;
						return b;
					}
				}
				return b;
			}
			finally {
				rs.close();
			}
		}
		finally {
			preparedStatement.close();
		}
	}
}
