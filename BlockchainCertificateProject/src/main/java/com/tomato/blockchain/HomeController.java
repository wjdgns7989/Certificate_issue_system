package com.tomato.blockchain;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.tomato.bean.UserBean;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// 1. 원래 있던 코드에서 HttpServletRequest request 라는 파라메터를 추가.
	// 2. @RequestMapping 어노테이션은 value값으로 된 URI값, 지정된 method방식으로 페이지 접근 요청이 들어오면
	// 해당 기능을 수행.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	// 1. 로그인페이지 요청 시 작업내용
	// 2. ( method = RequestMethod.GET ) 부분은 GET방식 요청으로만 접근 할 수 있다는 뜻
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(HttpServletRequest request, Model model) {
		// 세션정보에 유저 정보가 있으면 메인페이지로 강제이동
		if (getUserSession(request) != null) {
			return redirectView(request, "/");
		} else {
			// 그게 아니면 로그인 페이지를 보여줌
			return new ModelAndView("login");
		}
	}

	// 1. 로그인 요청 작업 수행 페이지x
	// 2. ( method = RequestMethod.POST ) 부분은 POST방식 요청으로만 접근 할 수 있다는 뜻
	// 3. @RequestParam 어노테이션은 페이지 요청 받았을 시
	// 지정된 name으로 파라메터값이 존재하면 바로 변수에 넣어줌. required 설정가능 (기본=true)
	@RequestMapping(value = "/login-request", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, Model model,
			@RequestParam(name = "login_id") String username, @RequestParam(name = "login_password") String password) {

		// 세션값을 가져오고 만약 null값이면 세션을 새로 생성함.
		HttpSession session = request.getSession(true);

		// 로그인 오류메시지 세션이 존재하면 해당 값의 로그인 오류메시지 세션만 지움
		if (session.getAttribute("LOGIN_EXCEPTION") != null) {
			session.removeAttribute("LOGIN_EXCEPTION");
		}

		// 임의의 로그인 아이디/비밀번호 지정
		final String tomatoUsername = "13010971";
		final String tomatoPassword = "12345678";

		// 요청받은 아이디와 비밀번호가 임의로 정한 값과 동일할 시.
		if (username.equals(tomatoUsername) && password.equals(tomatoPassword)) {
			// 유저 빈 생성후 빈에 들어갈 값들을 지정
			UserBean user = new UserBean();
			user.setUsername(username);
			user.setPassword(password);
			user.setNickname("김정훈");

			// 세션에 유저 정보값을 저장
			session.setAttribute("USER_SESSION", user);

			// 메인 페이지로 강제이동
			return redirectView(request, "/");
		} else {
			// 비밀번호나 아이디가 틀렸을 시 로그인 오류메시지를 세션에 저장.
			session.setAttribute("LOGIN_EXCEPTION", "없는 아이디거나 비밀번호가 틀렸습니다.");
		}

		return redirectView(request, "/login");
	}

	// 1. 로그아웃 요청시 수행
	@RequestMapping(value = "/logoff", method = RequestMethod.GET)
	public ModelAndView logoff(HttpServletRequest request, Model model) {

		// 세션을 가져오되 새로 생성하진않음.
		HttpSession session = request.getSession(false);

		// 세션이 null값이 아니면
		if (session != null) {
			// 세션을 초기화시킴
			session.invalidate();
		}
		return redirectView(request, "/");
	}

	// 로그인 된 유저정보를 세션에서 가져옴
	private UserBean getUserSession(HttpServletRequest request) {
		// 세션을 가져오지만 새로 생성하진않음.
		HttpSession session = request.getSession(false);

		// 세션이 존재하면
		if (session != null) {
			// 세션에서 유저정보를 가져옴
			Object obj = session.getAttribute("USER_SESSION");

			// 값이 null이 아니면서 UserBean Class값이면
			if (obj != null && obj instanceof UserBean) {
				// UserBean Class로 캐스팅 한 후 값 리턴
				return (UserBean) obj;
			}
		}
		return null;
	}

	// 페이지 강제이동을 위한 함수
	private ModelAndView redirectView(HttpServletRequest request, String url) {
		RedirectView rv = new RedirectView();
		ModelAndView mav = new ModelAndView(rv);
		rv.setUrl(request.getContextPath() + url);

		// GET방식으로 된 파라메터들을 모두 없앰
		rv.setExposePathVariables(false);
		// Model에 등록 된 값들을 모두 없앰
		rv.setExposeModelAttributes(false);

		return mav;
	}
}
