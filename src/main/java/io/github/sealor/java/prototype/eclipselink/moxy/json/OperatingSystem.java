package io.github.sealor.java.prototype.eclipselink.moxy.json;

public enum OperatingSystem {

	LINUX("Linux"), MACOSX("Mac OSX"), WINDOWS("Windows");

	private final String text;

	private OperatingSystem(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return this.text;
	}
}
