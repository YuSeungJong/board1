package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class BoardSave
 */
@WebServlet("/BoardSave.do")
public class BoardSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//0. 클라이언트 데이터 가져오기
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String password = request.getParameter("password");
		String mail = request.getParameter("mail");
		String content = request.getParameter("content");
		
		BoardVO vo = new BoardVO();
		
		vo.setWriter(writer);
		vo.setSubject(subject);
		vo.setPassword(password);
		vo.setMail(mail);
		vo.setContent(content);
		
		vo.setWip(request.getRemoteAddr());
		
		//1 서비스 객체 얻어오기
		IBoardService service = BoardServiceImpl.getservice();
		
		//2
		int seq = service.insertBoard(vo);
		
		//3
		request.setAttribute("result", seq);
		
		//4
		request.getRequestDispatcher("board/result.jsp").forward(request, response);
		
	}

}























