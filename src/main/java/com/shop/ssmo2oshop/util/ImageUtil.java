package com.shop.ssmo2oshop.util;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	public static String generateThumbnail(CommonsMultipartFile thumbnail, String targetAddr) {
		String realFileName = getRandomFileName();
		String extension = getFileExtension(thumbnail);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		try {
			Thumbnails.of(new File("G:\\xiaohuangren.jpg")).size(200, 200).watermark(Positions.BOTTOM_RIGHT, 
					ImageIO.read(new File(basePath+"/watermark.jpg")), 0.25f).outputQuality(0.8f).toFile("G:\\xiaohuangrennew.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

}