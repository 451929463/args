package cn.tri.args;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
public class TestArgsSchema {
	@Test
	public void should_show_l_Schema(){
		assertThat(new ArgsSchema().toString(), is("false p 0 d "));
		assertThat(new ArgsSchema("-l").toString(), is("true p 0 d "));
		assertThat(new ArgsSchema("l").toString(), is("false p 0 d "));
		assertThat(new ArgsSchema("q").toString(), is("您输入的命令行不能识别,请按“l p ? d ?”结构输入"));
	}
	@Test
	public void should_show_l_p_schema(){
		assertThat(new ArgsSchema("l p 8080").toString(), is("false p 8080 d "));
		assertThat(new ArgsSchema("-l p 8080").toString(), is("true p 8080 d "));
		assertThat(new ArgsSchema("-l p zzz").toString(), is("您输入的命令端口有误，请重新输入!"));
		assertThat(new ArgsSchema("-l x zzz").toString(), is("您输入的命令行不能识别,请按“l p ? d ?”结构输入"));
	}
	@Test
	public void should_show_l_d_schema(){
		assertThat(new ArgsSchema("-l d /user/log").toString(), is("true p 0 d /user/log"));
		assertThat(new ArgsSchema("l d /user/log").toString(), is("false p 0 d /user/log"));
		assertThat(new ArgsSchema("l x /user/log").toString(), is("您输入的命令行不能识别,请按“l p ? d ?”结构输入"));	
	}
	@Test
	public void should_show_l_p_d_schema(){
		assertThat(new ArgsSchema("-l p 3030 d usr/message").toString(), is("true p 3030 d usr/message"));
		assertThat(new ArgsSchema("l p 3030 d usr/message").toString(), is("false p 3030 d usr/message"));
		assertThat(new ArgsSchema("l d usr/message c d").toString(), is("您输入的命令行不能识别,请按“l p ? d ?”结构输入"));
		assertThat(new ArgsSchema("l d usr/message d ccc").toString(), is("您输入的命令行不能识别,请按“l p ? d ?”结构输入"));
	}
	@Test
	public void should_show_other_schema(){
		assertThat(new ArgsSchema("l p d x").toString(), is("您输入的命令行不能识别,请按“l p ? d ?”结构输入"));
		assertThat(new ArgsSchema("p d x d d").toString(), is("您输入的命令行不能识别,请按“l p ? d ?”结构输入"));
		
	}
	@Test
	public void should_show_p_schema(){
		assertThat(new ArgsSchema("p 50").toString(), is("false p 50 d "));
		assertThat(new ArgsSchema("l d ").toString(), is("您输入的命令行不能识别,请按“l p ? d ?”结构输入"));
	}
	@Test
	public void should_show_d_schema(){
		assertThat(new ArgsSchema("d ccc50").toString(), is("false p 0 d ccc50"));
		assertThat(new ArgsSchema("l d ").toString(), is("您输入的命令行不能识别,请按“l p ? d ?”结构输入"));
	}
	@Test
	public void should_show_p_d_schema(){
		assertThat(new ArgsSchema("p 50 d ccc50").toString(), is("false p 50 d ccc50"));
		assertThat(new ArgsSchema("l d ").toString(), is("您输入的命令行不能识别,请按“l p ? d ?”结构输入"));
	}
}
