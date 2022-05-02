package com;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.bettery.ChargeBattery;
import com.bettery.NormalBattery;
import com.toy.ElectronicCar;
import com.toy.ElectronicRadio;

public class MainClass {

	public static void main(String[] args) {
		
		//일반적 사용 예
		//배터리가 장착된 상태로 판매되는 일체형
		ElectronicCar carToy = new ElectronicCar();
		
		NormalBattery nbatt1 = new NormalBattery();
		ChargeBattery cbatt1 = new ChargeBattery();
		ElectronicRadio radioToy1 = new ElectronicRadio(nbatt1);
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		ElectronicCar carToy2 = ctx.getBean("car", ElectronicCar.class);
		ElectronicRadio radioToy2 = ctx.getBean("radio", ElectronicRadio.class);
		radioToy2.setBattery(nbatt1);
	}
}
