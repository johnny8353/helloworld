//package com.zte.mcrm.compSearch.ui.compSearch.mobile;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import org.junit.runners.Parameterized.Parameters;
//
//import com.zte.mcrm.framework.ui.framework.AbstractTestBase;
//import com.zte.mcrm.framework.ui.framework.SysTestConst;
//@RunWith(Parameterized. class )
//public class AAATest extends AbstractTestBase {
//	private static AAA calculator = new AAA();
//	private   int  param;
//	private   int  result;
//	@Parameters
//	public   static  Collection data()
//	{
//		return  Arrays.asList( new  Object[][] 
//		{
//			{2 ,  4}
////			{0 ,  0},
////			{-3 , 9},
//		}
//		);
//	}
//	// 构造函数，对变量进行初始化
//	public  AAATest( int  param,  int  result)
//	{
//		this.param  =  param;
//		this.result  =  result;
//	}
//
////	@Test
////	public   void  square()
////	{
////		calculator.square(param);
////		assertEquals(result, calculator.getResult());
////	}
//
//	@Before
//	public void setUp() throws Exception {
//		calculator.clear();
//	}
//
//	@Test(timeout=SysTestConst.TIME_CS_FUNC)
//	public void testAdd() {
//		calculator.add(2);
//		calculator.add(3);
//		assertEquals("测试用例-功能测试-黄福强6011000052",5, calculator.getResult());
//	}
//
////	@Test(timeout=SysTestConst.TIME_NORMAL_FUNC)
////	public void testSubstract() {
////		calculator.add(10);
////		calculator.substract(2);
////		assertEquals(8, calculator.getResult());
////	}
////
////	@Ignore("Multiply() Not yet implemented")
////	@Test
////	public void testMultiply() {
////		fail("Not yet implemented");
////	}
////
////	@Test(timeout=SysTestConst.TIME_NORMAL_FUNC)
////	public void testDivide() {
////		calculator.add(8);
////		calculator.divide(2);
////		assertEquals(4, calculator.getResult());
////	}
//
//}
