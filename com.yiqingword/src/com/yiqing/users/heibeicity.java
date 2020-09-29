package com.yiqing.users;

public class heibeicity {

	String Date,City,New_confirmed_num,Confirmed_num,Dead_num,Zhong_num,Cured_num;

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getNew_confirmed_num() {
		return New_confirmed_num;
	}

	public void setNew_confirmed_num(String new_confirmed_num) {
		New_confirmed_num = new_confirmed_num;
	}

	public String getConfirmed_num() {
		return Confirmed_num;
	}

	public void setConfirmed_num(String confirmed_num) {
		Confirmed_num = confirmed_num;
	}

	public String getDead_num() {
		return Dead_num;
	}

	public void setDead_num(String dead_num) {
		Dead_num = dead_num;
	}

	public String getZhong_num() {
		return Zhong_num;
	}

	public void setZhong_num(String zhong_num) {
		Zhong_num = zhong_num;
	}

	public String getCured_num() {
		return Cured_num;
	}

	public void setCured_num(String cured_num) {
		Cured_num = cured_num;
	}

	public heibeicity(String date, String city, String new_confirmed_num, String confirmed_num, String dead_num,
			String zhong_num, String cured_num) {
		super();
		Date = date;
		City = city;
		New_confirmed_num = new_confirmed_num;
		Confirmed_num = confirmed_num;
		Dead_num = dead_num;
		Zhong_num = zhong_num;
		Cured_num = cured_num;
	}
	public heibeicity() {}
}
