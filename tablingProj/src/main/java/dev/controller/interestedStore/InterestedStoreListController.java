package dev.controller.interestedStore;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dev.controller.Utils;
import dev.controller.Controller;
import dev.domain.InterestedStore;
import dev.domain.Member;

public class InterestedStoreListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		// 세션 로그인 멤버
		Member loginMember = (Member) req.getSession().getAttribute("loginMember");
		
		// 테스트용
//		loginId = "user1";
		
		List<InterestedStore> list = interestedStoreService.findAllPickStore(loginMember.getMemberId());
//		System.out.println("inter");
//		list.forEach(System.out::println);
		
		req.setAttribute("list", list);
		
		Utils.forward(req, resp, "reservationList.do");
	}

}
