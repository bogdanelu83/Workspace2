package com.proiect.ip2tara;

import java.util.Calendar;

public class Ipsz {
	
	public Calendar calendar;
	public String ip_sz;
	public String tara;
	public Calendar getCalendar() {
		return calendar;
	}
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	public String getIp_sz() {
		return ip_sz;
	}
	public void setIp_sz(String ip_sz) {
		this.ip_sz = ip_sz;
	}
	public String getTara() {
		return tara;
	}
	public void setTara(String tara) {
		this.tara = tara;
	}
	
	public Ipsz(){
		
	}
	
public Ipsz(String ip,Calendar calendar){
		this.ip_sz = ip;
		this.calendar =calendar;
		}
public Ipsz(String ip,Calendar calendar,String tara){
	this.ip_sz = ip;
	this.calendar =calendar;
	this.tara = tara;
	}
	

}
