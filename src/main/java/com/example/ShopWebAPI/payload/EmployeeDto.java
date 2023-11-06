package com.example.ShopWebAPI.payload;

import java.sql.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
	@NotEmpty
	@Schema(name ="name", example = "ngô tất sơn")
	private String name;
	@NotEmpty
	@Schema(name = "phoneNumber",example = "0879693122")
	private String phoneNumber;
	@NotEmpty
	private Date birthDay;
	@NotEmpty
	@Schema(name = "address", example = "Bắc từ liêm, hà nội")
	private String address;
}
