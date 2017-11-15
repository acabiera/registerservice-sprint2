package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.models.api.Product;
import edu.uark.models.entities.fieldnames.ProductFieldNames;
import edu.uark.models.repositories.ProductRepository;

public class ProductEntity extends BaseEntity<ProductEntity> 
{
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException 
	{
		this.lookupCode = rs.getString(ProductFieldNames.LOOKUP_CODE);
		this.quantity = rs.getInt(ProductFieldNames.QUANTITY);
		this.createdOn = rs.getTimestamp(ProductFieldNames.CREATED_ON).toLocalDateTime();
		this.name = rs.getString(ProductFieldNames.NAME);
		this.price = rs.getDouble(ProductFieldNames.PRICE);
		this.active = rs.getBoolean(ProductFieldNames.ACTIVE);
		this.description = rs.getString(ProductFieldNames.DESCRIPTION);
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) 
	{
		record.put(ProductFieldNames.LOOKUP_CODE, this.lookupCode);
		record.put(ProductFieldNames.QUANTITY, this.quantity);
		record.put(ProductFieldNames.CREATED_ON, Timestamp.valueOf(this.createdOn));
		record.put(ProductFieldNames.NAME, this.name);
		record.put(ProductFieldNames.PRICE, this.price);
		record.put(ProductFieldNames.ACTIVE, this.active);
		record.put(ProductFieldNames.DESCRIPTION, this.description);
		
		return record;
	}

	private String lookupCode;
	public String getLookupCode() 
	{
		return this.lookupCode;
	}
	public ProductEntity setLookupCode(String lookupCode) 
	{
		if (!StringUtils.equals(this.lookupCode, lookupCode)) 
		{
			this.lookupCode = lookupCode;
			this.propertyChanged(ProductFieldNames.LOOKUP_CODE);
		}
		
		return this;
	}

	private int quantity;
	public int getQuantity() 
	{
		return this.quantity;
	}
	public ProductEntity setQuantity(int quantity) 
	{
		if (this.quantity != quantity) 
		{
			this.quantity = quantity;
			this.propertyChanged(ProductFieldNames.QUANTITY);
		}
		
		return this;
	}

	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() 
	{
		return this.createdOn;
	}
	
	private String name;
	public String getName() 
	{
		return this.name;
	}
	public ProductEntity setName(String name) 
	{
		if (!StringUtils.equals(this.name, name)) 
		{
			this.name = name;
			this.propertyChanged(ProductFieldNames.NAME);
		}
		
		return this;
	}
	
	private double price;
	public double getPrice() 
	{
		return this.price;
	}
	public ProductEntity setPrice(double price) 
	{
		if (this.price != price) 
		{
			this.price = price;
			this.propertyChanged(ProductFieldNames.PRICE);
		}
		
		return this;
	}
	
	private boolean active;
	public boolean getActive() 
	{
		return this.active;
	}
	public ProductEntity setActive(boolean active) 
	{
		if (this.active != active) 
		{
			this.active = active;
			this.propertyChanged(ProductFieldNames.ACTIVE);
		}
		
		return this;
	}
	
	private String description;
	public String getDescription() 
	{
		return this.description;
	}
	public ProductEntity setDescription(String description) 
	{
		if (!StringUtils.equals(this.description, description)) 
		{
			this.description = description;
			this.propertyChanged(ProductFieldNames.DESCRIPTION);
		}
		
		return this;
	}
	
	public Product synchronize(Product apiProduct) 
	{
		this.setQuantity(apiProduct.getQuantity());
		this.setLookupCode(apiProduct.getLookupCode());
		this.setName(apiProduct.getName());
		this.setPrice(apiProduct.getPrice());
		this.setActive(apiProduct.getActive());
		this.setDescription(apiProduct.getDescription());
		
		apiProduct.setCreatedOn(this.createdOn);
		
		return apiProduct;
	}
	
	public ProductEntity() 
	{
		super(new ProductRepository());
		
		this.quantity = -1;
		this.lookupCode = StringUtils.EMPTY;
		this.createdOn = LocalDateTime.now();
		this.name = StringUtils.EMPTY;
		this.price = 0.00;
		this.active = false;
		this.description = StringUtils.EMPTY;		
	}
	
	public ProductEntity(UUID id) 
	{
		super(id, new ProductRepository());
		
		this.quantity = -1;
		this.lookupCode = StringUtils.EMPTY;
		this.createdOn = LocalDateTime.now();
		this.name = StringUtils.EMPTY;
		this.price = 0.00;
		this.active = false;
		this.description = StringUtils.EMPTY;
	}

	public ProductEntity(Product apiProduct) 
	{
		super(apiProduct.getId(), new ProductRepository());
		
		this.quantity = apiProduct.getQuantity();
		this.lookupCode = apiProduct.getLookupCode();
		this.createdOn = LocalDateTime.now();
		this.name = apiProduct.getName();
		this.price = apiProduct.getPrice();
		this.active = apiProduct.getActive();
		this.description = apiProduct.getDescription();
	}
}
