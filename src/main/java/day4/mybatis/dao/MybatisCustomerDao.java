package day4.mybatis.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import day4.mybatis.dto.CustomerDto;
import day4.mybatis.dto.ProductDto;
import mybatis.SqlSessionBean;

public class MybatisCustomerDao {
	
	private SqlSessionFactory sessionFactory = SqlSessionBean.getSessionFactory();
	   
	   public List<CustomerDto> selectAll() {
	      SqlSession sqlSession = sessionFactory.openSession();
	      List<CustomerDto> list = sqlSession.selectList("tblcustom.selectAll");
	      sqlSession.close();
	      return list;
	   }
	   
	   public int insert(CustomerDto vo) {
	      SqlSession sqlSession = sessionFactory.openSession();
	      int result = sqlSession.insert("tblcustom.insert",vo);
	      sqlSession.commit();
	      sqlSession.close();
	      return result;
	   }
	   
	   public int delete(String customId) {
		   SqlSession sqlSession = sessionFactory.openSession();
		   int result = sqlSession.delete("tblcustom.delete", customId);
		   sqlSession.commit();
		   sqlSession.close();
		   return result;
	   }
	   
	   public int update(CustomerDto vo) {
	      SqlSession sqlSession = sessionFactory.openSession();
	      int result = sqlSession.update("tblcustom.update", vo);
	      sqlSession.commit();
	      sqlSession.close();
	      return result;
	   }
	   
	   public List<CustomerDto> getCustomer(String customid){
			SqlSession sqlSession = sessionFactory.openSession();
			List<CustomerDto> list = sqlSession.selectList("tblcustom.getCustomer",customid);
			sqlSession.close();
			return list;
		   }
	   

}
