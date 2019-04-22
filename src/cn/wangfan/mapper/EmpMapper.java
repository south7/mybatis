package cn.wangfan.mapper;

import java.util.List;
import java.util.Set;

import cn.wangfan.vo.Emp;
/**
 * 动态代理方式操作mybatis的接口
 * 接口中的方法必须遵循的预定：
 * 方法名和EmpMapper.xml文件中标签的id值相同
 * 方法的输入参数和EmpMapper.xml文件中标签的parameterType类型一致
 * 方法的返回值和EmpMapper.xml文件中标签的resultType类型一致
 * @author wangfan
 *
 */
public interface EmpMapper {
	
    public boolean doCreate(Emp vo)throws Exception;
	
	public boolean doUpdate(Emp vo)throws Exception;
	
	public boolean doRemoveBatch(Set<Integer>ids)throws Exception;
	
	public Emp findById(Integer id)throws Exception;

	public List<Emp>findAll()throws Exception;

	public List<Emp>findAllSplit(Integer currentPage,Integer lineSize,String column,String keyWord)throws Exception;
	
	public Integer findAllCount(String column,String keyWord)throws Exception;
}