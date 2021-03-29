package com.porto.portocom.portal.cliente.v1.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ValidaTokenAAResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1688095981892270495L;
	private LocalDateTime validityStartTime;
	private LocalDateTime validityEndTime;
    private String numberOfFailedAuthAttempts;
    private Integer daysLeftToExpire;
    private Integer remainingUsageCount;
    private Integer usageCount;
	private String message;	   
	private Integer responseCode;

}
