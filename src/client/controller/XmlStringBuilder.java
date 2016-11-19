package client.controller;
import xml.Message;
public class XmlStringBuilder {
	String xml;
	String name;

	/**
	 * define different string for XML
	 * @param name
	 */
	public XmlStringBuilder(String name) {
		this.name = name;
		this.xml = Message.requestHeader() +"<" + name;
	}

	public XmlStringBuilder(String name, boolean header) {
		this.name = name;

		if (header) {
			this.xml = Message.requestHeader() + "<" + name;
		} else {
			this.xml = "<" + name;
		}
	}

	public XmlStringBuilder add(String s) {
		this.xml += s;

		return this;
	}

	public XmlStringBuilder add(String id, String value) {
		this.xml += " " + id + "='" + value + "'";

		return this;
	}

	public XmlStringBuilder closeSegment() {
		this.xml += ">";

		return this;
	}
	
	public XmlStringBuilder closeElement() {
		this.xml += "/>";

		return this;
	}

	public XmlStringBuilder finishSegment() {
		this.xml += "</" + name + "></request>";

		return this;
	}

	public XmlStringBuilder finish() {
		this.xml += "/></request>";

		return this;
	}

	@Override
	public String toString() {
		return xml;
	}

	public static void main(String[] args) {
	
	}
}
