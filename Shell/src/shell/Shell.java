/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author lukas
 */
public class Shell {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while(true) {
            System.out.print("> ");
            Scanner input =  new Scanner(System.in);
            String inputUser = input.nextLine();
            String[] commands = inputUser.trim().split("&");
            for(int i = 0; i < commands.length; i++) {
                if(commands[i].equals("q")) {
                    return;
                }
                try {
                    Process process = Runtime.getRuntime().exec(commands[i]);
                    process.waitFor();
                    InputStream inputStream = process.getInputStream();
                    int x = inputStream.read();
                    while(i != -1) {
                        System.out.print((char)i);
                        x = inputStream.read();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }    
}