package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class VoteStatusBean {
	private int userId;
	private int candId;
	private String message;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCandId() {
		return candId;
	}
	public void setCandId(int candId) {
		this.candId = candId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void vote() {
		try(UserDao udao = new UserDaoImpl()) {
			User user = udao.findById(userId);
			
			if(user.getStatus() != 0) {				
				this.message = "You have already voted!!";	
				return;
			} 
			try(CandidateDao cdao = new CandidateDaoImpl()){
				int cnt = cdao.incrementVote(candId);
				
				if(cnt == 1) {
					cnt = udao.updateStatus(userId, true);
					if(cnt == 1)
						this.message = "Your Vote Registered Successfully!!";
					else 
						this.message = "Voting failed!!";
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
