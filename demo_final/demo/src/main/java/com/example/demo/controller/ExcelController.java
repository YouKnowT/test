package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.Competition;
import com.example.demo.service.CategoryService;
import com.example.demo.service.CompetitionService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.util.ExcelUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/export")
public class ExcelController {
    @Autowired
    private CompetitionService competitionServiceImp;
    @Autowired
    private CategoryService categoryServiceImpl;

    /**
     * 导出报表
     * * @return
     */
    @ResponseBody
    @GetMapping(value = "/exportExcel")
    public void export( HttpServletResponse response) throws Exception {
        //获取数据
        List<Competition> list = competitionServiceImp.findAll();
        List<Category> list1 = categoryServiceImpl.findAll();

        for(Category ca : list1){
            double a = ca.getCardinalNumber() * 10;
            ca.setGzl(ca.getBase() * a);
        }

        // excel标题
        String[] title = {"ID", "比赛名称", "比赛类型", "系数","基数", "工作量"};
        //excel文件名
        String fileName = "工作总量明细表" + System.currentTimeMillis() + ".xls";
        //sheet名
        String sheetName = "工作总量明细表";
        String[][] temp = new String[title.length][title.length];

        for (int i = 0; i < list.size(); i++) {
            Competition obj = list.get(i);
            Category cat = list1.get(i);

            temp[i][0] = String.valueOf(obj.getId());
            temp[i][1] = obj.getName();
            temp[i][2] = obj.getCategory();
            temp[i][3] = String.valueOf(cat.getCardinalNumber());
            temp[i][4] = String.valueOf(cat.getBase());
            temp[i][5] = String.valueOf(cat.getGzl());
        }
        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, temp, null);
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

