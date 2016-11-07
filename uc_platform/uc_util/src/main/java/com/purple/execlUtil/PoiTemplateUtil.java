package com.purple.execlUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class PoiTemplateUtil {
	@Test
	public void updateExecl() throws FileNotFoundException, IOException{
		InputStream out = null;
		PoiExcel2k3Helper poiExcelHelper=new PoiExcel2k3Helper();
		
		ArrayList<ArrayList<String>> readList= poiExcelHelper.readExcel("d:/KF16083114580219跨境付款付款明细文件.xls", 0,"3-");
		int row=0;
		int cell=readList.get(0).size()-2;
		for (int i = 0; i < readList.size(); i++) {
			if(readList.get(i).get(0).equals("846453123555")){
				row=i;
			}
		}
		@SuppressWarnings("resource")
		Workbook workbook = new HSSFWorkbook( new FileInputStream("d:/1.xls"));
		Sheet sheet=workbook.getSheetAt(0);
		sheet.getRow(row).getCell(cell).setCellValue("我是测试的");
		FileOutputStream os = new FileOutputStream("d:/2.xls");
		workbook.write(os);
		os.close();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		workbook.write(baos);
		baos.flush();
		baos.close();
		byte[] aa = baos.toByteArray();
		out=new ByteArrayInputStream(aa, 0, aa.length);
		System.out.println(out);
	}
	@Test
	public void createExeclTest(){
		ArrayList<ArrayList<String>>  data=new ArrayList<>();
		ArrayList<String> dataDetail=new ArrayList<>();
		dataDetail.add("5566845626");
		dataDetail.add("Juice");
		dataDetail.add("CHEMGUARD.INC 204 S.6th AvenueMsnsfield,Texas,USA ");
		dataDetail.add("HKD");
		dataDetail.add(" ");
		dataDetail.add(" ");
		dataDetail.add(" ");
		dataDetail.add("Payment for goods from International Trade Co.");
		dataDetail.add("314306100178");
		dataDetail.add("0");
		dataDetail.add("UPS");
		dataDetail.add("5566845626");
		data.add(dataDetail);
		PoiTemplateUtil poiTemplateUtil=new PoiTemplateUtil();
		
		poiTemplateUtil.createExeclResultInputStream("d:/1.xls","d:/2.xls", data);
	}
	public void createExecl(String TemplatefileName,String OutFileName,ArrayList<ArrayList<String>> data){
		try {
			InputStream in = new FileInputStream(TemplatefileName);
			Workbook workbook = createWorkbook(TemplatefileName,in);
			// 得到excel的第0张表
			Sheet sheet = workbook.getSheetAt(0);
			// 得到第1行的第一个单元格的样式
			Row rowCellStyle = sheet.getRow(2);
			CellStyle columnOne = rowCellStyle.getCell(0).getCellStyle();
			// 这里面的行和列的数法与计算机里的一样，从0开始是第一
			// 填充title数据
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(0);
			Cell cellBatchNo = row.getCell(1);
			cellBatchNo.setCellValue("11111111111111111111");// 填充值
			cell.setCellStyle(columnOne);// 填充样式
			int i = 2;//计数器
			// 得到行，并填充数据和表格样式		
			for (ArrayList<String> col : data) {
				row = sheet.createRow(i);// 得到行
				for(int j=0;j<col.size();j++){
					cell = row.createCell(j);// 得到第0个单元格
					cell.setCellValue(col.get(j));// 填充值
					cell.setCellStyle(columnOne);// 填充样式
				}
				i++;
			}
			// 合并单元格
			sheet.addMergedRegion(new CellRangeAddress(i,i,0,2));
			FileOutputStream os = new FileOutputStream(OutFileName);
			workbook.write(os);
			os.close();
		} catch (FileNotFoundException e) {
			System.out.println("文件路径错误");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("文件输入流错误");
			e.printStackTrace();
		}
	}
	public InputStream  createExeclResultInputStream(String TemplatefileName,String OutFileName,ArrayList<ArrayList<String>> data){
		InputStream out = null;
		try {
			InputStream in = new FileInputStream(TemplatefileName);
			Workbook workbook = createWorkbook(TemplatefileName,in);
			// 得到excel的第0张表
			Sheet sheet = workbook.getSheetAt(0);
			// 得到第1行的第一个单元格的样式
			Row rowCellStyle = sheet.getRow(2);
			CellStyle columnOne = rowCellStyle.getCell(0).getCellStyle();
			// 这里面的行和列的数法与计算机里的一样，从0开始是第一
			// 填充title数据
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(0);
			Cell cellBatchNo = row.getCell(1);
			cellBatchNo.setCellValue("11111111111111111111");// 填充值
			cell.setCellStyle(columnOne);// 填充样式
			int i = 2;//计数器
			// 得到行，并填充数据和表格样式		
			for (ArrayList<String> col : data) {
				row = sheet.createRow(i);// 得到行
				for(int j=0;j<col.size();j++){
					cell = row.createCell(j);// 得到第0个单元格
					cell.setCellValue(col.get(j));// 填充值
					cell.setCellStyle(columnOne);// 填充样式
				}
				i++;
			}
			// 合并单元格
			sheet.addMergedRegion(new CellRangeAddress(i,i,0,2));
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			workbook.write(baos);
			baos.flush();
			baos.close();
			byte[] aa = baos.toByteArray();
			out=new ByteArrayInputStream(aa, 0, aa.length);
		} catch (FileNotFoundException e) {
			System.out.println("文件路径错误");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("文件输入流错误");
			e.printStackTrace();
		}
		System.out.println(out);
		return out;
	}
	/**
	 * 校验execl版本
	 * @param filePath
	 * @param in
	 * @return
	 * @throws IOException
	 */
	private Workbook createWorkbook(String filePath,InputStream in) throws IOException {
		Workbook workbook;
		if (filePath.indexOf(".xlsx") != -1) {
			workbook = new XSSFWorkbook(in);
		} else {
			workbook = new HSSFWorkbook(in);
		}
		return workbook;
	}
}	
