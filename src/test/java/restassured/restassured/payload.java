package restassured.restassured;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
public class payload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			employee emp1=new employee(1,"ram","bangalore");

			employee emp2=new employee(2,"lisa","delhi");
	
			List<employee> payload=new ArrayList<employee>();
			payload.add(emp1);
			payload.add(emp2);
			
			for(int i=0;i<payload.size();i++)
			{
				System.out.println(payload.get(i).getCity());
			}

			RestAssured.given().log().all().body(payload).when().get();
	}

}
