package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;
/*
 *  SqlMapClient 객체 얻어오기
 *  자신의 객체를 생성해서 리턴 
 */
public class BoardDaoImpl implements IBoardDao {
      private SqlMapClient client;
      private static IBoardDao dao;
      
      private BoardDaoImpl() {
    	  client = SqlMapClientFactory.getSqlMapClient();
      }
      
      public static IBoardDao getDao() {
    	  if(dao==null) dao = new BoardDaoImpl();
    	  return dao;
      }
	
	@Override
	public List<BoardVO> listAll() throws SQLException {
		// TODO Auto-generated method stub
		return client.queryForList("board.listAll");
	}

	@Override
	public List<BoardVO> listPage(Map<String, Object> map) throws SQLException {
		
		
		return client.queryForList("board.listPage", map);
	}

	@Override
	public int getTotalCount() throws SQLException {
		// TODO Auto-generated method stub
		return (Integer) client.queryForObject("board.getTotalCount");
	}

	@Override
	public int insertReply(ReplyVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return (Integer)client.insert("reply.insertReply", vo);
	}

	@Override
	public List<ReplyVO> listReply(int bonum) throws SQLException {
		// TODO Auto-generated method stub
		return client.queryForList("reply.listReply", bonum);
	}

	@Override
	public int updateReply(ReplyVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return client.update("reply.updateReply", vo);
	}

	@Override
	public int deleteReply(int renum) throws SQLException {
		// TODO Auto-generated method stub
		return client.delete("reply.deleteReply", renum);
	}

	@Override
	public int insertBoard(BoardVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return (Integer)client.insert("board.insertBoard", vo);
	}

	@Override
	public int deleteBoard(int seq) throws SQLException {
		// TODO Auto-generated method stub
		return client.delete("board.deleteBoard", seq);
	}

	@Override
	public int updateBoard(BoardVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return client.update("board.updateBoard", vo);
	}

	@Override
	public int hitUpdate(int seq) throws SQLException {
		// TODO Auto-generated method stub
		return client.update("board.hitUpdate", seq);
	}

}








