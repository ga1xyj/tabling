package dev.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.controller.Controller;
import dev.controller.Utils;
import dev.domain.Board;
import dev.domain.Comment;
import dev.domain.Member;

public class PostDetailController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 요청에서 세션 받아옴
				Member loginMember = (Member) req.getSession().getAttribute("loginMember");
				req.getSession().setAttribute("loginMember", loginMember);
				
				//postList.jsp에서 받아오는 boardId속성값 변수 선언
				String bdId = req.getParameter("boardId");
				
				int boardId=0;
				
				//postAdd.do에서 바로 넘어왔을 때 = 속성값 boardId값이 없을 때
				//==>변수 boardId에 postAdd.do에서 받아온 속성값을 Board타입으로 선언. 그것의 boardId를 가져와서 담음
				if (bdId == null) {
					boardId = ((Board) req.getAttribute("boardDetail")).getBoardId();
				} else {
					//postList.jsp에서 넘어온다면 = 선택한 글의 boardId 속성값 받아옴
					boardId = Integer.parseInt(req.getParameter("boardId")); 
				}
				
				//받아온 boardId값을 Board타입의 매개변수에 넣어 단건 조회 서비스 실행
				Board boardDetail = boardService.getPost(boardId);
				
//				//---------코멘트 목록 전체
				List<Comment> commentList = commentService.commentList(boardId);
				
				//BoardVO 속성값 세팅-> postDetail.jsp
				req.setAttribute("boardDetail", boardDetail);
				//CommentVo 속성값 세팅 ->postDetail.jsp
				req.setAttribute("comment",commentList);
				
				//---------postDetail 뷰 전송
				Utils.forward(req, resp, "/board/postDetail.tiles");
			}
		}