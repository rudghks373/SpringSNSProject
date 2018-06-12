package com.mvcboard.board.Controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
	
	 
	@RequestMapping("/signcheck")
	public @ResponseBody String signcheck(Model model, @RequestBody String paramData	) throws ParseException {
	
		System.out.println("체크창 접속");
	    System.out.println("반응:"+paramData);
	    
	    JSONParser parser = new JSONParser(); //–JSON Parser 생성
	    JSONObject jsonObj = (JSONObject)parser.parse(paramData); //– 넘어온 문자열을 JSON 객체로 변환
	    
	    String data1 = jsonObj.get("id").toString();
	    String data2 = jsonObj.get("name").toString();
	    String data3 = jsonObj.get("pass").toString(); //값을 가져옴
	    
	    System.out.println("/////////DB////////");
		IDao dao = sqlSession.getMapper(IDao.class);
	   
		
	    System.out.println(dao.signcheck(data1).isEmpty());
	    
		if (dao.signcheck(data1).isEmpty()) {
			Map map = new HashMap();
			
			map.put("parameter1", data1);
			map.put("parameter2", data2);
			map.put("parameter3", data3);
			dao.signup(map);
			System.out.println("회원가입완료");
			return "OK";
		}
		else {
			System.out.println("이미 가입되어 있습니다.");
			return "EX";
		}
		
	}
	
	@RequestMapping("/login")
	public String login(){
		
	System.out.println("로그인창 접속");
	
		return "login";
	}
	
	
	@RequestMapping("/logincheck")
	public @ResponseBody String logincheck(Model model, @RequestBody String paramData) throws ParseException{
		
		System.out.println("로그인체크창 접속");
	    System.out.println("반응:"+paramData);
	    
	    JSONParser parser = new JSONParser(); //–JSON Parser 생성
	    JSONObject jsonObj = (JSONObject)parser.parse(paramData); //– 넘어온 문자열을 JSON 객체로 변환
	    
	    String data1 = jsonObj.get("id").toString();
	    String data2 = jsonObj.get("pass").toString();
	    
	    
	    System.out.println("/////////DB////////");
	    
		IDao dao = sqlSession.getMapper(IDao.class);
		
		if(dao.loginIdcheck(data1).isEmpty()) {
		return "noID";	
		}
		
		else{
		System.out.println("입력결과 DB에 아이디존재");
        ContentDto passwordcheck = dao.loginIdcheck(data1).get(0);
        passwordcheck.getPASSWORD();
        
        System.out.println("로그인입력 패스워드:"+data2);
        System.out.println("DB저장된 패스워드:"+passwordcheck.getPASSWORD().replace(" ",""));
        
        if(passwordcheck.getPASSWORD().replace(" ","").equals(data2)){
        	System.out.println("완벽한로그인");
        	return "OK";
        }
        else {
        	System.out.println("비밀번호가 틀립니다");
        	return "PS";
        }
	}
	}
	
	//세션확인
	
	
	@RequestMapping("/session")
	public String session(Model model , HttpSession session) {
		
		
		session.setAttribute("iogincheck", "OK");
		String iogincheck = (String)session.getAttribute("iogincheck");
        System.out.println("세션확인-----:"+iogincheck);
        
		return "main";
	
	}
	
	@RequestMapping("/sessioncheck")
	public @ResponseBody String sessioncheck(Model model , HttpSession session , @RequestBody String paramData) {
		
		String iogincheck = (String)session.getAttribute("iogincheck");
        System.out.println("세션값확인-----:"+iogincheck);
        
        String del = "sessiondelete=";
        
	    System.out.println("반응:"+paramData);
	    
	    
        if(paramData.equals(del)){
        	session.invalidate(); 
        	System.out.println("세션삭제완료");
        	return "deleteOK";
        }
        else if(iogincheck == null){
        	return "NO";
        }
        
        else{
	        return "OK";
	  }
	
        
}
	@RequestMapping("/logout")
	public String logout(Model model , HttpSession session) {
		
		String iogincheck = (String)session.getAttribute("iogincheck");
		removeAttribute(iogincheck);     
		return "login";
	
	}
	
	private void removeAttribute(String iogincheck) {
		// TODO Auto-generated method stub
		
	}


	@RequestMapping("/template")
	public String template(Model model){
		
		return "template";
	}

}

