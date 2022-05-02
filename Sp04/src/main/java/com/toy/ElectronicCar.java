package com.toy;

import com.bettery.Battery;
import com.bettery.NormalBattery;

public class ElectronicCar {
	private Battery bat;  //인터페이스 참조 변수. 배터리 변수=멤버변수
	public ElectronicCar() {	//생성자에서 노멀배터리를 멤버변수 초기값으로 대입
		bat = new NormalBattery();  //인터페이스 멤버변수에 battery를 implements한 클래스를 대입
	}
}
