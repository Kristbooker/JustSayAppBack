package com.example.ProjectMobile.mobile.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectMobile.mobile.json.LikeListJson;
import com.example.ProjectMobile.mobile.model.Like;
import com.example.ProjectMobile.mobile.paylaod.LikePayload;
import com.example.ProjectMobile.mobile.service.LikeService;



@Service
public class LikeBusiness {
	@Autowired
	LikeService likeService;
	
	public List<LikeListJson> getListLike(){
		return LikeListJson.packJsons(likeService.getAllLikeds());
	}
	public LikeListJson getLikeByUserId(long id) {
		return LikeListJson.packJson(likeService.findByUserId(id));
	}
	public List<LikeListJson> getLikeByPostId(long id) {
		return LikeListJson.packJsons(likeService.findByPostId(id));
	}
	public void saveLike(LikePayload likePayload) {
		Like like = new Like(
					likePayload.getUser(),
					likePayload.getPost());
		likeService.save(like);
	}
	public void updateLike(long id, LikePayload likePayload) {
		Like likeData = likeService.findById(id);
		likeData.setUser(likePayload.getUser());
		likeData.setPost(likePayload.getPost());
		likeService.save(likeData);
	}
	public void deleteLike(long id) {
		likeService.deleteById(id);
	}
}
