package com.orangedietc.flim.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.orangedietc.flim.comparator.CommentFloorComparator;
import com.orangedietc.flim.mapper.CommentsMapper;
import com.orangedietc.flim.po.Comments;
import com.orangedietc.flim.po.CommentsCustom;
import com.orangedietc.flim.po.CommentsExample;
import com.orangedietc.flim.po.CommentsQueryVo;
import com.orangedietc.flim.service.CommentsService;

public class CommentsServiceImpl implements CommentsService {
	
	@Autowired
	private CommentsMapper commentsMapper;

	@Override
	public void insertComment(CommentsCustom commentsCustom) throws Exception {
		commentsMapper.insert(commentsCustom);
	}

	@Override
	public List<CommentsCustom> findCommentsListByReview(CommentsQueryVo commentsQueryVo) throws Exception {
		Integer reviewId = commentsQueryVo.getReviewsCustom().getReviewId();
		CommentsExample commentsExample = new CommentsExample();
		commentsExample.createCriteria().andReviewIdEqualTo(reviewId);
		List<Comments> commentsList = commentsMapper.selectByExampleWithBLOBs(commentsExample);
		
		List<CommentsCustom> commentsCustomList = new ArrayList<CommentsCustom>();
		for(Comments comment: commentsList) {
			CommentsCustom commentsCustom = new CommentsCustom();
			BeanUtils.copyProperties(comment, commentsCustom);
			commentsCustomList.add(commentsCustom);
		}
		Collections.sort(commentsCustomList, new CommentFloorComparator());
		return commentsCustomList;
	}

}
