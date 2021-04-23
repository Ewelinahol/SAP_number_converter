package com.numberconverter.number_converter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NumberConverterApplicationTests {

private Converter converter= new Converter();
@Autowired
private ConverterController controller;

	@Test
	public void testBinaryNegative()
	{
		try {
			converter.setBinaryString(-1);
			fail("Exception should be thrown here");
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
	}
	}

	@Test
	public void testBinaryZero()
	{
		converter.setBinaryString(0);
		assertEquals(converter.getString(),"0");
	}

	@Test
	public void testBinaryPositiveNumberOne()
	{
		converter.setBinaryString(365);
		assertEquals(converter.getString(),"101101101");
	}

	@Test
	public void testBinaryPositiveNumberTwo()
	{
		converter.setBinaryString(56);
		assertEquals(converter.getString(),"111000");
	}

	@Test
	public void testBinaryMaxPositive()
	{
		converter.setBinaryString(2147483647);
		assertEquals(converter.getString(),"1111111111111111111111111111111");
	}

	@Test
	public void testOctalZero()
	{
		converter.setOctalString(0);
		assertEquals(converter.getString(),"1");
	}

	@Test
	public void testOctalPositiveNumberOne()
	{
		converter.setOctalString(55);
		assertEquals(converter.getString(),"70");
	}

	@Test
	public void testOctalPositiveNumberTwo()
	{
		converter.setOctalString(16);
		assertEquals(converter.getString(),"21");
	}

	@Test
	public void testHexadecimalZero()
	{
		converter.setHexadecimalString(0);
		assertEquals(converter.getString(),"0");
	}

	@Test
	public void testHexadecimalPositiveNumberOne()
	{
		converter.setHexadecimalString(55);
		assertEquals(converter.getString(),"3B");
	}

	@Test
	public void testHexadecimalPositiveNumberTwo()
	{
		converter.setHexadecimalString(22);
		assertEquals(converter.getString(),"D");
	}

	@Test
	public void testDecimalZero()
	{
		converter.setDecimalString(0);
		assertEquals(converter.getString(),"0");
	}

	@Test
	public void testDecimalPositiveNumberOne()
	{
		converter.setDecimalString(10);
		assertEquals(converter.getString(),"12");
	}

	@Test
	public void testDecimalPositiveNumberTwo()
	{
		converter.setDecimalString(21);
		assertEquals(converter.getString(),"28");
	}
}
