package ecommerce.products.API;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_api_list_users {
	
	@Test
	public void getUsers()
	
	{
		String id=createUser();
		//BaseUrl
		String url=RestAssured.baseURI="https://reqres.in/api/users/"+id+"";
		
		//Body
		RequestSpecification api=RestAssured.given();
		
		System.out.println("BaseUrl :"+ url);
		//sending request to server
		
		JSONObject requestparam = new JSONObject();
		requestparam.put("name", "restAssured");
		api.header("content-Type","application/json");
		api.body(requestparam.toJSONString());
		Response response =api.request(Method.PATCH);
		
		
		String responsebody =response.getBody().asString();
		System.out.println(responsebody);
		int statusCode =response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}

	public static String createUser() {
			
		RestAssured.baseURI="https://reqres.in";
		
		
		RequestSpecification request =RestAssured.given();
		
		//BodyJson data
		JSONObject requestBody =new JSONObject();
		requestBody.put("name", "Raj11");
		requestBody.put("job", "leader111");
		request.body(requestBody.toJSONString());
		
		request.header("content-Type","application/json");
		
		Response response =request.request(Method.POST,"/api/users");
		String responseBody =response.getBody().asString();
		System.out.println(responseBody);
		String customerID = response.jsonPath().get("id");
		
		System.out.println("Cusomer ID is : " + customerID);
		
		return customerID;
		
		
		
		
	}
	
	

}
