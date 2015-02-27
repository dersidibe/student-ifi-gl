package com.apphealth.ifi.parser;

import com.apphealth.ifi.beans.Structure;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;


public class StructureSAXHandler extends DefaultHandler {

    private ArrayList<Structure> structures;
    private String tempVal;
    private Structure struct;

    public StructureSAXHandler() {

        structures = new ArrayList<Structure>();
    }

    public ArrayList<Structure> getStructures() {
        return structures;
    }

    // Event Handlers
    public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException {

        tempVal = "";
        if (qName.equalsIgnoreCase("item")) {

            struct = new Structure();
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {

        tempVal = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("item")) {

            structures.add(struct);
        }
        else if (qName.equalsIgnoreCase("id")) {

            struct.setId(tempVal);
        }
        else if (qName.equalsIgnoreCase("nom")) {

            struct.setNom(tempVal);
        }
        else if (qName.equalsIgnoreCase("latitude")) {

            struct.setLatitude(tempVal);
        }
        else if (qName.equalsIgnoreCase("longitude")) {

            struct.setLongitude(tempVal);
        }
        else if (qName.equalsIgnoreCase("telephone")) {

            struct.setTelephone(tempVal);
        }
        else if (qName.equalsIgnoreCase("rue")) {

            struct.setAdresse(tempVal);
        }
        else if (qName.equalsIgnoreCase("distance")) {

            struct.setDistance(tempVal);
        }
    }
}
