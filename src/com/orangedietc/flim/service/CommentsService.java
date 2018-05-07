package com.orangedietc.flim.service;

import java.util.List;

import com.orangedietc.flim.po.CommentsCustom;
import com.orangedietc.flim.po.CommentsQueryVo;

public interface CommentsService {
	public void insertComment(CommentsCustom commentsCustom) throws Exception;
	
	public List<CommentsCustom> findCommentsListByReview(CommentsQueryVo commentsQueryVo) throws Exception;
}
