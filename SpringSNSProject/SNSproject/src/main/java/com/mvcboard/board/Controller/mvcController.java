package com.mvcboard.board.Controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
   
//초기화면
	@RequestMapping("/start")
	public String start(Model model){
		return "start";
	}
	
	@RequestMapping("fetch")
	public @ResponseBody String fetch(Model model,  HttpSession session, @RequestBody String paramData	) throws ParseException{

		
		System.out.println("글목록쇼 체크창 접속");
	   

	    String logininfo = (String) session.getAttribute("iogincheck");
	    System.out.println("글쓰기창세션값확인:"+logininfo);
	   
	    IDao dao = sqlSession.getMapper(IDao.class);
	    ArrayList<ContentDto> showlist = dao.showlist2(logininfo);
	    
	    if(showlist.isEmpty()){
	    	System.out.println("빈값:"+showlist.isEmpty());
	    
        return "null";
	    }
	    else {
	    	
			return logininfo;
	    }
	   
        }
	

//글쓰기창
	@RequestMapping("/write")
	public String write(Model model){
		return "write";
	}
	
	
	@RequestMapping("/writeupdata")
	public @ResponseBody String writeupdata(Model model,  HttpSession session, @RequestBody String paramData	) throws ParseException{
		System.out.println("글쓰기 컨트롤러 접속");
	    System.out.println("입력된 값:"+paramData);
	   
	    
	    String logininfo = (String) session.getAttribute("iogincheck");
	    System.out.println("글쓰기창세션값확인:"+logininfo);
	    
	    JSONParser parser = new JSONParser(); //–JSON Parser 생성
	    JSONObject jsonObj = (JSONObject)parser.parse(paramData); //– 넘어온 문자열을 JSON 객체로 변환
	    
	    String data1 = jsonObj.get("id").toString();
	    String data2 = jsonObj.get("jsonobj").toString();
        
	    System.out.println(data1);
	    System.out.println(data2);
	    if(logininfo != null){
	    IDao dao = sqlSession.getMapper(IDao.class);
	   
	    Map map = new HashMap();
	    map.put("id", data1);
		map.put("jsonobj", data2);
		
		System.out.println("db에 등록할 값 확인"+map);
		
		dao.writeup(map);
	
	    ArrayList<ContentDto> datadata = dao.showlist(logininfo);
	    
	    for(ContentDto datadata1 : datadata) {
	        System.out.println(datadata1.getJSONOBJ());
	       }
	    
	    return "writeOK";
	    }
	    else{
	    System.out.println("세션이 존재하지않음");
		return "writeNO";
	    }

	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model){
		
		IDao dao = sqlSession.getMapper(IDao.class);
	    dao.deletelist(request.getParameter("num"));
		
		return "redirect:main";
	}

	
	@RequestMapping("/wwritereupdate")
	public String wwritereupdate(HttpServletRequest request, Model model){
		
		IDao dao = sqlSession.getMapper(IDao.class);
	    ArrayList<ContentDto> datadata = dao.writeupdata(request.getParameter("num"));
		model.addAttribute("writedata", datadata.get(0).getJSONOBJ());
        model.addAttribute("num" , request.getParameter("num"));
		System.out.println(datadata);
		
		return "writereupdate";
	}
	
	@RequestMapping("/writereupdate")
	public String writereupdate(HttpServletRequest request, Model model){

		
		return "writereupdate";
	}
	
	@RequestMapping("/modify")
	public @ResponseBody String modify(Model model,  HttpSession session, @RequestBody String paramData	) throws ParseException{
		System.out.println("글쓰기 컨트롤러 접속");
	    System.out.println("입력된 값:"+paramData);
	    
	    String logininfo = (String) session.getAttribute("iogincheck");
	    JSONParser parser = new JSONParser(); //–JSON Parser 생성
	    JSONObject jsonObj = (JSONObject)parser.parse(paramData); //– 넘어온 문자열을 JSON 객체로 변환
	    
	    String data1 = jsonObj.get("jsonobj").toString();
	    String data2 = jsonObj.get("num").toString();
        
	    System.out.println(data1);
	    System.out.println(data2);
	    if(logininfo != null){
	    IDao dao = sqlSession.getMapper(IDao.class);
	   
	    Map map = new HashMap();
	    map.put("jsonobj", data1);
		map.put("num", data2);

		
		System.out.println("db에 등록할 값 확인"+map);
		dao.modify(map);
		
	    return "writeOK";
	    }
	    else{
	    System.out.println("세션이 존재하지않음");
		return "writeNO";
	    }
	}
	
	
	//메인화면 and 글뿌려주기
	@RequestMapping("/main")
	public String main(Model model ,HttpSession session , @RequestBody String paramData)throws ParseException{

		IDao dao = sqlSession.getMapper(IDao.class);
		System.out.println("입력값확인:"+ paramData);
		
	    String logininfo = (String) session.getAttribute("iogincheck");
	    System.out.println("글쓰기창세션값확인:"+logininfo);
		ArrayList<ContentDto> list = dao.showlist2(logininfo);
	    if(logininfo==null){
	    return "main";
	    
	    }
	    else if(!(dao.showlist2(logininfo)==null)){

	   	    model.addAttribute("list", dao.showlist2(logininfo));
	   	    return "main";
        }
	   
	    
	
	    return "main";
		
	    }
	
	
	
	//회원가입 & 회원가입체크
	
	@RequestMapping("/signup")
	public String signup(){
		
	System.out.println("회원가입창 접속");
	
		return "signup";
	}
	
	 
	@RequestMapping("/signcheck")
	public @ResponseBody String signcheck(Model model,HttpSession session, @RequestBody String paramData	) throws ParseException {
	
		System.out.println("회원가입 컨트롤러 접속");
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
	
	
	//로그인창 & 로그인체크
	@RequestMapping("/login")
	public String login(){
		
	System.out.println("로그인창 접속");
	
		return "login";
	}
	
	
	@RequestMapping("/logincheck")
	public @ResponseBody String logincheck(Model model, HttpSession session, @RequestBody String paramData) throws ParseException{
		
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
        	System.out.println("완벽한로그인"); //로그인 확인과 세션주입
        	
    		session.setAttribute("iogincheck", data1);
    		String iogincheck = (String)session.getAttribute("iogincheck");
            System.out.println("로그인 전달 세션확인-----:"+iogincheck);
            
        	return "OK";
        }
        else {
        	System.out.println("비밀번호가 틀립니다");
        	return "PS";
        }
	}
	}
	
	//세션확인
	@RequestMapping("/sessioncheck")
	public @ResponseBody String sessioncheck(Model model , HttpSession session , @RequestBody String paramData) {
		
		String iogincheck = (String)session.getAttribute("iogincheck");
        System.out.println("메인창세션값확인-----:"+iogincheck);
        
        String del = "sessiondelete=";
	    
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

	@RequestMapping("/template")
	public String template(Model model){
		
		return "template";
	}

}

