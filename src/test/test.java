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

import com.how2java.pojo.Category;
import com.how2java.pojo.product;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 根据配置文件mybatis-config.xml得到sqlSessionFactory 。
		String resource = "mybatis-config.xml";
		try {
			InputStream inputstream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);

			// 然后再根据sqlSessionFactory 得到session

			SqlSession session = sqlSessionFactory.openSession();
			// 最后通过session的selectList方法，调用sql语句listCategory。listCategory这个就是在配置文件Category.xml中那条sql语句设置的id。
			// 执行完毕之后，得到一个Category集合，遍历即可看到数据。
			Category c2 = new Category();

			// 增加
			/*
			 * c2.setName("新增加的a2"); session.insert("addCategory",c2);
			 */
			// session.insert("addCategory","爱你");
			// 删除#{id}会自动获取c对象的id属性值
			// int a=2;
			/*
			 * c2.setId(1); session.delete("deleteCategory",c2);
			 */

			// Category c = session.selectOne("getCategory", 1);
			// session.delete("deleteCategory",
			// c);//找到这个对象，使用这个对象的id进行删除，和直接用id删除是一致的
			// 获取
			// c2.setId(1);
			/*
			 * List<Category> cs2=session.selectList("getCategory",c2);
			 * for(Category c1:cs2) {
			 * System.out.println(c1.getName()+c1.getId()+"----");
			 * 
			 * 
			 */

			/*
			 * Category c3= session.selectOne("getCategory",c2);
			 * System.out.println(c3.getName()+"--");
			 */

			// 修改
			// 先找到这个对象
			/*
			 * c2.setId(1); Category a=session.selectOne("getCategory",c2);
			 * //Category a=session.selectOne("getCategory",2);
			 * a.setName("西fgu瓜"); //把a对象存入 session.update("updateCategory",a);
			 */

			// 模糊查询

			/*
			 * List<Category> cs2= session.selectList("listCategoryByName",
			 * "der"); for (Category c4 : cs2) { System.out.println(c4.getName()
			 * + c4.getId()+"-----s");
			 * 
			 * }
			 */

			// 多条件查询*//*
			/*
			 * Map<String,Object> params=new HashMap<>(); params.put("id", 1);
			 * params.put("name", "der");
			 * 
			 * 
			 * List<Category> cs2=
			 * session.selectList("listCategoryMore",params); for (Category c4 :
			 * cs2) { System.out.println(c4.getName() + c4.getId()+"-----s");
			 * 
			 * }
			 * 
			 * 
			 * List<Category> cs = session.selectList("listCategory"); for
			 * (Category c4 : cs) { System.out.println(c4.getName() +
			 * c4.getId());
			 * 
			 * } session.commit(); session.close();
			 */
			session.update("updateproduct");
			List<product> cs = session.selectList("listProduct");
			for (product c : cs) {
				System.out.println(c);

				/*
				 * List<product> ps = c.getList(); for(product p:ps) {
				 * System.out.println("\t"+p); }
				 */
			}

			session.commit();
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
