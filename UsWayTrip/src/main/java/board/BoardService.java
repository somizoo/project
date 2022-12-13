package board;

import java.util.List;
import java.util.Map;

import boarddata.BoardDataVO;

public class BoardService {
	public BoardDAO boardDao;
	
	public BoardService(BoardDAO boardDao) {
		this.boardDao = boardDao;
	}
	
	public List<BoardDataVO> selectList() {
		List<BoardDataVO> list = boardDao.selectList();
		
		if(list.isEmpty()) {
			System.out.println(list);
			list = null;
		}
		return list;
	}
	
	public List<BoardDataVO> selectList2(Map<String, Object> map) {
		List<BoardDataVO> list = boardDao.selectList2(map);
		if(list.isEmpty()) {
			System.out.println(list);
			list = null;
		}
		return list;
	}
	
	public BoardVO selectOne(int board_no) {
		
		return boardDao.selectOne(board_no);
	}
	
	public int count(int board_no) {
		return boardDao.count(board_no);
	}
	
}
