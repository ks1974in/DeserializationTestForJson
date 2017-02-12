package in.cloudnine.inventory.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;

import in.cloudnine.nanoerp.model.inventory.LineItemExternal;
import in.cloudnine.nanoerp.model.inventory.StoresVoucherExternal;
import in.cloudnine.webservices.client.WebServiceResponse;
import in.cloudnine.webservices.client.WebServiceResponseArrayImpl;

public class TestSerializationAndDeserialization {
	private static Logger logger=Logger.getLogger("TestSerializationAndDeserialization");
	private StoresVoucherExternal createStoresVoucherExternalInstance(){
		StoresVoucherExternal voucher=new StoresVoucherExternal();
		voucher.setDate(new Date());
		voucher.setReferenceDate(new Date());
		voucher.setReferenceNumber("IN-123");
		voucher.setStoresVoucherExternalId(UUID.randomUUID().toString());
		voucher.getLineItemExternals().add(createLineItemExternalInstance(voucher,1));
		voucher.getLineItemExternals().add(createLineItemExternalInstance(voucher,2));
		voucher.getLineItemExternals().add(createLineItemExternalInstance(voucher,3));
		voucher.getLineItemExternals().add(createLineItemExternalInstance(voucher,4));
		voucher.getLineItemExternals().add(createLineItemExternalInstance(voucher,5));
		
		
		return voucher;
	}
	
	private LineItemExternal createLineItemExternalInstance(StoresVoucherExternal voucher,int serialNumber){
		LineItemExternal item=new LineItemExternal();
		Random random=new Random();
		item.setSerialNumber(String.valueOf(serialNumber));
		item.setBags(random.nextInt());
		item.setKgs(BigDecimal.valueOf(random.nextDouble()));
		item.setLineItemExternalId(UUID.randomUUID().toString());
		item.setManufacturerBatchNumber("#44");
		item.setRate(BigDecimal.valueOf(200));
		item.setSubtotal(item.getKgs().multiply(item.getRate()));
		item.setStoresVoucherExternal(voucher);
		return item;
	}
	@Test
	public void test() {
		try{
		StoresVoucherExternal voucher=createStoresVoucherExternalInstance();
		ObjectMapper mapper=new ObjectMapper();
		mapper.enableDefaultTyping(DefaultTyping.NON_CONCRETE_AND_ARRAYS);
		String json=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(voucher);
		//logger.log(Priority.INFO,json);
		StoresVoucherExternal readValue=mapper.readValue(json,StoresVoucherExternal.class);
		assertEquals(voucher,readValue);
		}
		catch(JsonProcessingException e){
			e.printStackTrace();
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	@Test
	public void testArrays(){
		try{
			StoresVoucherExternal voucher=createStoresVoucherExternalInstance();
			ObjectMapper mapper=new ObjectMapper();
			mapper.enableDefaultTyping(DefaultTyping.NON_CONCRETE_AND_ARRAYS);
			String json=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(voucher.getLineItemExternals().toArray(new LineItemExternal[]{}));
			//logger.log(Priority.INFO,json);
			LineItemExternal[] readValue=mapper.readValue(json,LineItemExternal[].class);
			assertEquals(readValue.length,5);
			assertEquals(voucher.getLineItemExternals().toArray(new LineItemExternal[]{}),readValue);
			logger.info("OK");
			for(Object item:readValue){
				
			logger.log(Priority.INFO,item.getClass()+item.toString());
				
			}
			
			}
			catch(JsonProcessingException e){
				e.printStackTrace();
				
			}
			catch(IOException e){
				e.printStackTrace();
			}
	}
	@Test
	public void testArraysWithWrapper(){
		try{
			StoresVoucherExternal voucher=createStoresVoucherExternalInstance();
			ObjectMapper mapper=new ObjectMapper();
			mapper.enableDefaultTyping(DefaultTyping.NON_CONCRETE_AND_ARRAYS);
			
			WebServiceResponse response=new WebServiceResponseArrayImpl(voucher.getLineItemExternals().toArray(new LineItemExternal[]{}));
			String json=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
			//logger.log(Priority.INFO,json);
			WebServiceResponse readResponse=mapper.readValue(json,WebServiceResponse.class);
			Serializable[] readValue=(Serializable[])readResponse.getData();
			assertEquals(readValue.length,5);
			//assertEquals(voucher.getLineItemExternals().toArray(new LineItemExternal[]{}),readValue);
			logger.info("OK");
			for(Serializable item:readValue){
				
			logger.log(Priority.INFO,item.getClass()+item.toString());
				
			}
			
			}
			catch(JsonProcessingException e){
				e.printStackTrace();
				
			}
			catch(IOException e){
				e.printStackTrace();
			}
	}
	@Test
	public void testWithFile(){
		try{
			
			File file=new File("/home/sagar/json/input.json");
			FileReader reader=new FileReader(file);
			BufferedReader b=new BufferedReader(reader);
			StringBuilder builder=new StringBuilder();
			while(b.ready()){
			builder.append(b.readLine());	
			}
			String json=builder.toString();
			ObjectMapper mapper=new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
			mapper.configure(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS,true);
			mapper.enableDefaultTyping(DefaultTyping.NON_CONCRETE_AND_ARRAYS);
			
			WebServiceResponse readResponse=mapper.readValue(json,WebServiceResponse.class);
			Serializable[] readValue=(Serializable[])readResponse.getData();
			assertEquals(readValue.length,3);
			//assertEquals(voucher.getLineItemExternals().toArray(new LineItemExternal[]{}),readValue);
			logger.info("OK");
			for(Serializable item:readValue){
				
			logger.log(Priority.INFO,item.getClass()+item.toString());
			assertEquals(LineItemExternal.class,item.getClass());
				
			}
			
			
		}
	
	catch(FileNotFoundException e){
		e.printStackTrace();
	}
	catch(JsonProcessingException e){
		e.printStackTrace();
		
	}
	catch(IOException e){
		e.printStackTrace();
	}
}
	

}
