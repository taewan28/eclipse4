package day4.mybatis.dto;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode

public class CustomerBuyDto {
	private int BUYIDX;
    private String pcode;
    private String pname;
    private int price;
    private int quantity;
    private Timestamp BUYDATE;

}
