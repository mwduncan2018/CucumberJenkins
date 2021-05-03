package duncan.cucumberjenkins.safeflightautoframe.api;

import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class WatchListApi {
	{
		RestAssured.baseURI = "http://localhost:60030/api";		
	}
	
	@SuppressWarnings("unchecked")
	public static void postEntry(String firstName, String lastName, Integer bounty) {
		JSONObject postJson = new JSONObject();
		{
			postJson.put("FirstName", firstName);
			postJson.put("LastName", lastName);
			postJson.put("Bounty", bounty);
		}
		
		RestAssured.given()
			.header("Content-Type", "application/json")
			.body(postJson.toJSONString())
			.when()
			.post("/watchlist/post")
			.then()
			.assertThat()
			.statusCode(201);
	}
	
	public static void deleteEntry(String firstName, String lastName) {
		RestAssured.given()
			.header("Content-Type", "application/json")
			.queryParam("firstName", firstName)
			.queryParam("lastName", lastName)
			.when()
			.delete("/watchlist/delete");
	}
	
	public static boolean verifyEntryExists(String firstName, String lastName) {
		String getJson = RestAssured.given()
			.header("Content-Type", "application/json")
			.when()
			.get("/watchlist")
			.getBody()
			.asString();
		
		Map<String, ?> result =
			JsonPath.from("\"Object\":" + getJson + "}")
			.get("Object.find { x -> x.FirstName == '" + firstName + "' && x.LastName == '" + lastName + "' }");
			
		if (result != null) {
			return true;
		}
		return false;
	}
	
	
}
