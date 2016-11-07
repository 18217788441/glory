package com.pay.execlUtil;

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

@SuppressWarnings("resource")
public class PoiTemplateUtil {
	public InputStream createExeclResultInputStreamByFile(InputStream in, String batchNo, ArrayList<ArrayList<String>> data)
			throws IOException {
		InputStream out = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
		
			Workbook workbook = new HSSFWorkbook(in);
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
			int i =2;// 计数器
			// 得到行，并填充数据和表格样式
			for (ArrayList<String> col : data) {
				row = sheet.createRow(i);// 得到行
				for (int j = 0; j < col.size(); j++) {
					cell = row.createCell(j);// 得到第0个单元格
					cell.setCellValue(col.get(j));// 填充值
					cell.setCellStyle(columnOne);// 填充样式
				}
				i++;
			}
			// 合并单元格
			FileOutputStream os = new FileOutputStream("d:/test.xls");
			workbook.write(os);
			os.close();
		} finally {
			baos.close();
		}
		return out;
	}

	public InputStream createExeclResultInputStream(InputStream in, String batchNo, ArrayList<ArrayList<String>> data)
			throws IOException {
		InputStream out = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			Workbook workbook = new HSSFWorkbook(in);
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
			cellBatchNo.setCellValue(batchNo);// 设置业务批次号
			cell.setCellStyle(columnOne);// 填充样式
			int i = 2;// 计数器
			// 得到行，并填充数据和表格样式
			for (ArrayList<String> col : data) {
				row = sheet.createRow(i);// 得到行
				for (int j = 0; j < col.size(); j++) {
					cell = row.createCell(j);// 得到第0个单元格
					cell.setCellValue(col.get(j));// 填充值
					cell.setCellStyle(columnOne);// 填充样式
				}
				i++;
			}
			// 合并单元格
			sheet.addMergedRegion(new CellRangeAddress(i, i, 0, 2));
			workbook.write(baos);
			baos.flush();
			byte[] aa = baos.toByteArray();
			out = new ByteArrayInputStream(aa, 0, aa.length);
		} finally {
			baos.close();
			out.close();
		}
		return out;
	}

	public void createExecl(String TemplatefileName, String OutFileName, ArrayList<ArrayList<String>> data) {
		try {
			InputStream in = new FileInputStream(TemplatefileName);
			Workbook workbook = createWorkbook(TemplatefileName, in);
			// 得到excel的第0张表
			Sheet sheet = workbook.getSheetAt(0);
			// 得到第1行的第一个单元格的样式
			Row rowCellStyle = sheet.getRow(1);
			CellStyle columnOne = rowCellStyle.getCell(0).getCellStyle();
			// 这里面的行和列的数法与计算机里的一样，从0开始是第一
			// 填充title数据
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(0);
			int i = 2;// 计数器
			int number = 0;
			// 得到行，并填充数据和表格样式
			for (ArrayList<String> col : data) {
				row = sheet.createRow(i);// 得到行
				for (int j = 0; j < col.size(); j++) {
					cell = row.createCell(j);// 得到第0个单元格
					cell.setCellValue(col.get(j));// 填充值
					cell.setCellStyle(columnOne);// 填充样式
				}
				i++;
				number++;
			}
			// 创建每个单元格，添加样式，最后合并
			row = sheet.createRow(i);
			cell = row.createCell(0);
			cell.setCellValue("总计：" + number + "个学生");// 填充值
			cell.setCellStyle(columnOne);
			cell = row.createCell(1);
			cell.setCellStyle(columnOne);
			cell = row.createCell(2);
			cell.setCellStyle(columnOne);
			// 合并单元格
			sheet.addMergedRegion(new CellRangeAddress(i, i, 0, 2));
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

	/**
	 * 校验execl版本
	 * 
	 * @param filePath
	 * @param in
	 * @return
	 * @throws IOException
	 */
	private Workbook createWorkbook(String filePath, InputStream in) throws IOException {
		Workbook workbook;
		if (filePath.indexOf(".xlsx") != -1) {
			workbook = new XSSFWorkbook(in);
		} else {
			workbook = new HSSFWorkbook(in);
		}
		return workbook;
	}
}
