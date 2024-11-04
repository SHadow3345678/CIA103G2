package com.counter.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import com.counter.model.CounterService;
import com.counter.model.CounterVO;
import com.emp.model.*;

@MultipartConfig
public class CounterServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer counterNo = Integer.valueOf(req.getParameter("counterNo"));

			/*************************** 2.開始查詢資料 ****************************************/
			CounterService counterSvc = new CounterService();
			CounterVO counterVO = counterSvc.getOneCounter(counterNo);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("counterVO", counterVO); // 資料庫取出的empVO物件,存入req
			String url = "/back-end/counter/update_counter_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}
//		
//
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

//				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer counterNo = Integer.valueOf(req.getParameter("counterNo").trim());
			String counterAccount = req.getParameter("counterAccount").trim();
			String accountReg = "^[a-zA-Z0-9]{4,20}$";
			if (counterAccount == null || counterAccount.trim().isEmpty()) {
				errorMsgs.add("櫃位帳號: 請勿空白");
			} else if (!counterAccount.matches(accountReg)) {
				errorMsgs.add("櫃位帳號: 只能包含英數字，且長度需在4到20之間");
			}

			String counterName = req.getParameter("counterName").trim();
			String nameReg = "^[(\\u4e00-\\u9fa5)(a-zA-Z) \\s]{2,45}$";
			if (counterName == null || counterName.trim().isEmpty()) {
				errorMsgs.add("管理者姓名: 請勿空白");
			} else if (!counterName.matches(nameReg)) {
				errorMsgs.add("管理者姓名: 只能包含中文或英文，且長度需在2到45之間");
			}

			String counterPassword = req.getParameter("counterPassword").trim();
			String passReg = "^[a-zA-Z0-9]{4,20}$";
			if (counterPassword == null || counterPassword.trim().isEmpty()) {
				errorMsgs.add("密碼: 請勿空白");
			} else if (!counterPassword.matches(passReg)) {
				errorMsgs.add("櫃位密碼: 只能包含英數字，且長度需在4到20之間");
			}

			String counterAddress = req.getParameter("counterAddress").trim();
			String addressReg = "^[\\u4e00-\\u9fa5a-zA-Z0-9\\s]{2,100}$";
			if (counterAddress == null || counterAddress.trim().isEmpty()) {
				errorMsgs.add("地址: 請勿空白");
			} else if (!counterAddress.matches(addressReg)) {
				errorMsgs.add("櫃位地址: 長度需在2到100之間");
			}

			String counterPhone = req.getParameter("counterPhone").trim();
			String phoneReg = "^09\\d{8}$";
			if (counterPhone == null || counterPhone.trim().isEmpty()) {
				errorMsgs.add("電話: 請勿空白");
			} else if (!counterPhone.matches(phoneReg)) {
				errorMsgs.add("電話: 格式不正確，請輸入有效的台灣手機號碼");
			}

			String counterUid = req.getParameter("counterUid").trim();
			String uidReg = "^[A-Z][1-2][0-9]{8}$";
			if (counterUid == null || counterUid.trim().isEmpty()) {
				errorMsgs.add("管理者身分證字號: 請勿空白");
			} else if (!counterUid.matches(uidReg)) {
				errorMsgs.add("管理者身分證字號: 格式不正確，請輸入有效的台灣身分證字號");
			}

			String counterEmail = req.getParameter("counterEmail").trim();
			String emailReg = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
			if (counterEmail == null || counterEmail.trim().isEmpty()) {
				errorMsgs.add("電子信箱: 請勿空白");
			} else if (!counterEmail.matches(emailReg)) {
				errorMsgs.add("電子信箱: 格式不正確，請輸入有效的電子信箱");
			}

			String counterUbn = req.getParameter("counterUbn").trim();
			String ubnReg = "^[0-9]{8}$";
			if (counterUbn == null || counterUbn.trim().isEmpty()) {
				errorMsgs.add("統一編號: 請勿空白");
			} else if (!counterUbn.matches(ubnReg)) {
				errorMsgs.add("統一編號: 格式不正確，應為 8 位數字");
			}

			String counterCName = req.getParameter("counterCName").trim();
			if (counterCName == null || counterCName.trim().isEmpty()) {
				errorMsgs.add("櫃位名稱: 請勿空白");
			}

			Integer counterTypeNo = null;
			try {
				counterTypeNo = Integer.valueOf(req.getParameter("counterTypeNo").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("請選擇櫃位類別");
			}

			String counterInform = req.getParameter("counterInform").trim();

			Integer counterStatus = null;
			try {
				counterStatus = Integer.valueOf(req.getParameter("counterStatus").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("請確認櫃位狀態");
			}

			Part filePart = req.getPart("counterPic"); //
			byte[] counterPic = null;
			if (filePart != null && filePart.getSize() > 0) {
				// 有上傳新圖片，讀取新圖片資料
				InputStream inputStream = filePart.getInputStream();
				counterPic = new byte[inputStream.available()];
				inputStream.read(counterPic);
				inputStream.close();
			} else {
				// 沒有上傳新圖片，保持原圖
				CounterService counterSvc = new CounterService();
				CounterVO existingCounterVO = counterSvc.getOneCounter(counterNo);
				counterPic = existingCounterVO.getCounterPic();
			}

			// 建立 CounterVO
			CounterVO counterVO = new CounterVO();
			counterVO.setCounterNo(counterNo);
			counterVO.setCounterAccount(counterAccount);
			counterVO.setCounterName(counterName);
			counterVO.setCounterPassword(counterPassword);
			counterVO.setCounterAddress(counterAddress);
			counterVO.setCounterPhone(counterPhone);
			counterVO.setCounterUid(counterUid);
			counterVO.setCounterEmail(counterEmail);
			counterVO.setCounterUbn(counterUbn);
			counterVO.setCounterCName(counterCName);
			counterVO.setCounterTypeNo(counterTypeNo);
			counterVO.setCounterInform(counterInform);
			counterVO.setCounterPic(counterPic);
			counterVO.setCounterStatus(counterStatus);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("counterVO", counterVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/counter/update_counter_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			CounterService counterSvc = new CounterService();
			counterVO = counterSvc.updateCounter(counterTypeNo, counterAccount, counterName, counterPassword,
					counterAddress, counterPhone, counterUid, counterEmail, counterUbn, counterCName, counterTypeNo,
					counterInform, counterPic, counterTypeNo);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("counterVO", counterVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/back-end/counter/listAllCounter.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自 addCounter.jsp 的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/****************** 1. 接收請求參數 - 輸入格式的錯誤處理 ******************/
			String counterAccount = req.getParameter("counterAccount").trim();
			String accountReg = "^[a-zA-Z0-9]{4,20}$";
			if (counterAccount == null || counterAccount.trim().isEmpty()) {
				errorMsgs.add("櫃位帳號: 請勿空白");
			} else if (!counterAccount.matches(accountReg)) {
				errorMsgs.add("櫃位帳號: 只能包含英數字，且長度需在4到20之間");
			}

			String counterName = req.getParameter("counterName").trim();
			String nameReg = "^[(\\u4e00-\\u9fa5)(a-zA-Z)]{2,45}$";
			if (counterName == null || counterName.trim().isEmpty()) {
				errorMsgs.add("管理者姓名: 請勿空白");
			} else if (!counterName.matches(nameReg)) {
				errorMsgs.add("管理者姓名: 只能包含中文或英文，且長度需在2到45之間");
			}

			String counterPassword = req.getParameter("counterPassword").trim();
			String passReg = "^[a-zA-Z0-9]{4,20}$";
			if (counterPassword == null || counterPassword.trim().isEmpty()) {
				errorMsgs.add("密碼: 請勿空白");
			} else if (!counterPassword.matches(passReg)) {
				errorMsgs.add("櫃位密碼: 只能包含英數字，且長度需在4到20之間");
			}

			String counterAddress = req.getParameter("counterAddress").trim();
			String addressReg = "^[\\u4e00-\\u9fa5a-zA-Z0-9\\s]{2,100}$";
			if (counterAddress == null || counterAddress.trim().isEmpty()) {
				errorMsgs.add("地址: 請勿空白");
			} else if (!counterAddress.matches(addressReg)) {
				errorMsgs.add("櫃位地址: 只能中文跟數字，且長度需在2到100之間");
			}

			String counterPhone = req.getParameter("counterPhone").trim();
			String phoneReg = "^09\\d{8}$";
			if (counterPhone == null || counterPhone.trim().isEmpty()) {
				errorMsgs.add("電話: 請勿空白");
			} else if (!counterPhone.matches(phoneReg)) {
				errorMsgs.add("電話: 格式不正確，請輸入有效的台灣手機號碼");
			}

			String counterUid = req.getParameter("counterUid").trim();
			String uidReg = "^[A-Z][1-2][0-9]{8}$";
			if (counterUid == null || counterUid.trim().isEmpty()) {
				errorMsgs.add("管理者身分證字號: 請勿空白");
			} else if (!counterUid.matches(uidReg)) {
				errorMsgs.add("管理者身分證字號: 格式不正確，請輸入有效的台灣身分證字號");
			}

			String counterEmail = req.getParameter("counterEmail").trim();
			String emailReg = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
			if (counterEmail == null || counterEmail.trim().isEmpty()) {
				errorMsgs.add("電子信箱: 請勿空白");
			} else if (!counterEmail.matches(emailReg)) {
				errorMsgs.add("電子信箱: 格式不正確，請輸入有效的電子信箱");
			}

			String counterUbn = req.getParameter("counterUbn").trim();
			String ubnReg = "^[0-9]{8}$";
			if (counterUbn == null || counterUbn.trim().isEmpty()) {
				errorMsgs.add("統一編號: 請勿空白");
			} else if (!counterUbn.matches(ubnReg)) {
				errorMsgs.add("統一編號: 格式不正確，應為 8 位數字");
			}

			String counterCName = req.getParameter("counterCName").trim();
			if (counterCName == null || counterCName.trim().isEmpty()) {
				errorMsgs.add("櫃位名稱: 請勿空白");
			}

			Integer counterTypeNo = null;
			try {
				counterTypeNo = Integer.valueOf(req.getParameter("counterTypeNo").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("請選擇櫃位類別");
			}

			String counterInform = req.getParameter("counterInform").trim();

			Part filePart = req.getPart("counterPic");
			byte[] counterPic = null;
			if (filePart != null && filePart.getSize() > 0) {
				InputStream inputStream = filePart.getInputStream();
				counterPic = inputStream.readAllBytes();
				inputStream.close();
			}

			// 建立 CounterVO
			CounterVO counterVO = new CounterVO();
			counterVO.setCounterAccount(counterAccount);
			counterVO.setCounterName(counterName);
			counterVO.setCounterPassword(counterPassword);
			counterVO.setCounterAddress(counterAddress);
			counterVO.setCounterPhone(counterPhone);
			counterVO.setCounterUid(counterUid);
			counterVO.setCounterEmail(counterEmail);
			counterVO.setCounterUbn(counterUbn);
			counterVO.setCounterCName(counterCName);
			counterVO.setCounterTypeNo(counterTypeNo);
			counterVO.setCounterInform(counterInform);
			counterVO.setCounterPic(counterPic);

			// 將輸入錯誤的 CounterVO 回傳給表單頁面
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("counterVO", counterVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/counter/addCounter.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2. 開始新增資料 ***************************/
			CounterService counterSvc = new CounterService();
			counterVO = counterSvc.addCounter(counterAccount, counterName, counterPassword, counterAddress,
					counterPhone, counterUid, counterEmail, counterUbn, counterCName, counterTypeNo, counterInform,
					counterPic, counterTypeNo);

			/*************************** 3. 新增完成, 準備轉交 ***************************/
			String url = "/back-end/counter/listAllCounter.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

	}
}