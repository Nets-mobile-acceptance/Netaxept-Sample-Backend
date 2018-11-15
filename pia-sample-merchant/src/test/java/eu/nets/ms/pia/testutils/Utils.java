package eu.nets.ms.pia.testutils;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.assertj.core.util.DateUtil;

public class Utils {
	
	private Utils(){
		throw new AssertionError();
	}
	
	public static XMLGregorianCalendar getXMLGregorianCalendar(String date) throws DatatypeConfigurationException {
	    XMLGregorianCalendar xmlCalender=null;
	    GregorianCalendar calender = new GregorianCalendar();
	    calender.setTime(DateUtil.parseDatetime(date));
	    xmlCalender = DatatypeFactory.newInstance().newXMLGregorianCalendar(calender);
	    return xmlCalender;
	}
}
