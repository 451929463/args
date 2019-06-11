package cn.tri.args;
import java.util.Scanner;

public class ArgsRefactoring {
	
	public String inputString() {
		System.out.println("请输入指令: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(checkInputString(str));
		return checkInputString(str);
	}
	
	private String checkInputString(String str) {
		if(str.isEmpty()){
			return "请输入指令: ";
		}
		String[] strs = str.split(" ");
		
		if(strs.length == 1){
			//-----2
			if(strs[0].equals("-g") || strs[0].equals("-d")){
				return "-g -d";
			}
			//-----2
			if(strs[0].equals("l") || strs[0].equals("-l")){
				return strs[0]+" p 0 d";
			}
			if(strs[0].equals("p") || strs[0].equals("d")){
				return "l p 0 d";
			}
			return "您的指令有误,请按此格式输入1";
		}
		
		if(strs.length == 2){
			//-----------2
			if(strs[0].equals("-g")){
				if(strs[1].equals("-d")){
					return str;
				}
				return "-g "+strs[1];
			}
			
			if(strs[0].equals("-d") && isNumberArray(strs[1])){
				return str;
			}
			//------------2
			if(strs[0].equals("l") || strs[0].equals("-l")){
				if(strs[1].equals("p") || strs[1].equals("d")){
					return strs[0]+" p 0 d";
				}
			}
			if(strs[0].equals("p")){
				if(strs[1].equals("d")) {
					return "l p 0 d";
				}
				if(isNumberPort(strs[1])){
					return "l p "+strs[1]+" d";
				}else{
					return "您输入的命令中,端口号有误";
				}
			}
			
			if(strs[0].equals("d")){
				return "l p 0 d "+strs[1];
			}
			return "您的指令有误,请按此格式输入2";
		}
		
		
		if(strs.length == 3){
			//----------------------3
			if(strs[0].equals("-g")){
				if(strs[2].equals("-d")){
					return str;
				}
				if(strs[1].equals("-d") && isNumberArray(strs[2])){
					return str;
				}
			}
			//----------------------3
			if(strs[0].equals("l") || strs[0].equals("-l") ){
				if(strs[1].equals("p") && isNumberPort(strs[2])){
					return str + " d";
				}
				if(strs[1].equals("p") && strs[2].equals("d")){
					return strs[0]+" p 0 d";
				}
				if(strs[1].equals("d")){
					return strs[0]+" p 0 d "+strs[2];
				}
			}
			if(strs[0].equals("p")){
				if(isNumberPort(strs[1]) && strs[2].equals("d")){
					return "l "+str;
				}
				if(strs[1].equals("d")){
					return "l p 0 "+strs[1]+" "+strs[2];
				}
			}
			return "您的指令有误,请按此格式输入3";
		}
		
		if(strs.length == 4){
			//--------------------4
			if(strs[0].equals("-g") && strs[2].equals("-d") && isNumberArray(strs[3])){
				return str;
			}
			//----------------------4
			if(strs[0].equals("l") || strs[0].equals("-l")){
				if(strs[1].equals("p") && isNumberPort(strs[2]) && strs[3].equals("d")){
					return str;
				}
				if(strs[1].equals("p") && strs[3].equals("d")){
					return strs[0]+"p 0 "+strs[1]+" "+strs[1];
				}
			}
			if(strs[0].equals("p") && isNumberPort(strs[1]) && strs[2].equals("d")){
				return "l "+str;
			}
			return "您的指令有误,请按此格式输入4";
		}
		
		if(strs.length == 5){
			if(strs[0].equals("l") || strs[0].equals("-l")){
				if(strs[1].equals("p") && isNumberPort(strs[2]) && strs[3].equals("d")){
					return str;
				}
			}
			return "您的指令有误,请按此格式输入5";
		}
		boolean is = strs[0].equals("l") || strs[0].equals("-l");
		return "您的指令有误,请按此格式输入>5";
	}
	
	
	private boolean isNumberPort(String port){
		try {
			if(Integer.valueOf(port) instanceof Integer){
				return true;
			}
			return false;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	private boolean isNumberArray(String arr){
		boolean flag = false;
		String[] arrs = arr.split(",");
		for (int i = 0; i < arrs.length; i++) {
			flag = isNumberPort(arrs[i]);
		}
		return flag;
	}
	
	private boolean isEquals_l_or_ul(String string){
		return string.equals("l") || string.equals("-l") ;
	}
}
