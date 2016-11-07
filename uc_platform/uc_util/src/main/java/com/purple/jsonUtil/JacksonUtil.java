package com.purple.jsonUtil;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("deprecation")
public class JacksonUtil {
	private static ObjectMapper objectMapper = null;
	private static JsonGenerator jsonGenerator = null;
	private static StringWriter stringWriter = null;
	static {
		objectMapper = new ObjectMapper();
		stringWriter = new StringWriter();
		try {
			jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(stringWriter);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String entityConvertJSON(Object entity) throws IOException {
		stringWriter.close();
		stringWriter.flush();
		jsonGenerator.writeObject(entity);
		return stringWriter.toString();
	}

	public static String mapConvertJSON(Map<String, String> date)
			throws JsonGenerationException, JsonMappingException, IOException {
		objectMapper.writeValue(stringWriter, date);
		stringWriter.close();
		stringWriter.flush();
		return stringWriter.toString();
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object jsonConvertEntity(String json,Class class1) throws JsonParseException, JsonMappingException, IOException{
		return	objectMapper.readValue(json, class1);
	}
	
	@SuppressWarnings("unchecked")
	public static Map<Object, Object> jsonConvertMap(String json) throws JsonParseException, JsonMappingException, IOException{
		Map<Object, Object> result =objectMapper.readValue(json, Map.class);
		return result;
	}

}
