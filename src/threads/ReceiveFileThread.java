/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import data.FileDataList;
import dto.FileDTO;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Vector;
import javax.swing.JTextArea;

/**
 *
 * @author TruongTN
 */
public class ReceiveFileThread extends Thread{
    Socket fileSocket;
    ObjectInputStream ois;
    JTextArea txtMessages;
    Vector<FileDTO> fileList;
    
    public ReceiveFileThread(Socket fileSocket, JTextArea txtMessages, Vector<FileDTO> fileList) {
        super();
        this.fileSocket = fileSocket;
        this.txtMessages = txtMessages;
        this.fileList = fileList;
    }

    

    @Override
    public void run(){
        while(true){
            try {
                if(fileSocket != null){
                    FileDTO fileData  = null;
                    ois = new ObjectInputStream(fileSocket.getInputStream());
                    if((fileData = (FileDTO) ois.readObject()) != null){
                        sleep(500);
                        fileList.add(fileData);
                        txtMessages.append(fileData.fileName + "\n");
                    }
                }
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
}
