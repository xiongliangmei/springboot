package com.runke.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/***
 * 有Model 写入 excel  单表头
 */
@Data
public class ExcelPropertyIndexModel extends BaseRowModel {
    @ExcelProperty(value = "姓名",index = 0)
    private String name; //姓名
    @ExcelProperty(value = "年龄",index = 1)
    private String age;//年龄
    @ExcelProperty(value = "邮箱",index = 2)
    private String email;//邮箱
    @ExcelProperty(value = "地址",index = 3)
    private String address; //地址
    @ExcelProperty(value = "性别",index = 4)
    private String sax;//性别
    @ExcelProperty(value = "高度",index=5)
    private String height;
    @ExcelProperty(value = "被准",index = 6)
    private String last;
}
