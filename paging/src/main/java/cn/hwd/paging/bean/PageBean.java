package cn.hwd.paging.bean;

import java.util.List;

public class PageBean<T> {
	
	private int pc;// ��ǰҳ��page code
//	private int tp;// ��ҳ��total page
	private int tr;// �ܼ�¼��total record
	private int ps;// ÿҳ��¼��page size
	private List<T> list;// ��ǰҳ�ļ�¼
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
	/**
	 * ������ҳ��
	 * @return
	 */
	public int getTp() {
		// ͨ���ܼ�¼����ÿҳ��¼����������ҳ��
		int tp = tr / ps;
		return tr%ps==0 ? tp : tp+1;
	}
//	public void setTp(int tp) {
//		this.tp = tp;
//	}
	public int getTr() {
		return tr;
	}
	public void setTr(int tr) {
		this.tr = tr;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
