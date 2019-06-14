package cn.tri.args;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.validation.Schema;

public class Parser {
	private List arguments = null;
	public Parser(Schema schema,String inputText){
		arguments = new ArrayList<>();
		Matcher m = Pattern.compile("(-[a-z] [^-]*)").matcher(inputText);
		while (m.find()) {
			//arguments.add(new Argument(m.group(1),schema));
			System.out.println(m.group(1));
		}
	}
}
