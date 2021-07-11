package com.itechgenie.apps.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@JsonDeserialize(builder = ItgStatusDTO.ItgStatusDTOBuilder.class)
public class ItgStatusDTO {

	private final String message;
	private final String code;
	private final boolean success;

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@ToString
	static class ItgStatusDTOBuilder { // added static to avoid issue - non-static inner classes like this can only by instantiated using default, no-argument constructor

		private String message;
		private String code;
		private boolean success;

		public ItgStatusDTO build() {
			return new ItgStatusDTO(message, code, success);
		}

	}

}
