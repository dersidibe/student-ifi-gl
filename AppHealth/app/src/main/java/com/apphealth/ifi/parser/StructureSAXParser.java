package com.apphealth.ifi.parser;

import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import javax.xml.parsers.SAXParser;
import com.apphealth.ifi.beans.Structure;

public class StructureSAXParser {

    public static ArrayList<Structure> getData(String link) {

        ArrayList<Structure> structures = null;

        try {

/** Handling XML */
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            XMLReader xr = sp.getXMLReader();

/** Send URL to parse XML Tags */
            URL sourceUrl = new URL(link);

/** Create handler to handle XML Tags ( extends DefaultHandler ) */
            StructureSAXHandler myXMLHandler = new StructureSAXHandler();
            xr.setContentHandler(myXMLHandler);
            InputSource is = new InputSource(sourceUrl.openStream());
            is.setEncoding("utf-8");
            xr.parse(is);
            structures = myXMLHandler.getStructures();

        } catch (Exception e) {
            System.out.println("XML Pasing Excpetion = " + e);
        }

/** Get result from MyXMLHandler SitlesList Object */
        return structures;
    }
}
