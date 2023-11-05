package com.example.ProjectMobile.mobile.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjectMobile.exception.BaseException;
import com.example.ProjectMobile.mobile.business.CommentBusiness;
import com.example.ProjectMobile.mobile.business.FavoriteBusiness;
//import com.example.ProjectMobile.mobile.business.FavoriteBusiness;
import com.example.ProjectMobile.mobile.business.LikeBusiness;
import com.example.ProjectMobile.mobile.business.PostBusiness;
import com.example.ProjectMobile.mobile.business.UserBusiness;
import com.example.ProjectMobile.mobile.json.CommentListJson;
import com.example.ProjectMobile.mobile.json.FavoriteListJson;
//import com.example.ProjectMobile.mobile.json.FavoriteListJson;
import com.example.ProjectMobile.mobile.json.LikeListJson;
import com.example.ProjectMobile.mobile.json.PostListJson;
import com.example.ProjectMobile.mobile.json.UserListJson;
import com.example.ProjectMobile.mobile.model.Comment;
import com.example.ProjectMobile.mobile.model.Favorite;
//import com.example.ProjectMobile.mobile.model.Favorite;
import com.example.ProjectMobile.mobile.model.Like;
import com.example.ProjectMobile.mobile.model.Post;
import com.example.ProjectMobile.mobile.model.User;
import com.example.ProjectMobile.mobile.paylaod.CommentPayload;
import com.example.ProjectMobile.mobile.paylaod.FavoritePayload;
//import com.example.ProjectMobile.mobile.paylaod.FavoritePayload;
import com.example.ProjectMobile.mobile.paylaod.LikePayload;
import com.example.ProjectMobile.mobile.paylaod.LoginPayload;
import com.example.ProjectMobile.mobile.paylaod.PostPayload;
import com.example.ProjectMobile.mobile.paylaod.UserPayload;
import com.example.ProjectMobile.mobile.service.CommentService;
import com.example.ProjectMobile.mobile.service.FavoriteService;
//import com.example.ProjectMobile.mobile.service.FavoriteService;
import com.example.ProjectMobile.mobile.service.LikeService;
import com.example.ProjectMobile.mobile.service.PostService;
import com.example.ProjectMobile.mobile.service.UserService;




@RestController
@RequestMapping("/api")
public class UserController {
	//user
	@Autowired
	UserService userService;
	@Autowired
	UserBusiness userBusiness;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@PostMapping(value = "/users")
	public ResponseEntity<Void> saveUser(@RequestBody UserPayload userPayload) throws BaseException{
		userBusiness.saveUser(userPayload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@GetMapping(value = "/users")
	public ResponseEntity<List<UserListJson>> getAllUsers() throws BaseException{
		return ResponseEntity.ok(userBusiness.getListUser());
	}
	@GetMapping(value = "/users/{id}")
	public ResponseEntity<UserListJson> getUserById(@PathVariable("id") long id) throws BaseException{
		return ResponseEntity.ok(userBusiness.getUserId(id));
	}
	@GetMapping(value = "/users/user/{userName}")
	public ResponseEntity<UserListJson> getUserByUserName(@PathVariable("userName") String userName) throws BaseException{
		return ResponseEntity.ok(userBusiness.getUserByUserName(userName));
	}
	@PutMapping("/users/update/{id}")
	public ResponseEntity<UserListJson> updateUser(@PathVariable("id") long id, @RequestBody UserPayload userPayload){
		Optional<User> userData = userService.findOptionalById(id);
		if(userData.isPresent()) {
			userBusiness.updateUser(userData.get().getId(),userPayload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id){
		try {
			userBusiness.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			// TODO: handle exception
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserListJson> login(@RequestBody LoginPayload loginPayload) {
	    // ค้นหา user จาก username
	    User user = userService.findByUserName(loginPayload.getUserName());
	    if (user == null) {
	        // ไม่พบ user ในระบบ
	        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	    }

	    // ตรวจสอบ password ถ้าไม่ตรง ให้ return 401 Unauthorized
	    if (!user.getPassword().equals(loginPayload.getPassword())) {
	        // password ไม่ตรง
	        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	    }

	    // หาก password ตรง ให้ทำการแปลง user ไปเป็น UserListJson และ return 200 OK
	    UserListJson userListJson = UserListJson.packJson(user);
	    return ResponseEntity.ok(userListJson);
	}

	
//	/////post
//	@GetMapping(value="users/post")
//	public ResponseEntity<List<PostListJson>> getAllPosts() throws BaseException{
//		return ResponseEntity.ok(postBusiness.getListPost());
//	} 
//	
//	@PostMapping(value = "/users/post")
//	public ResponseEntity<Void> savePost(@RequestBody PostPayload postPayload) throws BaseException{
//		postBusiness.savePost(postPayload);
//		return new ResponseEntity<>(HttpStatus.CREATED);
//	}
//	@PutMapping("/users/post/{id}")
//	public ResponseEntity<PostListJson> updatePost(@PathVariable("id") long id,
//			@RequestBody PostPayload postPayload){
//		Optional<Post> postData = postService.findOptionalById(id);
//		if(postData.isPresent()) {
//			postBusiness.updatePost(postData.get().getId(),postPayload);
//			return new ResponseEntity<>(HttpStatus.OK);
//		}else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//	@DeleteMapping("/users/post/{id}")
//	public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long id){
//		try {
//			postBusiness.deletePost(id);
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//			// TODO: handle exception
//		}
//	}
//	
//	///comment
//	@GetMapping(value = "/users/comment")
//	public ResponseEntity<List<CommentListJson>> getAllComments() throws BaseException{
//		return ResponseEntity.ok(commentBusiness.getListComment());
//	} 
//	
//	@GetMapping(value = "/users/comment/post/{postId}")
//	public ResponseEntity<List<CommentListJson>> getCommentByPostId(@PathVariable("postId") long id) throws BaseException{
//		return ResponseEntity.ok(commentBusiness.getCommentByPostId(id));
//	}
//	@GetMapping("/users/comment/ownerUserId/{userId}")
//    public ResponseEntity<List<CommentListJson>> getCommentsByPostOwner(@PathVariable Long userId) {
//        List<Comment> comments = commentService.findCommentsByPostOwner(userId);
//        List<CommentListJson> commentsJson = CommentListJson.packJsons(comments);
//        return new ResponseEntity<>(commentsJson, HttpStatus.OK);
//    }
//	@PostMapping(value = "/users/comment")
//	public ResponseEntity<Void> saveComment(@RequestBody CommentPayload commentPayload) throws BaseException{
//		commentBusiness.saveComment(commentPayload);
//		return new ResponseEntity<>(HttpStatus.CREATED);
//	}
//	@PutMapping("/users/comment/{id}")
//	public ResponseEntity<CommentListJson> updateComment(@PathVariable("id") long id,
//			@RequestBody CommentPayload commentPayload){
//		Optional<Comment> commentData = commentService.findOptionalById(id);
//		if(commentData.isPresent()) {
//			commentBusiness.updateComment(commentData.get().getId(),commentPayload);
//			return new ResponseEntity<>(HttpStatus.OK);
//		}else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//	@DeleteMapping("/users/comment/{id}")
//	public ResponseEntity<HttpStatus> deleteComment(@PathVariable("id") long id){
//		try {
//			commentBusiness.deleteComment(id);
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//			// TODO: handle exception
//		}
//	}
//	
//	//like
//	@GetMapping(value = "/users/like")
//	public ResponseEntity<List<LikeListJson>> getAllLikes() throws BaseException{
//		return ResponseEntity.ok(likeBusiness.getListLike());
//	} 
//	
//	@GetMapping(value = "/users/like/post/{postId}")
//	public ResponseEntity<List<LikeListJson>> getLikeByPostId(@PathVariable("postId") long id) throws BaseException{
//		return ResponseEntity.ok(likeBusiness.getLikeByPostId(id));
//	}
//	
//	@GetMapping("/users/like/ownerUserId/{userId}")
//    public ResponseEntity<List<LikeListJson>> getLikesByPostOwner(@PathVariable Long userId) {
//        List<Like> likes = likeService.findLikesByPostOwner(userId);
//        List<LikeListJson> likesJson = LikeListJson.packJsons(likes);
//        return new ResponseEntity<>(likesJson, HttpStatus.OK);
//    }
//	
//	@PostMapping(value = "/users/like")
//	public ResponseEntity<Void> saveLike(@RequestBody LikePayload likePayload) throws BaseException{
//		likeBusiness.saveLike(likePayload);
//		return new ResponseEntity<>(HttpStatus.CREATED);
//	}
//	@PutMapping("/users/like/{id}")
//	public ResponseEntity<LikeListJson> updateLike(@PathVariable("id") long id,
//			@RequestBody LikePayload likePayload){
//		Optional<Like> likeData = likeService.findOptionalById(id);
//		if(likeData.isPresent()) {
//			likeBusiness.updateLike(likeData.get().getId(),likePayload);
//			return new ResponseEntity<>(HttpStatus.OK);
//		}else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//	@DeleteMapping("/users/like/{id}")
//	public ResponseEntity<HttpStatus> deleteLike(@PathVariable("id") long id){
//		try {
//			likeBusiness.deleteLike(id);
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//			// TODO: handle exception
//		}
//	}
//	
//	//favorite
//	@GetMapping(value = "/users/favorite")
//	public ResponseEntity<List<FavoriteListJson>> getAllFavorites() throws BaseException{
//		return ResponseEntity.ok(favoriteBusiness.getListFavorite());
//	} 
//	@GetMapping("/getFavByUser/{userId}")
//	public ResponseEntity<List<FavoriteListJson>> getFavoriteByUserId(@PathVariable("userId") long id) throws BaseException{
//		return ResponseEntity.ok(favoriteBusiness.getFavoriteByUserId(id));
//	}
//	@PostMapping(value = "/users/favorite")
//	public ResponseEntity<Void> saveFavorite(@RequestBody FavoritePayload favoritePayload) throws BaseException{
//		favoriteBusiness.saveFavorite(favoritePayload);
//		return new ResponseEntity<>(HttpStatus.CREATED);
//	}
//	@PutMapping("/users/favorite/{id}")
//	public ResponseEntity<FavoriteListJson> updateFavorite(@PathVariable("id") long id,
//			@RequestBody FavoritePayload favoritePayload){
//		Optional<Favorite> favoriteData = favoriteService.findOptionalById(id);
//		if(favoriteData.isPresent()) {
//			favoriteBusiness.updateFavorite(favoriteData.get().getId(),favoritePayload);
//			return new ResponseEntity<>(HttpStatus.OK);
//		}else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//	@DeleteMapping("/users/favorite/{id}")
//	public ResponseEntity<HttpStatus> deleteFavorite(@PathVariable("id") long id){
//		try {
//			favoriteBusiness.deleteFavorite(id);
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//			// TODO: handle exception
//		}
//	}
	
}
