package com.ga.capitalmgmtplatform.controller;

import com.ga.capitalmgmtplatform.pojo.AccountBalanceInfo;
import com.ga.capitalmgmtplatform.pojo.AccountDetail;
import com.ga.capitalmgmtplatform.pojo.User;
import com.ga.capitalmgmtplatform.pojo.AccountInfo;
import com.ga.capitalmgmtplatform.service.AccountDetailService;
import com.ga.capitalmgmtplatform.service.AccountService;
import com.ga.capitalmgmtplatform.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private AccountService accService;

    @Autowired
    private AccountDetailService accDetailService;

    @Autowired
    private UserService usrService;

    @RequestMapping("/index")
    public String Index(Model model) {
        String name = SecurityUtils.getSubject().getPrincipal().toString();
        //获取当前用户信息
        User u = usrService.getByName(name);
        //获取当前用户的id
        Long id = u.getId();
        List<AccountBalanceInfo> listBalance = accDetailService.getBalanceDetailsByUserId(id);
        BigDecimal total = BigDecimal.ZERO;
        DecimalFormat df = new DecimalFormat("###,##0.000");
        for (AccountBalanceInfo info : listBalance) {
            if (info.getBalance() != null) {
                total = total.add(info.getDecimalBalance());
            }
        }
        model.addAttribute("listBalance", listBalance);
        model.addAttribute("u", name);
        model.addAttribute("balance", df.format(total));
        return "index";
    }

    @RequestMapping("/CapitalBudgetQuery")
    public String BudgetQuery(Model m){
        return "capitalBudgetDetailQuery";
    }

    @RequestMapping("/CapitalBudgetInput")
    public String BudgetInput(Model m){
        return "capitalBudgetInput";
    }

    @RequestMapping("/CapitalBudgetTotalQuery")
    public String BudgetTotalQuery(Model m){
        return "capitalBudgetTotalQuery";
    }

    @RequestMapping("/CapitalDetailQuery")
    public String CapitalDetailQuery(Model m,String acc) {
        //获取当前用户名
        String name = SecurityUtils.getSubject().getPrincipal().toString();
        //获取当前用户信息
        User u = usrService.getByName(name);
        //获取当前用户的主体
        Long id = u.getId();
        //获取当前用户操作的账户信息
        List<AccountInfo> usracc = accService.GetAccountInfoById(id);
        m.addAttribute("liAcc", usracc);
        m.addAttribute("u", name);
        if(acc!=""){
            List<AccountDetail> details=accDetailService.getDetailsByDateAndAccnum("",acc);
            m.addAttribute("liDetail",details);
        }
        return "capitalDetailQuery";
    }

    @RequestMapping("/CapitalDetailInput")
    public String CapitalDetailInput(Model m) {
        //获取当前用户名
        String name = SecurityUtils.getSubject().getPrincipal().toString();
        //获取当前用户信息
        User u = usrService.getByName(name);
        //获取当前用户的主体
        String depart = u.getDepart();
        Long id = u.getId();
        //获取当前用户操作的账户信息
        List<AccountInfo> usracc = accService.GetAccountInfoById(id);
        m.addAttribute("liAcc", usracc);
        m.addAttribute("u", name);
        return "capitalDetailInput";
    }

    @RequestMapping("/CapitalDetailTotalQuery")
    public String CapitalDetailTotalQuery(Model m){
        //获取当前用户名
        String name = SecurityUtils.getSubject().getPrincipal().toString();
        //获取当前用户信息
        User u = usrService.getByName(name);
        //获取当前用户的主体
        Long id = u.getId();
        //获取当前用户操作的账户信息
        List<AccountInfo> usracc = accService.GetAccountInfoById(id);
        m.addAttribute("liAcc", usracc);
        m.addAttribute("u",name);

        return "capitalDetailTotalQuery";
    }

    @RequestMapping("unauthorized")
    public String noPerms() {
        return "403";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String FirstPage(Model m) throws Exception {
        return "login";
    }
}
