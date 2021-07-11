package com.itechgenie.apps.dtos;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItgResponseDTO {

	private ItgStatusDTO apiStatus;
	private Optional<String> data = Optional.empty();

}
