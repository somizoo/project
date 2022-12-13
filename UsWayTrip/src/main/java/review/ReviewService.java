package review;

import java.util.List;

import member.MemberDAO;
import reviewimg.ReviewImgDAO;
import reviewimg.ReviewImgVO;

public class ReviewService {
	private ReviewDAO reviewDao;
	private MemberDAO memberDao;
	private ReviewImgDAO riDao;
	public ReviewService(ReviewDAO reviewDao, MemberDAO memberDao, ReviewImgDAO riDao) {
		this.reviewDao = reviewDao;
		this.memberDao = memberDao;
		this.riDao = riDao;
	}


	public List<ReviewVO> allList(){
		return reviewDao.allList();
	}
	
	public String getName(int no) {
		return memberDao.getName(no);
	}

	public int insert(ReviewVO vo) {
		return reviewDao.insert(vo);
	}
	
	public int insertImg(ReviewImgVO vo) {
		return riDao.insert(vo);
	}
	
	public ReviewVO selectOne(int reviewSeq) {
		return reviewDao.selectOne(reviewSeq);
	}


	public List<String> getImage(int seq) {
		return riDao.getImage(seq);
	}


	public int update(ReviewVO vo) {
		return reviewDao.update(vo);
	}


	public int delete(int seq) {
		return reviewDao.delete(seq);
	}
	
	public int deleteImg(int seq) {
		return riDao.deleteImg(seq);
	}
	
	public List<ReviewVO> allUList(int member_no){
		return reviewDao.allUList(member_no);
	}
}
