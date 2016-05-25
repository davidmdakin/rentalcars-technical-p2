import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import RestExercise.Car;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

public class RestExerciseTest {
    
    @Test
    public void testExerciseList()
    {
    	try {
			String jsonString = IOUtils.toString(new URL("http://localhost:8080"), (Charset) null);
			assertTrue(jsonString.length() > 0);
			try {
			    new JsonParser().parse(jsonString);
			    JsonElement jelement = new JsonParser().parse(jsonString);
			    JsonArray jarray = jelement.getAsJsonArray();
			    for (int i = 0; i < jarray.size(); i++)
			    {
			    	JsonObject jobject = jarray.get(i).getAsJsonObject();
			    	String id = jobject.get("id").toString();
			    	assertTrue(id.equals(Integer.toString(i+1)));
			    	String name = jobject.get("name").getAsString();
			    	assertTrue(name.equals("Exercise " + Integer.toString(i+1)));
			    	jelement = jobject.get("exerciseOutput");
			    	Type listType = new TypeToken<List<String>>() {}.getType();
			    	List<String> jlist = new Gson().fromJson(jelement, listType);
			    	assertTrue(jlist.size() > 0);
			    }
			    
			} catch (JsonParseException e) {
			    fail("JsonParseException: " + e.getMessage());
			}
    	} catch (MalformedURLException e) {
			e.printStackTrace();
			fail("MalformedURLException: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			fail("IOException: " + e.getMessage());
		}
    }
    
    @Test
    public void testExercise()
    {
    	try {
    		
			String jsonString = IOUtils.toString(new URL("http://localhost:8080/1"), (Charset) null);
			assertTrue(jsonString.length() > 0);
			try {
			    new JsonParser().parse(jsonString);
			    JsonElement jelement = new JsonParser().parse(jsonString);
			    JsonObject jobject = jelement.getAsJsonObject();
			    String id = jobject.get("id").toString();
			    assertEquals(id, "1");
			    String name = jobject.get("name").getAsString();
			    assertEquals(name, "Exercise 1");
			    jelement = jobject.get("exerciseOutput");
		    	Type listType = new TypeToken<List<String>>() {}.getType();
		    	List<String> jlist = new Gson().fromJson(jelement, listType);
		    	assertTrue(jlist.size() > 0);
			} catch (JsonParseException e) {
			    fail("JsonParseException: " + e.getMessage());
			}
    	} catch (MalformedURLException e) {
			e.printStackTrace();
			fail("MalformedURLException: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			fail("IOException: " + e.getMessage());
		}
    }
    
    @Test
    public void testInvalidExercise()
    {
    	String url = "http://localhost:8080/5";
    	try {
			String jsonString = IOUtils.toString(new URL(url), (Charset) null);
    	} catch (MalformedURLException e) {
			e.printStackTrace();
			fail("MalformedURLException: " + e.getMessage());
    	} catch (FileNotFoundException e) {
    		assertEquals(e.getMessage(), url);
		} catch (IOException e) {
			e.printStackTrace();
			fail("MalformedURLException: " + e.getMessage());
		}
    }
}
