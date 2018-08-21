package com.ga.capitalmgmtplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FinancialManualController {

    @RequestMapping("/FinancialManual")
    public String manualOne(int fid,int sid ) {
        String first = GetTrans(fid);
        String second = GetTrans(sid);
        String ret = "manual" + first + second;
        return ret;
    }

    private String GetTrans(int id){
        switch (id) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            default:
                return "Zero";
        }
    }
}
