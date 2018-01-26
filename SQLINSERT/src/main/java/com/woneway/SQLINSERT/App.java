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
    	String pathname = "E:\\github\\JavaUtils\\SQLINSERT\\src\\main\\source\\";   
    	SQLINSERTUtil sqlinsert = new SQLINSERTUtil();
    	List<String> list_field = new ArrayList<String>();
    	list_field.add("StuID");
    	list_field.add("StuName");
    	list_field.add("Profession");
    	list_field.add("Date");
    	list_field.add("Sex");
    	list_field.add("IDNum");
    	list_field.add("TotalScore");
    	list_field.add("Note");
    	
    	List<String> list_stuid = sqlinsert.getText(pathname+"stuid"),
	    			 list_name = sqlinsert.getText(pathname+"name"),
	    			 list_profession = sqlinsert.getText(pathname+"profession"),
	    			 list_date = sqlinsert.getText(pathname+"date"),
	    			 list_sex = sqlinsert.getText(pathname+"sex"),
	    			 list_idnum = sqlinsert.getText(pathname+"idnum"),
	    			 list_totalscore = sqlinsert.getText(pathname+"totalscore"),
	    			 list_note = sqlinsert.getText(pathname+"note");
    	String sql = sqlinsert.SQL("studentmanage","StudentInfo",list_field,list_stuid,
    			list_name,list_profession,list_date,list_sex,list_idnum,list_totalscore,list_note);
    	sqlinsert.InsertSQL(sql,pathname+"result.sql");
    }
    
    
    
    
    
  
}
