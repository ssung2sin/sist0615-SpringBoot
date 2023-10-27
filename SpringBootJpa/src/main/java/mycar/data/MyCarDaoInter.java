package mycar.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyCarDaoInter extends JpaRepository<MyCarDto, Long>{ //primary key num 자료형을 Long으로 선언
	
}
