package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import connect.ConnectDB;
import entity.ChuyenDi;

public class ChuyenDi_DAO {

	public ArrayList<ChuyenDi> getAllChuyenDi() {
		ArrayList<ChuyenDi> dsChuyenDi = new ArrayList<ChuyenDi>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		String sql = "select * from ChuyenDi";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				ChuyenDi chuyenDi = new ChuyenDi();
				chuyenDi.setMaChuyenDi(rs.getString("maChuyenDi"));
				chuyenDi.setNgayKhoiHanh(rs.getDate("ngayKhoiHanh"));
				chuyenDi.setNgayKetThuc(rs.getDate("ngayKetThuc"));
				chuyenDi.setSoCho(rs.getInt("soCho"));
				chuyenDi.setSoChoConNhan(rs.getInt("soChoConNhan"));
				chuyenDi.setGiaChuyenDi(rs.getDouble("giaChuyenDi"));
				chuyenDi.setNoiKhoiHanh(DiaChi_DAO.getDiaChi(rs.getString("noiKhoiHanh")));
				chuyenDi.setLoaiChuyenDi(LoaiChuyenDi_DAO.getLoaiChuyenDi(rs.getString("maLoai")));
				chuyenDi.setMoTa(rs.getString("moTa"));
				chuyenDi.setHuongDanVien(HuongDanVien_DAO.getHuongDanVien(rs.getString("maHuongDanVien")));
				dsChuyenDi.add(chuyenDi);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsChuyenDi;
	}

	public ChuyenDi getChuyenDi(String maCD) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ChuyenDi chuyenDi = null;
		String sql = "select * from ChuyenDi where maChuyenDi = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maCD);
			rs = stmt.executeQuery();
			if(rs.next()) {
				chuyenDi = new ChuyenDi();
				chuyenDi.setMaChuyenDi(rs.getString("maChuyenDi"));
				chuyenDi.setNgayKhoiHanh(rs.getDate("ngayKhoiHanh"));
				chuyenDi.setNgayKetThuc(rs.getDate("ngayKetThuc"));
				chuyenDi.setSoCho(rs.getInt("soCho"));
				chuyenDi.setSoChoConNhan(rs.getInt("soChoConNhan"));
				chuyenDi.setGiaChuyenDi(rs.getDouble("giaChuyenDi"));
				chuyenDi.setNoiKhoiHanh(DiaChi_DAO.getDiaChi(rs.getString("noiKhoiHanh")));
				chuyenDi.setLoaiChuyenDi(LoaiChuyenDi_DAO.getLoaiChuyenDi(rs.getString("maLoai")));
				chuyenDi.setMoTa(rs.getString("moTa"));
				chuyenDi.setHuongDanVien(HuongDanVien_DAO.getHuongDanVien(rs.getString("maHuongDanVien")));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return chuyenDi;
	}
	public String phatSinhMaChuyenDi() {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select max(maChuyenDi) from ChuyenDi";
		String ID = "";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				ID = PhatSinhMaTuDong.getMa(rs.getString(1).substring(0, 2), rs.getString(1).substring(2, 7), 5);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ID;
	}
	public boolean insertChuyenDi(ChuyenDi chuyenDi) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		int n = 0;
		String sql = "insert ChuyenDi (maChuyenDi, ngayKhoiHanh, ngayKetThuc, soCho, soChoConNhan, giaChuyenDi, noiKhoiHanh, maLoai, moTa, maHuongDanVien)\r\n"
				+ "values ('"+ phatSinhMaChuyenDi() +"', '"+ chuyenDi.getNgayKhoiHanh() +"',"
				+ " '"+ chuyenDi.getNgayKetThuc()+"', "+ chuyenDi.getSoCho() +", "+ chuyenDi.getSoCho() +", "+ chuyenDi.getGiaChuyenDi() +","
				+ " '"+ chuyenDi.getNoiKhoiHanh().getMaDiaChi() +"', '"+ chuyenDi.getLoaiChuyenDi().getMaLoai() +"', N'"+ chuyenDi.getMoTa() +"',"
				+ " '"+ chuyenDi.getHuongDanVien().getMaHuongDanVien() +"')";
		try {
			PreparedStatement stmt= con.prepareStatement(sql);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}

	public void updateChuyenDi(ChuyenDi chuyenDi) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<ChuyenDi> themVaoBangChuyenDi(int page, String noiKhoiHanh, double min, double max, Date ngayKhoiHanh, Date ngayKetThuc) {
		ArrayList<ChuyenDi> dsChuyenDi = new ArrayList<ChuyenDi>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "";
		int number = page * 20;
		
		if(max == 0) 
			sql = "SELECT *\r\n"
					+ "FROM     DiaChi as dc INNER JOIN\r\n"
					+ "                  ChuyenDi as cd ON dc.maDiaChi = cd.noiKhoiHanh\r\n"
					+ "where tinhThanh like N'%"+ noiKhoiHanh +"%'\r\n"
					+ "and ngayKhoiHanh >= '"+ ngayKhoiHanh +"' and ngayKetThuc <= '"+ ngayKetThuc +"'\r\n"
					+ "order by maChuyenDi offset " + number + " rows fetch next 20 rows only";
		else {
			sql = "SELECT *\r\n"
					+ "FROM     DiaChi as dc INNER JOIN\r\n"
					+ "                  ChuyenDi as cd ON dc.maDiaChi = cd.noiKhoiHanh\r\n"
					+ "				  where tinhThanh like N'%"+ noiKhoiHanh +"%'\r\n"
					+ "				  and giaChuyenDi between "+ min +"  and "+ max +"\r\n"
					+ "and ngayKhoiHanh >= '"+ ngayKhoiHanh +"' and ngayKetThuc <= '"+ ngayKetThuc +"'\r\n"
					+ "order by maChuyenDi offset " + number + " rows fetch next 20 rows only";
		}
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs == null) {
				return null;
			}
			while (rs.next()) {
				ChuyenDi chuyenDi = new ChuyenDi();
				chuyenDi.setMaChuyenDi(rs.getString("maChuyenDi"));
				chuyenDi.setNgayKhoiHanh(rs.getDate("ngayKhoiHanh"));
				chuyenDi.setNgayKetThuc(rs.getDate("ngayKetThuc"));
				chuyenDi.setSoCho(rs.getInt("soCho"));
				chuyenDi.setSoChoConNhan(rs.getInt("soChoConNhan"));
				chuyenDi.setGiaChuyenDi(rs.getDouble("giaChuyenDi"));
				chuyenDi.setNoiKhoiHanh(DiaChi_DAO.getDiaChi(rs.getString("noiKhoiHanh")));
				chuyenDi.setTrangThai(rs.getString("trangThai"));
				chuyenDi.setMoTa(rs.getString("moTa"));
				chuyenDi.setLoaiChuyenDi(LoaiChuyenDi_DAO.getLoaiChuyenDi(rs.getString("maLoai")));
				chuyenDi.setHuongDanVien(HuongDanVien_DAO.getHuongDanVien(rs.getString("maHuongDanVien")));
				dsChuyenDi.add(chuyenDi);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return dsChuyenDi;
	}
	public ArrayList<ChuyenDi> themVaoBangChuyenDi(int page, String noiKhoiHanh, double min, double max) {
		ArrayList<ChuyenDi> dsChuyenDi = new ArrayList<ChuyenDi>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "";
		int number = page * 20;
		if(max == 0) 
			sql = "SELECT *\r\n"
					+ "FROM     DiaChi as dc INNER JOIN\r\n"
					+ "                  ChuyenDi as cd ON dc.maDiaChi = cd.noiKhoiHanh\r\n"
					+ "where tinhThanh like N'%"+ noiKhoiHanh +"%'\r\n"
					+ "order by maChuyenDi offset " + number + " rows fetch next 20 rows only";
		else {
			sql = "SELECT *\r\n"
					+ "FROM     DiaChi as dc INNER JOIN\r\n"
					+ "                  ChuyenDi as cd ON dc.maDiaChi = cd.noiKhoiHanh\r\n"
					+ "				  where tinhThanh like N'%"+ noiKhoiHanh +"%'\r\n"
					+ "				  and giaChuyenDi between "+ min +"  and "+ max +"\r\n"
					+ "order by maChuyenDi offset " + number + " rows fetch next 20 rows only";
		}
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs == null) {
				return null;
			}
			while (rs.next()) {
				ChuyenDi chuyenDi = new ChuyenDi();
				chuyenDi.setMaChuyenDi(rs.getString("maChuyenDi"));
				chuyenDi.setNgayKhoiHanh(rs.getDate("ngayKhoiHanh"));
				chuyenDi.setNgayKetThuc(rs.getDate("ngayKetThuc"));
				chuyenDi.setSoCho(rs.getInt("soCho"));
				chuyenDi.setSoChoConNhan(rs.getInt("soChoConNhan"));
				chuyenDi.setGiaChuyenDi(rs.getDouble("giaChuyenDi"));
				chuyenDi.setNoiKhoiHanh(DiaChi_DAO.getDiaChi(rs.getString("noiKhoiHanh")));
				chuyenDi.setTrangThai(rs.getString("trangThai"));
				chuyenDi.setMoTa(rs.getString("moTa"));
				chuyenDi.setLoaiChuyenDi(LoaiChuyenDi_DAO.getLoaiChuyenDi(rs.getString("maLoai")));
				chuyenDi.setHuongDanVien(HuongDanVien_DAO.getHuongDanVien(rs.getString("maHuongDanVien")));
				dsChuyenDi.add(chuyenDi);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return dsChuyenDi;
	}

	public ArrayList<ChuyenDi> themVaoBangChuyenDi(int page) {
		// TODO Auto-generated method stub
		return null;
	}
	public int soLuongChuyenDi(String noiKhoiHanh, double min, double max) {
		int soLuongChuyenDi = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "";
		if(max == 0)
			sql = "SELECT COUNT(*)\r\n"
					+ "FROM     DiaChi as dc INNER JOIN\r\n"
					+ "                  ChuyenDi as cd ON dc.maDiaChi = cd.noiKhoiHanh\r\n"
					+ "				  where tinhThanh like N'%"+ noiKhoiHanh +"%'";
		else 
			sql = "SELECT COUNT(*)\r\n"
					+ "FROM     DiaChi as dc INNER JOIN\r\n"
					+ "                  ChuyenDi as cd ON dc.maDiaChi = cd.noiKhoiHanh\r\n"
					+ "				  where tinhThanh like N'%"+ noiKhoiHanh +"%'\r\n"
					+ "and giaChuyenDi between "+ min +" and "+ max +"";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				soLuongChuyenDi = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return soLuongChuyenDi;
	}
	public int soLuongChuyenDi(String noiKhoiHanh, double min, double max, Date ngayKhoiHanh, Date ngayKetThuc) {
		int soLuongChuyenDi = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "";
		if(max == 0)
			sql = "SELECT COUNT(*)\r\n"
					+ "FROM     DiaChi as dc INNER JOIN\r\n"
					+ "                  ChuyenDi as cd ON dc.maDiaChi = cd.noiKhoiHanh\r\n"
					+ "				  where tinhThanh like N'%"+ noiKhoiHanh +"%'\r\n"
					+ "and ngayKhoiHanh >= '"+ ngayKhoiHanh +"' and ngayKetThuc <= '"+ ngayKetThuc +"'";
		else 
			sql = "SELECT COUNT(*)\r\n"
					+ "FROM     DiaChi as dc INNER JOIN\r\n"
					+ "                  ChuyenDi as cd ON dc.maDiaChi = cd.noiKhoiHanh\r\n"
					+ "				  where tinhThanh like N'%"+ noiKhoiHanh +"%'\r\n"
					+ "and giaChuyenDi between "+ min +" and "+ max +""
					+ "and ngayKhoiHanh >= '"+ ngayKhoiHanh +"' and ngayKetThuc <= '"+ ngayKetThuc +"'\r\n";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				soLuongChuyenDi = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return soLuongChuyenDi;
	}
	public boolean deleteChuyenDi(String maChuyenDi) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		int n = 0;
		String sql = "delete CT_ThamQuan\r\n"
				+ "where maChuyenDi = '"+ maChuyenDi +"'\r\n"
				+ "delete ChuyenDi\r\n"
				+ "where maChuyenDi = '"+ maChuyenDi +"'";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean updateTrangThaiChuyenDi(String maChuyenDi, String trangThai) {
		int n = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "update ChuyenDi\r\n"
				+ "set trangThai = N'"+ trangThai +"'\r\n"
				+ "where maChuyenDi = '"+ maChuyenDi +"'";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
}
