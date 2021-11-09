package com.example.datagriptoolsdesign.demo;


import com.example.datagriptoolsdesign.bean.TraceBean;
import com.example.datagriptoolsdesign.servesutils.DataGripServesutils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class Data_Processing{
    private ArrayList<Map<String, String>> logs;
    private ArrayList<Map<String, String>> maps;

//    // 自动装配映射器
//    @Autowired
//    private DataGripServesutils dataGripServes;

    public void init(String FilePath) throws Exception {
        /* *
         *   读取Excel中数据
         *
         * */
        // 存储每一格数据

        File file = new File(FilePath);
        if (!file.exists()) {
            throw new Exception("该文件不存在");
        }
        InputStream in = new FileInputStream(file);
//    读取整个EXCEL文件
        XSSFWorkbook sheets = new XSSFWorkbook(in);
//     读取EXCEL文件的第一个表单
        XSSFSheet sheetAt = sheets.getSheetAt(0);
        ArrayList<Map<String, String>> list = new ArrayList<>();

        // 默认第一行为标题行
        // 获取标题行
        XSSFRow titleRow = sheetAt.getRow(0);
        // 循环获取每一行的数据
        for (int i = 1; i < sheetAt.getPhysicalNumberOfRows(); i++) {
            XSSFRow row = sheetAt.getRow(i);
            // 读取每一列数据
            LinkedHashMap<String, String> map = new LinkedHashMap<>();
            for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                XSSFCell titleCell = titleRow.getCell(j);
                XSSFCell cell = row.getCell(j);
                if (cell != null)
                    cell.setCellType(CellType.STRING);
                else
                    continue;
                if (cell.getStringCellValue().equals("")) {
                    continue;
                }
                map.put(getString(titleCell), getString(cell));
            }
            if (map.isEmpty()) {
                continue;
            }
            list.add(map);
        }
        this.maps = list;
    }

    public String getString(XSSFCell cell) {
        if (cell == null)
            return "";
        if (cell.getCellType() == CellType.NUMERIC)
            return String.valueOf(cell.getNumericCellValue());
        else {
            return cell.getStringCellValue();
        }
    }

    public void processing(){
        try {
            List<Map<String, String>> maps = this.maps;
//            maps.forEach(System.out::println);
            // 获取数据后对数据进行处理:    1. 去重   2. 补缺(或删除缺省数据,假如缺少的书location和身份证, 若缺少的是名字但是身份证不缺少则设置为无名氏)
            // 去重
            ArrayList<Map<String, String>> logs = new ArrayList<>();
            for (Map<String, String> map : maps) {
                if (!logs.contains(map))
                    // 假如logs中没有map则假如,否则不加入,从而达到去重的效果
                    logs.add(map);
            }
//            logs.forEach(System.out::println);
//            System.out.println(logs.size());
//            System.out.println(maps.size());
            // 完成去重后,检查map中location id两项是否为空,若为空则移除
            ArrayList<Map<String, String>> logs2 = new ArrayList<>();
            logs.forEach((log) -> {
//                System.out.println(log);
//                System.out.println(log.get("id"));
                if (!(log.get("location") == null || log.get("id") == null)) {
                    logs2.add(log);
                }
            });
//            logs2.forEach(System.out::println);
            System.out.println(logs2.size());
            // 假如名字为空则补充为未留名
            String enter_time = "";
            logs2.forEach(map -> {
                map.putIfAbsent("Name", "未留名");
            });
            // 假如时间为空则用前一位的时间进行补充
            for (Map<String, String> map : maps){
                if (map.get("enter time") != null){
                    String get = map.get("enter time");
                    if (get != null){
                        enter_time = get;
                    }
                }else{
                    map.put("enter time", enter_time);
                }
            }
            this.logs = logs2;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public ArrayList<TraceBean> upload(){
        ArrayList<Map<String, String>> logs = this.logs;
        ArrayList<TraceBean> traceBeans = new ArrayList<>();
        logs.forEach(map->{
            TraceBean  temp = new TraceBean(map.get("location"), map.get("enter time"), map.get("Name"), map.get("Phone"), map.get("id"));
            System.out.println(temp);
            traceBeans.add(temp);
        });
        return traceBeans;
    }

    public ArrayList<Map<String, String>> getLogs() {
        return logs;
    }

    public static void main(String[] args) {
        Data_Processing data_processing = new Data_Processing();
        try {

            data_processing.init("D:\\Study\\Study in MUC\\DataGripToolsDesign\\src\\main\\resources\\进入登记.xlsx");
            data_processing.processing();
//            data_processing.logs.forEach(System.out::println);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

