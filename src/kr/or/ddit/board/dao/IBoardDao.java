package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardDao {

	
	// 전체 게시글 가져오기
	public List<BoardVO> listAll() throws SQLException;
	
	//페이지별 가져오기 
	public List<BoardVO> listPage(Map<String, Object> map) throws SQLException;
	
	// 전체글 갯수 가져오기
	public int getTotalCount() throws SQLException;
	
	// 게시글 등록
	public int insertBoard(BoardVO vo) throws SQLException;
		
	// 게시글 삭제 
	public int deleteBoard(int seq) throws SQLException;
		
	// 게시글 수정
	public int updateBoard(BoardVO vo) throws SQLException;
	
	// 조회수 증가
	public int hitUpdate(int seq) throws SQLException;
	
	// 댓글 등록
	public int insertReply(ReplyVO vo) throws SQLException;
	
	// 댓글 수정
	public int updateReply(ReplyVO vo) throws SQLException;
	
	// 댓글 삭제
	public int deleteReply(int renum) throws SQLException;
	
	//댓글 리스트
	public List<ReplyVO> listReply(int bonum) throws SQLException; 
	
}
