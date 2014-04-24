package io.github.sealor.java.prototype.eclipselink.moxy.json;

import static org.junit.Assert.assertEquals;

import javax.xml.bind.JAXBException;

import org.junit.Test;

public class SimpleTOTest extends AbstractTest {

	@Test
	public void testMarshallingAndUnmarshalling() throws JAXBException {
		SimpleTO simpleTO1 = new SimpleTO();
		simpleTO1.setText("stefan");

		String jsonString = marshal(simpleTO1);
		assertEquals(replaceQuotes("{'text':'stefan'}"), jsonString);

		SimpleTO simpleTO2 = unmarshal(jsonString, SimpleTO.class);
		assertEquals("stefan", simpleTO2.getText());
	}

	@Test
	public void testMarshalBooleanWithoutQuotes() throws JAXBException {
		SimpleTO simpleTO = new SimpleTO();
		simpleTO.setIsActive(true);

		String jsonString = marshal(simpleTO);
		assertEquals(replaceQuotes("{'isActive':true}"), jsonString);
	}
}
