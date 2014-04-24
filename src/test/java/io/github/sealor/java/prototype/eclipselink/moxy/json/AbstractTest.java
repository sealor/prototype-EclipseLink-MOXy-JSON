package io.github.sealor.java.prototype.eclipselink.moxy.json;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.eclipse.persistence.jaxb.JAXBContextProperties;

public abstract class AbstractTest {

	private Map<String, Object> jaxbProperties = new HashMap<String, Object>(2);

	public AbstractTest() {
		this.jaxbProperties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
	}

	protected String marshal(Object object) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(new Class<?>[] { object.getClass() }, this.jaxbProperties);
		Marshaller marshaller = context.createMarshaller();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(object, baos);

		return baos.toString();
	}

	protected String replaceQuotes(String text) {
		return text.replace('\'', '"');
	}
}
