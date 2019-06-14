package cn.tri.args;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
public class TestParser {
	//@Test
	public void test1(){
		Pattern p = Pattern.compile("a*b");
		System.out.println(p);
		Matcher m = p.matcher("abbbbb");
		System.out.println(m);
		boolean flag = m.matches();
		System.out.println(flag);
	}
	
	@Test
	public void test2(){
		String ArgsAsText = "-l p 8080 d user/log";
		String[] argsAsArray= ArgsAsText.split(" ");
		String SchemaAsText = "l:boolean p:Integer d:String";
		Schema schema = new Schema(SchemaAsText);
	    Args args = new Args(schema ,"-l");
	    assertThat(new Args(schema ,ArgsAsText).getValue("p"), is("8080"));
	    assertThat(new Args(schema ,ArgsAsText).getValue("d"), is("user/log"));
	}
}
