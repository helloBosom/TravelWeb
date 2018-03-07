package com.cissst.software.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cissst.software.model.City;
import com.cissst.software.model.ViewSpace;
import com.cissst.software.service.ICityWebService;
import com.cissst.software.service.IViewSpaceService;
@Service 
public class TestClient {
	
	 
	@Test
	public void testMethod1(){
		ApplicationContext context =
				new ClassPathXmlApplicationContext("viewspace.xml");
		IViewSpaceService viewSpaceService =
				(IViewSpaceService)context.getBean("viewSpaceService");
		ViewSpace viewSpace = new ViewSpace();
		
		viewSpaceService.addViewSpace(viewSpace);
	}
	@Test
	public void testMethod2(){
		ApplicationContext context =
				new ClassPathXmlApplicationContext("viewspace.xml");
		ICityWebService cityWebServiceImpl =
				(ICityWebService)context.getBean("cityWebServiceImpl");
		List<City> citys = cityWebServiceImpl.queryWebCity();
		for(City c : citys){
			System.out.println(c.toString());
		}
		
		
	}
	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("viewspace.xml");
		ICityWebService cityWebServiceImpl =
				(ICityWebService)context.getBean("cityWebServiceImpl");
		List<City> citys = cityWebServiceImpl.queryWebCity();
		
		for(City c : citys){
			System.out.println(c.toString());
		}
	}
}
