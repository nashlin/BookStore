package cn.itcast.utils;

public class DaoFactory {

	private static final DaoFactory instance=new DaoFactory();
	
	private DaoFactory(){}
	
	public static DaoFactory getInstance(){
		return instance;
	}
	
	public static <T> T createDao(String name,Class<T> clazz){
		T t;
		try {
			t = (T) clazz.forName(name).newInstance();
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
