package cn.tri.args;

public class ArgsSchema {
	private boolean args_l = false;
	private String args_p = " p ";
	private int port = 0;
	private String args_d = " d ";

	private String message = "";
	String[] params = null;
	public ArgsSchema() {
		super();
	}
	public ArgsSchema(String param){
		params = param.split(" ");
		if(params.length == 1){
			string_length_1();
		}
		if(params.length == 2){
			string_length_2();
		}
		if(params.length == 3){
			string_length_1();
			string_length_3();
		}
		if(params.length == 4){
			string_length_2();
			string_length_4();
		}
		if(params.length == 5){
			string_length_1();
			string_length_3();
			string_length_5();
		}
		if(params.length > 5){
			this.message = "您输入的命令行不能识别,请按“l p ? d ?”结构输入";
		}
		
	}
	
	@Override
	public String toString() {
		if(message.isEmpty()){
			return args_l+args_p+port+args_d;
		}
		return message;
	}
	
	
	private void string_length_1(){
		if(params[0].equals("-l")){
			this.args_l = true;
		}else if(params[0].equals("l") || params[0].isEmpty()){
			this.args_l = false;
		}else{
			this.message = "您输入的命令行不能识别,请按“l p ? d ?”结构输入";
		}
	}
	
	private void string_length_3() {
		if(params[1].equals("p") ){
			if(isNumber(params[2])){
				this.port = Integer.valueOf(params[2]);
			}else{
				this.message = "您输入的命令端口有误，请重新输入!";
			}
		}else if(params[1].equals("d")){
			this.args_d += params[2];
		}else{
			this.message = "您输入的命令行不能识别,请按“l p ? d ?”结构输入";
		}
		
	}
	private void string_length_5() {
		if(params[3].equals("d") && !params[1].equals("d")){
			this.args_d += params[4];
		}else{
			this.message = "您输入的命令行不能识别,请按“l p ? d ?”结构输入";
		}
		
	}
	private void string_length_2() {
		if(params[0].equals("p")){
			if(isNumber(params[1])){
				this.port = Integer.valueOf(params[1]);
			}
		}else if(params[0].equals("d")){
				this.args_d += params[1];
		}else{
			this.message = "您输入的命令行不能识别,请按“l p ? d ?”结构输入";
		}
	}
	private void string_length_4() {
		if(params[2].equals("d") && !params[0].equals("d")){
			this.args_d += params[3];
		}
		this.message = "您输入的命令行不能识别,请按“l p ? d ?”结构输入";
	}
	
	private boolean isNumber(String str){
		try {
			return Integer.valueOf(str) instanceof Integer ;
		} catch (Exception e) {
			return false; 
		}
	}
}
