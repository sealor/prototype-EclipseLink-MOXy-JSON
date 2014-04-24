package io.github.sealor.java.prototype.eclipselink.moxy.json;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.eclipse.persistence.internal.oxm.ByteArraySource;
import org.eclipse.persistence.jaxb.JAXBContextProperties;

public abstract class AbstractTest {

	private Map<String, Object> jaxbProperties = new HashMap<String, Object>(2);

	public AbstractTest() {
		this.jaxbProperties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
		this.jaxbProperties.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);
	}

	protected String marshal(Object object) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(new Class<?>[] { object.getClass() }, this.jaxbProperties);
		Marshaller marshaller = context.createMarshaller();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(object, baos);

		return baos.toString();
	}

	protected <T> T unmarshal(String jsonString, Class<T> clazz) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(new Class<?>[] { clazz }, this.jaxbProperties);
		Unmarshaller unmarshaller = context.createUnmarshaller();

		JAXBElement<T> jaxbElement = unmarshaller.unmarshal(new ByteArraySource(jsonString.getBytes()), clazz);
		return jaxbElement.getValue();
	}

	protected String replaceQuotes(String text) {
		return text.replace('\'', '"');
	}
}
