package com.appsoft.systerm.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;


/**
 * 	 对象---直接导出(无需模板)
 * 注:如果模型 的父类的属性也有@Excel注解，那么导出excel时，会连该模型的父类的属性也一会儿导出
 * @author hurri
 *
 */
public class Test {

	public static void directExportExcelByObject() throws IOException {

		List<StudentVO> list = new ArrayList<>(16);

		StudentVO student;

		Random random = new Random();

		for (int i = 0; i < 10; i++) {

			student = new StudentVO(i + "",

					"name" + i,

					random.nextInt(2),

					random.nextInt(100),

					new Date(),

					"className" + i);

			student.setSchoolName("学校名称" + i);

			student.setSchoolAddress("学校地址" + i);

			list.add(student);

		}

		ExportParams exportParams = new ExportParams();

		exportParams.setSheetName("我是sheet名字");

		// 生成workbook 并导出

		Workbook workbook = ExcelExportUtil.exportExcel(exportParams, StudentVO.class, list);

		File savefile = new File("C:/Users/imhur/Desktop/");

		if (!savefile.exists()) {

			boolean result = savefile.mkdirs();

			System.out.println("目录不存在，创建" + result);

		}

		FileOutputStream fos = new FileOutputStream("C:/Users/imhur/Desktop/HRBZS/student.xls");

		workbook.write(fos);

		fos.close();

	}
	
	/**
	 * 生成Excel
	 * @param list  需要生成Excel的信息
	 * @param path  文件位置
	 * @throws IOException
	 */
	public static void directExportExcelByObject(ArrayList<HashMap<String,String>> list,String path) throws IOException {

		List<PojoVo> pojoList = new ArrayList<>(16);
		PojoVo vo;
		for (int i = 0; i < list.size(); i++) {
			HashMap<String,String> map = list.get(i);
			String code = (String) map.get("code");
			String url = (String) map.get("url");
			
			vo = new PojoVo();
			vo.setCode(code);
			vo.setUrl(url);
			pojoList.add(vo);
		}

		ExportParams exportParams = new ExportParams();

		exportParams.setSheetName("sheet1m");
		// 生成workbook 并导出
		Workbook workbook = ExcelExportUtil.exportBigExcel(exportParams, PojoVo.class, pojoList);
		ExcelExportUtil.closeExportBigExcel();

		File savefile = new File(path);
		 POIFSFileSystem poifsFileSystem=new POIFSFileSystem(savefile);
		if (!savefile.exists()) {
			boolean result = savefile.mkdirs();
			System.out.println("目录不存在，创建" + result);
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");

		FileOutputStream fos = new FileOutputStream(path+"B网合约地址"+ new Date().getTime() +".xlsx");
		workbook.write(fos);
		fos.close();
	}
	
	
	public static void main(String[] args) {
		try {
			directExportExcelByObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
