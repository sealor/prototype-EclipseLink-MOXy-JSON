package io.github.sealor.java.prototype.eclipselink.moxy.json;

import javax.xml.bind.annotation.XmlEnumValue;

public enum OperatingSystem {

	@XmlEnumValue("L1nux")
	LINUX("Linux"),
	//
	@XmlEnumValue("Mac 0SX")
	MACOSX("Mac OSX"),
	//
	@XmlEnumValue("W1ndows")
	WINDOWS("Windows");

	private final String text;

	private OperatingSystem(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return this.text;
	}
}
