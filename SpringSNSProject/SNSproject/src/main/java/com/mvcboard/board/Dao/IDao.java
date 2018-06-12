package com.mvcboard.board.Dao;

import java.util.ArrayList;
import java.util.Map;

import com.mvcboard.board.Dto.ContentDto;


public interface IDao {

	public ArrayList<ContentDto> signcheck(String id);
	public void signup(Map map);
	public ArrayList<ContentDto> loginIdcheck(String id);

}
