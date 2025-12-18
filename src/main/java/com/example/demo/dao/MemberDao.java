package com.example.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dto.Member;

@Mapper
public interface MemberDao {
	@Insert("""
			INSERT INTO `member`
				SET loginId = #{loginId}
					, loginPw = #{loginPw}
					, regDate = NOW()
					, updateDate = NOW()
					, name = #{name}
			""")
	public void joinMember(String loginId, String loginPw, String name);

	
	@Select("""
			SELECT * FROM `member`
				WHERE loginId = #{loginId}
			""")
	public Member getByLoginId(String loginId);
	
	@Update("""
			UPDATE `member`
				SET loginPw = #{loginPw}
					, updateDate = NOW()
					, name = #{name}
			""")
	public void modifyMember(String loginPw, String name);
}
