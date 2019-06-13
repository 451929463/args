package cn.tri.args;

public class ModelAnalyze {
	private String message = "";
	private String fullArgs = "";
	private boolean flag = false;
	private String result = "";
	private String[] models = new String[5];
	private String[] fullArg = new String[5];
	
	public ModelAnalyze(String[] model,String args){
		firstSame(model,args);
		fullArg = fullArgs.split(" ");
		if(fullArg.length == models.length){
			argsLengthSame();
		}else if(fullArg.length < models.length){
			errorArgs();
			complementArgs();
		}else{
			message = "您输入的命令过长，不符合";
		}
	}
		
	

		
	@Override
	public String toString() {
		if(message.isEmpty()){
			return result ;
		}
		return message ;
	}
	//任何命令格式首项必须为l或则-l
	private void firstSame(String[] model,String args){
		if(model.length % 2 != 0){
			if(model[0].equals("l") || model[0].equals("-l")){
				models = model;
				if(args.split(" ")[0].equals("l") || args.split(" ")[0].equals("-l")){
					fullArgs = args;
				}else{
					fullArgs = "l " + args;
				}
			}else{
				message = "您输入的命令行不能识别,请“l 或   -l”输入";
			}
		}else{
			fullArgs = "l " + args;
			for (int i = 0; i < model.length; i++) {
				models[0] = "l";
				models[i+1] = model[i];
			}
		}
	}
	//model长度 与 执行命令长度一样长
	private void argsLengthSame() {
		if(fullArg.length == models.length){
			if(fullArg[1].equals(models[1]) && fullArg[3].equals(models[3])){
				isType(models[2], fullArg[2]);
				isType(models[4], fullArg[4]);
				result = fullArgs;
			}else{
				this.message = "您输入的命令行不能识别";
			}
		}
	}
	//验证错误命令
	private void errorArgs() {
		if(fullArg.length != 2){
			for (int i = 1; i < fullArg.length; i += 2) {
				for (int j = 1; j < models.length; j += 2) {
					if(fullArg[i].equals(models[j])){
						flag =true;
					}
				}
				if(!flag){
					message = "输入错误命令";
				}
			}
		}
	}
	//补全命令
	private void complementArgs() {
		// parameter 1 
		flag = false;
		System.out.println(fullArg[0]);
		result += fullArg[0];
		for (int i = 1; i < models.length; i += 2) {
			for (int j = 1; j < fullArg.length; j += 2) {
				if(fullArg[j].equals(models[i])){
					isType(models[i+1], fullArg[j+1]);
					result += " "+fullArg[j]+" "+fullArg[j+1];
					flag = true;
					continue;
				}
			}
			//parameter n
			if(!flag){
				result +=" "+ models[i] +" "+getDefault(models[i+1]);
			}
			flag = false;
		}
		
	}
	
	private void isType(String type , String value){
		try {
				switch (type) {
				case "Integer":
					Integer.valueOf(value);
					break;
				case "String":
					String.valueOf(value);
					break;
				case "List<Integer>":
					 String[] ints = value.split(",");
					 for(int i = 0 ; i < ints.length ; i++){
						 Integer.valueOf(ints[i]);
					 }
					 break;
				case "List<String>":
					 String[] strs = value.split(",");
					 for(int i = 0 ; i < strs.length ; i++){
						 String.valueOf(strs[i]);
					 }
					 break;
				default:
					message = "无对应命令模板支持";
					break;
			}
		} catch (Exception e) {
			message = "与模板定义的参数类型不匹配";
		}
	}
	private Object getDefault(String type) {
			switch (type) {
			case "Integer":
				return 0;
				
			case "String":
				return "";
				
			case "List<Integer>":
				return null;
				
			default:
				return null;
		}
	}
}
