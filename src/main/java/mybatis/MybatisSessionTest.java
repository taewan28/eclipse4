package mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import day4.mybatis.dao.MybatisBuyDao;
import day4.mybatis.dao.MybatisCustomerDao;
import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.BuyDto;
import day4.mybatis.dto.CustomerBuyDto;
import day4.mybatis.dto.CustomerDto;
import day4.mybatis.dto.ProductDto;


public class MybatisSessionTest {

	public static void main(String[] args) {
		testProduct();
		//testBuy();
		//testCustomer();
	}
	
	public static void testProduct(){
		MybatisProductDao dao = new MybatisProductDao();
		System.out.println("dao 객체 : " + dao);
		
		System.out.println("====== SELECTByCategory 테스트 =====");
		List<ProductDto> list1 = dao.SELECTByCategory("B1");
		System.out.println(list1);
		
		
		System.out.println("====== selectByPname 테스트 =====");
		List<ProductDto> list2 = dao.selectByPname("애플");
		System.out.println(list2);
		
		System.out.println("====== Allselect 테스트 =====");
		List<ProductDto> list3 = dao.Allselect();
		System.out.println(list3);
		
		System.out.println("====== insert 테스트 =====");
		int result = dao.insert(new ProductDto("KOREA COW", "D1", "소고기", 70000));
		System.out.println("반영된 행 개수 : " + result);
		
	}
	
	public static void testCustomer(){
		MybatisCustomerDao dao = new MybatisCustomerDao();
		System.out.println("dao 객체 : " + dao);
		
		System.out.println("====== selectAll 테스트 =====");
		List<CustomerDto> list1 = dao.selectAll();
		System.out.println(list1);

		/*System.out.println("====== insert 테스트 =====");
		int result1 = dao.insert(new CustomerDto("tae1212", "김태완", "twk0223@gmail.com", 40, null));
		System.out.println("반영된 행 개수 : " + result1);

		System.out.println("====== delete 테스트 =======");
		int result2 = dao.delete("tae1212");
		System.out.println("삭제요청 행 개수 : " + result2);
		
		System.out.println("======= update 테스트======");
		int result3 = dao.update(new CustomerDto("tae1212", "김태완", "twk0223@gmail.com", 30, null));
		System.out.println("업데이트 행 개수 : " + result3);
		
		System.out.println("====== getCustomer 테스트 =====");
		List<CustomerDto> list2 = dao.getCustomer("mina012");
		System.out.println(list2);*/
		
	}
	
	public static void testBuy() {
		MybatisBuyDao dao = new MybatisBuyDao();
		System.out.println("dao 객체 : " + dao);

		System.out.println("====== selectAll 테스트 =====");
		List<BuyDto> list = dao.selectAll();
		System.out.println(list);

		System.out.println("====== insert 테스트 =====");
		int result1 = dao.insert(new BuyDto(0, "mina012", "CJBAb12g", 4, null));
		System.out.println("반영된 행 개수 : " + result1);

		System.out.println("====== delete 테스트 =======");
		int result2 = dao.delete(1044);
		System.out.println("삭제요청 행 개수 : " + result2);
		
		System.out.println("======= update 테스트======");
		Map<String,Integer> map = new HashMap<>();
		map.put("buy_idx", 1043);
		map.put("quantity", 3);
		dao.update(map);
		System.out.println(map);
		
		System.out.println("===== selectCustomerBuyList 테스트 =====");
		List<CustomerBuyDto> list2 = dao.selectCustomerBuyList("hongGD");
		System.out.println(list2);
		
	}
	
}	


