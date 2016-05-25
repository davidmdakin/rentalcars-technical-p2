import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import main.java.Car;

import static org.junit.Assert.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import org.apache.commons.io.*;

public class RestExerciseTest {
    
    @Test
    public void testJsonFromWebpage()
    {
    	try {
			String jsonString = IOUtils.toString(new URL("http://localhost:8080"), (Charset) null);
    	} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("MalformedURLException: " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("IOException: " + e.getMessage());
		}
    }
}
