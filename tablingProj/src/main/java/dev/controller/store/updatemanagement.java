package dev.controller.store;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.controller.Controller;
import dev.controller.Utils;
import dev.domain.Member;
import dev.domain.Store;

public class updatemanagement implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		
		Member loginMember = (Member) req.getSession().getAttribute("loginMember");
	    String loginMemberId = loginMember.getMemberId();
		
//		Store st = storeService.storemanagement(loginMemberId);
	    // 0816_wana - 점주가 점포조회 후 해당 점포를 파라미터로 넘겨줌
	    String storeName = req.getParameter("storeName");
	    Store store = storeService.findOneStore(storeName);
		
		System.out.println("member = " + loginMemberId);
		
		req.setAttribute("store", store);
		
		Utils.forward(req, resp, "/store/storeupdatemanager.tiles");
	}

}
