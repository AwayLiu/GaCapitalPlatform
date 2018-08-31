package com.ga.capitalmgmtplatform.controller;

import com.ga.capitalmgmtplatform.dtdao.AccDetailDtDao;
import com.ga.capitalmgmtplatform.pojo.AccountDetail;
import com.ga.capitalmgmtplatform.service.AccountDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class CapitalController {

    @Autowired
    private AccountDetailService detailService;

    @RequestMapping(value = "/CapitalDetail", method = RequestMethod.POST)
    @ResponseBody
    public String AddDetails(HttpServletResponse response, @RequestBody AccDetailDtDao[] details) throws Exception {
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        AccDetailDtDao first=details[0];
        AccountDetail last=detailService.getLastDetailByAccnum(first.getAccNum());
        if(last!=null){
            if(format1.parse(last.getTransDate()).compareTo(format1.parse(first.getTransDate()))>0){
                return "导入失败,您当前导入记录的交易时间早于已有记录的交易时间,请修改后再次尝试导入!";
            }

            BigDecimal nowBalance=new BigDecimal(first.getBalance());
            BigDecimal nowCredit=new BigDecimal(first.getCreditAmount());
            BigDecimal nowDebit=new BigDecimal(first.getDebitAmount());

            if ((last.getBalance().add(nowCredit).subtract(nowDebit)) != nowBalance) {
                return "导入失败,您当前导入的记录与后台已有记录之间存在缺失,请补充后再次尝试导入!";
            }
        }

        List<AccountDetail> list = new ArrayList<>();
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

    @RequestMapping(value = "/CapitalDetail", method = RequestMethod.GET)
    public @ResponseBody
    List<AccountDetail> QueryDetails(HttpServletRequest request) throws Exception {
        List<AccountDetail> list = new ArrayList<>();
        String date = request.getParameter("date");
        String accnum = request.getParameter("accnum");

        if (date != "") {
            SimpleDateFormat format1 = new SimpleDateFormat("MM-dd-yyyy");
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = format1.parse(date);
            date = format2.format(date1);
        }
        list = detailService.getDetailsByDateAndAccnum(date, accnum);

        return list;
    }

    @RequestMapping(value = "/CapitalDetails", method = RequestMethod.GET)
    public @ResponseBody
    List<AccountDetail> TotalQueryDetails(HttpServletRequest request) throws Exception {
        List<AccountDetail> list = new ArrayList<>();
        String dtFrom = request.getParameter("dtFrom");
        String dtTo = request.getParameter("dtTo");
        String accnum = request.getParameter("accnum");

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
