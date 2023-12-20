package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.pojos.Movies;

public interface MoviesInt extends AutoCloseable {
	public List<Movies> displayAll() throws Exception;
	public Movies findById(int id) throws Exception;
}
