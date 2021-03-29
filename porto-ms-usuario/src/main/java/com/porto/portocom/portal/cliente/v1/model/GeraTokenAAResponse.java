package com.porto.portocom.portal.cliente.v1.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class GeraTokenAAResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2412813469673102477L;
	
	
		private String otp;
		private Long usageCount;
		private LocalDateTime validityStartTime;
		private LocalDateTime validityEndTime;
		private Long remainingUsageCount;
		private String message;
		

		

}
