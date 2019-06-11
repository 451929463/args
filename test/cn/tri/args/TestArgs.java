package cn.tri.args;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
public class TestArgs {
	ArgsRefactoring args = new ArgsRefactoring();
	//Args args = new Args();
	//1、测试输入
	@Test
	public void should_show_inputString() {
		assertThat(args.inputString(), is(String.class));
	}
	//2、长度递增测试
	@Test
	public void should_show_InputStringLength_by_x(){
		//assertThat(args.inputString(),startsWith("l p"));
		assertThat(args.inputString(),startsWith("-g"));
	}
	
}
