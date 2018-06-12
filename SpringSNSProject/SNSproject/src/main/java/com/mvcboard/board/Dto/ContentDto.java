package com.mvcboard.board.Dto;

import java.sql.Date;

public class ContentDto {


    private String ID;
    private String NAME;
    private String PASSWORD;

	
	public ContentDto(String PASSWORD) {

		this.PASSWORD = PASSWORD;
	    
	}
	
	
	public ContentDto(String ID, String PASSWORD) {
        this.ID = ID;
		this.PASSWORD = PASSWORD;
	    
	}
	
    
	public ContentDto(String ID, String NAME, String PASSWORD) {
		this.ID=ID;
		this.NAME = NAME;
		this.PASSWORD = PASSWORD;

}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
}