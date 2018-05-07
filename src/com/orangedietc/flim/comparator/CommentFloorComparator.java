package com.orangedietc.flim.comparator;

import java.util.Comparator;

import com.orangedietc.flim.po.CommentsCustom;

public class CommentFloorComparator implements Comparator<CommentsCustom>{

	@Override
	public int compare(CommentsCustom o1, CommentsCustom o2) {
		// TODO Auto-generated method stub
		return o1.getFloor() - o2.getFloor();
	}
}
