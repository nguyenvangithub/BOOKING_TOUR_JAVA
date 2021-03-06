package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.DiaChi_DAO;
import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;
import entity.DiaChi;
import entity.NhanVien;

public class DialogThemNhanVien extends JDialog implements ActionListener{
	private JPanel wrapper;
	private JTextField sDTTextField;
	private JTextField emailTextField;
	private DefaultComboBoxModel<String> tinhThanhComboBoxModel;
	private JComboBox<String> tinhThanhComboBox;
	private DefaultComboBoxModel<String> quanHuyenComboBoxModel;
	private JComboBox<String> quanHuyenComboBox;
	private DefaultComboBoxModel<String> phuongXaComboBoxModel;
	private JComboBox<String> phuongXaComboBox;
	private JPasswordField nhapLaiMKField;
	private JTextField hoTenTextField;
	private JLabel maLabel2;
	private JCheckBox gioiTinhCheckBox;
	private JButton huyButton;
	private JButton lamMoiButton;
	private JButton luuButton;
	private NhanVien_DAO nv_DAO;
	private JPasswordField matKhauField;
	public DialogThemNhanVien() {
		setModal(true);
		nv_DAO = new NhanVien_DAO();
		setSize(800, 530);
		setLocationRelativeTo(null);
		buidDialogThemNhanVien();
	}
	private void buidDialogThemNhanVien() {

		addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				requestFocus();
			}
		});
		addWindowFocusListener(new WindowAdapter() {
			@Override
			public void windowLostFocus(WindowEvent e) {
				requestFocus();
			}
		});
		
		wrapper = new JPanel();
		wrapper.setLayout(null);
		wrapper.setBackground(MainScreen.BACKGROUND_COLOR);
		
		
		
		JPanel header = new JPanel();
		header.setBackground(MainScreen.HEADER_COLOR);
		header.setBounds(0, 0, 800, 80);
		header.setLayout(null);
		wrapper.add(header);
		
		JLabel tenCongTy = new JLabel("TOP TRAVEL", JLabel.CENTER);
		tenCongTy.setForeground(Color.WHITE);
		tenCongTy.setFont(new Font(MainScreen.FONT_TEXT, Font.BOLD, 46));
		tenCongTy.setBounds(0, 0, 800, 40);
		header.add(tenCongTy);
		
		JLabel title = new JLabel("Th??m nh??n vi??n", JLabel.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 18));
		title.setBounds(0, 50, 800, 30);
		header.add(title);
		
		JLabel maLabel1 = new JLabel("M?? nh??n vi??n");
		maLabel1.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		maLabel1.setBounds(10, 85, 130, 30);
		wrapper.add(maLabel1);
		
		maLabel2 = new JLabel();
		maLabel2.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		maLabel2.setBounds(140, 85, 100, 30);
		wrapper.add(maLabel2);
		
		JLabel gioiTinhLabel = new JLabel("Gi???i t??nh: ");
		gioiTinhLabel.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		gioiTinhLabel.setBounds(500, 85, 100, 30);
		wrapper.add(gioiTinhLabel);
		
		gioiTinhCheckBox = new JCheckBox("N???");
		gioiTinhCheckBox.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		gioiTinhCheckBox.setBounds(580, 85, 300, 30);
		wrapper.add(gioiTinhCheckBox);
		
		JLabel hoTenLabel = new JLabel("H??? t??n (*): ");
		hoTenLabel.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		hoTenLabel.setBounds(10, 135, 100, 30);
		wrapper.add(hoTenLabel);

		hoTenTextField = new JTextField();
		hoTenTextField.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		hoTenTextField.setBounds(140, 135, 640, 30);
		wrapper.add(hoTenTextField);

		JLabel sDTLabel = new JLabel("S??? ??i???n tho???i (*):");
		sDTLabel.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		sDTLabel.setBounds(10, 185, 120, 30);
		wrapper.add(sDTLabel);

		sDTTextField = new JTextField();
		sDTTextField.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		sDTTextField.setBounds(140, 185, 640, 30);
		wrapper.add(sDTTextField);

		JLabel emailLabel = new JLabel("Email: ");
		emailLabel.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		emailLabel.setBounds(10, 235, 100, 30);
		wrapper.add(emailLabel);

		emailTextField = new JTextField();
		emailTextField.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		emailTextField.setBounds(140, 235, 640, 30);
		wrapper.add(emailTextField);

		JLabel diaChiLabel = new JLabel("?????a ch??? (*): ");
		diaChiLabel.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		diaChiLabel.setBounds(10, 285, 100, 30);
		wrapper.add(diaChiLabel);

		tinhThanhComboBoxModel = new DefaultComboBoxModel<String>();
		tinhThanhComboBox = new JComboBox<String>(tinhThanhComboBoxModel);
		tinhThanhComboBox.addItem("<T???nh/TP>");
		tinhThanhComboBoxModel.addAll(DiaChi_DAO.getAllTinh());
		tinhThanhComboBox.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		tinhThanhComboBox.setBounds(140, 285, 200, 30);
		wrapper.add(tinhThanhComboBox);

		quanHuyenComboBoxModel = new DefaultComboBoxModel<String>();
		quanHuyenComboBox = new JComboBox<String>(quanHuyenComboBoxModel);
		quanHuyenComboBox.addItem("<Qu???n/Huy???n>");
		quanHuyenComboBox.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		quanHuyenComboBox.setBounds(360, 285, 200, 30);
		wrapper.add(quanHuyenComboBox);

		phuongXaComboBoxModel = new DefaultComboBoxModel<String>();
		phuongXaComboBox = new JComboBox<String>(phuongXaComboBoxModel);
		phuongXaComboBox.addItem("<Ph?????ng/x??>");
		phuongXaComboBox.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		phuongXaComboBox.setBounds(580, 285, 200, 30);
		wrapper.add(phuongXaComboBox);
		
		JLabel matKhauLabel = new JLabel("M???t kh???u: ");
		matKhauLabel.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		matKhauLabel.setBounds(10, 335, 140, 30);
		wrapper.add(matKhauLabel);

		matKhauField = new JPasswordField();
		matKhauField.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		matKhauField.setBounds(140, 335, 640, 30);
		wrapper.add(matKhauField);
		
		JLabel nhapLaiMatLabel = new JLabel("Nh???p l???i m???t kh???u");
		nhapLaiMatLabel.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		nhapLaiMatLabel.setBounds(10, 385, 140, 30);
		wrapper.add(nhapLaiMatLabel);
		
		nhapLaiMKField = new JPasswordField();
		nhapLaiMKField.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		nhapLaiMKField.setBounds(140, 385, 640, 30);
		wrapper.add(nhapLaiMKField);
		
		huyButton = new JButton("H???y");
		huyButton.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		huyButton.setBounds(10, 445, 100, 40);
		wrapper.add(huyButton);
		
		lamMoiButton = new JButton("L??m m???i");
		lamMoiButton.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		lamMoiButton.setBounds(560, 445, 100, 40);
		wrapper.add(lamMoiButton);
		
		luuButton = new JButton("Th??m");
		luuButton.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		luuButton.setBounds(670, 445, 100, 40);
		wrapper.add(luuButton);
		
		setContentPane(wrapper);
		
		tinhThanhComboBox.addActionListener(this);
		quanHuyenComboBox.addActionListener(this);
		huyButton.addActionListener(this);
		lamMoiButton.addActionListener(this);
		luuButton.addActionListener(this);
		
		maLabel2.setText(nv_DAO.phatSinhMaTuDongNhanVien());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(tinhThanhComboBox)) {
			String tinhThanh = tinhThanhComboBox.getSelectedItem().toString();
			if(!tinhThanh.equals("<T???nh/TP>")) {
				quanHuyenComboBoxModel.removeAllElements();
				quanHuyenComboBoxModel.addAll(DiaChi_DAO.getQuanHuyenTheoTinh(tinhThanh));
				quanHuyenComboBox.setSelectedIndex(0);
			}
			else {
				quanHuyenComboBoxModel.removeAllElements();
				quanHuyenComboBox.addItem("<Qu???n/Huy???n>");
				quanHuyenComboBox.setSelectedIndex(0);
			}
			
		}
		else if (o.equals(quanHuyenComboBox)) {
			if(quanHuyenComboBoxModel.getSelectedItem() != null) {
				String quanHuyen = quanHuyenComboBoxModel.getSelectedItem().toString();
				if(!quanHuyen.equals("<Qu???n/Huy???n>")) {
					phuongXaComboBoxModel.removeAllElements();
					phuongXaComboBoxModel.addAll(DiaChi_DAO.getPhuongXaTheoQuanHuyenVaTinh(tinhThanhComboBox.getSelectedItem().toString(), quanHuyen));
					phuongXaComboBox.setSelectedIndex(0);
				}
				else {
					phuongXaComboBoxModel.removeAllElements();
					phuongXaComboBox.addItem("<Ph?????ng/x??>");
					phuongXaComboBox.setSelectedIndex(0);
				}
			}
		}
		else if (o.equals(huyButton)) {
			dispose();
		}
		else if(o.equals(lamMoiButton)) {
			hoTenTextField.setText("");
			sDTTextField.setText("");
			emailTextField.setText("");
			tinhThanhComboBox.setSelectedIndex(0);
			matKhauField.setText("");
			nhapLaiMKField.setText("");
		}
		else if(o.equals(luuButton)) {
			if (checkData_ThemNhanVien()) {
				String tenNhanVien = hoTenTextField.getText().trim();
				boolean gioiTinh = gioiTinhCheckBox.isSelected();
				String soDienThoai = sDTTextField.getText().trim();
				if(TaiKhoan_DAO.getTaiKhoan(soDienThoai) != null) {
					JOptionPane.showMessageDialog(this, "S??? ??i???n tho???i ???? ???????c ????ng k??!");
					selectAllText();
					sDTTextField.requestFocus();
					return;
				}
				String email = emailTextField.getText().trim();
				DiaChi diaChi = DiaChi_DAO.getDiaChi(tinhThanhComboBox.getSelectedItem().toString(), quanHuyenComboBox.getSelectedItem().toString(), phuongXaComboBox.getSelectedItem().toString());
				String matKhau = nhapLaiMKField.getText();
				if(!matKhauField.getText().equals(matKhau)) {
					JOptionPane.showMessageDialog(this, "M???t kh???u nh???p l???i kh??ng ????ng!");
					return;
				}
				NhanVien nhanVien = new NhanVien();
				nhanVien.setTenNhanVien(tenNhanVien);
				nhanVien.setGioiTinh(gioiTinh);
				nhanVien.setSoDienThoai(soDienThoai);
				nhanVien.setEmail(email);
				nhanVien.setDiaChi(diaChi);
				nhanVien.setMatKhau(matKhau);
				if(nv_DAO.themNhanVien(nhanVien)) {
					JOptionPane.showMessageDialog(this, "Th??m th??nh c??ng!");
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(this, "Th??m th???t b???i!");
					selectAllText();
					hoTenTextField.requestFocus();
				}
			}
		}
	}
	private void selectAllText() {
		hoTenTextField.selectAll();
		emailTextField.selectAll();
		sDTTextField.selectAll();
		matKhauField.setText("");
		nhapLaiMKField.setText("");
	}
	//
	public void getShowMessage(String str, JTextField txt)
	{
		JOptionPane.showMessageDialog(this , str);
		txt.selectAll();
		txt.requestFocus();
	}
	//
	public boolean checkData_ThemNhanVien()
	{
		String mess = "";
		String tenNhanVien = hoTenTextField.getText().trim();
		if(!(tenNhanVien.length()>0 && tenNhanVien.matches("([???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????A-Z]{1}[???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????a-z]*){1}(\\s+[???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????A-Z]{1}[???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????a-z]*)*$")))
		{
			if (tenNhanVien.length() == 0 ) {
				JOptionPane.showMessageDialog(this, "H??y nh???p t??n nh??n vi??n.");
			}
			else {
				JOptionPane.showMessageDialog(this, "T??n nh??n vi??n ph???i vi???t hoa ch??? c??i ?????u.");				
			}
			hoTenTextField.selectAll();
			hoTenTextField.requestFocus();
			return false;
		}
		//
		
		String soDienThoai = sDTTextField.getText().trim();
		if (!(soDienThoai.length()>0 && soDienThoai.matches("^0[0-9]{9}$"))) {
			if (soDienThoai.length() == 0 ) {
				JOptionPane.showMessageDialog(this, "H??y nh???p s??? ??i???n tho???i c???a nh??n vi??n.");
			}
			else {
				JOptionPane.showMessageDialog(this, "S??? ??i???n tho???i c?? 10 s??? v?? b???t ?????u b???ng s??? 0.");				
			}
			sDTTextField.selectAll();
			sDTTextField.requestFocus();
			return false;
		}
		
		//
		String email = emailTextField.getText().trim();
		if (!(email.matches("^[A-Z0-9._]+@[A-Z0-9.]+\\.[a-z]{2,4}$"))) {
			if (email.length() == 0) {
				mess = "";
			} else {
			mess = "Email phai ????ng theo ?????nh d???ng (VD: Abc@gmail.com)";
			getShowMessage(mess,emailTextField);
			return false;
			}				
		}
		//
		
		if (tinhThanhComboBox.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this , "Hay ch???n ?????a ch???.");
			return false;
		}
		//
		String matKhau = matKhauField.getText().trim();
		if (!(matKhau.length()>0 && matKhau.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,20}$"))) {
			if (matKhau.length() <= 0) {
				mess = "H??y nh???p th??ng tin cho ?? m???t kh???u.";
			}
			else {
				mess = "M???t kh???u ph???i tr??n 6 k?? t??? trong d?? c?? m???t ch??? s???, m???t ch??? c??i v?? m???t k?? t??? ?????c bi???t";
			}
			getShowMessage(mess, matKhauField);
			return false;
		}
		
		String matKhau2 = nhapLaiMKField.getText().trim();
		if (!(matKhau2.length() > 0 && matKhau2.equalsIgnoreCase(matKhau))) {
			if (matKhau.length()<= 0 ) {
				mess = "H??y nh???p th??ng tin cho ?? nh???p l???i m???t kh???u.";
			} else {
				mess = "M???t kh???u nh???p l???i ph???i gi???ng v???i m???t kh???u ??? tr??n";
			}
			getShowMessage(mess, nhapLaiMKField);
			return false;			
		}
		return true;
	}
	
}
