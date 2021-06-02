package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dohuyhoang.animation.AnimationPane;
import dohuyhoang.roundedpane.RoundedPane;

public class Nav extends RoundedPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel menuIcon;
	private JLabel trangChuLbl;
	private JPanel trangChuBtn;
	private JLabel khachHangLbl;
	private JPanel khachHangBtn;
	private JLabel tourLbl;
	private JPanel tourBtn;
	private JLabel caiDatLbl;
	private JPanel caiDatBtn;
	private JPanel menuBtn;
	private RoundedPane selectPanel;
	private JLabel diaDanhLbl;
	private JPanel diaDanhBtn;
	private JLabel nhanVienLbl;
	private JPanel nhanVienBtn;
	private JLabel huongDanVienLbl;
	private JPanel huongDanVienBtn;
	
	/**
	 * @return the trangChuBtn
	 */
	public JPanel getTrangChuBtn() {
		return trangChuBtn;
	}

	/**
	 * @param trangChuBtn the trangChuBtn to set
	 */
	public void setTrangChuBtn(JPanel trangChuBtn) {
		this.trangChuBtn = trangChuBtn;
	}

	/**
	 * @return the khachHangBtn
	 */
	public JPanel getKhachHangBtn() {
		return khachHangBtn;
	}

	/**
	 * @param khachHangBtn the khachHangBtn to set
	 */
	public void setKhachHangBtn(JPanel khachHangBtn) {
		this.khachHangBtn = khachHangBtn;
	}

	/**
	 * @return the tourBtn
	 */
	public JPanel getTourBtn() {
		return tourBtn;
	}

	/**
	 * @param tourBtn the tourBtn to set
	 */
	public void setTourBtn(JPanel tourBtn) {
		this.tourBtn = tourBtn;
	}

	/**
	 * @return the caiDatBtn
	 */
	public JPanel getCaiDatBtn() {
		return caiDatBtn;
	}

	/**
	 * @param caiDatBtn the caiDatBtn to set
	 */
	public void setCaiDatBtn(JPanel caiDatBtn) {
		this.caiDatBtn = caiDatBtn;
	}

	/**
	 * @return the diaDanhBtn
	 */
	public JPanel getDiaDanhBtn() {
		return diaDanhBtn;
	}

	/**
	 * @param diaDanhBtn the diaDanhBtn to set
	 */
	public void setDiaDanhBtn(JPanel diaDanhBtn) {
		this.diaDanhBtn = diaDanhBtn;
	}

	/**
	 * @param menuBtn the menuBtn to set
	 */
	public void setMenuBtn(JPanel menuBtn) {
		this.menuBtn = menuBtn;
	}

	public JPanel getMenuBtn() {
		return menuBtn;
	}
	/**
	 * @return the nhanVienBtn
	 */
	public JPanel getNhanVienBtn() {
		return nhanVienBtn;
	}
	/**
	 * @param nhanVienBtn the nhanVienBtn to set
	 */
	public void setNhanVienBtn(JPanel nhanVienBtn) {
		this.nhanVienBtn = nhanVienBtn;
	}
	
	/**
	 * @return the huongDanVienBtn
	 */
	public JPanel getHuongDanVienBtn() {
		return huongDanVienBtn;
	}

	public Nav(int radius, String direction) {
		super(radius, direction);
		setBackground(MainScreen.COLOR_MAIN);
		setOpaque(false);
		setLayout(null);
		buidNav();
	}
	
	private void buidNav() {
		
		menuIcon = new JLabel();
		menuIcon.setText("MENU");
		menuIcon.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 14));
		menuIcon.setIcon(new ImageIcon(getClass().getResource("/gui/icon/menu_20px.png")));
		menuIcon.setIconTextGap(100);
		menuIcon.setForeground(Color.WHITE);
		menuIcon.setHorizontalTextPosition(JLabel.LEFT);
		menuIcon.setBounds(20, 0, 200, 60);
		menuBtn = new JPanel();
		menuBtn.setToolTipText("Menu");
		menuBtn.setBackground(new Color(0,141,76));
		menuBtn.setLayout(null);
		menuBtn.setBounds(-140, 0, 200, 60);
		menuBtn.add(menuIcon);
		menuBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(menuBtn);
		
		
		
		trangChuLbl = new JLabel();
		trangChuLbl.setText("Trang chủ");
		trangChuLbl.setIcon(new ImageIcon(getClass().getResource("/gui/icon/home_30-1px.png")));
		trangChuLbl.setIconTextGap(20);
		trangChuLbl.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 18));
		trangChuLbl.setForeground(Color.BLACK);
		trangChuLbl.setBounds(15, 10, 200, 40);
		trangChuBtn = new JPanel();
		trangChuBtn.setToolTipText("Trang chủ");
		trangChuBtn.setOpaque(false);
		trangChuBtn.setLayout(null);
		trangChuBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		trangChuBtn.setBackground(MainScreen.COLOR_MAIN);
		trangChuBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnMousePressed(e,
						trangChuLbl,
						"/gui/icon/home_30-1px.png",
						new JLabel[] {khachHangLbl, tourLbl, caiDatLbl, diaDanhLbl, nhanVienLbl, huongDanVienLbl},
						new String[] {"/gui/icon/customer_30px.png",
								"/gui/icon/around_the_globe_30px.png",
								"/gui/icon/settings_30px.png",
								"/gui/icon/map_marker_30px.png",
								"/gui/icon/user_group_30px.png",
								"/gui/icon/trekking_30px.png"},
						new Rectangle(selectPanel.getX(), selectPanel.getY(), 230, 60),
						new Rectangle(selectPanel.getX(), 100, 230, 60));
			}
		});
		trangChuBtn.add(trangChuLbl);
		
		khachHangLbl = new JLabel();
		khachHangLbl.setText("Khách hàng");
		khachHangLbl.setIcon(new ImageIcon(getClass().getResource("/gui/icon/customer_30px.png")));
		khachHangLbl.setIconTextGap(20);
		khachHangLbl.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 18));
		khachHangLbl.setForeground(Color.WHITE);
		khachHangLbl.setBounds(15, 10, 200, 40);
		khachHangBtn = new JPanel();
		khachHangBtn.setToolTipText("Thông tin khách hàng");
		khachHangBtn.setOpaque(false);
		khachHangBtn.setLayout(null);
		khachHangBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		khachHangBtn.setBackground(MainScreen.COLOR_MAIN);
		khachHangBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnMousePressed(e,
						khachHangLbl,
						"/gui/icon/customer_30px-1.png",
						new JLabel[] {trangChuLbl, tourLbl, caiDatLbl, diaDanhLbl, nhanVienLbl, huongDanVienLbl},
						new String[] {"/gui/icon/home_30px.png",
								"/gui/icon/around_the_globe_30px.png",
								"/gui/icon/settings_30px.png",
								"/gui/icon/map_marker_30px.png",
								"/gui/icon/user_group_30px.png",
								"/gui/icon/trekking_30px.png"},
						new Rectangle(selectPanel.getX(), selectPanel.getY(), 230, 60),
						new Rectangle(selectPanel.getX(), 160, 230, 60));
			}
		});
		khachHangBtn.add(khachHangLbl);
		
		tourLbl = new JLabel();
		tourLbl.setText("Chuyến đi");
		tourLbl.setIcon(new ImageIcon(getClass().getResource("/gui/icon/around_the_globe_30px.png")));
		tourLbl.setIconTextGap(20);
		tourLbl.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 18));
		tourLbl.setForeground(Color.WHITE);
		tourLbl.setBounds(15, 10, 200, 40);
		tourBtn = new JPanel();
		tourBtn.setToolTipText("Thông tin Tour");
		tourBtn.setLayout(null);
		tourBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tourBtn.setOpaque(false);
		tourBtn.setBackground(MainScreen.COLOR_MAIN);
		tourBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnMousePressed(e,
						tourLbl,
						"/gui/icon/around_the_globe_30px-1.png",
						new JLabel[] {trangChuLbl, khachHangLbl, caiDatLbl, diaDanhLbl, nhanVienLbl, huongDanVienLbl},
						new String[] {"/gui/icon/home_30px.png",
								"/gui/icon/customer_30px.png",
								"/gui/icon/settings_30px.png",
								"/gui/icon/map_marker_30px.png",
								"/gui/icon/user_group_30px.png",
								"/gui/icon/trekking_30px.png"},
						new Rectangle(selectPanel.getX(), selectPanel.getY(), 230, 60),
						new Rectangle(selectPanel.getX(), tourBtn.getY(), 230, 60));
			}
		});
		tourBtn.add(tourLbl);
		
		caiDatLbl = new JLabel();
		caiDatLbl.setText("Cài đặt");
		caiDatLbl.setIcon(new ImageIcon(getClass().getResource("/gui/icon/settings_30px.png")));
		caiDatLbl.setIconTextGap(20);
		caiDatLbl.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 18));
		caiDatLbl.setForeground(Color.WHITE);
		caiDatLbl.setBounds(15, 10, 200, 40);
		caiDatBtn = new JPanel();
		caiDatBtn.setToolTipText("Cài đặt");
		caiDatBtn.setOpaque(false);
		caiDatBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		caiDatBtn.setLayout(null);
		caiDatBtn.setBackground(MainScreen.COLOR_MAIN);
		caiDatBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnMousePressed(e,
						caiDatLbl,
						"/gui/icon/settings_30px-1.png",
						new JLabel[] {trangChuLbl, khachHangLbl, tourLbl, diaDanhLbl, nhanVienLbl, huongDanVienLbl},
						new String[] {"/gui/icon/home_30px.png",
								"/gui/icon/customer_30px.png",
								"/gui/icon/around_the_globe_30px.png",
								"/gui/icon/map_marker_30px.png",
								"/gui/icon/user_group_30px.png",
								"/gui/icon/trekking_30px.png"},
						new Rectangle(selectPanel.getX(), selectPanel.getY(), 230, 60),
						new Rectangle(selectPanel.getX(), caiDatBtn.getY(), 230, 60));
			}
		});
		caiDatBtn.add(caiDatLbl);
		
		diaDanhLbl = new JLabel();
		diaDanhLbl.setText("Địa danh");
		diaDanhLbl.setIcon(new ImageIcon(getClass().getResource("/gui/icon/map_marker_30px.png")));
		diaDanhLbl.setIconTextGap(20);
		diaDanhLbl.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 18));
		diaDanhLbl.setForeground(Color.WHITE);
		diaDanhLbl.setBounds(15, 10, 200, 40);
		diaDanhBtn = new JPanel();
		diaDanhBtn.setToolTipText("Thông tin địa danh");
		diaDanhBtn.setOpaque(false);
		diaDanhBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		diaDanhBtn.setLayout(null);
		diaDanhBtn.setBackground(MainScreen.COLOR_MAIN);
		diaDanhBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnMousePressed(e, diaDanhLbl, "/gui/icon/map_marker_30px-1.png",
						new JLabel[] {trangChuLbl, khachHangLbl, tourLbl, caiDatLbl, nhanVienLbl, huongDanVienLbl},
						new String[] {"/gui/icon/home_30px.png",
								"/gui/icon/customer_30px.png",
								"/gui/icon/around_the_globe_30px.png",
								"/gui/icon/settings_30px.png",
								"/gui/icon/user_group_30px.png",
								"/gui/icon/trekking_30px.png"},
						new Rectangle(selectPanel.getX(), selectPanel.getY(), selectPanel.getWidth(), selectPanel.getHeight()), 
						new Rectangle(selectPanel.getX(), diaDanhBtn.getY(), selectPanel.getWidth(), selectPanel.getHeight())
				);
			}
		});
		diaDanhBtn.add(diaDanhLbl);
		
		nhanVienLbl = new JLabel();
		nhanVienLbl.setText("Nhân viên");
		nhanVienLbl.setIcon(new ImageIcon(getClass().getResource("/gui/icon/user_group_30px.png")));
		nhanVienLbl.setIconTextGap(20);
		nhanVienLbl.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 18));
		nhanVienLbl.setForeground(Color.WHITE);
		nhanVienLbl.setBounds(15, 10, 200, 40);
		nhanVienBtn = new JPanel();
		nhanVienBtn.setToolTipText("Thông tin nhân viên");
		nhanVienBtn.setOpaque(false);
		nhanVienBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		nhanVienBtn.setLayout(null);
		nhanVienBtn.setBackground(MainScreen.COLOR_MAIN);
		nhanVienBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnMousePressed(e, nhanVienLbl, "/gui/icon/user_group_30px-1.png",
						new JLabel[] {trangChuLbl, khachHangLbl, tourLbl, caiDatLbl, diaDanhLbl, huongDanVienLbl},
						new String[] {"/gui/icon/home_30px.png",
								"/gui/icon/customer_30px.png",
								"/gui/icon/around_the_globe_30px.png",
								"/gui/icon/settings_30px.png",
								"/gui/icon/map_marker_30px.png",
								"/gui/icon/trekking_30px.png"},
						new Rectangle(selectPanel.getX(), selectPanel.getY(), selectPanel.getWidth(), selectPanel.getHeight()), 
						new Rectangle(selectPanel.getX(), nhanVienBtn.getY(), selectPanel.getWidth(), selectPanel.getHeight())
				);
			}
		});
		nhanVienBtn.add(nhanVienLbl);
		
		huongDanVienLbl = new JLabel();
		huongDanVienLbl.setText("Hướng dẫn viên");
		huongDanVienLbl.setIcon(new ImageIcon(getClass().getResource("/gui/icon/trekking_30px.png")));
		huongDanVienLbl.setIconTextGap(20);
		huongDanVienLbl.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 18));
		huongDanVienLbl.setForeground(Color.WHITE);
		huongDanVienLbl.setBounds(15, 10, 200, 40);
		huongDanVienBtn = new JPanel();
		huongDanVienBtn.setToolTipText("Thông tin hướng dẫn viên");
		huongDanVienBtn.setOpaque(false);
		huongDanVienBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		huongDanVienBtn.setLayout(null);
		huongDanVienBtn.setBackground(MainScreen.COLOR_MAIN);
		huongDanVienBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnMousePressed(e, huongDanVienLbl, "/gui/icon/trekking_30px-1.png",
						new JLabel[] {trangChuLbl, khachHangLbl, tourLbl, caiDatLbl, diaDanhLbl, nhanVienLbl},
						new String[] {"/gui/icon/home_30px.png",
								"/gui/icon/customer_30px.png",
								"/gui/icon/around_the_globe_30px.png",
								"/gui/icon/settings_30px.png",
								"/gui/icon/map_marker_30px.png",
								"/gui/icon/user_group_30px.png"},
						new Rectangle(selectPanel.getX(), selectPanel.getY(), selectPanel.getWidth(), selectPanel.getHeight()), 
						new Rectangle(selectPanel.getX(), huongDanVienBtn.getY(), selectPanel.getWidth(), selectPanel.getHeight())
				);
			}
		});
		huongDanVienBtn.add(huongDanVienLbl);
		
		
		
		trangChuBtn.setBounds(0, 100, 200, 60);
		add(trangChuBtn);
		
		khachHangBtn.setBounds(0, 160, 200, 60);
		add(khachHangBtn);
		
		tourBtn.setBounds(0, 220, 200, 60);
		add(tourBtn);
		
		diaDanhBtn.setBounds(0, 280, 200, 60);
		add(diaDanhBtn);
		
		nhanVienBtn.setBounds(0, 340, 200, 60);
		add(nhanVienBtn);
		
		huongDanVienBtn.setBounds(0, 400, 200, 60);
		add(huongDanVienBtn);
		
		caiDatBtn.setBounds(0, 740, 200, 60);
		add(caiDatBtn);
		
		
		selectPanel = new RoundedPane(50);
		selectPanel.setBackground(new Color(255, 255, 255)); 
		selectPanel.setOpaque(false);
		selectPanel.setBounds(5, 100, 230, 60);
		add(selectPanel);
		
	}
	
	private void setColor(JLabel lbl, String path) {
		lbl.setIcon(new ImageIcon(getClass().getResource(path)));
		lbl.setForeground(Color.BLACK);
	}
	private void resetColor(JLabel [] labels, String [] paths) {
		for(int i = 0; i < labels.length; i++) {
			labels[i].setIcon(new ImageIcon(getClass().getResource(paths[i])));
			labels[i].setForeground(Color.WHITE);
		}
	}
	private void btnMousePressed(MouseEvent e, JLabel lbl, String path, JLabel[] labels, String [] paths, Rectangle from, Rectangle to) {
		AnimationPane animation = new AnimationPane(selectPanel, from, to);
		animation.start();
		setColor(lbl, path);
		resetColor(labels, paths);
	}
}
