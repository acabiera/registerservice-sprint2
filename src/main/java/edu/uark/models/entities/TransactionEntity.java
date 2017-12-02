package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.models.api.Transaction;
import edu.uark.models.entities.fieldnames.TransactionFieldNames;
import edu.uark.models.repositories.TransactionRepository;

public class TransactionEntity extends BaseEntity<TransactionEntity> 
{
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException 
	{
		this.lookupCode = rs.getString(TransactionFieldNames.LOOKUP_CODE);
		this.transactionNum = rs.getInt(TransactionFieldNames.TRANSACTION_NUM);
		/*this.createdOn = rs.getTimestamp(TransactionFieldNames.CREATED_ON).toLocalDateTime();
		this.name = rs.getString(TransactionFieldNames.NAME);
		this.price = rs.getDouble(TransactionFieldNames.PRICE);
		this.active = rs.getBoolean(TransactionFieldNames.ACTIVE);
		this.description = rs.getString(TransactionFieldNames.DESCRIPTION);*/
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) 
	{
		record.put(TransactionFieldNames.LOOKUP_CODE, this.lookupCode);
		record.put(TransactionFieldNames.TRANSACTION_NUM, this.transactionNum);
		/*record.put(TransactionFieldNames.CREATED_ON, Timestamp.valueOf(this.createdOn));
		record.put(TransactionFieldNames.NAME, this.name);
		record.put(TransactionFieldNames.PRICE, this.price);
		record.put(TransactionFieldNames.ACTIVE, this.active);
		record.put(TransactionFieldNames.DESCRIPTION, this.description);*/
		
		return record;
	}

	private String lookupCode;
	public String getLookupCode() 
	{
		return this.lookupCode;
	}
	public TransactionEntity setLookupCode(String lookupCode) 
	{
		if (!StringUtils.equals(this.lookupCode, lookupCode)) 
		{
			this.lookupCode = lookupCode;
			this.propertyChanged(TransactionFieldNames.LOOKUP_CODE);
		}
		
		return this;
	}

	private int transactionNum;
	public int getTransactionNum() 
	{
		return this.transactionNum;
	}
	public TransactionEntity setTransactionNum(int transactionNum) 
	{
		if (this.transactionNum != transactionNum) 
		{
			this.transactionNum = transactionNum;
			this.propertyChanged(TransactionFieldNames.TRANSACTION_NUM);
		}
		
		return this;
	}

	/*private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() 
	{
		return this.createdOn;
	}
	
	private String name;
	public String getName() 
	{
		return this.name;
	}
	public TransactionEntity setName(String name) 
	{
		if (!StringUtils.equals(this.name, name)) 
		{
			this.name = name;
			this.propertyChanged(TransactionFieldNames.NAME);
		}
		
		return this;
	}
	
	private double price;
	public double getPrice() 
	{
		return this.price;
	}
	public TransactionEntity setPrice(double price) 
	{
		if (this.price != price) 
		{
			this.price = price;
			this.propertyChanged(TransactionFieldNames.PRICE);
		}
		
		return this;
	}
	
	private boolean active;
	public boolean getActive() 
	{
		return this.active;
	}
	public TransactionEntity setActive(boolean active) 
	{
		if (this.active != active) 
		{
			this.active = active;
			this.propertyChanged(TransactionFieldNames.ACTIVE);
		}
		
		return this;
	}
	
	private String description;
	public String getDescription() 
	{
		return this.description;
	}
	public TransactionEntity setDescription(String description) 
	{
		if (!StringUtils.equals(this.description, description)) 
		{
			this.description = description;
			this.propertyChanged(TransactionFieldNames.DESCRIPTION);
		}
		
		return this;
	}*/
	
	public Transaction synchronize(Transaction apiTransaction) 
	{
		this.setTransactionNum(apiTransaction.getTransactionNum());
		this.setLookupCode(apiTransaction.getLookupCode());
		/*this.setName(apiTransaction.getName());
		this.setPrice(apiTransaction.getPrice());
		this.setActive(apiTransaction.getActive());
		this.setDescription(apiTransaction.getDescription());
		
		apiTransaction.setCreatedOn(this.createdOn);*/
		
		return apiTransaction;
	}
	
	public TransactionEntity() 
	{
		super(new TransactionRepository());
		
		this.transactionNum = -1;
		this.lookupCode = StringUtils.EMPTY;
		/*this.createdOn = LocalDateTime.now();
		this.name = StringUtils.EMPTY;
		this.price = 0.00;
		this.active = false;
		this.description = StringUtils.EMPTY;*/
	}
	
	public TransactionEntity(UUID id) 
	{
		super(id, new TransactionRepository());
		
		this.transactionNum = -1;
		this.lookupCode = StringUtils.EMPTY;
		/*this.createdOn = LocalDateTime.now();
		this.name = StringUtils.EMPTY;
		this.price = 0.00;
		this.active = false;
		this.description = StringUtils.EMPTY;*/
	}

	public TransactionEntity(Transaction apiTransaction) 
	{
		super(apiTransaction.getId(), new TransactionRepository());
		
		this.transactionNum = apiTransaction.getQuantity();
		this.lookupCode = apiTransaction.getLookupCode();
		/*this.createdOn = LocalDateTime.now();
		this.name = apiTransaction.getName();
		this.price = apiTransaction.getPrice();
		this.active = apiTransaction.getActive();
		this.description = apiTransaction.getDescription();*/
	}
}