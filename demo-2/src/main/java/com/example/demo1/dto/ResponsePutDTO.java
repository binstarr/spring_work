package com.example.demo1.dto;

import java.util.List;

import com.example.demo1.dto.common.CarDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResponsePutDTO {
	
	@JsonProperty("status_code")
	private int statusCode;
	private String name;
	private String age;
	private List<CarDTO> carList;

}
