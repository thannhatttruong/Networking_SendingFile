/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Vector;

/**
 *
 * @author TruongTN
 */
public class FileDataList {
    Vector<byte[]> list;

    public FileDataList(Vector<byte[]> list) {
        this.list = list;
    }

    public Vector<byte[]> getList() {
        return list;
    }

    public void setList(Vector<byte[]> list) {
        this.list = list;
    }
    
    
    
}
