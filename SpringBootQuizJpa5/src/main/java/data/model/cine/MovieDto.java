package data.model.cine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="mycine")
@Data
public class MovieDto {
	@Id //각 엔티티 구별할 식별아이디를 갖도록 설계(시퀀스)
	@GeneratedValue(strategy=GenerationType.AUTO) //둘다 식별자. 기본키 프라이머리키를 지정하는 것.
	
	@Column
	private long mv_num;
	@Column
	private String mv_title;
	@Column
	private String mv_poster;
	@Column
	private String mv_director;
	@Column
	private String mv_opendate;

}
