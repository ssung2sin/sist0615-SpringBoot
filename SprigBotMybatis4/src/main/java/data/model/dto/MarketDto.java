package data.model.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("mdto")
public class MarketDto {
	private String num;
	private int price;
	private String sang;
	private String photoname;
	private Timestamp ipgoday;
}
