package com.appsoft.systerm.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * poi文件操作工具类
 * @author hurri
 * @date 2019年4月11日
 */
public class PoiUtil {

	public static void writeExcel(ArrayList<HashMap<String, String>> mapList, String path, String fileName, int maxRows)
			throws Exception {

		System.out.println("开始生成Excel---------------------");
		boolean flag = fileExists(new File(path + fileName));
		if (flag) {
			FileInputStream fileInputStream = new FileInputStream(path + fileName); // 获取excel,建立数据的输入通道

			POIFSFileSystem poifsFileSystem = new POIFSFileSystem(fileInputStream); // 使用POI提供的方法得到excel的信息

			HSSFWorkbook Workbook = new HSSFWorkbook(poifsFileSystem);// 得到文档对象
			
			HSSFSheet sheet = Workbook.getSheet("Sheet0"); // 根据name获取sheet表
			int lastRowNum = sheet.getLastRowNum();
			if (lastRowNum <= maxRows) {
				addDataToExcel(mapList, path,fileName);
			} else {
				String lastFileName = getFileList(path);
				lastFileName = lastFileName.replace(".xls", "");
				String[] split = lastFileName.split("B网合约地址");
				int arr = Integer.parseInt(split[1]);
				split[1] = arr+1+"";
				String newFileName = split[0] +"B网合约地址"+ split[1] +".xls";
				createExcel(mapList, path,newFileName);
			}
			if(Workbook!=null) {
				Workbook.close();
			}
			if(poifsFileSystem!=null) {
				poifsFileSystem.close();
			}
			if(fileInputStream!=null) {
				fileInputStream.close();
			}
			
		} else {
			createExcel(mapList, path,fileName);
		}
		
		
		System.out.println("Excel生成完毕！");

	}

	public static void createExcel(ArrayList<HashMap<String, String>> mapList, String path, String fileName)
			throws Exception {
		// 1.在内存中创建一个excel文件
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		// 2.创建工作簿
		HSSFSheet sheet = hssfWorkbook.createSheet();
		HSSFCellStyle setBorder = hssfWorkbook.createCellStyle();
		
		setBorder.setBorderBottom(HSSFCellStyle.ALIGN_GENERAL); //下边框
		setBorder.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
		setBorder.setBorderTop(HSSFCellStyle.BORDER_MEDIUM_DASHED); //上边框
		setBorder.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
		HSSFFont font = hssfWorkbook.createFont();
		font.setFontName("黑体");
		font.setFontHeightInPoints((short) 16);//设置字体大小
		setBorder.setFont(font);//选择需要用到的字体格式
		sheet.setColumnWidth(0, 25000); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(1, 25000); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		// 3.创建标题行
		HSSFRow titlerRow = sheet.createRow(0);
		titlerRow.createCell(0).setCellValue("url");
		titlerRow.createCell(1).setCellValue("address");

		// 4.遍历数据,创建数据行
		for (int i = 0; i < mapList.size(); i++) {
			HashMap<String, String> map = mapList.get(i);
			String code = map.get("address");
			String url = map.get("url");
			int lastRowNum = sheet.getLastRowNum();
			HSSFRow dataRow = sheet.createRow(lastRowNum + 1);
			dataRow.createCell(0).setCellValue(url);
			dataRow.createCell(1).setCellValue(code);
		}

		FileOutputStream fos = new FileOutputStream(path + fileName);

		// 10.写出文件,关闭流
		hssfWorkbook.write(fos);
		hssfWorkbook.close();
		fos.close();
	}

	public static void addDataToExcel(ArrayList<HashMap<String, String>> mapList, String path, String fileName)
			throws Exception {

		FileInputStream fileInputStream = new FileInputStream(path + fileName); // 获取excel,建立数据的输入通道

		POIFSFileSystem poifsFileSystem = new POIFSFileSystem(fileInputStream); // 使用POI提供的方法得到excel的信息

		HSSFWorkbook Workbook = new HSSFWorkbook(poifsFileSystem);// 得到文档对象

		HSSFSheet sheet = Workbook.getSheet("Sheet0"); // 根据name获取sheet表

		HSSFRow row = sheet.getRow(0); // 获取第一行

		FileOutputStream out = new FileOutputStream(path + fileName); // 向excel中写数据
		for (int i = 0; i < mapList.size(); i++) {
			row = sheet.createRow((short) (sheet.getLastRowNum() + 1)); // 对总行数减4，就是倒数行数加数据
			HashMap<String, String> map = mapList.get(i);
			String code = map.get("address");
			String url = map.get("url");

			row.createCell(0).setCellValue(url);
			row.createCell(1).setCellValue(code);

		}
		out.flush();
		Workbook.write(out);
		out.close();
	}

	// 判断文件是否存在
	public static boolean fileExists(File file) {

		if (file.exists()) {
			return true;
		} else {
			return false;
		}

	}

	// 判断文件夹是否存在
	public static void dirExists(File file) {

		if (file.exists()) {
			if (file.isDirectory()) {
				System.out.println("dir exists");
			} else {
				System.out.println("the same name file exists, can not create dir");
			}
		} else {
			System.out.println("dir not exists, create it ...");
			file.mkdir();
		}

	}

	public static String getFileList(String strPath) throws IOException {
		String fileName = "";
		File dir = new File(strPath);
		File[] files = dir.listFiles(); //该文件目录下文件全部放入数组
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				String fileNameStr = files[i].getName();
				if (files[i].isDirectory()) { // 判断是文件还是文件夹
					getFileList(files[i].getAbsolutePath()); // 获取文件绝对路径
				} else if (fileNameStr.endsWith(".xls")) { // 判断文件名是否以.avi结尾
					fileName = files[i].getName();
				}else {
					fileName = "";
					continue;
				}
			}
		}else {
			
		}
		return fileName;
	}

}
