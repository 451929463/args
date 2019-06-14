package cn.tri.args;

import java.util.HashMap;
import java.util.Map;

public class Schema {
	private String[] SchemaArray = null;
	public Schema(String SchemaAsText){
		this.SchemaArray = SchemaAsText.split(" ");
	}
	
	public Map<String,String> matchingByArgs(String ArgsAsText){
		Map<String,String> map = new HashMap<>();
		System.out.println(SchemaArray);
		String[] ArgsArray = ArgsAsText.split(" ");
		for (int i = 0; i < ArgsArray.length; i++) {
			for (int j = 0; j < SchemaArray.length; j++) {
				String[] temps = SchemaArray[j].split(":");
				if(ArgsArray[i].equals(temps[0])){
					System.out.println(temps[1]+"===>>>"+ArgsArray[i]);
					switch (temps[1]) {
					case "Integer":
						if(ArgsArray[i+1] == null || ArgsArray[i+1]==""){
							map.put(ArgsArray[i],"0");
							return map;
						}
						map.put(ArgsArray[i], ArgsArray[i+1]);
						return map;
					case "String":
						if(ArgsArray[i+1] == null || ArgsArray[i+1]==""){
							map.put(ArgsArray[i],"");
							return map;
						}
						map.put(ArgsArray[i], ArgsArray[i+1]);
						return map;
					default:
						break;
					}
				}
			}
			
		}
		return null;
		
	}
}
