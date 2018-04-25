package com.orangedietc.flim.comparator;

import java.util.Comparator;

import com.orangedietc.flim.po.ReviewsCustom;

public class DatetimeReverseComparator implements Comparator<ReviewsCustom>{

	@Override
	public int compare(ReviewsCustom o1, ReviewsCustom o2) {
		
		return o2.getTimeStamp().compareTo(o1.getTimeStamp());
	}

}
