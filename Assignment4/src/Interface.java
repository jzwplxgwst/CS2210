/**
 * This class implements the user interface and it contains the main method
 * The input to the program will be a file containing the information that is to be stored in the ordered dictionary
 *
 * Class: CS2210
 * Date: Nov 17 2023
 * @author James Wong
 */

import java.io.BufferedReader;
import java.io.FileReader;

public class Interface {
    public static void main(String[] args) throws MultimediaException {
        BSTDictionary orderedDictionary = new BSTDictionary();
        String inputFile = args[0];

        if (args.length != 1) {
            System.err.println("Usage java Interface <inputFile>");
            System.exit(1);
        }

        try (BufferedReader reader = new BufferedReader((new FileReader(inputFile)))){

            String label;
            String typeAndData;
            int type;
            String data;

            while ((label = reader.readLine()) != null) {
                typeAndData = reader.readLine();

                if (typeAndData.startsWith("-")) {
                    type = 3; // Assuming sound file
                    data = typeAndData.substring(1); // Remove the '-' character
                } else if (typeAndData.startsWith("+")) {
                    type = 4; // Assuming music file
                    data = typeAndData.substring(1); // Remove the '+' character
                } else if (typeAndData.startsWith("*")) {
                    type = 5; // Assuming voice file
                    data = typeAndData.substring(1); // Remove the '*' character
                } else if (typeAndData.startsWith("/")) {
                    type = 2; // Assuming translation to French
                    data = typeAndData.substring(1); // Remove the '/' character
                } else {
                    // Splitting based on the last '.' to handle cases like "x.y.z"
                    String[] parts = typeAndData.split("\\.");
                    String y = parts[parts.length - 1];
                    switch (y) {
                        case "gif" -> {
                            type = 7;
                            data = typeAndData;
                        }
                        case "jpg" -> {
                            type = 6;
                            data = typeAndData;
                        }
                        case "html" -> {
                            type = 8;
                            data = typeAndData;
                        }
                        default -> {
                            type = 1; // Default type
                            data = typeAndData;
                        }
                    }
                }
                Record record = new Record(new Key(label, type), data);
                orderedDictionary.put(record);
            }

            boolean check = true;
            while (check) {

                StringReader keyboard = new StringReader();     // Create a StringReader object to read input from the user
                String line = keyboard.read("Enter next command: ");    // Prompt the user to enter the next command and read the input line
                line = line.toLowerCase();      // Convert the command to lowercase for case-insensitive comparisons

                // Create instances of utility classes for sound, HTML, and image display
                SoundPlayer sound = new SoundPlayer();      // Assumes the existence of SoundPlayer class
                ShowHTML html = new ShowHTML();             // Assumes the existence of ShowHTML class
                PictureViewer viewer = new PictureViewer(); // Assumes the existence of PictureViewer class

                /** define */
                if (line.startsWith("define ")) {
                    String[] hold = line.split(" ");

                    if (hold.length > 2) {
                        System.out.println("Invalid command");

                        // If the ordered dictionary has a Record object d whose Key attribute has label = w and type = 1
                    } else if (orderedDictionary.get(new Key(hold[1], 1)) != null) {

                        // Print the data attribute of the record
                        System.out.println(orderedDictionary.get(new Key(hold[1], 1)).getDataItem());
                    } else {
                        // Print the message if the record is not found
                        System.out.println("The word " + hold[1] + " is not in the ordered dictionary.");
                    }
                    /** translate */
                } else if (line.startsWith("translate ")) {
                    String[] hold = line.split(" ");

                    if (hold.length > 2) {
                        System.out.println("Invalid command");

                        // If the ordered dictionary has a Record object d whose Key attribute has label = w and type = 2
                    } else if (orderedDictionary.get(new Key(hold[1], 2)) != null) {

                        // Print the data attribute of the record
                        System.out.println(orderedDictionary.get(new Key(hold[1], 2)).getDataItem());
                    } else {
                        // Print the message if the record is not found
                        System.out.println("There is no definition for the word " + hold[1]);
                    }
                    /** sound */
                } else if (line.startsWith("sound ")) {
                    String[] hold = line.split(" ");

                    if (hold.length > 2) {
                        System.out.println("Invalid command");

                        // If the ordered dictionary has a Record object d whose Key attribute has label = w and type = 3
                    } else if (orderedDictionary.get(new Key(hold[1], 3)) != null) {

                        // Play the data attribute of the record
                        sound.play(orderedDictionary.get(new Key(hold[1], 3)).getDataItem());
                    } else {
                        // Print the message if the record is not found
                        System.out.println("There is no sound file for " + hold[1]);
                    }
                    /** play */
                } else if (line.startsWith("play ")) {
                    String[] hold = line.split(" ");

                    if (hold.length > 2) {
                        System.out.println("Invalid command");

                        // If the ordered dictionary has a Record object d whose Key attribute has label = w and type = 4
                    } else if (orderedDictionary.get(new Key(hold[1], 4)) != null) {

                        // Play the data attribute of the record
                        sound.play(orderedDictionary.get(new Key(hold[1], 4)).getDataItem());
                    } else {
                        // Print the message if the record is not found
                        System.out.println("There is no music file for " + hold[1]);
                    }
                    /** say */
                } else if (line.startsWith("say ")) {
                    String[] hold = line.split(" ");

                    if (hold.length > 2) {
                        System.out.println("Invalid command");

                        // If the ordered dictionary has a Record object d whose Key attribute has label = w and type = 5
                    } else if (orderedDictionary.get(new Key(hold[1], 5)) != null) {

                        // Play the data attribute of the record
                        sound.play(orderedDictionary.get(new Key(hold[1], 5)).getDataItem());
                    } else {
                        // Print the message if the record is not found
                        System.out.println("There is no voice file for " + hold[1]);
                    }
                    /** show */
                } else if (line.startsWith("show ")) {
                    String[] hold = line.split(" ");

                    if (hold.length > 2) {
                        System.out.println("Invalid command");

                        // If the ordered dictionary has a Record object d whose Key attribute has label = w and type = 6
                    } else if (orderedDictionary.get(new Key(hold[1], 6)) != null) {

                        // Display the data attribute of the record
                        viewer.show(orderedDictionary.get(new Key(hold[1], 6)).getDataItem());
                    } else {
                        // Print the message if the record is not found
                        System.out.println("There is no image file for " + hold[1]);
                    }
                    /** animate */
                } else if (line.startsWith("animate ")) {
                    String[] hold = line.split(" ");

                    if (hold.length > 2) {
                        System.out.println("Invalid command");

                        // If the ordered dictionary has a Record object d whose Key attribute has label = w and type = 7
                    } else if (orderedDictionary.get(new Key(hold[1], 7)) != null) {

                        // Display the data attribute of the record
                        viewer.show(orderedDictionary.get(new Key(hold[1], 7)).getDataItem());
                    } else {
                        // Print the message if the record is not found
                        System.out.println("There is no animated image file for " + hold[1]);
                    }
                    /** browse */
                } else if (line.startsWith("browse ")) {
                    String[] hold = line.split(" ");

                    if (hold.length > 2) {
                        System.out.println("Invalid command");

                        // If the ordered dictionary has a Record object d whose Key attribute has label = w and type = 8
                    } else if (orderedDictionary.get(new Key(hold[1], 8)) != null) {
                        // Display the data attribute of the record
                        html.show(orderedDictionary.get(new Key(hold[1], 8)).getDataItem());
                    } else {
                        // Print the message if the record is not found
                        System.out.println("There is no webpage called " + hold[1]);
                    }
                    /** delete w k */
                } else if (line.startsWith("delete ")) {
                    String[] hold = line.split(" ");

                    if (hold.length > 3) {
                        System.out.println("Invalid command");

                    } else if (orderedDictionary.get(new Key(hold[1], Integer.parseInt(hold[2]))).getDataItem() != null) {
                        orderedDictionary.remove(new Key(hold[1], Integer.parseInt(hold[2])));

                    } else {
                        System.out.printf("No record in the ordered dictionary has key (%s,%s).\n", hold[1], hold[2]);

                    }
                    /** add w t c */
                } else if (line.startsWith("add ")) {
                    String[] hold = line.split(" ");

                    if (hold.length > 4) {
                        System.out.println("Invalid command");

                    } else if (orderedDictionary.get(new Key(hold[1], Integer.parseInt(hold[2]))).getDataItem() != null) {
                        System.out.printf("No record in the ordered dictionary has key (%s,%s).\n", hold[1], hold[2]);

                    } else {
                        Record newRecord = new Record(new Key(hold[1], Integer.parseInt(hold[2])), hold[3]);
                        orderedDictionary.put(newRecord);
                    }

                    /** list prefix */
                } else if (line.startsWith("list ")) {
                    String[] hold = line.split(" ");
                    int counter = 0;        // counts the number of prints

                    if (hold.length > 2) {
                        System.out.println("Invalid command");

                    } else {
                        Record iterate = orderedDictionary.smallest();
                        while (iterate != orderedDictionary.largest()) {
                            if (iterate.getKey().getLabel().startsWith(hold[1])) {
                                System.out.println(iterate.getKey().getLabel());
                                counter++;      // add to the counter
                            }
                            iterate = orderedDictionary.successor(iterate.getKey());
                        }
                    }
                    if (counter == 0) {
                        System.out.println("No label attributes in the ordered dictionary start with prefix " + hold[1]);
                    }

                    /** first */
                } else if (line.equals("first")) {
                    System.out.println(orderedDictionary.smallest().getDataItem());

                    /** last */
                } else if (line.equals("last")) {
                    System.out.println(orderedDictionary.largest().getDataItem());

                    /** exit */
                } else if (line.equals("exit")) {
                    check = false;

                    /** Invalid command */
                } else {
                    System.out.println("Invalid Command");
                }
            }
        } catch (MultimediaException e) {
            System.out.println(e);
        } catch (Exception o) {
            System.out.println(o);
        }
    }
}