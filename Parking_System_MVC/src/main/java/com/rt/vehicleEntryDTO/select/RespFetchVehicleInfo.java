package com.rt.vehicleEntryDTO.select;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespFetchVehicleInfo {
	private int id;
	private String vehicle_type;
	private String vehicle_number;
	private String owner_name;
	private String contact_number;
	private LocalDate entry_date;
	private LocalTime entry_time;

}
