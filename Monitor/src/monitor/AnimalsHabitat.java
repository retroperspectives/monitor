/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author backt
 */
package monitor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import javax.swing.JOptionPane;

public class AnimalsHabitat {

    private String filePath;
    final private Scanner scnr;

    public AnimalsHabitat() {
        filePath = "";
        scnr = new Scanner(System.in);
    }

    public void askForWhichDetails(String fileName) throws IOException {
        FileInputStream fileByteStream = null; // File input stream
        Scanner inFS = null;                   // Scanner object

        String textLine = null;
        ArrayList aList1 = new ArrayList();

        int i = 0;
        int option = 0;

        boolean bailOut = false;

        // Try to open file
        fileByteStream = new FileInputStream(filePath + fileName + ".txt");
        inFS = new Scanner(fileByteStream);

        while (inFS.hasNextLine() && bailOut == false) {
            textLine = inFS.nextLine();

            if (textLine.contains("Details")) {
                i += 1;
                System.out.println(i + ". " + textLine);

                ArrayList aList2 = new ArrayList();

                for (String retval : textLine.split(" ")) {
                    aList2.add(retval);
                }

                String str = aList2.remove(2).toString();
                aList1.add(str);
            } else {
                System.out.print("Enter selection: ");
                option = scnr.nextInt();

                System.out.println("");

                if (option <= i) {
                    String detailOption = aList1.remove(option - 1).toString();
                    showData(fileName, detailOption);

                    bailOut = true;
                }

                break;
            }
        }

        // Done with file, so try to close it
        fileByteStream.close(); // close() may throw IOException if fails  
    }

    /**
     *
     * @param fileName
     * @param detailOption
     * @throws IOException
     */
    public void showData(String fileName, String detailOption) throws IOException {
        FileInputStream fileByteStream = null; // File input stream
        Scanner inFS = null;                   // Scanner object      

        String textLine = null;
        String lcTextLine = null;
        String alertMessage = "*****";

        int lcStr1Len = fileName.length();
        String lcStr1 = fileName.toLowerCase().substring(0, lcStr1Len - 1);

        int lcStr2Len = detailOption.length();
        String lcStr2 = detailOption.toLowerCase().substring(0, lcStr2Len - 1);

        boolean bailOut = false;

        // Try to open file
        fileByteStream = new FileInputStream(filePath + fileName + ".txt");
        inFS = new Scanner(fileByteStream);

        while (inFS.hasNextLine() && bailOut == false) {
            textLine = inFS.nextLine();
            lcTextLine = textLine.toLowerCase();

            if (lcTextLine.contains(lcStr1) && lcTextLine.contains(lcStr2)) {
                do {
                    System.out.println(textLine);

                    textLine = inFS.nextLine();
                    if (textLine.isEmpty()) {
                        bailOut = true;
                    }
                    
                    if (textLine.contains(alertMessage)) {
                        JOptionPane.showMessageDialog(null, textLine.substring(5));
                    }

                } while (inFS.hasNextLine() && bailOut == false);
            }
        }

        // Done with file, so try to close it
        fileByteStream.close(); // close() may throw IOException if fails      
    }
}
