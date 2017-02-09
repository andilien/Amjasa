/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectorarchivos;

/**
 *
 * @author AGL
 */
import Clases.Contador;
import java.io.File;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class LeerXML {
   private String archivo;

   public LeerXML(String archivo) {
       this.archivo = archivo;
   }
   public String getArchivo() {
       return archivo;
   }
   public Hashtable<String,String> leerXML(){
       Hashtable<String,String> contadores = new Hashtable();
      try {	
            File inputFile = new File(this.getArchivo());

            DocumentBuilderFactory dbFactory 
               = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Meter");
            for (int temp = 0; temp < nList.getLength(); temp++) {
               Node nNode = nList.item(temp);
               if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                  Element eElement = (Element) nNode;
                  if (Integer.parseInt(eElement.getElementsByTagName("Baja").item(0).getTextContent()) == 0 && !eElement.getElementsByTagName("Situation").item(0).getTextContent().isEmpty()) {
                       contadores.put(eElement.getElementsByTagName("MeterNumber").item(0).getTextContent(), eElement.getElementsByTagName("Situation").item(0).getTextContent());
                  }
               }
            }
      } catch (Exception e) {
         e.printStackTrace();
      }
       return contadores;
   }
}
