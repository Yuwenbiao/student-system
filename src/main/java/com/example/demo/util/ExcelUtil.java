package com.example.demo.util;

import com.example.demo.entity.Student;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * 解析Excel文件
 *
 * @author yuwb@corp.21cn.com
 * @date 19-3-5 下午3:27
 */
public class ExcelUtil {
    /**
     * 将数据集合写入到Excel中
     *
     * @param dataList 数据集合
     */
    public static void writeExcel(List<Student> dataList, String outFilePath) {
        try (FileOutputStream outputStream = new FileOutputStream(outFilePath)) {
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
            Sheet sheet = xssfWorkbook.createSheet();

            //将数据循环写入每一行
            for (int i = 0; i < dataList.size(); i++) {
                Row row = sheet.createRow(i);
                Student student = dataList.get(i);
                int cellIndex = 0;

                row.createCell(cellIndex++).setCellValue(String.valueOf(student.getNumber()));
                row.createCell(cellIndex++).setCellValue(String.valueOf(student.getName()));
                row.createCell(cellIndex++).setCellValue(String.valueOf(student.getSex()));
                row.createCell(cellIndex++).setCellValue(String.valueOf(student.getClassId()));
            }
            xssfWorkbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
