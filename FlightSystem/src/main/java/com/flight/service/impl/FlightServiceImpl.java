package com.flight.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.flight.bean.Flight;
import com.flight.bean.TransFlight;
import com.flight.service.FlightService;
import com.flight.util.HttpClientUtil;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
/*
 * 获取航班信息
 */
@Service
public class FlightServiceImpl implements FlightService{

	@Value("${FLIGHT_API}")
	private String FLIGHT_API;
	@Value("${FLIGHT_DCITY}")
	private String FLIGHT_DCITY;
	@Value("${FLIGHT_ACITY}")
	private String FLIGHT_ACITY;
	@Value("${FLIGHT_DATE}")
	private String FLIGHT_DATE;
	
	@Override//获取直飞航班信息
	public List<Flight> getFlights(String dCity, String aCity, String date) {
		List<Flight> list=new ArrayList<>();
		String pageUrl=FLIGHT_API+"?"+FLIGHT_DCITY+"="+dCity+"&"+FLIGHT_ACITY+"="+aCity+"&"+FLIGHT_DATE+"="+date;
		String json = HttpClientUtil.doGet(pageUrl);
        JSONObject result =JSONObject.parseObject(json);
        if(result.getInteger("code")==0)//有相应数据
        {
	        JSONArray flights = result.getJSONObject("data").getJSONArray("flights");
	        for (int i = 0; i < flights.size(); i++) {//遍历航班
	        	Flight f=new Flight();
				JSONObject flight = flights.getJSONObject(i);
				JSONObject binfo = flight.getJSONObject("binfo");
				if(binfo!=null)
				{
					f.setDiscount(flight.getString("discountStr"));			//折扣
					f.setPrice(flight.getDouble("minPrice"));				//价格
					f.setPunctuality(1); 									//准点率
					
					f.setCompany(binfo.getString("fullName"));			//航空公司
					f.setCode(binfo.getString("airCode"));				//航班号
					f.setPlanType(binfo.getString("planeFullType"));	//飞机类型
					f.setCabinType(binfo.getString("cabin"));			//舱位类型
					f.setaCity(aCity);									//目的城市
					f.setaAirport(binfo.getString("arrAirport"));		//目的机场
					f.setaAirportCode(binfo.getString("arrAirportCode"));//目的机场缩写
					f.setAirportExit(binfo.getString("arrTerminal"));	//目的机场出口 
					f.setdCity(dCity);									//出发城市
					f.setdAirport(binfo.getString("depAirport"));		//出发机场
					f.setdAirportCode(binfo.getString("depAirportCode"));//出发机场缩写
					f.setAirportEntrance(binfo.getString("depTerminal"));//机场入口
					f.setUse(binfo.getString("flightTime"));			//飞行时间
					f.setDistance(binfo.getInteger("distance"));		//飞行距离
					f.setMeal(binfo.getBoolean("meal"));				//是否有餐食
					if(binfo.getBoolean("stops"))						//是否经停
					{
						f.setStop(true);
						f.setStopCity((String)binfo.getJSONArray("stopCitys").get(0));
						f.setStopAirport((String)binfo.getJSONArray("stopAirports").get(0));
					}
					f.setaDate(binfo.getString("arrDate"));				//到达日期
					f.setaTime(binfo.getString("arrTime"));				//到达时间
					f.setdDate(binfo.getString("depDate"));				//出发日期
					f.setdTime(binfo.getString("depTime"));				//出发时间
					list.add(f);
				}
	        }
		}
		return list;
	}

	@Override//获取中转航班信息
	public List<TransFlight> getTransFlights(String dCity, String aCity, String date) {
		List<TransFlight> list=new ArrayList<>();
		String pageUrl=FLIGHT_API+"?"+FLIGHT_DCITY+"="+dCity+"&"+FLIGHT_ACITY+"="+aCity+"&"+FLIGHT_DATE+"="+date;
		String json = HttpClientUtil.doGet(pageUrl);
        JSONObject result =JSONObject.parseObject(json);
        if(result.getInteger("code")==0)//有相应数据
        {
        	JSONObject data = result.getJSONObject("data");
	        JSONArray flights = data.getJSONArray("flights");
	        String depCity = data.getJSONObject("geographyInfo").getJSONObject("depCity").getString("city");
	        String arrCity = data.getJSONObject("geographyInfo").getJSONObject("arrCity").getString("city");
	        for (int i = 0; i < flights.size(); i++) {//遍历航班
				JSONObject flight = flights.getJSONObject(i);
				TransFlight f=new TransFlight();
				JSONObject binfo1 = flight.getJSONObject("binfo1");
				JSONObject binfo2 = flight.getJSONObject("binfo2");
				if(binfo1!=null&&binfo2!=null)
				{
					Flight first=new Flight();
					Flight second=new Flight();
					f.setDiscount(flight.getString("discountStr"));			//折扣
					f.setPrice(flight.getDouble("minPrice"));				//价格
					f.setDepCity(dCity);									//出发城市
					f.setArrCity(aCity);									//目的城市
					f.setTransTime(flight.getString("transTime"));	 		//中转时间
					f.setTransCity(flight.getString("transCity"));			//中转城市 
					f.setDepAirportCode(depCity);							//出发城市缩写
					f.setArrAirportCode(arrCity);							//目的城市缩写
					
					first.setCompany(binfo1.getString("fullName"));			//航空公司
					first.setCode(binfo1.getString("airCode"));				//航班号
					first.setaAirport(binfo1.getString("arrAirport"));		//目的机场
					first.setaDate(binfo1.getString("arrDate"));			//到达日期
					first.setAirportExit(binfo1.getString("arrTerminal"));	//目的机场出口 
					first.setaTime(binfo1.getString("arrTime"));			//到达时间
					first.setdAirport(binfo1.getString("depAirport"));		//出发机场
					first.setdDate(binfo1.getString("depDate"));			//出发日期
					first.setAirportEntrance(binfo1.getString("depTerminal"));//机场入口
					first.setdTime(binfo1.getString("depTime"));			//出发时间
					first.setDistance(binfo1.getInteger("distance"));		//飞行距离
					first.setUse(binfo1.getString("flightTime"));			//飞行时间
					first.setPlanType(binfo1.getString("planeFullType"));	//飞机类型
					if((binfo1.getString("mealDesc")).equals("有餐食")){
						first.setMeal(true);								//是否有餐食
					}else {first.setMeal(false);}
					if(binfo1.getBoolean("stops"))							//是否经停
					{	first.setStop(true);
						first.setStopCity(binfo1.getJSONArray("stopCitys").getJSONObject(0).toString());
						first.setStopAirport(binfo1.getJSONArray("stopAirports").getJSONObject(0).toString());
					}
					
					second.setCompany(binfo2.getString("fullName"));			//航空公司
					second.setCode(binfo2.getString("airCode"));				//航班号
					second.setaAirport(binfo2.getString("arrAirport"));			//目的机场
					second.setaDate(binfo2.getString("arrDate"));				//到达日期
					second.setAirportExit(binfo2.getString("arrTerminal"));		//目的机场出口 
					second.setaTime(binfo2.getString("arrTime"));				//到达时间
					second.setdAirport(binfo2.getString("depAirport"));			//出发机场
					second.setdDate(binfo2.getString("depDate"));				//出发日期
					second.setAirportEntrance(binfo2.getString("depTerminal"));//机场入口
					second.setdTime(binfo2.getString("depTime"));				//出发时间
					second.setDistance(binfo2.getInteger("distance"));			//飞行距离
					second.setUse(binfo2.getString("flightTime"));				//飞行时间
					second.setPlanType(binfo2.getString("planeFullType"));		//飞机类型
					if((binfo2.getString("mealDesc")).equals("有餐食"))			//是否有餐食
					{second.setMeal(true);}else {second.setMeal(false);}
					if(binfo2.getBoolean("stops"))								//是否经停
					{	second.setStop(true);
						second.setStopCity((String)binfo2.getJSONArray("stopCitys").get(0));
						second.setStopAirport((String)binfo2.getJSONArray("stopAirports").get(0));
					}
					f.setFirst(first);
					f.setSecond(second);
					list.add(f);
				}
	        }
		}
		return list;
	}

}
