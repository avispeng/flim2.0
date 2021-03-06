package com.orangedietc.flim.mapper;

import com.orangedietc.flim.po.Reviews;
import com.orangedietc.flim.po.ReviewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReviewsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reviews
     *
     * @mbg.generated Wed Apr 25 09:48:57 EDT 2018
     */
    long countByExample(ReviewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reviews
     *
     * @mbg.generated Wed Apr 25 09:48:57 EDT 2018
     */
    int deleteByExample(ReviewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reviews
     *
     * @mbg.generated Wed Apr 25 09:48:57 EDT 2018
     */
    int deleteByPrimaryKey(Integer reviewId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reviews
     *
     * @mbg.generated Wed Apr 25 09:48:57 EDT 2018
     */
    int insert(Reviews record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reviews
     *
     * @mbg.generated Wed Apr 25 09:48:57 EDT 2018
     */
    int insertSelective(Reviews record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reviews
     *
     * @mbg.generated Wed Apr 25 09:48:57 EDT 2018
     */
    List<Reviews> selectByExampleWithBLOBs(ReviewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reviews
     *
     * @mbg.generated Wed Apr 25 09:48:57 EDT 2018
     */
    List<Reviews> selectByExample(ReviewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reviews
     *
     * @mbg.generated Wed Apr 25 09:48:57 EDT 2018
     */
    Reviews selectByPrimaryKey(Integer reviewId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reviews
     *
     * @mbg.generated Wed Apr 25 09:48:57 EDT 2018
     */
    int updateByExampleSelective(@Param("record") Reviews record, @Param("example") ReviewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reviews
     *
     * @mbg.generated Wed Apr 25 09:48:57 EDT 2018
     */
    int updateByExampleWithBLOBs(@Param("record") Reviews record, @Param("example") ReviewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reviews
     *
     * @mbg.generated Wed Apr 25 09:48:57 EDT 2018
     */
    int updateByExample(@Param("record") Reviews record, @Param("example") ReviewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reviews
     *
     * @mbg.generated Wed Apr 25 09:48:57 EDT 2018
     */
    int updateByPrimaryKeySelective(Reviews record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reviews
     *
     * @mbg.generated Wed Apr 25 09:48:57 EDT 2018
     */
    int updateByPrimaryKeyWithBLOBs(Reviews record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reviews
     *
     * @mbg.generated Wed Apr 25 09:48:57 EDT 2018
     */
    int updateByPrimaryKey(Reviews record);
}