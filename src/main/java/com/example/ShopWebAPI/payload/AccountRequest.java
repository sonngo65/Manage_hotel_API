package com.example.ShopWebAPI.payload;

import java.sql.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest extends EmployeeDto {
	@NotEmpty
	@Schema(name="username",example="sonngo")
	private String username;
	@NotEmpty
	@Schema(name="password",example="010702")
	private String password;
	public AccountRequest(String name, String phoneNumber, Date birthDay, String address,String username,String password) {
		super(name, phoneNumber, birthDay, address);
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "AccountRequest [username=" + username + ", password=" + password + ", getName()=" + getName()
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getBirthDay()=" + getBirthDay() + ", getAddress()="
				+ getAddress() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}
}
