package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class CandidateList {
	private List<Candidate> list;
	
	public CandidateList() {
		this.list = new ArrayList<>();
	}	
	
	public List<Candidate> getList() {
		return list;
	}

	public void setList(List<Candidate> list) {
		this.list = list;
	}

	public void displayAll() {		
		try(CandidateDao cdao = new CandidateDaoImpl()){
				list = cdao.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
