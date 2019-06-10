package cn.tri.args;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
public class TestArgs {
	Args args = new Args();
	//1、测试输入
	@Test
	public void should_show_inputString() {
		assertThat(args.inputString(), is(String.class));
	}
	//2、正确
	@Test
	public void should_show_InputStringLength_by_1(){
		assertThat(args.inputString(),is(String.class));
	}
	/*@Test
	public void should_show_InputStringLength_by_2(){
		assertThat(args.inputString(),startsWith("l p 0 d"));
	}*/
	//3、缺省或错误
	//
}
