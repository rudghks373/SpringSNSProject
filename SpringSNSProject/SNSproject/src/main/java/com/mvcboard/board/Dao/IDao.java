package com.mvcboard.board.Dao;

import java.util.ArrayList;

import com.mvcboard.board.Dto.ContentDto;


public interface IDao {

	public ArrayList<ContentDto> signcheck(String id);
	
}
