package com.geekstyle.survey.dao.survey;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.geekstyle.survey.model.survey.Survey;

@Mapper
public interface SurveyDao {
	
	@Insert({"insert into survey (id,name,create_time) values (#{id},#{name},#{createTime}) "})
	public void insertSurvey(Survey survey);
	
	public void deleteSurvey(String id);
	
	public void updateSurvey(Survey survey);
	
	@Select("select id,name,create_time createTime from survey")
	public Survey querySurvey(String id);
	
	public List<Survey> querySurvey(Survey survey);
	
}
