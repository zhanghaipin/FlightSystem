package com.flight.bean;

/*
 * 直飞航班
 */
public class Flight {

	private String code;	//航班号
	private String company;	//航班公司
	private String planType;//飞机型号
	private int distance;	//飞行距离
	private String use;		//飞行时间
	private boolean meal;	//飞机餐
	
	private String dAirport;//出发地点
	private String airportEntrance;//机场入口
	private String dDate;		//出发日期
	private String dTime;	//出发时间
	private boolean stop;	//是否经停
	private String stopCity;//经停城市
	private String stopAirport;//经停机场
	private String aAirport;//目的地点
	private String airportExit;//机场出口
	private String aDate;		//到达日期
	private String aTime;		//到达时间
	
	
	//以下属性只对直飞航班有效
	private String aCity;	//目的城市
	private String aAirportCode;//目的机场缩写
	private String dCity;	//出发城市
	private String dAirportCode;//出发机场缩写
	private String cabinType;	//舱位类型
	private int punctuality;//准点率
	private double price;	//价格
	private String discount;//折扣
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
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
	public String getCabinType() {
		return cabinType;
	}
	public void setCabinType(String cabinType) {
		this.cabinType = cabinType;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public boolean isMeal() {
		return meal;
	}
	public void setMeal(boolean meal) {
		this.meal = meal;
	}
	public int getPunctuality() {
		return punctuality;
	}
	public void setPunctuality(int punctuality) {
		this.punctuality = punctuality;
	}
	public String getdCity() {
		return dCity;
	}
	public void setdCity(String dCity) {
		this.dCity = dCity;
	}
	public String getdAirport() {
		return dAirport;
	}
	public void setdAirport(String dAirport) {
		this.dAirport = dAirport;
	}
	public String getdAirportCode() {
		return dAirportCode;
	}
	public void setdAirportCode(String dAirportCode) {
		this.dAirportCode = dAirportCode;
	}
	public String getdDate() {
		return dDate;
	}
	public void setdDate(String dDate) {
		this.dDate = dDate;
	}

	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	public String getStopCity() {
		return stopCity;
	}
	public void setStopCity(String stopCity) {
		this.stopCity = stopCity;
	}
	public String getStopAirport() {
		return stopAirport;
	}
	public void setStopAirport(String stopAirport) {
		this.stopAirport = stopAirport;
	}
	public String getaCity() {
		return aCity;
	}
	public void setaCity(String aCity) {
		this.aCity = aCity;
	}
	public String getaAirport() {
		return aAirport;
	}
	public void setaAirport(String aAirport) {
		this.aAirport = aAirport;
	}
	public String getaAirportCode() {
		return aAirportCode;
	}
	public void setaAirportCode(String aAirportCode) {
		this.aAirportCode = aAirportCode;
	}
	public String getAirportExit() {
		return airportExit;
	}
	public void setAirportExit(String airportExit) {
		this.airportExit = airportExit;
	}
	public String getaDate() {
		return aDate;
	}
	public void setaDate(String aDate) {
		this.aDate = aDate;
	}
	public String getaTime() {
		return aTime;
	}
	public void setaTime(String aTime) {
		this.aTime = aTime;
	}
	public String getdTime() {
		return dTime;
	}
	public void setdTime(String dTime) {
		this.dTime = dTime;
	}
	public String getAirportEntrance() {
		return airportEntrance;
	}
	public void setAirportEntrance(String airportEntrance) {
		this.airportEntrance = airportEntrance;
	}
	
}
