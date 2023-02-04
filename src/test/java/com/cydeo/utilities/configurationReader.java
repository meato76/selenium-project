package com.cydeo.utilities;


/*
In this class, we will be creating the re-usable logic to read from
configuration.properties file
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configurationReader {

    //1- Create the Properties object (create object)
    //make it "private" so we are limiting access to the object
    //"static" is to make sure its created and loaded before everything else.
    private static Properties properties = new Properties();

    static {


        try {
            //2- Open file using FileInputStream (open file)
            FileInputStream file = new FileInputStream("configuration.properties");
            //3- Load the "properties" object with "file" (load properties)
            properties.load(file);

            //close the file in the memory
            file.close();


        } catch (IOException e) {
            System.out.println("File not found with given path!!!");
            e.printStackTrace();
        }
    }


    // creat a utility method to use the object to read
    //4- Use"properties" object to read from the file (road properties)

    public static String getProperty (String keyword){
        return properties.getProperty(keyword);
    }



}
