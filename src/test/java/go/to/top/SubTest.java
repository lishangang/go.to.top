package go.to.top;

public class SubTest extends ParentTest {

	@Override
	protected void setTzPromIdInAreaAndPrice(String tzPromId2) {
		System.out.println("222222222222");
	}

	
	public static void main(String[] args) {
		SubTest test = new SubTest();
		test.setTzPromId("abc");
	}
}
