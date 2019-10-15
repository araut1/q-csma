/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package qcsma;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Administrator
 */
public class filesend {

    public void sendData(){
        try{
            int i=0;
            byte[] buffer = new byte[1024];
            File file=PacketGen.fle;
            Socket soc = new Socket("localhost", 1689);
            FileInputStream fileIn = new FileInputStream(file);
            DataOutputStream fileOut = new DataOutputStream(soc.getOutputStream());
            int parts= (int) Math.ceil((double) (file.length() / (double)1024));
            int readFile;
            while ((readFile = fileIn.read(buffer)) != -1) {
                i++;
                fileOut.write(buffer, 0, readFile);
                fileOut.flush();
            }
            soc.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }

}
