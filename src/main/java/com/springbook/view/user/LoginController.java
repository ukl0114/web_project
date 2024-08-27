package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

//SpringFramework에서 제공하는 Controller, interface의 handleRequest메소드는 리턴 타입 ModelAndView
public class LoginController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 처리");
		
		//1. 사용자 입력 정보 추출(login.jsp에서 전송한 id, password 받기)
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//2. DB연동 처리(UserDAO의 메소드 호출)
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		//3. 화면 네비게이션(로그인 후 화면 이동 처리)
		//DB 연동 후 리턴받은 데이터와 View를 모두 담을 수 있는 객체
		ModelAndView mav = new ModelAndView();
		//로그인 성공 시 게시판 목록 조회 화면으로 이동
		if(user != null) {
			//redirect : viewResolver를 무시하고 바로 리다이렉트
			mav.setViewName("redirect:getBoardList.do");
		//로그인 실패 시 다시 로그인 화면으로 이동
		} else {
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
	}
}