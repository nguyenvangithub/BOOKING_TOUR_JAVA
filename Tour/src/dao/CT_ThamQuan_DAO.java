package dao;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import connect.ConnectDB;
import entity.CT_ThamQuan;

public class CT_ThamQuan_DAO {
	public static ArrayList<String> getTenDiaTheoChuyenDi(String maChuyenDi) {
		ArrayList<String> dsTenDiaDanh = new ArrayList<String>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		String sql = "select STT, tenDiaDanh from CT_ThamQuan as tq join\r\n"
				+ "DiaDanh as dd on tq.maDiaDanh = dd.maDiaDanh\r\n"
				+ "where maChuyenDi = N'"+ maChuyenDi +"'\r\n"
				+ "order by STT";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				dsTenDiaDanh.add(rs.getString("tenDiaDanh"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return dsTenDiaDanh;
	}
	public static ArrayList<Image> getAnhChuyenDiTheoChuyenDi(String maChuyenDi) {
		ArrayList<Image> dsAnhChuyenDi = new ArrayList<Image>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select STT, anhDiaDanh from CT_ThamQuan as tq join\r\n"
				+ "DiaDanh as dd on tq.maDiaDanh = dd.maDiaDanh\r\n"
				+ "where maChuyenDi = N'"+ maChuyenDi +"'\r\n"
				+ "order by STT";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				byte[] imageData = rs.getBytes("anhDiaDanh");
				ImageIcon icon = new ImageIcon(imageData);
				Image anhDiaDanh = icon.getImage();
				dsAnhChuyenDi.add(anhDiaDanh);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsAnhChuyenDi;
	}
	public static boolean insertCT_ThamQuan(CT_ThamQuan ct_ThamQuan) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		int n = 0;
		String sql = "insert into CT_ThamQuan (maDiaDanh, maChuyenDi)\r\n"
				+ "values ('"+ ct_ThamQuan.getDiaDanh().getMaDiaDanh() +"', '"+ ct_ThamQuan.getChuyenDi().getMaChuyenDi() +"')";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	public static int soLuongDiaDanhCuaChuyenDi(String maChuyenDi) {
		int count = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select COUNT(*) from CT_ThamQuan\r\n"
				+ "where maChuyenDi = '"+ maChuyenDi +"'";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
 }
