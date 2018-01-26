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

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	String pathname = "E:\\workspace\\ww\\SQLINSERT\\src\\main\\source\\";   
    	List<String> list_stuid = getText(pathname+"stuid"),
	    			 list_name = getText(pathname+"name"),
	    			 list_profession = getText(pathname+"profession"),
	    			 list_date = getText(pathname+"date"),
	    			 list_sex = getText(pathname+"sex"),
	    			 list_idnum = getText(pathname+"idnum");
    	String sql = SQL(list_stuid,list_name,list_profession,list_date,list_sex,list_idnum);
    	InsertSQL(sql);
    }
    
    public static String SQL(List<String> ...lists){
    	StringBuffer sb = new StringBuffer("INSERT INTO `studentmanage`.`StudentInfo`\n");
    	sb.append("(`StuID`, `StuName`, `Profession`, `Date`, `Sex`, `IDNum`, `TotalScore`, `Note`) VALUES \n");
    	for(int i = 0;i<150;i++){
    		sb.append("('"+lists[0].get(i)+"',");
    		sb.append("'"+lists[1].get(i)+"',");
    		sb.append("'"+lists[2].get(i)+"',");
    		sb.append("'"+lists[3].get(i)+"',");
    		sb.append("'"+lists[4].get(i)+"',");
    		sb.append("'"+lists[5].get(i)+"',");
    		sb.append("0,");
    		sb.append("''),\n");
    	}
    	sb.replace(sb.length()-2, sb.length()-1, ";");
    	return sb.toString();
    }
    
    //读取文本
    public static List<String> getText(String pathname) throws IOException
    {
  	  	File filename = new File(pathname); // 要读取以上路径的input。txt文件  
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
    public static void InsertSQL(String sql) throws IOException{
    	File writename = new File("E:\\workspace\\ww\\SQLINSERT\\src\\main\\source\\result.sql"); 
        writename.createNewFile(); // 创建新文件  
        BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
        out.write(sql); // \r\n即为换行  
        out.flush(); // 把缓存区内容压入文件  
        out.close(); // 最后记得关闭文件  
    }
}
