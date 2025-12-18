package com.example.demo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.example.demo.dto.Article;

@Mapper
public interface ArticleDao {
	@Insert("""
			INSERT INTO article
				SET regDate = NOW()
					, updateDate = NOW()
					, title = #{title}
					, content = #{content}
					, memberId = #{memberId}
			""")
	public void writeArticle(String title, String content, int memberId);
	
	@Select("""
			SELECT LAST_INSERT_Id();
			""")
	
	public int getLastInsertId();
	
	@Select("""
			SELECT a.*, m.loginId
				FROM member m
				JOIN article a
				ON m.id = a.memberId
				ORDER BY m.loginId DESC
			""")
	public List<Article> listArticle();
	
	@Select("""
			SELECT a.*, m.loginId
				FROM member m
				JOIN article a
				ON m.id = a.memberId
				WHERE a.id = #{id}
			""")
	public Article getArticleById();
	
	@Update("""
			UPDATE article
				SET updateDate = NOW()
					, title = #{title}
					, content = #{content}
			""")
	public void modifyArticle(String title, String content);
	
	@Delete("""
			DELETE FROM article
			WHERE id = "{id}
			""")
	public void deleteArticle(int id);
}
