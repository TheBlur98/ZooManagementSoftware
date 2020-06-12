package com.progex.zoomanagementsoftware.datatypes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * This class shall general provide methods for the Implementation If they
 * cannot be assigned to a concrete Class
 */
public class Methods {

    public Methods() {

    }

    /**
     * Method which changes time every 60 seconds
     *
     * @param jLabelShowDateTime The label in which current time and date shall
     * be shown
     */
    public void showTimeAndDate(JLabel jLabelShowDateTime) {

        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String dateAndTime = s.format(date);
        String dateString = dateAndTime.substring(0, 10);
        String dateTime = dateAndTime.substring(11, 16);
        //System.out.println(dateAndTime); //Debug
        jLabelShowDateTime.setText("Zeit: " + dateTime + " Datum: " + dateString);

        //Each Minute get current Time 60000 
        new Timer(60000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Date date = new Date();
                SimpleDateFormat s = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                String dateAndTime = s.format(date);
                String dateString = dateAndTime.substring(0, 10);
                String dateTime = dateAndTime.substring(11, 16);
                //System.out.println(dateAndTime); //Debug
                jLabelShowDateTime.setText("Zeit: " + dateTime + " Datum: " + dateString);
            }
        }).start();
    }

    /**
     * Method to verify that the user inputs are not empty.
     *
     * @param textFields
     * @return
     */
    public boolean verifyTextFields(JTextField[] textFields) {

        //Remove trailing and leading Textfields and check if Field is empty
        for (JTextField textField : textFields) {
            textField.setText(textField.getText().trim());
            if (textField.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Bitte alle notwendigen Werte eintragen !", "Textfeld ohne Inhalt", JOptionPane.CANCEL_OPTION);
                return false;
            }
        }
        return true;
    }

    /**
     * Method to get the corresponding description enum of an Animal
     *
     * @param descriptionStr
     * @return The correspondig enum to the description String
     */
    public Description stringToDescription(String descriptionStr) {

        Description description = null;
        switch (descriptionStr) {

            case "Säugetier":
                description = Description.mammal;
                break;
            case "Fisch":
                description = Description.fish;
                break;
            case "Vogel":
                description = Description.bird;
                break;
            case "Amphibie":
                description = Description.amphibian;
                break;
            case "Reptil":
                description = Description.reptile;
                break;
            case "Insekt":
                description = Description.insect;
                break;
            case "Spinnentier":
                description = Description.arachnid;
                break;
            case "Wirbellos":
                description = Description.invertebrate;
                break;
        }

        return description;
    }

    /**
     * Method to convert a description enum to its corresponding "german" value.
     *
     * @param description
     * @return The description as String
     */
    public String descriptionToString(Description description) {

        String descriptionStr = null;

        switch (description) {

            case fish:
                descriptionStr = "Fisch";
                break;
            case bird:
                descriptionStr = "Vogel";
                break;
            case mammal:
                descriptionStr = "Säugetier";
                break;
            case amphibian:
                descriptionStr = "Amphibie";
                break;
            case reptile:
                descriptionStr = "Reptil";
                break;
            case insect:
                descriptionStr = "Insekt";
                break;
            case arachnid:
                descriptionStr = "Spinnentier";
                break;
            case invertebrate:
                descriptionStr = "Wirbellos";
                break;
        }

        return descriptionStr;

    }

    /**
     * Method to check if a given date has the format ""yyyy-MM-dd
     * @param dateString
     * @return true if pattern is valid, else false
     */
    public boolean isValidDateString(String dateString) {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            new SimpleDateFormat(pattern).parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

   
    /**
     * Method to remove the seconds From da String 
     * with the format: YYYY-MM-DD HH:MI:SS
     * @param dateString
     * @return The formated String with YYYY-MM-DD HH:MI
     */
   public String removeSeconds(String dateString){
   
        return dateString.substring(0,16);
   }
   
   
   /**
    * TODO: probably merge with function above in a valid pattern function???
    * @param feedingTime
    * @return True if format is yyyy-MM-dd HH:mm:ss, else false
    */
   public boolean isValidFeedingTime(String feedingTime){
   
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        
        if (feedingTime.length()> pattern.length()) return false;
        try {
            new SimpleDateFormat(pattern).parse(feedingTime);
            return true;
        } catch (ParseException e) {
            return false;
        }
   }
   
   
   
   /**
    * Method to check if end feeding time comes after starts feeding time.
    * @param startFeedingTime
    * @param endFeedingTime
    * @return true if end feeding time is greater than start, else false
    */
   public boolean isFeedingTimesGreater(String startFeedingTime, String endFeedingTime){
   
       String pattern = "yyyy-MM-dd HH:mm:ss";
        try {
            Date start = new SimpleDateFormat(pattern).parse(startFeedingTime);
             Date end = new SimpleDateFormat(pattern).parse(endFeedingTime);
        
           return end.after(start);
        
        } catch (ParseException ex) {
            
            
            System.err.println("Parsing Exception");
            System.out.println(ex.getMessage());
            
            
        }
       
        return false;
        
        
     }
   
    
}
