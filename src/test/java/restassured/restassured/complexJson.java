package restassured.restassured;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class complexJson {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		// TODO Auto-generated method stub
		
		//Jackson dependency
		ObjectMapper map=new ObjectMapper();
		employee[] empList=map.readValue(new File("src/main/java/resources/emp.json"),employee[].class);
			
		for(employee e1: empList)
			System.out.println("id:"+e1.getId() +"\tcity:"+e1.getCity() + "\tname:"+e1.getName() );
		
		System.out.println("****City updated for second json object *******");
		empList[1].setCity("Mumbai");
		
		for(employee e1: empList)
			System.out.println("id:"+e1.getId() +"\tcity:"+e1.getCity() + "\tname:"+e1.getName() );
		
		RestAssured.given().log().all().body(empList).post();
	}
}

