package cn.wangfan.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import cn.wangfan.mapper.EmpMapper;
import cn.wangfan.service.EmpService;
import cn.wangfan.util.SsfSington;
import cn.wangfan.vo.Emp;

public class EmpServiceImpl implements EmpService {
	
	@Override
	public boolean insert(Emp vo) throws Exception {
		SqlSession session = SsfSington.getInstance().openSession(true);
		try {
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			if(null==mapper.findById(vo.getEmpno())){
				return mapper.doCreate(vo);
			}
			return false;
		} catch (Exception e) {
			throw e;
		}finally {
			session.close();
		}
	}

	@Override
	public boolean update(Emp vo) throws Exception {
		SqlSession session = SsfSington.getInstance().openSession(true);
		try {
			 EmpMapper mapper = session.getMapper(EmpMapper.class);
			 return mapper.doUpdate(vo);
		} catch (Exception e) {
			throw e;
		}finally {
			session.close();
		}
	}

	@Override
	public boolean delete(Set<Integer> ids) throws Exception {
		SqlSession session = SsfSington.getInstance().openSession(true);
		try {
			 EmpMapper mapper = session.getMapper(EmpMapper.class);
			 return mapper.doRemoveBatch(ids);
		} catch (Exception e) {
			throw e;
		}finally {
			session.close();
		}
	}

	@Override
	public Emp get(int id) throws Exception {
		SqlSession session = SsfSington.getInstance().openSession(true);
		try {
			 EmpMapper mapper = session.getMapper(EmpMapper.class);
			 return mapper.findById(id);
		} catch (Exception e) {
			throw e;
		}finally {
			session.close();
		}
	}

	@Override
	public List<Emp> list() throws Exception {
		SqlSession session = SsfSington.getInstance().openSession(true);
		try {
			 EmpMapper mapper = session.getMapper(EmpMapper.class);
			 return mapper.findAll();
		} catch (Exception e) {
			throw e;
		}finally {
			session.close();
		}
	}

	@Override
	public Map<String, Object> list(int currentPage, int lineSize,String column, String keyWord) throws Exception {
		SqlSession session = SsfSington.getInstance().openSession(true);
		try {
			 EmpMapper mapper = session.getMapper(EmpMapper.class);
			 Map<String,Object>map=new HashMap<String, Object>();
			 map.put("allEmps", mapper.findAllSplit((currentPage-1)*lineSize, lineSize, column, "%" + keyWord + "%"));
			 map.put("empCount", mapper.findAllCount(column, "%" + keyWord + "%"));
			 return map;
		} catch (Exception e) {
			throw e;
		}finally {
			session.close();
		}
	}

}
