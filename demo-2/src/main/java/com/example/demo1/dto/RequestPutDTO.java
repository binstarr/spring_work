package com.example.demo1.dto;

import java.util.List;

import com.example.demo1.dto.common.CarDTO;

import lombok.Data;

@Data
public class RequestPutDTO {
	
	private String name;
	private String age;
	private List<CarDTO> carList;

}


