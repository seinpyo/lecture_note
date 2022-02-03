package com.toy;

import com.bettery.Battery;

public class ElectronicRadio {
	private Battery bat;
	
	public ElectronicRadio(Battery bat) {
		//생성자에서 배터리가 초기화 되는데 그 초기값이 생성자의 전달인수로 전달되어야함 
		this.bat = bat;
	}
	
	public void setBattery(Battery battery) {
		this.bat = battery;
	}
}
