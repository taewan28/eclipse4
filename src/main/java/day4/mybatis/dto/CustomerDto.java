package day4.mybatis.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor

public class CustomerDto {
	private String customId;
	private String custom_id;
    private String name;
    private String email;
    private int age;
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm", timezone = "Asia/Seoul")
    private Date regdate;
}
