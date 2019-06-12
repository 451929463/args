package cn.tri.args;

import java.util.Scanner;

public class Args {
	
	public String inputString() {
		System.out.println("请输入指令: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(str+"---show");
		String xx = checkInputString(str);
		System.out.println(xx);
		return xx;
	}
	
	private String checkInputString(String str) {
		if(str.isEmpty()){
			return "";
		}
		String[] strs = str.split(" ");
		System.out.println(strs.length+"==============");
		if(strs.length == 1){
			switch (strs[0]) {
			case "l": return "l p 0 d";
			case "-l": return "-l p 0 d";
			case "p": return "l p 0 d";
			case "d": return "l p 0 d";
			default:
				return "您的指令有误,请按此格式输入1";
			}
		}
		
		if(strs.length == 2){
			if(!strs[0].equals("l") && !strs[0].equals("-l") && !strs[0].equals("p") && !strs[0].equals("d")){
				return "您的指令有误,请按此格式输入2";
			}
			if(strs[0].equals("l") || strs[0].equals("-l")){
				if(strs[1].equals("p") || strs[1].equals("d")){
					return strs[0]+" p 0 d";
				}else{
					return "您的指令有误,请按此格式输入1";
				}
			}
				
			if(strs[0].equals("p") && strs[1].equals("d")){
				return "l p 0 d";
			}else if(strs[0].equals("p")){
				return "l p "+strs[1]+" d";
			}
			
			if(strs[0].equals("d")){
				return "l p 0 "+strs[0]+" "+strs[1];
			}
			
		}
		return "";
	}
}
