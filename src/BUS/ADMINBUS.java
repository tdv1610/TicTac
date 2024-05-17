/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ADMINDAO;
import DTO.ADMINDTO;
import java.util.ArrayList;
/**
 *
 * @author Oracle
 */
public class ADMINBUS {
    private ArrayList<ADMINDTO> list_AD;
    
    private ADMINDAO adDAO;
    
    public ADMINBUS() throws Exception {
        list_AD = new ArrayList<>();
        adDAO = new ADMINDAO();
        list_AD = (ArrayList<ADMINDTO>) adDAO.docDB();
    }
    
    public int getNumbAD() {
        return list_AD.size();
    }
    
    public ArrayList<ADMINDTO> getList_AD() {
        return list_AD;
    }
    
    public void setList_AD(ArrayList<ADMINDTO> list_ND) {
        this.list_AD = list_ND;
    }
    
    public ADMINDTO getInforEmail(String Email) {
        for (ADMINDTO ad : list_AD) {
            if (ad.getEmailAd().equals(Email)) {
                return ad;
            }
        }
        return null;
    }
    
}
