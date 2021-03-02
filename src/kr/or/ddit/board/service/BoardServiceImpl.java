package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public class BoardServiceImpl implements IBoardService {
	
	private IBoardDao dao;
	private static IBoardService service;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getDao();
	}
	
	public static IBoardService getservice() {
		if(service ==null) service = new BoardServiceImpl();
		
		return service;
	}
	
	

	@Override
	public List<BoardVO> listAll() {
		List<BoardVO> list = null;
		
		try {
			list = dao.listAll();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
		

	@Override
	public List<BoardVO> listPage(Map<String, Object> map) {
		List<BoardVO> list = null;
		
		try {
			list = dao.listPage(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getTotalCount() {
		int cnt = 0;
		
		try {
			cnt = dao.getTotalCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int insertReply(ReplyVO vo) {
		int rnum = 0;
		
		try {
			rnum = dao.insertReply(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rnum;
	}

	@Override
	public List<ReplyVO> listReply(int bonum) {
		List<ReplyVO> list = null;
		
		try {
			list = dao.listReply(bonum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int updateReply(ReplyVO vo) {
		int res = 0;
		
		try {
			res = dao.updateReply(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int deleteReply(int renum) {
		int res = 0;
		
		try {
			res = dao.deleteReply(renum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		int seq = 0;
		try {
			seq = dao.insertBoard(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return seq;
	}

	@Override
	public int deleteBoard(int seq) {
		int cnt = 0;
		
		try {
			cnt = dao.deleteBoard(seq);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO vo) {
		int cnt = 0;
		
		try {
			cnt = dao.updateBoard(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int hitUpdate(int seq) {
		int cnt = 0;
		
		try {
			cnt = dao.hitUpdate(seq);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

}
