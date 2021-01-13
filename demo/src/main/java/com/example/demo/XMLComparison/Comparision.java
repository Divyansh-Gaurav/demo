package com.example.demo.XMLComparison;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.Difference;
import org.custommonkey.xmlunit.XMLUnit;
import org.xml.sax.SAXException;

public class Comparision {
	
	public static void main(String[] args) throws SAXException, IOException{
        FileInputStream source = new FileInputStream("E:/demo/demo/src/main/resources/dummy1.xml");
        FileInputStream target = new FileInputStream("E:/demo/demo/src/main/resources/dummy2.xml");
        
        // using BufferedReader for improved performance
        BufferedReader sourceFile = new BufferedReader(new InputStreamReader(source));
        BufferedReader targetFile = new BufferedReader(new InputStreamReader(target));
        XMLUnit.setIgnoreWhitespace(true);
        List<?> differences = compareXML(sourceFile, targetFile);
        printDifferences(differences);
    }

    public static List<?> compareXML(Reader source, Reader target) throws SAXException, IOException {
        Diff xmlDiff = new Diff(source, target);
        DetailedDiff detailXmlDiff = new DetailedDiff(xmlDiff);
        return detailXmlDiff.getAllDifferences();
    }

    public static void printDifferences(List<?> differences) {
        int totalDifferences = differences.size();
        System.out.println("Number of differences : " + totalDifferences);
        for (Object object : differences) {
            Difference difference = (Difference) object;
            System.out.println(difference);
        }
    }
}