import java.io.*;
import javax.xml.*;
import javax.xml.parsers.*;

import org.xml.sax.SAXException;
public class TestSAX {
	public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse("/Users/dylan/eclipse-workspace/HuskyShare/src/test.xml" ,new SAXInterpreter());
	}
}
