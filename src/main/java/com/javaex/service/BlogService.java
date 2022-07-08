package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {
	
	//필드
	@Autowired
	private BlogDao blogDao;
		
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//블로그 메인화면
	public Map<String, Object> main(String id) {
		
		System.out.println("BlogService > main");
		
		Map<String, Object> blogMap = new HashMap<String, Object>();
		blogMap.put("blogVo", blogDao.main(id));
		
		return blogMap;
		
	}
	
	//파일 하드디스크 저장, 파일 정보(DB 저장) 추출 저장 | 기본 설정 변경
	public int upload(String id, String blogTitle, MultipartFile file) {
		
		System.out.println("BlogService > upload");
		
		String saveDir = "C:\\javaStudy\\upload";
		
		//[1]파일 정보(DB 저장) 추출 저장
		
		//오리지널 파일명
		String orgName = file.getOriginalFilename();
		
		//확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		
		//저장 파일명
		String saveName = "/upload" + System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		
		//파일 경로(디렉토리 + 저장 파일명)
		String filePath = saveDir + "\\" + saveName;

		//vo로 묶기
		BlogVo blogVo = new BlogVo();
		blogVo.setId(id);
		blogVo.setBlogTitle(blogTitle);
		blogVo.setLogoFile(saveName);
		
		//vo --> dao DB저장
		int count = blogDao.upload(blogVo);
		
		//[2]파일 저장
		try {
			
			byte[] fileData = file.getBytes();
			
			OutputStream os =  new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			bos.write(fileData);
			bos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return count;
		
	}

}
