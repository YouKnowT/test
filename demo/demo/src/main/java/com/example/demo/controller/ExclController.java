package com.example.demo.controller;

import com.example.demo.entity.Competition;
import com.example.demo.service.CompetitionService;
import com.example.demo.util.ExclUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class ExclController {

    @Autowired
    private CompetitionService competitionServiceImp;
    /**
     * 导出报表
     * * @return
     */
    @RequestMapping("/export")
    @ResponseBody
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取数据
        List<Competition> list = competitionServiceImp.findAll();
        for (Competition c : list) {
            double a = c.getCoefficient() * 10;
            c.setGzl(c.getCardinal() * a);
        }
        // excel标题
        String[] title = {"学号", "姓名", "基数", "系数", "计算结果"};
        //excel文件名
        String fileName = "工作总量明细表" + System.currentTimeMillis() + ".xls";
        //sheet名
        String sheetName = "工作总量明细表";
        String[][] temp = new String[title.length][title.length];
        for (int i = 0; i < list.size(); i++) {
            Competition obj = list.get(i);
            temp[i][0] = String.valueOf(obj.getSuser_count());
            temp[i][1] = obj.getSname();
            //temp[i][2] = obj.getCategory();
            temp[i][2] = String.valueOf(obj.getCardinal());
            temp[i][3] = String.valueOf(obj.getCoefficient());
            temp[i][4] = String.valueOf(obj.getGzl());
        }
        //创建HSSFWorkbook
        HSSFWorkbook wb = ExclUtil.getHSSFWorkbook(sheetName, title, temp, null);
        //响应到客户端
        this.setResponseHeader(response, fileName);
        OutputStream os = response.getOutputStream();
        wb.write(os);
        os.flush();
        os.close();
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "utf-8");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

