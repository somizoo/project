package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import board.BoardService;
import board.BoardVO;
import boarddata.BoardDataVO;
import common.RedirectPath;
import common.ViewPath;


@Controller
public class BoardController {
	
	private BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	// 메인리스트에서 자세히 보기 눌렀을 경우
	@RequestMapping("/admin/board/noticeListForm/{board_no1}/{board_no2}")
	public String noticeList(Model model, @PathVariable("board_no1") int board_no1, @PathVariable("board_no2") int board_no2) {
				
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("board_no1", board_no1);
		map.put("board_no2", board_no2);
		
		List<BoardDataVO> list = boardService.selectList2(map);
		
		BoardVO vo1 = boardService.selectOne(board_no1);
		BoardVO vo2 = boardService.selectOne(board_no2);
		
		model.addAttribute("vo1", vo1);
		model.addAttribute("vo2", vo2);
		
		int count1 = boardService.count(board_no1);
		int count2 = boardService.count(board_no2);
		
		model.addAttribute("count1", count1);
		model.addAttribute("count2", count2);
		
		model.addAttribute("list", list);
		model.addAttribute("boardpath", RedirectPath.A_BOARD);
		model.addAttribute("bdpath", RedirectPath.A_BD);
		model.addAttribute("b_no1",board_no1);
		model.addAttribute("b_no2",board_no2);
		
		return ViewPath.A_BOARD + "noticeListForm.jsp";
	}
	
	// adminheader에서 게시판 눌렀을 경우
	@RequestMapping("/admin/board/mainListForm")
	public String mainList(Model model) {
		
		List<BoardDataVO> list = boardService.selectList();
//		model.addAttribute("count", list.size());
		model.addAttribute("list", list);
		model.addAttribute("boardpath", RedirectPath.A_BOARD);
		model.addAttribute("bdpath", RedirectPath.A_BD);
		
		return ViewPath.A_BOARD + "mainListForm.jsp";
	}
	
	// 22.12.07 사용자 메인 게시판
	@RequestMapping("/board/mainListForm")
	public String UmainList(Model model) {
		
		List<BoardDataVO> list = boardService.selectList();
		model.addAttribute("list", list);
		model.addAttribute("boardpath", RedirectPath.U_BOARD);
		model.addAttribute("bdpath", RedirectPath.U_BD);
		
		return ViewPath.U_BOARD + "mainListForm.jsp";
	}
	
	// 22.12.07 사용자용 공지리스트
		@RequestMapping("/board/noticeListForm/{board_no1}/{board_no2}")
		public String UnoticeList(Model model, @PathVariable("board_no1") int board_no1, @PathVariable("board_no2") int board_no2) {
					
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("board_no1", board_no1);
			map.put("board_no2", board_no2);
			
			List<BoardDataVO> list = boardService.selectList2(map);
			
			BoardVO vo1 = boardService.selectOne(board_no1);
			BoardVO vo2 = boardService.selectOne(board_no2);
			
			model.addAttribute("vo1", vo1);
			model.addAttribute("vo2", vo2);
			
			int count1 = boardService.count(board_no1);
			int count2 = boardService.count(board_no2);
			
			model.addAttribute("count1", count1);
			model.addAttribute("count2", count2);
			
			model.addAttribute("list", list);
			model.addAttribute("boardpath", RedirectPath.U_BOARD);
			model.addAttribute("bdpath", RedirectPath.U_BD);
			model.addAttribute("b_no1",board_no1);
			model.addAttribute("b_no2",board_no2);
			
			return ViewPath.U_BOARD + "noticeListForm.jsp";
		}
	
}































