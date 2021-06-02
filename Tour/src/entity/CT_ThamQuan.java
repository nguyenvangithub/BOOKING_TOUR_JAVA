package entity;

public class CT_ThamQuan {
	private DiaDanh diaDanh;
	private ChuyenDi chuyenDi;
	/**
	 * @return the diaDanh
	 */
	public DiaDanh getDiaDanh() {
		return diaDanh;
	}
	/**
	 * @param diaDanh the diaDanh to set
	 */
	public void setDiaDanh(DiaDanh diaDanh) {
		this.diaDanh = diaDanh;
	}
	/**
	 * @return the chuyenDi
	 */
	public ChuyenDi getChuyenDi() {
		return chuyenDi;
	}
	/**
	 * @param chuyenDi the chuyenDi to set
	 */
	public void setChuyenDi(ChuyenDi chuyenDi) {
		this.chuyenDi = chuyenDi;
	}
	/**
	 * @param diaDanh
	 * @param chuyenDi
	 */
	public CT_ThamQuan(DiaDanh diaDanh, ChuyenDi chuyenDi) {
		super();
		setDiaDanh(diaDanh);
		setChuyenDi(chuyenDi);
	}
	public CT_ThamQuan() {
		// TODO Auto-generated constructor stub
	}
}
