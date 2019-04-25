package cn.wangfan.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import cn.wangfan.vo.Emp;


public interface EmpService {
   
	public boolean insert(Emp vo)throws Exception;
	
	public boolean update(Emp vo)throws Exception;
   
	public boolean delete(Set<Integer> ids)throws Exception;
	
	public Emp get(int id)throws Exception;
	
	public List<Emp> list() throws Exception;
	
	public Map<String,Object>list(int currentPage,int lineSize,String column,String keyWord)throws Exception;
}
