package cn.wangfan.factory;

import cn.wangfan.service.EmpService;
import cn.wangfan.service.impl.EmpServiceImpl;

public class ServiceFactory {
	public static EmpService getIEmpServiceInstance(){
		return new EmpServiceImpl();
	}
	
}
