package cn.tri.args;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class TestModelAnalyze {
	@Test
	public void TestModel_1(){
		String[] model = {"l","p","Integer","d","String"};
		assertThat(new ModelAnalyze(model,"l").toString(), is("l p 0 d "));
		assertThat(new ModelAnalyze(model,"p 0").toString(), is("l p 0 d "));
		assertThat(new ModelAnalyze(model,"d /user/log").toString(), is("l p 0 d /user/log"));
		assertThat(new ModelAnalyze(model,"p 8080 ").toString(), is("l p 8080 d "));
		assertThat(new ModelAnalyze(model,"p 80x").toString(), is("与模板定义的参数类型不匹配"));
		assertThat(new ModelAnalyze(model,"q /user/log").toString(), is("输入错误命令"));
		assertThat(new ModelAnalyze(model,"x 80x").toString(), is("输入错误命令"));
		assertThat(new ModelAnalyze(model,"p ccc d /user/log").toString(), is("与模板定义的参数类型不匹配"));
		assertThat(new ModelAnalyze(model,"d 8080 p /user/log").toString(), is("您输入的命令行不能识别"));
		assertThat(new ModelAnalyze(model,"p 8080 d /user/log").toString(), is("l p 8080 d /user/log"));
	}
	@Test
	public void TestModel2(){
		String[] model = {"-g","List<String>","-d","List<Integer>"};
		assertThat(new ModelAnalyze(model,"-g aa,bb,cc -d 11,22,33").toString(), is("l -g aa,bb,cc -d 11,22,33"));
		assertThat(new ModelAnalyze(model,"-g aa,bb,cc -d 11,22,33").toString(), is("l -g aa,bb,cc -d 11,22,33"));
		
	}
}
