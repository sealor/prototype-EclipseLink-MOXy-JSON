package io.github.sealor.java.prototype.eclipselink.moxy.json;

import static org.junit.Assert.assertEquals;

import javax.xml.bind.JAXBException;

import org.junit.Test;

public class SimpleTOTest extends AbstractTest {

	@Test
	public void testMarshallingAndUnmarshalling() throws JAXBException {
		SimpleTO simpleTO = new SimpleTO();
		simpleTO.setText("stefan");

		String jsonString = marshal(simpleTO);

		assertEquals(replaceQuotes("{'text':'stefan'}"), jsonString);
	}
}
