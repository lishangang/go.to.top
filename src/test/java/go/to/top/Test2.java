package go.to.top;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test2 {

	public static void main(String[] args) {
		Person p1 = Person.getInstance();
		Class<Person> p2 = Person.class;
		try {
			Constructor cc = p2.getDeclaredConstructor(null);
			cc.setAccessible(true);
			try {
				Person p33 = (Person) cc.newInstance(null);
				System.out.println(p33 == p1);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Person {
	
	private static final Person person = new Person();
	public static boolean flag = false;
	private Person() {
        synchronized(Person.class) {
        	if (flag == false) {
    			flag = true;
    		} else {
    			throw new RuntimeException("dddddddddddddd");
    		}
        }
	}
    private  static class SingletonHolder{
        private static final Person INSTANCE = new Person();
    }
 
    public static Person getInstance()
    {
        return SingletonHolder.INSTANCE;
    }
	public static Person getPerson() {
		return person;
	}
	
}
