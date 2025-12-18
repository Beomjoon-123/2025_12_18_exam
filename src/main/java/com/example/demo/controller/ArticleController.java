package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Article;
import com.example.demo.service.ArticleService;
import com.example.demo.util.Util;

public class ArticleController {
	private ArticleService articleService;
	
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@GetMapping("/usr/article/write")
	public String write() {
		return "/usr/article/write";
	}
	
	@PostMapping("/usr/article/doWrite")
	@ResponseBody
	public String dowrite(String title, String content, int memberId) {
		
		this.articleService.writeArticle(title, content, memberId);
		return Util.jsReplace("작성 완료", "/");
	}
	
	@GetMapping("/usr/article/list")
	public String list() {
		List<Article> article = this.articleService.listArticle();
				
		return null;
	}
	
	@GetMapping("/usr/article/detail")
	public String detail() {
		//Article
		return null;
	}
}
