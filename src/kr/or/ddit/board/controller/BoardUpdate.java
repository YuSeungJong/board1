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


@WebServlet("/BoardUpdate.do")
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BoardUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//0. writer, subject, mail, password, content, seq
		//가져와서 BoardVO에 저장
		BoardVO vo = new BoardVO();
		
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		vo.setWriter(writer);
		vo.setSubject(subject);
		vo.setMail(mail);
		vo.setPassword(password);
		vo.setContent(content);
		vo.setSeq(seq);
		
		//1
		IBoardService service = BoardServiceImpl.getservice();
		//2
		int cnt = service.updateBoard(vo);
		//3
		request.setAttribute("result", cnt);
		
		//4
		request.getRequestDispatcher("board/result.jsp").forward(request, response);
	}

}





















