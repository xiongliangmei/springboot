package com.runke.excel;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.metadata.TableStyle;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.runke.SpringBootEasyexcelApplicationTests;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelWriteTest extends SpringBootEasyexcelApplicationTests {
    /***
     *  写入 无标题的表格
     * @throws Exception
     */
    @Test
    public  void writeWithoutHeader() throws Exception{
        OutputStream out = new FileOutputStream("./withoutHead.xlsx");
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX,false);//无表头

        Sheet sheet1  = new Sheet(1,0);
        sheet1.setSheetName("sheet1");
        List<List<String>> data = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            List<String> item = new ArrayList<>();
            item.add("item0" + i);
            item.add("item1" + i);
            item.add("item2" + i);
            data.add(item);
        }
        writer.write0(data,sheet1);
        writer.finish();
    }

    @Test
    public void writeWithHead() throws Exception{
        OutputStream out = new FileOutputStream("./writeWithHead1.xlsx");
        ExcelWriter writer = new ExcelWriter(out,ExcelTypeEnum.XLSX);
        Sheet sheet1 = new Sheet(1,0);
        sheet1.setSheetName("sheet1");
        List<List<String>> data = new ArrayList<>();
        for (int i = 0; i < 100 ; i++) {
            List<String> item = new ArrayList<>();
            item.add("item0" + i );
            item.add("item1" + i);
            item.add("item2" + i);
            data.add(item);
        }
        List<List<String>> head = new ArrayList<>();
        List<String> headCoulumn1 = new ArrayList<>();
        List<String> headCoulumn2 = new ArrayList<>();
        List<String> headCoulumn3 = new ArrayList<>();

        headCoulumn1.add("第一列");
        headCoulumn2.add("第二列");
        headCoulumn3.add("第三列");

        head.add(headCoulumn1);
        head.add(headCoulumn2);
        head.add(headCoulumn3);

        Table table = new Table(1);
        table.setHead(head);
        writer.write0(data,sheet1,table);
        writer.finish();

    }
    /***
     * 有model 写入excel
     */
    @Test
    public void writeWithHead2() throws Exception{
        OutputStream out = new FileOutputStream("withHead.xlsx");
        ExcelWriter writer = new ExcelWriter(out,ExcelTypeEnum.XLSX);
        Sheet sheet = new Sheet(1,0,ExcelPropertyIndexModel.class);

        List<ExcelPropertyIndexModel> data = new ArrayList<>();
        for (int i = 0; i < 100 ; i++) {
            ExcelPropertyIndexModel item = new ExcelPropertyIndexModel();
            item.setName("name"+i);
            item.setAddress("四川成都市");
            item.setAge("22");
            item.setHeight("170");
            item.setSax("男");
            item.setLast("last"+ i);
            data.add(item);
        }

        writer.write(data,sheet);
        writer.finish();
    }

    //多行复杂的表头
    @Test
    public void test2() throws Exception{

        OutputStream out = new FileOutputStream("./withHead.xlsx");
        ExcelWriter writer = new ExcelWriter(out,ExcelTypeEnum.XLSX); //包装类

        Sheet sheet = new Sheet(1,0,MultiLineHeadExcelModel.class);
        sheet.setSheetName("sheet1");
        TableStyle tableStyle =  new TableStyle(); //设置excel 样式颜色
        tableStyle.setTableHeadBackGroundColor(IndexedColors.BLUE);
        tableStyle.setTableContentBackGroundColor(IndexedColors.DARK_RED);
        sheet.setTableStyle(tableStyle);
        List<MultiLineHeadExcelModel> data = new ArrayList<>();

        for (int i = 0; i < 100 ; i++) {
            MultiLineHeadExcelModel item = new MultiLineHeadExcelModel();
            item.setP1("p1"+i);
            item.setP2("p2"+i);
            item.setP3("p3"+i);
            item.setP4("p4"+i);
            item.setP5("p5"+i);
            item.setP6("p6"+i);
            item.setP7("p7"+i);
            item.setP8("p8"+i);
            item.setP9("p9"+i);
            data.add(item);
        }
        writer.write(data,sheet);
        writer.finish();
    }
}
