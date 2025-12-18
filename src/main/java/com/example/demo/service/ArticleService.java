package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.dao.ArticleDao;
import com.example.demo.dto.Article;

@Service
public class ArticleService {
	private ArticleDao articleDao;
	
	public ArticleService(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	public void writeArticle(String title, String content, int memberId) {
		this.articleDao.writeArticle(title, content, memberId);
	}
	
	public int getlastInsertId() {
		return this.articleDao.getLastInsertId();
	}
	
	public List<Article> listArticle() {
		return this.articleDao.listArticle();
	}
	
	public Article getArticleById() {
		return this.articleDao.getArticleById();
	}
	
	public void modifyArticle(String title, String content) {
		this.articleDao.modifyArticle(title, content);
	}
	
	public void deleteArticle(int id) {
		this.articleDao.deleteArticle(id);
	}
}
