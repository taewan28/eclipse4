package day4.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import day4.mybatis.dto.BuyDto;
import day4.mybatis.dto.CateDto;
import day4.mybatis.dto.ProductDto;
import mybatis.SqlSessionBean;

public class MybatisProductDao {
	
	private SqlSessionFactory sessionFactory = SqlSessionBean.getSessionFactory();

	public List<ProductDto> SELECTByCategory(String category) {
	      SqlSession sqlSession = sessionFactory.openSession();
	      List<ProductDto> list = sqlSession.selectList("tblproduct.SELECTByCategory",category);
	      sqlSession.close();
	      return list;
	   }
	
	public List<ProductDto> selectByPname(String pname) {
	      SqlSession sqlSession = sessionFactory.openSession();
	      List<ProductDto> list = sqlSession.selectList("tblproduct.selectByPname",pname);
	      sqlSession.close();
	      return list;
	   }
	
	public List<ProductDto> Allselect() {
	      SqlSession sqlSession = sessionFactory.openSession();
	      List<ProductDto> list = sqlSession.selectList("tblproduct.Allselect");
	      sqlSession.close();
	      return list;
	   }
	
	 public int insert(ProductDto vo) {
	      SqlSession sqlSession = sessionFactory.openSession();
	      int result = sqlSession.insert("tblproduct.insert",vo);
	      sqlSession.commit();
	      sqlSession.close();
	      return result;
	   }
	 public List<ProductDto> search(Map<String,Object>map){
		 SqlSession sqlSession = sessionFactory.openSession();
		 List<ProductDto> list = sqlSession.selectList("tblproduct.search",map);
		 sqlSession.close();
		 return list;
		 
	 }
	 
	 /*public List<String> getCategories(){
		 SqlSession sqlSession = sessionFactory.openSession();
		 List<String> list = sqlSession.selectList("tblproduct.getCategories");
		 sqlSession.close();
		 return list;
		 
	 }*/
	 
	 
	 public List<CateDto> getCategories(){
	 SqlSession sqlSession = sessionFactory.openSession();
	 List<CateDto> list = sqlSession.selectList("tblproduct.getCategories");
	 sqlSession.close();
	 return list;
	 
	 }
	 
	 
}
