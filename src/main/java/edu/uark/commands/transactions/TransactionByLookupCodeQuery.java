package edu.uark.commands.transactions;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Transaction;
import edu.uark.models.api.enums.TransactionApiRequestStatus;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.repositories.TransactionRepository;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;

public class TransactionByLookupCodeQuery implements ResultCommandInterface<Transaction> 
{
	@Override
	public Transaction execute() 
	{
		if (StringUtils.isBlank(this.lookupCode)) 
		{
			return new Transaction().setApiRequestStatus(TransactionApiRequestStatus.INVALID_INPUT);
		}
		
		TransactionEntity transactionEntity = this.transactionRepository.byLookupCode(this.lookupCode);
		if (transactionEntity != null) 
		{
			return new Transaction(transactionEntity);
		} 
		else 
		{
			return new Transaction().setApiRequestStatus(TransactionApiRequestStatus.NOT_FOUND);
		}
	}

	//Properties
	private String lookupCode;
	public String getLookupCode() 
	{
		return this.lookupCode;
	}
	public TransactionByLookupCodeQuery setLookupCode(String lookupCode) 
	{
		this.lookupCode = lookupCode;
		return this;
	}
	
	private TransactionRepositoryInterface transactionRepository;
	public TransactionRepositoryInterface getTransactionRepository() 
	{
		return this.transactionRepository;
	}
	public TransactionByLookupCodeQuery setTransactionRepository(TransactionRepositoryInterface transactionRepository) 
	{
		this.transactionRepository = transactionRepository;
		return this;
	}
	
	public TransactionByLookupCodeQuery() 
	{
		this.transactionRepository = new TransactionRepository();
	}
}
