package io.github.sealor.java.prototype.eclipselink.moxy.json;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.eclipse.persistence.jaxb.JAXBContextProperties;
import org.junit.Test;

public class SimpleTOTest {

	@Test
	public void testMarshallingAndUnmarshalling() throws JAXBException {
		Map<String, Object> jaxbProperties = new HashMap<String, Object>(2);
		jaxbProperties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");

		JAXBContext context = JAXBContext.newInstance(new Class[] { SimpleTO.class }, jaxbProperties);
		Marshaller marshaller = context.createMarshaller();

		SimpleTO simpleTO = new SimpleTO();
		simpleTO.setText("stefan");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(simpleTO, baos);

		assertEquals("{'text':'stefan'}".replace('\'', '"'), baos.toString());
	}
}
