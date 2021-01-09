import AccessClasses.Product;
import org.junit.Assert;
import org.junit.Test;

public class TestProduct {
    @Test
    public void testNameAssignment(){
        Product p1,p2;
        p1=new Product("test_name", "test_brand", 5);
        p2=new Product("name", "brand",  "1", 5.0f, "amount");
        Assert.assertEquals(p1.getName(),"test_name");
        Assert.assertEquals(p2.getSaleLimit(),"1");
    }

}
