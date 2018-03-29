package com.flight.bean;

/*
 * 中转航班
 */
public class TransFlight {

	//第一班航班信息：
//	private String firstCode;			//航班号
//	private String firstArrAirport;		//目的地点
//	private String firstArrDate;		//到达日期
//	private String firstAirportExit;	//机场出口
//	private String firstArrTime;		//到达时间
//	private String firstDepAirport;		//出发地点
//	private String firstDepDate;		//出发日期
//	private String firstAirportEntrance;//机场入口
//	private String firstDepTime;		//出发时间
//	private  int   firstDistance;		//飞行距离
//	private String firstUse;			//飞行时间
//	private String firstCompany;		//航班公司
//	private String firstPlanType;		//飞机型号
//	private boolean firstMeal;			//飞机餐
//	private boolean firstStop;			//是否经停
//	private String firstStopCity;		//经停城市
//	private String firstStopAirport;	//经停机场
	
	//通用信息：
	private double price;				//价格
	private String discount;			//折扣
	private String transTime;			//中转时间
	private String transCity;			//中转城市
	private String depCity;				//出发城市
	private String depAirportCode;		//出发机场缩写
	private String arrCity;				//目的城市
	private String arrAirportCode;		//目的机场缩写
	private Flight first;				//第一班
	private Flight second;				//第二班
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getTransTime() {
		return transTime;
	}
	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}
	public String getTransCity() {
		return transCity;
	}
	public void setTransCity(String transCity) {
		this.transCity = transCity;
	}
	public String getDepCity() {
		return depCity;
	}
	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}
	public String getDepAirportCode() {
		return depAirportCode;
	}
	public void setDepAirportCode(String depAirportCode) {
		this.depAirportCode = depAirportCode;
	}
	public String getArrCity() {
		return arrCity;
	}
	public void setArrCity(String arrCity) {
		this.arrCity = arrCity;
	}
	public String getArrAirportCode() {
		return arrAirportCode;
	}
	public void setArrAirportCode(String arrAirportCode) {
		this.arrAirportCode = arrAirportCode;
	}
	public Flight getFirst() {
		return first;
	}
	public void setFirst(Flight first) {
		this.first = first;
	}
	public Flight getSecond() {
		return second;
	}
	public void setSecond(Flight second) {
		this.second = second;
	}
	
}
