package edu.uark.commands.transactions;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Transaction;
import edu.uark.models.api.enums.TransactionApiRequestStatus;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.repositories.TransactionRepository;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;

public class TransactionByTransaction_NumQuery implements ResultCommandInterface<Transaction> 
{
	@Override
	public Transaction execute() 
	{
		if (StringUtils.isBlank(this.transaction_num)) 
		{
			return new Transaction().setApiRequestStatus(TransactionApiRequestStatus.INVALID_INPUT);
		}
		
		TransactionEntity transactionEntity = this.transactionRepository.byTranasaction_Num(this.transaction_num);
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
	private String transaction_num;
	public String getTransaction_Num() 
	{
		return this.transaction_num;
	}
	public TransactionByTransaction_NumQuery setTransaction_Num(String transaction_num) 
	{
		this.transaction_num = transaction_num;
		return this;
	}
	
	private TransactionRepositoryInterface transactionRepository;
	public TransactionRepositoryInterface getTransactionRepository() 
	{
		return this.transactionRepository;
	}
	public TransactionByTransaction_NumQuery setTransactionRepository(TransactionRepositoryInterface transactionRepository) 
	{
		this.transactionRepository = transactionRepository;
		return this;
	}
	
	public TransactionByTransaction_NumQuery() 
	{
		this.transactionRepository = new TransactionRepository();
	}
}
