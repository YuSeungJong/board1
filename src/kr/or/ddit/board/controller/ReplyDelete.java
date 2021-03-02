package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;


@WebServlet("/ReplyDelete.do")
public class ReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReplyDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0. 
		int renum = Integer.parseInt(request.getParameter("renum"));
		
		//1. service객체 얻기
		IBoardService service = BoardServiceImpl.getservice();
		
		//2. service메소드 호출 - 결과값 받기
		int res = service.deleteReply(renum);
		
		//3. 결과를 request에 저장
		request.setAttribute("res", res);
		
		//4. jsp로 forward
		request.getRequestDispatcher("board/replyDelete.jsp").forward(request, response);
	}

}





















