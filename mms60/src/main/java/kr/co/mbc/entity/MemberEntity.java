package kr.co.mbc.entity;

import java.util.jar.Attributes.Name;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.mbc.dto.MemberForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "member")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String username;

	private String password;

	private String name;

	private String role; // 권한정보르 저장할 수 있는 필드

	public static MemberEntity toMemberEntity(MemberForm memberForm) {

		MemberEntity entity = MemberEntity.builder().username(memberForm.getUsername()).name(memberForm.getName())
				.password(memberForm.getPassword()).build();

		return entity;
	}

	@Override
	public String toString() {
		return "MemberEntity [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", role=" + role + "]";
	}

}
