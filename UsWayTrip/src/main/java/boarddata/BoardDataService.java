package boarddata;

import java.util.List;

import board.BoardDAO;
import board.BoardVO;
import boarddatafile.BoardDataFileDAO;
import boarddatafile.BoardDataFileVO;


public class BoardDataService {
	public BoardDataDAO boardDataDao;
	public BoardDAO boardDao;
	public BoardDataFileDAO boardDataFileDao;
	
//	public BoardDataService(BoardDataDAO boardDataDao) {
//		this.boardDataDao = boardDataDao;
//	}
	
	public BoardDataService(BoardDataDAO boardDataDao,BoardDAO boardDao, BoardDataFileDAO boardDataFileDAO) {
		this.boardDataDao = boardDataDao;
		this.boardDao = boardDao;
		this.boardDataFileDao = boardDataFileDAO;
	}
	
	public List<BoardDataVO> selectList() {
		List<BoardDataVO> list = boardDataDao.selectList();
		
		if(list.isEmpty()) {
			System.out.println(list);
			list = null;
		}
		return list;
	}

	public List<BoardDataVO> bnSelectList(int board_no) {
		List<BoardDataVO> list = boardDataDao.bnSelectList(board_no);
		
		if(list.isEmpty()) {
			System.out.println(list);
			list = null;
		}
		return list;
	}
	
	public int insert(BoardDataVO vo) {
		int check = boardDataDao.insert(vo);
		
		return check;
	}
	
	public BoardDataVO selectOne(BoardDataVO vo) {
		return boardDataDao.selectOne(vo);
	}
	
	// 22.12.01 추가
	public BoardVO selectOne(int board_no) {
		return boardDao.selectOne(board_no);
	}
	
	public int delete(int bd_no) {
		
		return boardDataDao.delete(bd_no);
	}
	
	// 11.26 추가
	public int update(BoardDataVO vo) {
		return boardDataDao.update(vo);
	}
	
	// 22.12.02
	public void fileInsert(int bd_no, List<String> fileList) {
		for(String filename : fileList) {
			boardDataFileDao.insert(new BoardDataFileVO(filename, bd_no));
		}
	}
	
	// 22.12.02
	public List<BoardDataFileVO> fileSelectList(int bd_no) {
		return boardDataFileDao.selectList(bd_no);
	}
	
	public int getBd_no() {
		return boardDataDao.getBd_no();
	}
	
}
