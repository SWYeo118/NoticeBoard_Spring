package kr.ac.kopo.ctc.spring.board.web;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.ctc.spring.board.domain.Notice;
import kr.ac.kopo.ctc.spring.board.dto.Pagination;
import kr.ac.kopo.ctc.spring.board.repository.NoticeRepository;
import kr.ac.kopo.ctc.spring.board.repository.PaginationService;
import kr.ac.kopo.ctc.spring.board.service.NoticeService;
import kr.ac.kopo.ctc.spring.board.service.PaginationServiceImpl;

@Controller
@RequestMapping(value = "/e_02")
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;

	@RequestMapping(value = "")
	public String e_02(Model model, HttpServletRequest req) throws ClassNotFoundException, SQLException {
		// 키값 cPage 받아서 없으면 1
		String key = req.getParameter("cPage");
		if (key == null) {
			key = "0";
		}
		
		// 값이 있으면 keyNum
		Integer keyNum = Integer.parseInt(key);
		
		// 페이지 소팅
		PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id"));
		if (keyNum >= 0) {
			pageRequest = PageRequest.of(keyNum, 10, Sort.by(Sort.Direction.DESC, "id"));
		}
		
		// 총페이지 2
		int totalPage = noticeService.selectAll(pageRequest).getTotalPages();
		
		// 페이지사이즈 10
		int pageSize = noticeService.selectAll(pageRequest).getSize();
		
		// 첫페이지, 마지막페이지, 다음페이지, 이전페이지 세팅
		int ppPage = 0;
		int nnPage = totalPage - 1;
		int nPage = 0;
		int pPage = 0;
		if (totalPage <= nPage + pageSize) {
			nPage = totalPage - 1;
		} else {
			nPage = keyNum + totalPage;
		}
		
		if (pPage + pageSize >= totalPage) {
			pPage = keyNum - pageSize;
		}
		
		model.addAttribute("noticeDataAll", noticeService.selectAll(pageRequest).getContent());
		model.addAttribute("cPageInt", 1);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pPage", pPage);
		model.addAttribute("ppPage", ppPage);
		model.addAttribute("nPage", nPage);
		model.addAttribute("nnPage", nnPage);
		return "e_02";
	}
	
	@RequestMapping(value = "oneview")
	public String e_02_oneview(Model model, HttpServletRequest req) throws ClassNotFoundException, SQLException {
		String key = req.getParameter("key");
		Integer keyNum = Integer.parseInt(key);
		int viewingNum = noticeService.selectOne(keyNum).get().getViewingCount() + 1;
		noticeService.updateById(keyNum, viewingNum);
		model.addAttribute("noticeSelectOne", noticeService.selectOne(keyNum).get());
		model.addAttribute("noticeReplys", noticeService.selectReply(keyNum));
		model.addAttribute("viewingNum", viewingNum);
		
		return "e_02_oneview";
	}
	
	@RequestMapping(value = "allview_pageWrite")
	public String allview_pageWrite(Model model, HttpServletRequest req)
			throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		noticeService.create(title, content);
		return "redirect:/e_02";
	}
	
	@RequestMapping(value = "pageWrite")
	public String e_02_pageWrite(Model model, HttpServletRequest req)
			throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formatDate = now.format(formatter);
		model.addAttribute("formatDate", formatDate);
		return "e_02_pageWrite";
	}
	
	@RequestMapping(value = "delete")
	public String e_02_delete(Model model, HttpServletRequest req)
			throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
		String id = req.getParameter("key");
		int keyNum = Integer.parseInt(id);
		noticeService.delete(keyNum);
		return "redirect:/e_02";
	}
	
	@RequestMapping(value = "update")
	public String e_02_update(Model model, HttpServletRequest req)
			throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
		String id = req.getParameter("key");
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formatDate = now.format(formatter);
		model.addAttribute("formatDate", formatDate);
		int keyNum = Integer.parseInt(id);
		model.addAttribute("noticeSelectOne", noticeService.selectOne(keyNum).get());
		return "e_02_update";
	}
	
	@RequestMapping(value = "allview_update")
	public String allview_update(Model model, HttpServletRequest req)
			throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
		String key = req.getParameter("id");
		int keyNum = Integer.parseInt(key);
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		noticeService.updateById(keyNum, title, content);
		return "redirect:/e_02";
	}
	
	@RequestMapping(value = "replyWrite")
	public String e_02_replyWrite(Model model, HttpServletRequest req)
			throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		String key = req.getParameter("key");
		Integer keyNum = Integer.parseInt(key);
		int viewingNum = noticeService.selectOne(keyNum).get().getViewingCount();
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formatDate = now.format(formatter);
		model.addAttribute("noticeSelectOne", noticeService.selectOne(keyNum).get());
		model.addAttribute("noticeReplys", noticeService.selectReply(keyNum));
		model.addAttribute("viewingNum", viewingNum);
		model.addAttribute("formatDate", formatDate);
		model.addAttribute("key", key);
		model.addAttribute("keyNum", keyNum);
		return "e_02_replyWrite";
	}

	@RequestMapping(value = "allview_replyWrite")
	public String allview_replyWrite(Model model, HttpServletRequest req)
			throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		String key = req.getParameter("key");
		Integer keyNum = Integer.parseInt(key);
		String replyContent = req.getParameter("replyContent");
		String replyAuthor = req.getParameter("replyAuthor");
		noticeService.createReply(replyContent, replyAuthor, keyNum);
		return "redirect:/e_02";
	}
	
	
//	@RequestMapping(value = "")
//	public String e_02(Model model, HttpServletRequest req) throws ClassNotFoundException, SQLException {
//		NoticeRepository noticedao = new NoticeService();
//		PaginationService paginationImpl = new PaginationServiceImpl();
//
//		String cPage = req.getParameter("cPage");
//
//		if (cPage == null || "null".equals(cPage)) {
//			cPage = "1";
//		}
//		int cPageInt = Integer.parseInt(cPage);
//		List<Notice> noticeDatasPage = noticedao.selectAll(cPageInt, 10);
//		int totalCount = noticedao.getTotalCount();
//		Pagination paginationDatas = paginationImpl.getPagination(cPageInt, 10, 10, totalCount);
//		model.addAttribute("noticeDatasPage", noticeDatasPage);
//		model.addAttribute("paginationDatas", paginationDatas);
//		return "e_02";
//	}	
//
//	@RequestMapping(value = "allview_pageWrite")
//	public String allview_pageWrite(Model model, HttpServletRequest req)
//			throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
//		req.setCharacterEncoding("utf-8");
//		NoticeRepository noticedao = new NoticeService();
//		PaginationService paginationImpl = new PaginationServiceImpl();
//		String cPage = req.getParameter("cPage");
//		if (cPage == null || "null".equals(cPage)) {
//			cPage = "1";
//		}
//		int cPageInt = Integer.parseInt(cPage);
//		List<Notice> noticeDatasPage = noticedao.selectAll(cPageInt, 10);
//		int totalCount = noticedao.getTotalCount();
//		Pagination paginationDatas = paginationImpl.getPagination(cPageInt, 10, 10, totalCount);
//		model.addAttribute("noticeDatasPage", noticeDatasPage);
//		model.addAttribute("paginationDatas", paginationDatas);
//		LocalDate now = LocalDate.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String formatDate = now.format(formatter);
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopoctc", "root", "CJDghd9311@");
//		Statement stmt = conn.createStatement();
//		String titleTmp = req.getParameter("title");
//		String contentTmp = req.getParameter("content");
//		stmt.execute(
//				"insert into gongji (title, date, content, viewingCount, replyLevel, replyViewOrder, originalPostId) values('"
//						+ titleTmp + "','" + formatDate + "','" + contentTmp + "', 0, 0, 0, 0);");
//		int maxId = noticedao.getMax();
//		stmt.execute("update gongji SET originalPostId='" + maxId + "' where id ='" + maxId + "';");
//		stmt.close();
//		conn.close();
//
//		return "redirect:/e_02";
//	}
//
//	@RequestMapping(value = "allview_update")
//	public String allview_update(Model model, HttpServletRequest req)
//			throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
//		req.setCharacterEncoding("utf-8");
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopoctc", "root", "CJDghd9311@");
//		Statement stmt = conn.createStatement();
//		String id = req.getParameter("id");
//		String titleTmp = req.getParameter("title");
//		String contentTmp = req.getParameter("content");
//		model.addAttribute("titleTmp", titleTmp);
//		model.addAttribute("contentTmp", contentTmp);
//		model.addAttribute("id", id);
//		stmt.execute("UPDATE gongji SET title='" + titleTmp + "',content='" + contentTmp + "' where id = " + id + ";");
//		stmt.close();
//		conn.close();
//		return "redirect:/e_02";
//	}
//
//	@RequestMapping(value = "oneview")
//	public String e_02_oneview(Model model, HttpServletRequest req) throws ClassNotFoundException, SQLException {
//		NoticeRepository noticedao = new NoticeService();
//		List<Notice> noticeDatas = noticedao.selectAll();
//		String key = req.getParameter("key");
//		int keyNum = Integer.parseInt(key);
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopoctc", "root", "CJDghd9311@");
//		Statement stmt = conn.createStatement();
//		stmt.execute("UPDATE gongji SET viewingCount = viewingCount + 1 where id=" + keyNum + ";");
//		String title = noticedao.getOne(keyNum).getTitle();
//		Date date = noticedao.getOne(keyNum).getDate();
//		String content = noticedao.getOne(keyNum).getContent();
//		int viewingCount = noticedao.getOne(keyNum).getViewingCount();
////		int replyLevel = noticedao.getOne(keyNum).getReplyLevel();
////		int replyViewOrder = noticedao.getOne(keyNum).getReplyViewOrder();
//		model.addAttribute("key", key);
//		model.addAttribute("keyNum", keyNum);
//		model.addAttribute("noticeDatas", noticeDatas);
//		model.addAttribute("title", title);
//		model.addAttribute("date", date);
//		model.addAttribute("content", content);
//		model.addAttribute("viewingCount", viewingCount);
////		model.addAttribute("replyLevel", replyLevel);
////		model.addAttribute("replyViewOrder", replyViewOrder);
//		return "e_02_oneview";
//	}
//
//	@RequestMapping(value = "pageWrite")
//	public String e_02_pageWrite(Model model, HttpServletRequest req)
//			throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
//		req.setCharacterEncoding("utf-8");
//		LocalDate now = LocalDate.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String formatDate = now.format(formatter);
//		model.addAttribute("formatDate", formatDate);
//		return "e_02_pageWrite";
//	}
//
//	@RequestMapping(value = "delete")
//	public String e_02_delete(Model model, HttpServletRequest req)
//			throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopoctc", "root", "CJDghd9311@");
//		Statement stmt = conn.createStatement();
//		NoticeRepository noticedao = new NoticeService();
//		String id = req.getParameter("key");
//		int keyNum = Integer.parseInt(id);
//		stmt.close();
//		conn.close();
//		return "redirect:/e_02";
//	}
//
//	@RequestMapping(value = "update")
//	public String e_02_update(Model model, HttpServletRequest req)
//			throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
//		NoticeRepository noticedao = new NoticeService();
//		List<Notice> noticeDatas = noticedao.selectAll();
//		String key = req.getParameter("key");
//		int keyNum = Integer.parseInt(key);
//		String title = noticedao.getOne(keyNum).getTitle();
//		Date date = noticedao.getOne(keyNum).getDate();
//		String content = noticedao.getOne(keyNum).getContent();
//		model.addAttribute("key", key);
//		model.addAttribute("keyNum", keyNum);
//		model.addAttribute("noticeDatas", noticeDatas);
//		model.addAttribute("title", title);
//		model.addAttribute("date", date);
//		model.addAttribute("content", content);
//		return "e_02_update";
//	}
//
//	@RequestMapping(value = "replyWrite")
//	public String e_02_replyWrite(Model model, HttpServletRequest req)
//			throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
//		req.setCharacterEncoding("utf-8");
//		NoticeRepository noticedao = new NoticeService();
//		String key = req.getParameter("key");
//		int keyNum = Integer.parseInt(key);
//		LocalDate now = LocalDate.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String formatDate = now.format(formatter);
//
//		// 대댓글 확인번호
////		int replyLevel = noticedao.getOne(keyNum).getReplyLevel();
////		int replyLeveltoWrite = replyLevel + 1;
//
//
//		// 댓글 배치번호
////		int replyViewOrder = noticedao.getReplyViewOrders(originalPostIdtoWrite);
////		int replyViewOrdertoWrite = replyViewOrder + 1;
//
//		model.addAttribute("formatDate", formatDate);
//		model.addAttribute("key", key);
//		model.addAttribute("keyNum", keyNum);
////		model.addAttribute("replyLeveltoWrite", replyLeveltoWrite);
////		model.addAttribute("replyViewOrdertoWrite", replyViewOrdertoWrite);
//		return "e_02_replyWrite";
//	}
//
//	@RequestMapping(value = "allview_replyWrite")
//	public String allview_replyWrite(Model model, HttpServletRequest req)
//			throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
//		req.setCharacterEncoding("utf-8");
//		LocalDate now = LocalDate.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String formatDate = now.format(formatter);
//		String bar;
//		String barSum = "";
//		String replyTitle = "";
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopoctc", "root", "CJDghd9311@");
//		Statement stmt = conn.createStatement();
//		String replyContent = req.getParameter("replyContent");
//		String originalPostId = req.getParameter("originalPostId");
//		String replyLevel = req.getParameter("replyLevel");
//		int replyLevelInt = Integer.parseInt(replyLevel);
//		String replyViewOrder = req.getParameter("replyViewOrder");
//		String title = req.getParameter("replyTitle");
//		if (replyLevelInt >= 2) {
//			for (int i = 0; i < replyLevelInt - 1; i++) {
//				bar = "↳";
//				barSum += bar;
//			}
//			replyTitle = "↳" + barSum + title;
//		} else {
//			replyTitle = "↳" + title;
//		}
//		stmt.execute(
//				"insert into gongji (title, date, content, viewingCount, replyViewOrder, originalPostId, replyLevel) values('"
//						+ replyTitle + "','" + formatDate + "','" + replyContent + "', 0, '" + replyViewOrder + "', '"
//						+ originalPostId + "', '" + replyLevel + "');");
//		stmt.close();
//		conn.close();
//		return "redirect:/e_02";
//	}

}
