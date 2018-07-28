package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;

import com.biz.TravelAgencyBiz;
import com.entity.TravelAgency;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TravelAgencyManageAction extends ActionSupport {

	private BigDecimal idKey;
	private String agencyName;
	private String address;
	private String discription;
	private String phone;
	private Blob bussinessLicense; // 图片
	private Blob texLicense; // 图片
	private Blob codeLicense; // 图片
	private String state;

	// 上传文件
	private File bussinessL; // 文件
	private File texL;
	private File codeL;

	public File getCodeL() {
		return codeL;
	}

	public void setCodeL(File codeL) {
		this.codeL = codeL;
	}

	public File getTexL() {
		return texL;
	}

	public void setTexL(File texL) {
		this.texL = texL;
	}

	// private String bussinessLContentType;
	// private String bussinessLFileName;
	private List<TravelAgency> list;

	public File getBussinessL() {
		return bussinessL;
	}

	public void setBussinessL(File bussinessL) {
		this.bussinessL = bussinessL;
	}

	private TravelAgency travelAgency;
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public TravelAgency getTravelAgency() {
		return travelAgency;
	}

	public void setTravelAgency(TravelAgency travelAgency) {
		this.travelAgency = travelAgency;
	}

	// 声明一个UserBiz属性
	TravelAgencyBiz travelAgencyBiz;

	// 添加set方法用于spring依赖注入
	public void setTravelAgencyBiz(TravelAgencyBiz travelAgencyBiz) {
		this.travelAgencyBiz = travelAgencyBiz;
	}

	public TravelAgencyBiz getTravelAgencyBiz() {
		return travelAgencyBiz;
	}

	// 查找
	// 根据名称条件进行查找,agencyName为空时,查找全部旅行社,
	// 不为空时,查找制定名称的travel agency 返回
	// list不为空时,返回success
	// 其他返回error
	public String search() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		// 声明hibernate成员
		TravelAgency condition = new TravelAgency();

		condition.setAgencyName(agencyName);

		System.out.print("agencyName:" + agencyName);

		list = travelAgencyBiz.search(condition);

		if (list.size() > 0) {
			request.setAttribute("list", list);
			return "success";
		} else if(list.size() == 0){
			return "none";
		}else {
			return "error";
		}
	}

	// 增加
	public String add() throws Exception {
		System.out.println(travelAgency.getAgencyName());

		byte[] bL = null;
		byte[] tL = null;
		byte[] cL = null;
		if (bussinessL == null) {

		} else {

			InputStream isbl = new FileInputStream(bussinessL);
			// 图片已近上传上来
			bL = new byte[isbl.available()];
			isbl.read(bL);
			isbl.close();
		}

		if (texL == null) {

		} else {

			InputStream istl = new FileInputStream(texL);
			// 图片已近上传上来
			tL = new byte[istl.available()];
			istl.read(tL);
			istl.close();
		}
		if (codeL == null) {

		} else {

			InputStream iscl = new FileInputStream(codeL);
			// 图片已近上传上来
			cL = new byte[iscl.available()];
			iscl.read(cL);
			iscl.close();
		}
		// 调用数据库操作
		int ret = travelAgencyBiz.add(travelAgency, bL, tL, cL);

		if (ret == 0) {
			return "success";
		} else {
			return "error";
		}

	}

	// 删除
	// 根据idKey删除
	public String delete() throws Exception {
		System.out.print("idKey:" + idKey);

		TravelAgency condition = new TravelAgency();
		condition.setIdKey(idKey);

		int ret = travelAgencyBiz.delete(condition);
		if (ret < 0)
			return "error";
		return "success";

	}

	// 更新
	public String update() throws Exception {

		System.out.println("idKey:" + idKey);
		System.out.println("bussinessL:" + bussinessL);
		byte[] bL = null;
		byte[] tL = null;
		byte[] cL = null;
		if (bussinessL == null) {

		} else {

			InputStream isbl = new FileInputStream(bussinessL);
			// 图片已近上传上来
			bL = new byte[isbl.available()];
			isbl.read(bL);
			isbl.close();
		}

		if (texL == null) {

		} else {

			InputStream istl = new FileInputStream(texL);
			// 图片已近上传上来
			tL = new byte[istl.available()];
			istl.read(tL);
			istl.close();
		}
		if (codeL == null) {

		} else {

			InputStream iscl = new FileInputStream(codeL);
			// 图片已近上传上来
			cL = new byte[iscl.available()];
			iscl.read(cL);
			iscl.close();
		}
		travelAgency.setIdKey(idKey);
		int ret = travelAgencyBiz.update(travelAgency, bL, tL, cL);
		if (ret < 0)
			return "error";

		return "success";
	}

	// 根据状态查找,审核时调用
	public String searchbystate() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		// 声明hibernate成员
		TravelAgency condition = new TravelAgency();

		condition.setAgencyName(agencyName);
		condition.setState(state);

		System.out.println("agencyName:" + agencyName + "  state:" + state);

		list = travelAgencyBiz.searchbystate(condition);

		if (list.size() > 0) {
			request.setAttribute("list", list);
			return "success";
		} else if(list.size() == 0){
			return "none";
		}else {
			return "error";
		}
	}

	// 更新状态 审核时用到
	public String updatestate() throws Exception {

		System.out.println("idKey:" + idKey);
		System.out.println("state:" + state);
		
		//页面未传一个TravelAgency过来,new一个
		TravelAgency travelAgency = new TravelAgency();
		
		travelAgency.setIdKey(idKey);
		travelAgency.setState(state);
		travelAgency.setAgencyName(agencyName);
		travelAgency.setPhone(phone);
		
		int ret = travelAgencyBiz.updatestate(travelAgency);
		if (ret < 0) //执行失败
			return "error";
		
		return "success";
	}

	public List<TravelAgency> getList() {
		return list;
	}

	public void setList(List<TravelAgency> list) {
		this.list = list;
	}

	public BigDecimal getIdKey() {
		return idKey;
	}

	public void setIdKey(BigDecimal idKey) {
		this.idKey = idKey;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Blob getBussinessLicense() {
		return bussinessLicense;
	}

	public void setBussinessLicense(Blob bussinessLicense) {
		this.bussinessLicense = bussinessLicense;
	}

	public Blob getTexLicense() {
		return texLicense;
	}

	public void setTexLicense(Blob texLicense) {
		this.texLicense = texLicense;
	}

	public Blob getCodeLicense() {
		return codeLicense;
	}

	public void setCodeLicense(Blob codeLicense) {
		this.codeLicense = codeLicense;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
