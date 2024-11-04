package com.counter.model;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;

public class CounterJDBCDAO implements  CounterDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/dobuy?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "rin020255";
	
    private static final String INSERT_STMT = "INSERT INTO counter (counterAccount, counterName, counterPassword, counterAddress, counterPhone, counterUid, counterEmail, counterUbn, counterCName, counterTypeNo, counterInform, counterPic, counterStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_STMT = "UPDATE counter SET counterAccount = ?, counterName = ?, counterPassword = ?, counterAddress = ?, counterPhone = ?, counterUid = ?, counterEmail = ?, counterUbn = ?, counterCName = ?, counterTypeNo = ?, counterInform = ?, counterPic = ?, counterStatus = ? WHERE counterNo = ?";
    private static final String DELETE_STMT = "DELETE FROM counter WHERE counterNo = ?";
    private static final String GET_ONE_STMT = "SELECT * FROM counter WHERE counterNo = ?";
    private static final String GET_ALL_STMT = "SELECT * FROM counter";
    
    
	@Override
	public void insert(CounterVO counterVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

            pstmt.setString(1, counterVO.getCounterAccount());
            pstmt.setString(2, counterVO.getCounterName());
            pstmt.setString(3, counterVO.getCounterPassword());
            pstmt.setString(4, counterVO.getCounterAddress());
            pstmt.setString(5, counterVO.getCounterPhone());
            pstmt.setString(6, counterVO.getCounterUid());
            pstmt.setString(7, counterVO.getCounterEmail());
            pstmt.setString(8, counterVO.getCounterUbn());
            pstmt.setString(9, counterVO.getCounterCName());
            pstmt.setInt(10, counterVO.getCounterTypeNo());
            pstmt.setString(11, counterVO.getCounterInform());
            pstmt.setBytes(12, counterVO.getCounterPic());
            pstmt.setInt(13, counterVO.getCounterStatus());
            pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}
		
	
	@Override
	public void update(CounterVO counterVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STMT);

            pstmt.setString(1, counterVO.getCounterAccount());
            pstmt.setString(2, counterVO.getCounterName());
            pstmt.setString(3, counterVO.getCounterPassword());
            pstmt.setString(4, counterVO.getCounterAddress());
            pstmt.setString(5, counterVO.getCounterPhone());
            pstmt.setString(6, counterVO.getCounterUid());
            pstmt.setString(7, counterVO.getCounterEmail());
            pstmt.setString(8, counterVO.getCounterUbn());
            pstmt.setString(9, counterVO.getCounterCName());
            pstmt.setInt(10, counterVO.getCounterTypeNo());
            pstmt.setString(11,counterVO.getCounterInform());
            pstmt.setBytes(12, counterVO.getCounterPic());
            pstmt.setInt(13, counterVO.getCounterStatus());
            pstmt.setInt(14, counterVO.getCounterNo());
            
            pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}
		
	@Override
	public void delete(Integer counterNo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, counterNo);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	
	}
	@Override
	public CounterVO findByPrimaryKey(Integer counterNo) {
		CounterVO counterVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, counterNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				counterVO = new CounterVO();
				counterVO.setCounterNo(rs.getInt("counterNo"));
				counterVO.setCounterAccount(rs.getString("counterAccount"));
				counterVO.setCounterName(rs.getString("counterName"));
				counterVO.setCounterPassword(rs.getString("counterPassword"));
				counterVO.setCounterAddress(rs.getString("counterAddress"));
				counterVO.setCounterPhone(rs.getString("counterPhone"));
				counterVO.setCounterUid(rs.getString("counterUid"));
				counterVO.setCounterEmail(rs.getString("counterEmail"));
				counterVO.setCounterUbn(rs.getString("counterUbn"));
				counterVO.setCounterCName(rs.getString("counterCName"));
				counterVO.setCounterTypeNo(rs.getInt("counterTypeNo"));
				counterVO.setCounterInform(rs.getString("counterInform"));
				counterVO.setCounterPic(rs.getBytes("counterPic"));
				counterVO.setCounterStatus(rs.getInt("counterStatus"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return counterVO;
	}
	
	@Override
	public List<CounterVO> getAll() {
		List<CounterVO> list = new ArrayList<CounterVO>();
		CounterVO counterVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				 counterVO = new CounterVO();
				 counterVO.setCounterNo(rs.getInt("counterNo"));
				 counterVO.setCounterAccount(rs.getString("counterAccount"));
				 counterVO.setCounterName(rs.getString("counterName"));
				 counterVO.setCounterPassword(rs.getString("counterPassword"));
				 counterVO.setCounterAddress(rs.getString("counterAddress"));
				 counterVO.setCounterPhone(rs.getString("counterPhone"));
				 counterVO.setCounterUid(rs.getString("counterUid"));
				 counterVO.setCounterEmail(rs.getString("counterEmail"));
				 counterVO.setCounterUbn(rs.getString("counterUbn"));
				 counterVO.setCounterCName(rs.getString("counterCName"));
				 counterVO.setCounterTypeNo(rs.getInt("counterTypeNo"));
				 counterVO.setCounterInform(rs.getString("counterInform"));
				 counterVO.setCounterPic(rs.getBytes("counterPic"));
				 counterVO.setCounterStatus(rs.getInt("counterStatus"));
                 list.add(counterVO);
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
	
	public static void main(String[] args) {

		CounterJDBCDAO dao = new CounterJDBCDAO();

		// 新增
//		CounterVO counterVO1 = new CounterVO();
//		
//		counterVO1.setCounterAccount("abc234");
//		counterVO1.setCounterName("TEST");
//		counterVO1.setCounterPassword("passworld");
//		counterVO1.setCounterAddress("大溪");
//		counterVO1.setCounterPhone("0912365498");
//		counterVO1.setCounterUid("T122687638");
//		counterVO1.setCounterEmail("56482@gmail.com");
//		counterVO1.setCounterUbn("2312424");
//		counterVO1.setCounterCName("TESTCOUNTER");
//		counterVO1.setCounterTypeNo(4);
//		counterVO1.setCounterInform("TESTTEST");
//        
//		counterVO1.setCounterStatus(1);
		
		
//	       try {
//	            File file = new File("/back-end/images/1.jpg"); // 改用正確路徑
//	            byte[] imageData = Files.readAllBytes(file.toPath());
//	            counterVO1.setCounterPic(imageData);  // 設定圖片
//	            System.out.println("圖片設定成功！");
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	            System.out.println("圖片讀取失敗！");
//	        }
//
//	        // 執行新增操作
//	        try {
//	            dao.insert(counterVO1);
//	            System.out.println("成功更新一筆資料！");
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
			
//		
//		dao.insert(counterVO1);
//		System.out.println("OK");
		
		
		//修改
		CounterVO counterVO2 = new CounterVO();
//		
//		
		counterVO2.setCounterNo(1);
		counterVO2.setCounterAccount("account1");
		counterVO2.setCounterName("王XX");
		counterVO2.setCounterPassword("12345");
		counterVO2.setCounterAddress("新北");
		counterVO2.setCounterPhone("0912365400");
		counterVO2.setCounterUid("T122687639");
		counterVO2.setCounterEmail("wang888@gmail.com");
		counterVO2.setCounterUbn("2312515");
		counterVO2.setCounterCName("老子有錢");
		counterVO2.setCounterTypeNo(1);
		counterVO2.setCounterInform("精品專賣店"); 
		counterVO2.setCounterStatus(0);
		
        try {
            File file = new File("/back-end/images/1.jpg"); // 改用正確路徑
            byte[] imageData = Files.readAllBytes(file.toPath());
            counterVO2.setCounterPic(imageData);  // 設定圖片
            System.out.println("圖片設定成功！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("圖片讀取失敗！");
        }

        // 執行新增操作
        try {
            dao.update(counterVO2);
            System.out.println("成功更新一筆資料！");
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
//		

		
		

		// 查詢
//		List<CounterVO> list = dao.getAll();
//		for (CounterVO counter : list) {
//            System.out.println("Counter No: " + counter.getCounterNo());
//            System.out.println("Counter Account: " + counter.getCounterAccount());
//            System.out.println("Counter Name: " + counter.getCounterName());
//            System.out.println("Counter Password: " + counter.getCounterPassword());
//            System.out.println("Counter Address: " + counter.getCounterAddress());
//            System.out.println("Counter Phone: " + counter.getCounterPhone());
//            System.out.println("Counter UID: " + counter.getCounterUid());
//            System.out.println("Counter Email: " + counter.getCounterEmail());
//            System.out.println("Counter UBN: " + counter.getCounterUbn());
//            System.out.println("Counter CName: " + counter.getCounterCName());
//            System.out.println("Counter Type No: " + counter.getCounterTypeNo());
//            System.out.println("Counter Inform: " + counter.getCounterInform());
//            System.out.println("Counter Status: " + counter.getCounterStatus());
//            System.out.println("----------");
		}
	

}
	

