package exam2;

import java.beans.Transient;
import java.time.LocalDate;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="JpaMember2")
public class Member2 {
	@Id // 테이블의 pk
	@SequenceGenerator (
			name = "mySequence2",
			sequenceName = "JpaMember2_SEQ", // 실제 DB에 생성되는 시퀀스 이름
			initialValue = 1,
			allocationSize = 1
	)
	@GeneratedValue(generator = "mySequence2") // 시퀀스 : 별도의 설정이 없으면 자동으로 50씩 증가 한다.
	private Long id;
	

	@Access(AccessType.FIELD)				// 기본값 : 멤버 변수를 통해서 데이터 접근
	private String username;
	
	@Access(AccessType.PROPERTY)		// 프로퍼티(getter/setter메소드)를 통해서 데이터
	private String password;
	
	@jakarta.persistence.Transient 			// 어노테이션으로 제외 이 필드는 DB에 없는 필드이므로 
	private Long timestamp1;
	transient private Long timestamp2;	// 방법2 지시자를 이용하여 제외함
	
	public Member2() {}
	public Member2(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
