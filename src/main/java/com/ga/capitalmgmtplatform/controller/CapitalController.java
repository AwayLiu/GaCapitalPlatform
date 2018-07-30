package com.ga.capitalmgmtplatform.controller;

import com.ga.capitalmgmtplatform.dtdao.AccDetailDtDao;
import com.ga.capitalmgmtplatform.pojo.AccountDetail;
import com.ga.capitalmgmtplatform.service.AccountDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class CapitalController {

    @Autowired
    private AccountDetailService detailService;

    @RequestMapping("/DetailInput/AddDetails")
    @ResponseBody
    public String AddDetails(HttpServletResponse response, @RequestBody AccDetailDtDao[] details) throws Exception {
        List<AccountDetail> list=new ArrayList<>();
        DecimalFormat df = new DecimalFormat("###,###.00");
        for (AccDetailDtDao detail : details) {
            AccountDetail tmp = new AccountDetail();
            tmp.setAccNum(detail.getAccNum());
            tmp.setBalanceDepart(detail.getBalanceDepart());
            tmp.setTransDate(detail.getTransDate());
            tmp.setDebitAmount(detail.getDebitAmount().trim().length() == 0 ? BigDecimal.valueOf(0) : new BigDecimal(df.parse(detail.getDebitAmount().trim()).doubleValue()));
            tmp.setCreditAmount(detail.getCreditAmount().trim().length() == 0 ? BigDecimal.valueOf(0) : new BigDecimal(df.parse(detail.getCreditAmount().trim()).doubleValue()));
            tmp.setBalance(detail.getBalance().trim().length() == 0 ? BigDecimal.valueOf(0) : new BigDecimal(df.parse(detail.getBalance().trim()).doubleValue()));
            tmp.setReciprocalAccount(detail.getReciprocalAccount());
            tmp.setReciprocalName(detail.getReciprocalName());
            tmp.setOutOrIn(detail.getOutOrIn() == "是" ? "1" : "0");
            tmp.setIsCash(detail.getIsCash() == "是" ? "1" : "0");
            tmp.setTradeSummary(detail.getTradeSummary());
            tmp.setSummary(detail.getSummary());
            tmp.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            tmp.setCreateUser(detail.getCreateUser());

            list.add(tmp);
        }
        detailService.add(list);
        return "导入成功";
    }

    @RequestMapping(value = "/DetailQuery/QueryDetails",method = RequestMethod.POST)
    public @ResponseBody List<AccountDetail>  QueryDetails(@RequestBody Map<String,String> map) throws Exception {
        List<AccountDetail> list = new ArrayList<>();
        String date = map.get("date");
        String accnum = map.get("accnum");

        if(date!="") {
            SimpleDateFormat format1 = new SimpleDateFormat("MM-dd-yyyy");
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = format1.parse(date);
            date = format2.format(date1);
        }
        list = detailService.getDetailsByDateAndAccnum(date, accnum);

        return list;
    }

    @RequestMapping(value = "/DetailQuery/TotalQueryDetails",method = RequestMethod.POST)
    public @ResponseBody List<AccountDetail> TotalQueryDetails(@RequestBody Map<String,String> map) throws Exception {
        List<AccountDetail> list = new ArrayList<>();
        String dtFrom = map.get("dtFrom");
        String dtTo = map.get("dtTo");
        String accnum = map.get("accnum");

        SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        Date dateF1 = format1.parse(dtFrom);
        dtFrom = format2.format(dateF1);
        Date dateT1 = format1.parse(dtTo);
        dtTo = format2.format(dateT1);

        list = detailService.getDetailsByDatesAndAccnum(dtFrom, dtTo, accnum);

        return list;
    }
}
