package com.shop.ssmo2oshop.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random r = new Random();
	private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);
	
	public static File transferCommsMultipartFileToFile(CommonsMultipartFile cFile) {
		//将CommonsMultipartFile转换成File类
		File newFile = new File(cFile.getOriginalFilename());
		try {
			cFile.transferTo(newFile);
		} catch (IllegalStateException e) {
			logger.error(e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return newFile;
	}
	
	//处理缩略图 并返回新生成图片的相对路径
	public static String generateThumbnail(File thumbnail, String targetAddr) {
		String realFileName = getRandomFileName();
		String extension = getFileExtension(thumbnail);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		logger.debug("Current relative address is:" + relativeAddr);
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		logger.debug("Current complete address is:" + PathUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnail).size(200, 200).watermark(Positions.BOTTOM_RIGHT, 
					ImageIO.read(new File(basePath+"/watermark.jpg")), 0.25f)
			.outputQuality(0.8).toFile(dest);
		}
		catch(IOException e){
			logger.error(e.toString());
			e.printStackTrace();
		}
		return relativeAddr;
	}
	
	private static void makeDirPath(String targetAddr) {
		//创建目标路径所涉及到的目录 即/home/ssmo2oshop/image/xxx.jpg
		//home ssmo2oshop image这三个目录都要自动创建出来
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if(!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}

	private static String getFileExtension(File cFile) {
		//获取输入文件流的扩展名 .jpg/.png
		String originalFileName = cFile.getName();
		
		return originalFileName.substring(originalFileName.lastIndexOf("."));
	}

	//生成随机文件名 当前年月日小时分钟秒钟+五位随机数
	public static String getRandomFileName() {
		//获取随机的五位数 10000~99999
		int rannum = r.nextInt(89999) + 10000;
		String nowTimeStr = sDateFormat.format(new Date());
		return nowTimeStr + rannum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Thumbnails.of(new File("G:\\xiaohuangren.jpg")).size(200, 200).watermark(Positions.BOTTOM_RIGHT, 
					ImageIO.read(new File(basePath+"/watermark.jpg")), 0.25f).outputQuality(0.8f).toFile("G:\\xiaohuangrennew.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

}