package com.orangedietc.flim.mapper;

import com.orangedietc.flim.po.Comments;
import com.orangedietc.flim.po.CommentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    long countByExample(CommentsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    int deleteByExample(CommentsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    int deleteByPrimaryKey(Integer commentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    int insert(Comments record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    int insertSelective(Comments record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    List<Comments> selectByExampleWithBLOBs(CommentsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    List<Comments> selectByExample(CommentsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    Comments selectByPrimaryKey(Integer commentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    int updateByExampleSelective(@Param("record") Comments record, @Param("example") CommentsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    int updateByExampleWithBLOBs(@Param("record") Comments record, @Param("example") CommentsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    int updateByExample(@Param("record") Comments record, @Param("example") CommentsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    int updateByPrimaryKeySelective(Comments record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    int updateByPrimaryKeyWithBLOBs(Comments record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comments
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    int updateByPrimaryKey(Comments record);
}