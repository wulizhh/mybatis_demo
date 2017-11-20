package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.how2java.pojo.Order;
import com.how2java.pojo.Orderitem;
import com.how2java.pojo.product;

public class testmore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String resource = "mybatis-config.xml";
		
			InputStream inputstream;
			try {
				inputstream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);

			// 然后再根据sqlSessionFactory 得到session

			SqlSession session = sqlSessionFactory.openSession();
			//addorseritem(session);
			//deleteordertitem(session);
			//deleteall(session);
			//listOrder(session);
			productlist2(session);
	        session.commit();
	        session.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	
	private static void listOrder(SqlSession session)
	{
		List<Order> os=session.selectList("listOrder");
		for(Order o:os)
		{
			System.out.println(o.getCode());
			List<Orderitem> ois=o.getOrderitem();
			for(Orderitem oi:ois)
			{/* System.out.println(oi.getNumber()+"---");
			
				System.out.println(oi.getProduct().getName()+"--"+oi.getProduct().getPrice());
				
				*/
				System.out.println(oi.getProduct().getName());
				//System.out.println(oi.getOrder().getCode()+"--code");
				//System.out.println(oi.getProduct().getName()+"--product");
			}
		
			
		}
		
		
	}
	
	
	private static void deleteordertitem(SqlSession session){
		product product=session.selectOne("productbyid",6);
		//System.out.println(product.getName());
		Order order=session.selectOne("orderbycode", 1);
		Orderitem orderitem=new Orderitem();
		
		orderitem.setOrder(order);
		orderitem.setProduct(product);
		
		session.delete("deleteOrderitem", orderitem);
		
		
	}
	
	private static void deleteall(SqlSession session){
		int a=2;
		session.delete("deleteorderbyid", a);
		Orderitem orderitem=new Orderitem();
		Order order=new Order();
		order.setId(a);
		orderitem.setOrder(order);
		session.delete("deleteOrderitembyoid", orderitem);
	}
	
	
	private static void addorseritem(SqlSession session){
		product product=session.selectOne("productbyid",6);
		//System.out.println(product.getName());
		Order order=session.selectOne("orderbycode", 1);
		Orderitem orderitem=new Orderitem();
		orderitem.setNumber(30);
		orderitem.setOrder(order);
		orderitem.setProduct(product);
		//System.out.println(orderitem.getOrder().getCode());
		//System.out.println(orderitem.getNumber()+"--"+orderitem.getProduct().getName());
		session.insert("addOrderitem", orderitem);
	}
	
	
	private static void productlist(SqlSession session){
		//product pro=new product();
		   Map<String,Object> params = new HashMap<>();
	        params.put("name", "x");
	//	pro.setName("x");
	List<product> list=session.selectList("productlist",params);
		for(product l:list)
		{
			System.out.println(l.getName());
		}
		
	}
	
	

	private static void productlist2(SqlSession session){
		//product pro=new product();
		   Map<String,Object> params = new HashMap<>();
	        params.put("name", "pro");
	        params.put("prices", 80);
	//	pro.setName("x");
	List<product> list=session.selectList("productlist2",params);
		for(product l:list)
		{
			System.out.println(l.getName());
		}
		
	}
	
}
