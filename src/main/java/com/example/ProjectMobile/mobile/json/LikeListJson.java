package com.example.ProjectMobile.mobile.json;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.ProjectMobile.mobile.model.Like;
import com.example.ProjectMobile.mobile.model.Post;
import com.example.ProjectMobile.mobile.model.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LikeListJson {
    private long id;
    private User user;
    private Post post;
    private LocalDateTime time;

    public static LikeListJson packJson(Like like) {
        LikeListJson llj = new LikeListJson();
        llj.setId(like.getId());
        llj.setUser(like.getUser());
        llj.setPost(like.getPost());
        llj.setTime(like.getTime());

        return llj;
    }

    public static List<LikeListJson> packJsons(List<Like> likes){
        List<LikeListJson> llj = new ArrayList<LikeListJson>();
        for(Like like : likes) {
            llj.add(packJson(like));
        }
        return llj;
    }
}