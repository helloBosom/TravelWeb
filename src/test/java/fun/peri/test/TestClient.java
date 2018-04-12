package fun.peri.test;

import fun.peri.model.City;
import fun.peri.model.ViewSpace;
import fun.peri.service.ICityWebService;
import fun.peri.service.IViewSpaceService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestClient {

    @Test
    public void testMethod1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("viewspace.xml");
        IViewSpaceService viewSpaceService = (IViewSpaceService) context.getBean("viewSpaceService");
        ViewSpace viewSpace = new ViewSpace();
        viewSpaceService.addViewSpace(viewSpace);
    }

    @Test
    public void testMethod2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("viewspace.xml");
        ICityWebService cityWebServiceImpl = (ICityWebService) context.getBean("cityWebServiceImpl");
        List<City> citys = cityWebServiceImpl.queryWebCity();
        for (City c : citys) {
            System.out.println(c.toString());
        }
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("viewspace.xml");
        ICityWebService cityWebServiceImpl = (ICityWebService) context.getBean("cityWebServiceImpl");
        List<City> citys = cityWebServiceImpl.queryWebCity();
        for (City c : citys) {
            System.out.println(c.toString());
        }
    }
}