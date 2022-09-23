package com.example.FoodWebsite.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FoodWebsite.Dto.ItemDto;
import com.example.FoodWebsite.dao.ItemDao;
import com.example.FoodWebsite.model.Item;



@Service
public class PicFolderServiceImpl implements PicFolderService{
	
	@Autowired
	private ItemDao itemDao;

	@Override
	public String savePic(HttpSession session, ItemDto itemDto) {
		// 製作資料夾路徑
		File folderpath = createFolderPath(session);
		// 如果沒有資料夾 創建資料夾
		createFolder(folderpath);
		// 取得時間戳
		String timestamp = getTimeStamp();
		// 製作照片路徑
		String picpath = createPicPath(session, timestamp);
		// 儲存照片
		String picPathAfterSave = createPic(picpath, itemDto);
		
		return picPathAfterSave;
	}

	@Override
	public String updatePic(HttpSession session, ItemDto itemDto) {
		// 取得照片路徑
		String oldpicpath = getPicPath(itemDto);
		// 刪除照片
		deleteSrc(oldpicpath);
		// 取得時間戳
		String timestamp = getTimeStamp();
		// 製作照片路徑
		String newpicpath = createPicPath(session, timestamp);
		// 儲存照片
		String picPathAfterSave = createPic(newpicpath, itemDto);
		
		return picPathAfterSave;
	}

	@Override
	public String deletePic(ItemDto itemDto) {
		// 取得照片路徑
		String picpath = getPicPath(itemDto);
		// 刪除照片
		deleteSrc(picpath);
		return null;
	}
	
	public String getTimeStamp() {
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmss");
		String timeStamp = date.format(new Date());
		return timeStamp;
	}
	
	
	public File createFolderPath(HttpSession session) {
		String shopname = (String)session.getAttribute("shop_name");
		String filePath = ".\\"+shopname;
		File file=new File(filePath);
		return file;
	}
	
	public void createFolder(File file) {
		if(!file.exists() && !file.isDirectory()) {
			file.mkdir();
		}
	}
	
	public String createPicPath(HttpSession session ,String timeStamp) {
		String shopname = (String)session.getAttribute("shop_name");
		String PicPath = ".\\"+shopname+"\\"+timeStamp+".jpg";
		return PicPath;
	}
	
	public String createPic(String picpath ,ItemDto Dto) {
		try {
			byte[] bytes = Dto.getPic().getBytes();
			Path path = Paths.get(picpath);
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return picpath;
	}
	
	public String getPicPath(ItemDto itemDto) {
		List<Long> ids = new ArrayList<>();
		ids.add(Long.parseLong(itemDto.getId()));
		List<Item> items = itemDao.findAllById(ids);
		String picpath = items.get(0).getPic();

		return picpath;
	}
	
	
	public void deleteSrc(String picpath) {
		Path path = Paths.get(picpath);
		try {
			Files.delete(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
