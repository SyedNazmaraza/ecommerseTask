package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.WatchList;
import entity.UserEntity;
import entity.WatchListReturnEntity;

public class UserDao {


	
	public boolean addUser(Connection c , UserEntity user) {
		try {
			PreparedStatement preparedStatement = c.prepareStatement(Constants.ADD_USER);
			try {
				preparedStatement.setString(1, user.getUserName());
				preparedStatement.setString(2, user.getUserPass());
				boolean n = preparedStatement.executeUpdate()>0;
				return n;
			}
			finally {
				preparedStatement.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public List<WatchListReturnEntity> getAllDetails(Connection c , UserEntity user){
		List<WatchListReturnEntity> list = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = c.prepareStatement(Constants.GET_DETAILS_FROM_WATCHLIST);
			preparedStatement.setString(1, user.getUserName());
			ResultSet rs = preparedStatement.executeQuery();
			try {
				while(rs.next()) {
					WatchListReturnEntity w = new WatchListReturnEntity(rs.getString("watchlistname"),rs.getString("products"));
					list.add(w);
				}
				return list;
				}
			finally {
				rs.close();
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			try {
				preparedStatement.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return list;
		
		
	}
	
	public List<String> getDetailsByWatchListName(Connection c , UserEntity user){
		List<String> list = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = c.prepareStatement(Constants.GET_PRODUCTS_FROM_WATCHLIST);
			try {
				preparedStatement.setString(1, user.getUserName());
				preparedStatement.setString(2, user.getWatchListName());
				ResultSet rs = preparedStatement.executeQuery();
				try {
					while(rs.next()) {
						String s = rs.getString("products");
						list.add(s);
					}
					return list;
				}
				finally {
					rs.close();
				}
			}
			finally {
				preparedStatement.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		return list;
		
	}
}
