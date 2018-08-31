package com.ga.capitalmgmtplatform.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;

@Controller
public class FinancialManualController {

    @RequestMapping("/FinancialManual")
    public String manualOne(int fid, int sid) {
        String first = GetTrans(fid);
        String second = GetTrans(sid);
        String ret = "manual" + first + second;
        return ret;
    }

    private String GetTrans(int id) {
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

    @RequestMapping("/Download/Template")
    public ResponseEntity<byte[]> downloadTemplate(HttpServletRequest request,
                                                   Model model) throws Exception {
        String name = "template.xlsx";
        ClassPathResource classPathResource = new ClassPathResource("/static/file/" + name);
        String filename = classPathResource.getFilename();
        InputStream inputStream = classPathResource.getInputStream();
        byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文名称乱码问题
        String downloadFielName = new String(filename.getBytes("UTF-8"), "iso-8859-1");
        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFielName);
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.CREATED);
    }
}
