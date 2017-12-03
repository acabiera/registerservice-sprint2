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
		this.transaction_num = rs.getInt(TransactionFieldNames.TRANSACTION_NUM);
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) 
	{
		record.put(TransactionFieldNames.LOOKUP_CODE, this.lookupCode);
		record.put(TransactionFieldNames.TRANSACTION_NUM, this.transaction_num);
		
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

	private int transaction_num;
	public int getTransaction_Num() 
	{
		return this.transaction_num;
	}
	public TransactionEntity setTransaction_Num(int transactionNum) 
	{
		if (this.transaction_num != transactionNum) 
		{
			this.transaction_num = transactionNum;
			this.propertyChanged(TransactionFieldNames.TRANSACTION_NUM);
		}
		
		return this;
	}
	
	public Transaction synchronize(Transaction apiTransaction) 
	{
		this.setTransaction_Num(apiTransaction.getTransaction_Num());
		this.setLookupCode(apiTransaction.getLookupCode());
		
		return apiTransaction;
	}
	
	public TransactionEntity() 
	{
		super(new TransactionRepository());
		
		this.transaction_num = -1;
		this.lookupCode = StringUtils.EMPTY;
	}
	
	public TransactionEntity(UUID id) 
	{
		super(id, new TransactionRepository());
		
		this.transaction_num = -1;
		this.lookupCode = StringUtils.EMPTY;
	}

	public TransactionEntity(Transaction apiTransaction) 
	{
		super(apiTransaction.getId(), new TransactionRepository());
		
		this.transaction_num = apiTransaction.getTransaction_Num();
		this.lookupCode = apiTransaction.getLookupCode();
	}
}