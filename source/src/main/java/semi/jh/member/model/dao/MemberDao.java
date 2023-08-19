package semi.jh.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import semi.jh.member.model.dto.MemberDto;

public class MemberDao {
	public int memberInsert(SqlSession session, MemberDto vo) {
		int result = session.insert("memberMapper1.memberInsert", vo);
		System.out.println("MemberDao mapper애서 insert 성공");
		return result;
	}
}
