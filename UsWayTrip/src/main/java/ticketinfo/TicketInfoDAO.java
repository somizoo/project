package ticketinfo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ticketinfodata.TicketInfoDataVO;
import ticketinfojoin.TicketInfoJoinVO;

public class TicketInfoDAO {
	
	private SqlSession sqlSession;
	
	public TicketInfoDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int tiInsert(TicketInfoVO ti_vo) {
		sqlSession.insert("ticketinfo.tiInsert", ti_vo);
		return ti_vo.getTi_no();
	}
	
	public int tidInsert(TicketInfoDataVO tid_vo) {
		return sqlSession.insert("ticketinfo.tidInsert", tid_vo);
	}

	public TicketInfoVO tiSelect() {
		return sqlSession.selectOne("ticketinfo.tiSelect");
	}

	public List<TicketInfoVO> tiSelectList() {
		return sqlSession.selectList("ticketinfo.tiSelectList");
	}
	
	public List<TicketInfoDataVO> tidSelectList() {
		return sqlSession.selectList("ticketinfo.tidSelectList");
	}

	public TicketInfoVO tiSelectOne(int ti_no) {
		return sqlSession.selectOne("ticketinfo.tiSelectOne", ti_no);
	}

	public TicketInfoDataVO tidSelectOne(int ti_no) {
		return sqlSession.selectOne("ticketinfo.tidSelectOne", ti_no);
	}
	
	public List<TicketInfoDataVO> tidValSelect(int ti_no) {
		return sqlSession.selectList("ticketinfo.tidValSelect", ti_no);
	}

	public int tiUpdate(TicketInfoVO ti_vo) {
		return sqlSession.update("ticketinfo.tiUpdate", ti_vo);
	}

	public int tiUpdate(TicketInfoDataVO tid_vo) {
		return sqlSession.update("ticketinfo.tidUpdate", tid_vo);
	}

	public int delete(int ti_no) {
		return sqlSession.delete("ticketinfo.delete", ti_no);
	}

	public List<TicketInfoVO> tiAllSelectList() {
		return sqlSession.selectList("ticketinfo.tiAllSelectList");
	}

	public int tijInsert(TicketInfoJoinVO tij) {
		return sqlSession.insert("ticketinfo.tijInsert", tij);
	}

	public List<TicketInfoDataVO> tijSelect(int no) {
		return sqlSession.selectList("ticketinfo.tijSelect", no);
	}

	public int tidDelete(int tid_no) {
		return sqlSession.delete("ticketinfo.tidDelete", tid_no);
	}

	public List<TicketInfoDataVO> tidSelectValList(int ti_no) {
		return sqlSession.selectList("ticketinfo.tidSelectValList", ti_no);
	}


	


}
