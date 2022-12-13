package ticket;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import img.ImgVO;
import ticketevent.TicketEventVO;
import ticketeventdata.TicketEventDataVO;
import ticketoption.TicketOptionVO;

public class TicketDAO {

   private SqlSession sqlSession;
    
   public TicketDAO(SqlSession sqlSession) {
      this.sqlSession = sqlSession;
   }
   
   // ticket 상품 리스트
   public List<TicketVO> selectList() {
      return sqlSession.selectList("ticket.selectList");
   }
   
   // ticket 정보 삽입
   public int ticketInsert(TicketVO vo) {
      sqlSession.insert("ticket.ticketInsert", vo);
      System.out.println(vo.getTicket_no());
      return vo.getTicket_no();
   }
   
   
   public TicketVO selectOne(int no) {
      return sqlSession.selectOne("ticket.selectOne", no);
   }

   
   public String tscSelectOne(int no) {
      return sqlSession.selectOne("ticket.tscSelectOne", no);
   }
   
   public String placeSelectOne(int no) {
      return sqlSession.selectOne("ticket.placeSelectOne", no);
   }
   
   public TicketOptionVO toSelectOne(int no) {
      return sqlSession.selectOne("ticket.toSelectOne", no);
   }
   
   public int delete(int no) {
      return sqlSession.delete("ticket.delete", no);
   }

   public List<TicketOptionVO> toSelectList(int no) {
      return sqlSession.selectList("ticket.toSelectList", no);
   }

   public List<TicketEventVO> teSelectList() {
      return sqlSession.selectList("ticket.teSelectList");
   }

   public int imgInsert(ImgVO imgvo) {
      return sqlSession.insert("ticket.imgInsert", imgvo);
   }
   
   public int teInsert(TicketEventDataVO ted_vo) {
      return sqlSession.insert("ticket.teInsert", ted_vo);
   }
   
   public List<String> teNameSelectList(int no) {
      return sqlSession.selectList("ticket.teNameSelectList", no);
   }

   public List<ImgVO> multiImgSelect(int product_no) {
      return sqlSession.selectList("ticket.multiImgSelect", product_no);
   }

   public TicketVO joinSelectOne(int no) {
      return sqlSession.selectOne("ticket.joinSelectOne", no);
   }

   public TicketVO joinTeSelectOne(int no) {
      return sqlSession.selectOne("ticket.joinTeSelectOne", no);
   }

   public int update(TicketVO vo) {
      return sqlSession.update("ticket.update", vo);
   }
   
   /* 22.12.06 추가 */
   public TicketVO wishList(int no) {
      return sqlSession.selectOne("ticket.wishList", no);
   }
   

	public List<Integer> joinTeSelectList(int no) {
		return sqlSession.selectList("ticket.joinTeSelectList", no);
	}

	public TicketVO ticketSelectOne(int product_no) {
		return sqlSession.selectOne("ticket.ticketSelectOne", product_no);
	}

	public List<TicketVO> toPaySelectList(int product_no) {
		return sqlSession.selectList("ticket.toPaySelectList", product_no);
	}
	
	/* 22.12.08 추가*/
   public int wishChoice(Map<String, Integer> map) {
	      return sqlSession.selectOne("ticket.wishChoice", map);
	   }


}