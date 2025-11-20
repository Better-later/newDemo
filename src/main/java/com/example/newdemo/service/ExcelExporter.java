package com.example.newdemo.service;

import com.example.newdemo.bean.MyEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ExcelExporter {

    public static void exportToExcel(List<MyEntity> entities, String filePath) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Entities");

        // 创建数值格式样式
        DataFormat dataFormat = workbook.createDataFormat();
        CellStyle numberCellStyle = workbook.createCellStyle();
        numberCellStyle.setDataFormat(dataFormat.getFormat("0.00")); // 数值格式，保留两位小数

        // 创建表头
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Amount");

        int rowNum = 1;
        for (MyEntity entity : entities) {
            Row row = sheet.createRow(rowNum++);

            // ID - int 类型，设置为数值格式
            Cell idCell = row.createCell(0);
            idCell.setCellValue(entity.getId());
            idCell.setCellStyle(numberCellStyle);

            // Name - String 类型，POI 默认即为文本格式
            row.createCell(1).setCellValue(entity.getName());

            // Amount - BigDecimal 类型，设置为数值格式
            Cell amountCell = row.createCell(2);
            amountCell.setCellValue(entity.getAmount().doubleValue());
            amountCell.setCellStyle(numberCellStyle);
        }

        // 自动调整列宽
        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {
        // 创建一些示例数据
        List<MyEntity> entities = new ArrayList<>();
        entities.add(new MyEntity(1, "lisi", new BigDecimal("100321321321321.5")));
        entities.add(new MyEntity(2, "lisi",new BigDecimal("20032131321321321321.75")));
        entities.add(new MyEntity(3, "lisi",new BigDecimal("300.25")));
        entities.add(new MyEntity(4, "lisi",new BigDecimal("400.5")));

        // 导出到Excel
        exportToExcel(entities, "entities.xlsx");
    }
}
