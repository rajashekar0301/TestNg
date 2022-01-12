package ecommerce.products.API;

import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_Update_user_details {
	
//	@Test
	public void customerUpdate()
	{
		String id =Test_api_list_users.createUser();
//		String id=createUser();
		//BaseUrl
		String url=RestAssured.baseURI="https://reqres.in/api/users/"+id+"";
		
		//Body
		RequestSpecification api=RestAssured.given();
		 
		
		System.out.println("BaseUrl :"+ url);
		//sending request to server
		
		JSONObject requestparam = new JSONObject();
		requestparam.put("name", "peter");
		requestparam.put("job", "zion resident");
		api.header("content-Type","application/json");
		api.body(requestparam.toJSONString());
		Response response =api.request(Method.PUT);
		
		
		String responsebody =response.getBody().asString();
		System.out.println(responsebody);
		int statusCode =response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}
	
	
	@Test
	public void ListUsers()
	{
		String url=RestAssured.baseURI="https://reqres.in/api/users";
		
		//Body
		RequestSpecification api=RestAssured.given().queryParam("page=2");
		
		System.out.println("BaseUrl :"+ url);
		//sending request to server
		
		Response response =api.request(Method.GET);
		
		
		String responsebody =response.getBody().asString();
		System.out.println(responsebody);
		int statusCode =response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		JsonPath jsonpathevalutor =response.jsonPath();
		List<String> emails =jsonpathevalutor.getList("data.email");
		System.out.println(emails.get(1));
		
		for (String email : emails) {
			System.out.println("Email :"+ email);
		}
	}

}
