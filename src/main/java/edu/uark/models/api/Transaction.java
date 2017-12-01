package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.models.api.enums.TransactionApiRequestStatus;
import edu.uark.models.entities.TransactionEntity;

public class Transaction 
{
	private UUID id;
	public UUID getId() 
	{
		return this.id;
	}
	public Transaction setId(UUID id) 
	{
		this.id = id;
		return this;
	}
	
	private String lookupCode;
	public String getLookupCode() 
	{
		return this.lookupCode;
	}
	public Transaction setLookupCode(String lookupCode) 
	{
		this.lookupCode = lookupCode;
		return this;
	}
	
	private int quantity;
	public int getQuantity() 
	{
		return this.quantity;
	}
	public Transaction setQuantity(int quantity) 
	{
		this.quantity = quantity;
		return this;
	}
	
	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() 
	{
		return this.createdOn;
	}
	public Transaction setCreatedOn(LocalDateTime createdOn) 
	{
		this.createdOn = createdOn;
		return this;
	}
	
	private String name;
	public String getName() 
	{
		return this.name;
	}
	public Transaction setName(String name) 
	{
		this.name = name;
		return this;
	}
	
	private double price;
	public double getPrice() 
	{
		return this.price;
	}
	public Transaction setPrice(double price) 
	{
		this.price = price;
		return this;
	}
	
	private boolean active;
	public boolean getActive() 
	{
		return this.active;
	}
	public Transaction setActive(boolean active) 
	{
		this.active = active;
		return this;
	}
	
	private String description;
	public String getDescription() 
	{
		return this.description;
	}
	public Transaction setDescription(String description) 
	{
		this.description = description;
		return this;
	}
	
	private TransactionApiRequestStatus apiRequestStatus;
	public TransactionApiRequestStatus getApiRequestStatus() 
	{
		return this.apiRequestStatus;
	}
	public Transaction setApiRequestStatus(TransactionApiRequestStatus apiRequestStatus) 
	{
		if (this.apiRequestStatus != apiRequestStatus) 
		{
			this.apiRequestStatus = apiRequestStatus;
		}
		
		return this;
	}
	
	private String apiRequestMessage;
	public String getApiRequestMessage() 
	{
		return this.apiRequestMessage;
	}
	public Transaction setApiRequestMessage(String apiRequestMessage) 
	{
		if (!StringUtils.equalsIgnoreCase(this.apiRequestMessage, apiRequestMessage)) 
		{
			this.apiRequestMessage = apiRequestMessage;
		}
		
		return this;
	}
	
	public Transaction() 
	{
		this.id = new UUID(0, 0);
		this.transaction_num = -1;
		this.lookupCode = "";

		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = TransactionApiRequestStatus.OK;
	}
	
	public Transaction(TransactionEntity transactionEntity) 
	{
		this.id = transactionEntity.getId();
		this.transaction_num = transactionEntity.getTransaction_Num();
		this.lookupCode = transactionEntity.getLookupCode();

		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = TransactionApiRequestStatus.OK;
	}
}

