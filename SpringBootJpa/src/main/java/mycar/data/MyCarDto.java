package mycar.data;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Table(name = "mycar") //자동으로 mycar라는 table이 mysql에 만들어진다
@Data
public class MyCarDto {
	
	@Id //각 엔티티 구별할 식별아이디를 갖도록 설계(시퀀스)
	@GeneratedValue(strategy=GenerationType.AUTO) //둘다 식별자. 기본키 프라이머리키를 지정하는 것.
	
	@Column(name="num")
	private long num;
	
	@Column //이름 같으면 생략가능
	private String carname;
	
	@Column
	private int carprice;
	
	@Column
	private String carcolor;
	
	@Column
	private String carguip;
	
	@CreationTimestamp //엔티티가 생성되는 시점의 시간 자동등록
	@Column(updatable = false) //수정시 이컬럼은 수정x
	//updateable=false 없을시 날짜가 null로 찍힐것
	private Timestamp guipday;
	
	@Column
	private String carphoto;
	
}
