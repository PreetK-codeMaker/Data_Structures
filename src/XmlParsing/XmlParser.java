package XmlParsing;

import Stack.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;


/**
 * This class makes runs through given files with the for the xml parsing and It has done a successful for parse the file
 * samplefile #1 and Sample file#3. Because these file does not have any error I use regex for this to accomplish.
 *  References:
 *          1. https://regex101.com/
 *          2.http://regexstorm.net/reference
 *          3.https://www.codeproject.com/articles/24040/regex-tester-regular-expression-tester
 */
public class XmlParser {

    public static void main(String[] args) throws IOException {
        String error = "<([^>]+)>[^<]*<\\/(\\1)>";
        String not1 = "\\s*<(.*?)\\s*\\/>"; //This regex evaluate if the tag is self closing.
        String begin ="\\s*<(?!\\/)(.*)>"; //This test if the tag is not self closing and is begining tag
        String end = "\\s*<(\\/)(.*)>";// This make sure this tag has ending tag.
       String dupBracket  ="\\s*<(?!\\/)(.*)>\\s*\\>";
        String fileName = "res/sample2.xml";
        boolean status = false;
        int counter = 0;
        Stack<String> j = new Stack<String>();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line  = "";
//        br.readLine();
        while((line = br.readLine()) !=null){
            ++counter;
            if((line.matches(begin))){
                if(line.matches(dupBracket)){
                    System.out.println("Error");
                    System.out.println(line+"  line"+counter);
                }
                if(!(line.matches(not1))){
                    j.push(line);
                }
            }else if(line.matches(end)){
                String checkNull = j.pop();
            }
        }

        br.close();

        System.out.println(j.isEmpty());
        }

    }

