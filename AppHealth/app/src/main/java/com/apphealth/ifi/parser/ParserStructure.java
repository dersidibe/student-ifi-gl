package com.apphealth.ifi.parser;

import com.apphealth.ifi.beans.Structure;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class ParserStructure extends DefaultHandler{

    private final String ITEM = "item";
    private final String ID = "id";
    private final String NOM = "nom";
    private final String LATITUDE = "latitude";
    private final String LONGITUDE = "longitude";
    private final String TELEPHONE = "telephone";
    private final String RUE = "rue";
    private final String DISTANCE = "distance";

    ArrayList<Structure> structures = null;

    private boolean inItem;
    private Structure currentStructure = null;

    private StringBuffer buffer;

    @Override
    public void processingInstruction(String target, String data) throws SAXException {

        super.processingInstruction(target, data);
    }

    public ParserStructure(){

        super();
    }

    @Override
    public void startDocument() throws SAXException {

        super.startDocument();
        structures = new ArrayList<Structure>();
    }



    @Override
    public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException {

        buffer = new StringBuffer();

        if(localName.equalsIgnoreCase(ITEM)){

            this.currentStructure = new Structure();
            inItem = true;
        }

        if(localName.equalsIgnoreCase(ID)){

        }
        if(localName.equalsIgnoreCase(NOM)){

        }

        if(localName.equalsIgnoreCase(LATITUDE)){

        }
        if(localName.equalsIgnoreCase(LONGITUDE)){

        }
        if(localName.equalsIgnoreCase(TELEPHONE)){

        }
        if(localName.equalsIgnoreCase(RUE)){

        }

        if(localName.equalsIgnoreCase(DISTANCE)){

        }

        //super.startElement(uri, localName, qName, attributes);

    }


    @Override
    public void endElement(String uri, String localName, String qName)throws SAXException {



        if(localName.equalsIgnoreCase(ID)){

            if(inItem){

                this.currentStructure.setId((buffer.toString()));
                buffer = null;
            }
        }

        if(localName.equalsIgnoreCase(NOM)){

            if(inItem){

                this.currentStructure.setNom(buffer.toString());
                buffer = null;
            }
        }

        if(localName.equalsIgnoreCase(LATITUDE)){

            if(inItem){

                this.currentStructure.setLatitude(buffer.toString());
                buffer = null;
            }
        }
        if(localName.equalsIgnoreCase(LONGITUDE)){

            if(inItem){

                this.currentStructure.setLongitude(buffer.toString());
                buffer = null;
            }
        }
        if(localName.equalsIgnoreCase(TELEPHONE)){

            if(inItem){

                this.currentStructure.setTelephone(buffer.toString());
                buffer = null;
            }
        }

        if(localName.equalsIgnoreCase(RUE)){

            if(inItem){

                this.currentStructure.setAdresse(buffer.toString());
                buffer = null;
            }
        }

        if(localName.equalsIgnoreCase(DISTANCE)){

            if(inItem){

                this.currentStructure.setDistance(buffer.toString());
                buffer = null;
            }
        }


        if(localName.equalsIgnoreCase(ITEM)){

            structures.add(currentStructure);
            inItem = false;
        }
        //super.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length)throws SAXException {

        String lecture = new String(ch,start,length);

        if(buffer != null){

            buffer.append(lecture);
        }
        //super.characters(ch, start, length);
    }

    public ArrayList<Structure> getData(){

        return structures;
    }
}
