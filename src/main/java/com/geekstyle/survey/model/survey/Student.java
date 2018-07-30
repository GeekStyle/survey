package com.geekstyle.survey.model.survey;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Student {
	
	private Long id;
    @Size(min=2, max=30, message="str,2,30")
	private String name;
	
    @Min(value=18, message="int,18,")
	private Integer age;
    
    @Pattern(regexp = "A|B|C|D")
    private String type;
	
	private Date createTime;
	
}
