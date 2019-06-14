package cn.tri.args;

import java.util.Map;

public class Args {
	private Map<String,String> map = null ;
	public Args(Schema schema , String ArgsAsText) {
		this.map = schema.matchingByArgs(ArgsAsText);
	}
	public String getValue(String flagName) {
		return map.get(flagName);
	}
}
