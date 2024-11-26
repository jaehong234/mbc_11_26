package kr.co.mbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import kr.co.mbc.dto.MemberForm;
import kr.co.mbc.entity.MemberEntity;
import kr.co.mbc.service.MemberService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

	private final MemberService memberService;
	
	@GetMapping("/mainpage")
	public void mainpage() {
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		
		
		return "redirect:/member/login";
	}
	
	@GetMapping("/read/{username}")
	public String read(@PathVariable("username")String username, Model model) {
		
		MemberEntity memberEntity = memberService.findByUsername(username);
		memberEntity.setId(0L);
		memberEntity.setPassword(null);
		
		model.addAttribute("memberEntity", memberEntity);
		
		return "/member/read";
	}
	
	@PostMapping("/login")
	public String login(MemberForm memberForm, HttpSession session) {
		
		MemberEntity memberEntity = MemberEntity.toMemberEntity(memberForm);
		
		try {
			memberEntity = memberService.login(memberEntity);
		} catch (Exception e) {
			e.printStackTrace();
			
			return "redirect:/member/login";
		}
		
		memberEntity.setId(0L);
		memberEntity.setPassword(null);
		
		session.setAttribute("login", memberEntity);
		
		
		return "redirect:/member/read/" + memberForm.getUsername();
	}
	
	@GetMapping("/login")
	public void login() {
		
	}
	
	@PostMapping("/insert")
	public String save(MemberForm memberForm) {
		
		MemberEntity memberEntity = MemberEntity.toMemberEntity(memberForm);
		
		memberService.save(memberEntity);
		
		return "redirect:/member/login";
	}
	
	@GetMapping("/insert")
	public void save() {
		
	}
	
}
