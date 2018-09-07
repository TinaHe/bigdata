package com.insigma.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

public class ExcelUtil {

	//工作簿
	private HSSFWorkbook workbook;
	
	//工作表
	private HSSFSheet[] sheet;

	//行数
	private HSSFRow row;

	
	public ExcelUtil(){
	}	
	
	public HSSFWorkbook getWorkbook() {
		return workbook;
	}


	public void setWorkbook(HSSFWorkbook workbook) {
		this.workbook = workbook;
	}


	public HSSFSheet[] getSheet() {
		return sheet;
	}


	public void setSheet(HSSFSheet[] sheet) {
		this.sheet = sheet;
	}

	public HSSFRow getRow() {
		return row;
	}

	public void setRow(HSSFRow row) {
		this.row = row;
	}


	/**
     * 功能:创建工作簿
     */
    public void createWorkbook() {
    	HSSFWorkbook workbook = new HSSFWorkbook();
    	setWorkbook(workbook);
    }
    
    /**
     * 功能:创建工作表
     * @param sheetName表名
     */
    public void createSheet(String[] sheetName) {
    	//创建工作表数组
    	HSSFSheet[] sheetArray = new HSSFSheet[sheetName.length];
        for(int i=0;i<sheetName.length;i++){
        	// 生成工作表
            HSSFSheet sheet = this.workbook.createSheet(sheetName[i]);
            //插入工作表
            sheetArray[i]=sheet;
        }
        //工作表赋值
        setSheet(sheetArray);
    }
    
    /**
     * 功能:工作表基本格式
     * @param height单元格行高
     * @param width设置工作表默认列宽度
     * @param sheetIndex工作表序号
     * @param firstRow起始行号
     * @param lastRow终止行号
     * @param firstCol起始列号
     * @param lastCol终止列号
     * @param freezePane冻结前几行
     */
    public void createSheetStyle(int height,int width,int firstRow,int lastRow,int firstCol,int lastCol,int sheetIndex,int freezePane){
    	HSSFSheet sheet = this.sheet[sheetIndex];
    	//设置工作表单元格默认高度
        sheet.setDefaultRowHeight((short) height);
        //设置工作表默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) width);
        CellRangeAddress region = new CellRangeAddress(firstRow,lastRow,firstCol,lastCol);    //给定要合并的单元格范围
        //在工作表中合并首行并居中
        sheet.addMergedRegion(region);
        setBorderStyle(HSSFCellStyle.BORDER_THIN, region, sheet, this.workbook);
        //冻结前几行
        sheet.createFreezePane(0,freezePane,0,freezePane); 
    }
    
    /**
     * 功能:创建单元格样式
     * @param color样式颜色
     * @param fontName字体
     * @param fontSize字体大小
     * @param isBold字体加粗
     * @param isCenter是否居中
     * @param sheetIndex工作表序号
     * {@link VerticalAlignment#CENTER}
     */
    public HSSFCellStyle createStyle(short color,String fontName,short fontSize,boolean isBold,boolean isCenter,int sheetIndex) {
        HSSFCellStyle cellStyle=this.workbook.createCellStyle();
        HSSFFont font=this.workbook.createFont();
        font.setColor(color);
        font.setBold(isBold);
        font.setFontName(fontName);
        font.setFontHeightInPoints(fontSize);
        cellStyle.setFont(font);
        
        //设置单元格边框
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
        
        // 设置单元格的背景颜色（单元格的样式会覆盖列或行的样式）  
        cellStyle.setFillForegroundColor(HSSFColor.WHITE.index);  
        if(isCenter){
        	cellStyle.setAlignment(HorizontalAlignment.JUSTIFY);
        	cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中  
        	cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        }
        return cellStyle;
    }
    /**
     * 功能:添加表头标题说明
     * @param height单元格行高
     * @param headContent表头说明
     * @param sheetIndex工作表序号
     */
    public void createInstruction(HSSFCellStyle cellStyle,short height,String headContent,int sheetIndex) {
    	HSSFRow firstRow = this.sheet[sheetIndex].createRow(0);
        //设置行高
        firstRow.setHeight(height);
        HSSFCell title = firstRow.createCell(0);
        title.setCellValue(headContent);
        cellStyle.setWrapText(true);  //控制换行
        title.setCellStyle(cellStyle); //格式
    }
    
    /**
     * 功能:添加表头
     * @param height单元格行高 0为默认行高
     * @param titleContent插入内容
     * @param rows在第几行插入
     * @param sheetIndex工作表序号
     */
    public void createTitle(HSSFCellStyle cellStyle,short height,String[] titleContent,int rows,int sheetIndex) {
    	HSSFRow row = this.sheet[sheetIndex].createRow(rows);
        //设置行高
    	if(height!=0){
    		row.setHeight(height);
    	}
    	for(int i=0;i<titleContent.length;i++){
            HSSFCell title = row.createCell(i);
            title.setCellValue(titleContent[i]);
            title.setCellStyle(cellStyle); //格式
    	}
    }
    
    /**
     * 功能:添加部分内容
     * @param height单元格行高
     * @param headContent表头说明
     * @param sheetIndex工作表序号
     */
    public void createPart(HSSFCellStyle cellStyle,short height,String headContent,int sheetIndex) {
    	HSSFRow firstRow = this.sheet[sheetIndex].createRow(1);
        HSSFCell title = firstRow.createCell(0);
        title.setCellValue(headContent);
        //设置行高
    	if(height!=0){
    		firstRow.setHeight(height);
    	}
    	cellStyle.setWrapText(true);  //控制换行
    	title.setCellStyle(cellStyle); //格式
    }
    
    /**
     * 功能:单元格添加内容
     * @param row
     * @param rowsCount行数
     * @param cellCount列数
     * @param titleContent插入内容
     * @param sheetIndex工作表序号
     */
    public void createRowContent(HSSFCellStyle cellStyle,HSSFRow row,int rowsCount,int cellCount,String[] content,int sheetIndex) {
    	cellStyle.setWrapText(true);  //控制换行
    	for(int i=0;i<cellCount;i++){
    		HSSFCell cell =  row.createCell(i);
    		cell.setCellValue(content[i]); 
        	cell.setCellStyle(cellStyle); 
    	}

    }
    
    /**
     * 功能:单元格单独添加内容富文本格式
     * @param row
     * @param rowsCount行数
     * @param partFont部分字体
     * @param content内容
     * @param cellIndex列数
     * @param start部分文字开始部分
     * @param end部分文字结束部分
     * @param sheetIndex工作表序号
     * 
     */
    public void createSingleRowContent(HSSFCellStyle cellStyle,HSSFRow row,int rowsCount,HSSFFont partFont,String content,int cellIndex,int start,int end,int sheetIndex) {
    	HSSFRichTextString richText = new HSSFRichTextString(content);
    	richText.applyFont(start, end, partFont);
    	HSSFCell cell = row.createCell(cellIndex);
    	cell.setCellValue(richText);
    	cell.setCellStyle(cellStyle); 
    }
    
    public void setBorderStyle(int border, CellRangeAddress region, HSSFSheet sheet, HSSFWorkbook wb){
        RegionUtil.setBorderBottom(border, region, sheet, wb);   //下边框
        RegionUtil.setBorderLeft(border, region, sheet, wb);     //左边框
        RegionUtil.setBorderRight(border, region, sheet, wb);    //右边框
        RegionUtil.setBorderTop(border, region, sheet, wb);      //上边框
    }
}
