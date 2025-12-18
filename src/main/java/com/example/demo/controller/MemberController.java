package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Member;
import com.example.demo.service.MemberService;
import com.example.demo.util.Util;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	private MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/usr/member/join")
	public String join() {
		return "/usr/member/join";
	}
	
	@PostMapping("/usr/member/doJoin") 
	@ResponseBody
	public String doJoin(String loginId, String loginPw, String name) {
		
		Member member = this.memberService.getByLoginId(loginId);
		
		if (member != null) {
			return Util.jsReplace("중복되는 아이디입니다", "join");
		}
		this.memberService.joinMember(loginId, loginPw, name);
		
		return Util.jsReplace("회원가입 완료", "login");
	}
	
	@GetMapping("/usr/member/login")
	public String login() {
		return "/usr/member/login";
	}
	
	@PostMapping("/usr/member/doLogin")
	@ResponseBody
	public String doLogin(HttpSession session, String loginId, String loginPw) {
		Member member = this.memberService.getByLoginId(loginId);
		
		return null;
	}
	
	@GetMapping("usr/member/logout")
	@ResponseBody
	public void logout(HttpSession session) {
		session.invalidate();
	}
}
