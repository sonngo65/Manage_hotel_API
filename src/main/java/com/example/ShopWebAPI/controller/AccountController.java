package com.example.ShopWebAPI.controller;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import javax.swing.plaf.multi.MultiScrollBarUI;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ShopWebAPI.entity.Account;
import com.example.ShopWebAPI.entity.Employee;
import com.example.ShopWebAPI.entity.Image;
import com.example.ShopWebAPI.payload.AccountRequest;
import com.example.ShopWebAPI.payload.EmployeeDto;
import com.example.ShopWebAPI.service.AccountService;
import com.example.ShopWebAPI.service.EmployeeService;
import com.example.ShopWebAPI.service.ImageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.classic.Logger;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
@Log4j2
public class AccountController {

	private final AccountService accountService;
	private final EmployeeService employeeService;
	private final ImageService imageService;
	
	private final String  accountRequestExample = "{\n"
			+ "  \"name\": \"ngô tất sơn\",\n"
			+ "  \"phoneNumber\": \"0879693122\",\n"
			+ "  \"birthDay\": \"2023-11-05T02:51:10.849Z\",\n"
			+ "  \"address\": \"Bắc từ liêm, hà nội\",\n"
			+ "  \"username\": \"sonngo\",\n"
			+ "  \"password\": \"010702\"\n"
			+ "}";
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	public AccountController(AccountService accountService, EmployeeService employeeService, ImageService imageService,
			ModelMapper modelMapper) {
		super();
		this.accountService = accountService;
		this.employeeService = employeeService;
		this.imageService = imageService;
		this.modelMapper = modelMapper;
	}

	@PostMapping(name = "/accounts", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<EmployeeDto> signUp(@RequestParam("image") MultipartFile imageFile,
		 @Parameter(name= "account",description = "account request", example = accountRequestExample)	@RequestParam("account") String accountRequestString) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		AccountRequest accountRequest = objectMapper.readValue(accountRequestString,AccountRequest.class);
		Account account = modelMapper.map(accountRequest, Account.class);
		EmployeeDto employeeRequest = modelMapper.map(accountRequest, EmployeeDto.class);
		Employee employee = modelMapper.map(employeeRequest,Employee.class);
		
		employee.setAccount(null);
		
		Image image = new Image(imageFile.getOriginalFilename());
		employee.setImage(image);

		account.setEmployee(employee);

		Account savedAccount = accountService.add(account);

		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
//		return new ResponseEntity<>(accountResponse,HttpStatus.OK );
		return new ResponseEntity<>(employeeDto, HttpStatus.OK);
	}

	@PutMapping("/accounts/{id}")
	public ResponseEntity<EmployeeDto> updateAccount(@PathVariable UUID id,
			@RequestBody AccountRequest accountRequest) {
		Account account = modelMapper.map(accountRequest, Account.class);
		account.setDelete(false);
		account.setId(id);
		Account updatedAccount = accountService.update(account);
		EmployeeDto accountResponse = modelMapper.map(updatedAccount, EmployeeDto.class);
		return new ResponseEntity<>(accountResponse, HttpStatus.OK);
	}

	@PutMapping("/accounts/{id}/password")
	public ResponseEntity<EmployeeDto> changePassword(@PathVariable UUID id,
			@RequestParam("password") String password) {
		Account account = new Account();
		account.setDelete(false);
		account.setId(id);
		Account passwordChangedAccount = accountService.changePassword(account, password);
		EmployeeDto accountResponse = modelMapper.map(passwordChangedAccount, EmployeeDto.class);
		return new ResponseEntity<>(accountResponse, HttpStatus.OK);
	}

	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> getAllTestAccounts() {

		return new ResponseEntity<>(accountService.listAll(), HttpStatus.OK);
	}

}
