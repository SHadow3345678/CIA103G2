package com.counter.model;

import java.util.List;

public class CounterService {

	private CounterDAO_interface dao;

	public CounterService() {
		dao = new CounterJDBCDAO();
	}

	public CounterVO addCounter(String counterAccount, String counterName, String counterPassword,
			String counterAddress, String counterPhone, String counterUid, String counterEmail, String counterUbn,
			String counterCName, Integer counterTypeNo, String counterInform, byte[] counterPic,
			Integer counterStatus) {

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
		counterVO.setCounterStatus(counterStatus);

		dao.insert(counterVO);
		return counterVO;
	}

	public CounterVO updateCounter(Integer counterNo, String counterAccount, String counterName, String counterPassword,
			String counterAddress, String counterPhone, String counterUid, String counterEmail, String counterUbn,
			String counterCName, Integer counterTypeNo, String counterInform, byte[] counterPic,
			Integer counterStatus) {

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

		dao.update(counterVO);
		return counterVO;
	}

	public void deleteCounter(Integer counterNo) {
		dao.delete(counterNo);
	}

	public CounterVO getOneCounter(Integer counterNo) {
		return dao.findByPrimaryKey(counterNo);
	}

	public List<CounterVO> getAll() {
		return dao.getAll();
	}
}
