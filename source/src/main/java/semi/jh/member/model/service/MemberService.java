package semi.jh.member.model.service;

import org.apache.ibatis.session.SqlSession;

import semi.jh.common.jdbc.MyBatisTemplate;
import semi.jh.member.model.dao.MemberDao;
import semi.jh.member.model.dto.MemberDto;

public class MemberService {
	private MemberDao dao = new MemberDao();
	
	public int memberInsert (MemberDto vo) {
		System.out.println("Service memberInsert 실행");
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		System.out.println("Service 전달 접속 완료");
		int result = dao.memberInsert(session, vo);
		return result;
	}
}
