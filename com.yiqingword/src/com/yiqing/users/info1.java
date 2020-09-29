package com.yiqing.users;

public class info1 {
String Date,Province,City,Confirmed_num,Cured_num,Dead_num,Yisi_num;

public String getDate() {
	return Date;
}

public void setDate(String date) {
	Date = date;
}

public String getProvince() {
	return Province;
}

public void setProvince(String province) {
	Province = province;
}

public String getCity() {
	return City;
}

public void setCity(String city) {
	City = city;
}

public String getConfirmed_num() {
	return Confirmed_num;
}

public void setConfirmed_num(String confirmed_num) {
	Confirmed_num = confirmed_num;
}

public info1(String date, String province, String city, String confirmed_num) {
	super();
	Date = date;
	Province = province;
	City = city;
	Confirmed_num = confirmed_num;
}
public info1() {}

public String getCured_num() {
	return Cured_num;
}

public void setCured_num(String cured_num) {
	Cured_num = cured_num;
}

public info1(String date, String province, String city, String confirmed_num, String cured_num) {
	super();
	Date = date;
	Province = province;
	City = city;
	Confirmed_num = confirmed_num;
	Cured_num = cured_num;
}

public String getDead_num() {
	return Dead_num;
}

public void setDead_num(String dead_num) {
	Dead_num = dead_num;
}

public info1(String date, String province, String city, String confirmed_num, String cured_num, String dead_num) {
	super();
	Date = date;
	Province = province;
	City = city;
	Confirmed_num = confirmed_num;
	Cured_num = cured_num;
	Dead_num = dead_num;
}

public String getYisi_num() {
	return Yisi_num;
}

public void setYisi_num(String yisi_num) {
	Yisi_num = yisi_num;
}

public info1(String date, String province, String city, String confirmed_num, String cured_num, String dead_num,
		String yisi_num) {
	super();
	Date = date;
	Province = province;
	City = city;
	Confirmed_num = confirmed_num;
	Cured_num = cured_num;
	Dead_num = dead_num;
	Yisi_num = yisi_num;
}

}
