package com.apphealth.ifi.parser;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import android.content.Context;
import android.util.Log;

import com.apphealth.ifi.beans.Structure;


public class StructureDataHandler {


    static public Context context;

    public  StructureDataHandler() {

    }


    public static ArrayList<Structure> getFeeds(String link){

        SAXParserFactory fabrique = SAXParserFactory.newInstance();
        SAXParser parseur = null;
        ArrayList<Structure> structures = null;

        try {

            parseur = fabrique.newSAXParser();

        } catch (ParserConfigurationException e) {

            Log.e("Error", "Parser Configuration Error");

        } catch (SAXException e) {

            Log.e("Error", "SAX Error");

        }

        URL url = null;

        try {

            url = new URL(link);

        } catch (MalformedURLException e1) {

            Log.e("Error", "Parser URL Error");

        }

		/*
		 * Le handler sera gestionnaire du fichier XML c'est à dire que c'est lui qui sera chargé
		 * des opérations de parsing. On vera cette classe en détails ci après.
		*/

        DefaultHandler handler = new ParserStructure();

        try {
            // On parse le fichier XML
            InputStream input = url.openStream();

            if(input == null){

                Log.e("Erreur Android",null);
            }

            else{

                parseur.parse(input, handler);
                structures = ((ParserStructure) handler).getData();

            }

        } catch (SAXException e) {

            Log.e("Error", "SAX Error");

        } catch (IOException e) {

            Log.e("Error", "IO Error");

        }


        return structures;

    }
}
