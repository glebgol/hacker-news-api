package com.glebgol.hackernewsapi.services;

import com.glebgol.hackernewsapi.model.Comment;

public interface CommentsService {
    Comment getComment(int id);
}
