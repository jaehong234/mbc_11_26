package kr.co.mbc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MemberForm {
	
	private String username;
	
	private String password;
	private String password2;
	
	private String name;

	@Override
	public String toString() {
		return "MemberForm [username=" + username + ", password=" + password + ", password2=" + password2 + ", name="
				+ name + "]";
	}
	

	
}
