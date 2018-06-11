package com.mvcboard.board.Controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.apache.ibatis.session.SqlSession;
import com.mvcboard.board.Dao.ContentDao;
import com.mvcboard.board.Dto.ContentDto;
import com.mvcboard.board.Dao.*;



@Controller
public class mvcController {
	
	ContentDao dao;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	public void setDao(ContentDao dao) {
		this.dao = dao;
	}
   

	@RequestMapping("start")
	public String start(Model model){
		
		
		return "start";
	}
	
	@RequestMapping("write")
	public String write(Model model){
		
		
		return "write";
	}
	
	@RequestMapping("/main")
	public String main(){
		
		
		return "main";
	}
	
	//회원가입
	
	@RequestMapping("/signup")
	public String signup(){
		
	System.out.println("회원가입창 접속");
	
		return "signup";
	}
	
	@ResponseBody 
	@RequestMapping("/signcheck")
	public String signcheck(Model model, @RequestBody String paramData	) {

	

		System.out.println("체크창 접속");
	    System.out.println("반응:"+paramData);
		
		ModelAndView EX = new ModelAndView();
		
		EX.addObject("result", EX);
		return "result";
	}
	@RequestMapping("/login")
	public String login(Model model){
		
		return "login";
	}
	
	@RequestMapping("/template")
	public String template(Model model){
		
		return "template";
	}

}
