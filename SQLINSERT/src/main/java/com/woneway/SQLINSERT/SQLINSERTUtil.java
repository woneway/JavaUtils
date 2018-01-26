package com.woneway.SQLINSERT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SQLINSERTUtil {
	
	//生成SQL语句
	public  String SQL(String database,String tablename,List<String> ...lists){
		int size = lists.length;
		if(size<2) return "";
    	StringBuffer sb = new StringBuffer("INSERT INTO `"+database+"`.`"+tablename+"`\n(");
    	//lists[0]:字段名
    	for(String fieldname : lists[0]){
    		sb.append("`"+fieldname+"`,");
    	}
    	sb.replace(sb.length()-1, sb.length(), ") VALUES \n");
    	for(int i = 0;i<150;i++){
    		sb.append("(");
    		for(int j = 1;j < size;j++){
    			String str = lists[j].get(i);
    			if(!str.equals("\"\"")&&!str.equals("0")&&!str.equals("1"))
    				sb.append("'"+str+"',");
    			else if(str.equals("\"\"")){
    				sb.append("'',");
    			}else if(str.equals("0")) sb.append("0,");
    			else sb.append("1,");
    		}
    		sb.replace(sb.length()-1, sb.length(), "),\n");
    	}
    	
    	sb.replace(sb.length()-2, sb.length()-1, ";");
        System.out.println(sb.toString());
    	return sb.toString();
    }
	
	//读取文本
    public  List<String> getText(String pathname) throws IOException
    {
  	  	File filename = new File(pathname); // 要读取以上路径的pathname文件  
        InputStreamReader reader = new InputStreamReader(  
                new FileInputStream(filename)); // 建立一个输入流对象reader  
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
        String line = "";  
        line = br.readLine();
        List<String> list = new ArrayList<String>();
        while (line != null) {  
      	  //System.out.println(line);
      	  list.add(line);
          line = br.readLine(); // 一次读入一行数据  
        }    
  	  	//System.out.println(list);
        return list;
    }

    //写入sql文本
    public  void InsertSQL(String sql,String pathname) throws IOException{
    	File writename = new File(pathname); 
        writename.createNewFile(); // 创建新文件  
        BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
        out.write(sql); // \r\n即为换行  
        out.flush(); // 把缓存区内容压入文件  
        out.close(); // 最后记得关闭文件  
    }
}
