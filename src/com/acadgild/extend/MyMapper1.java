package com.acadgild.extend;

import java.io.IOException;

//import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper1 extends Mapper<Text,IntWritable,IntWritable,Text>{

	public void map(Text key,IntWritable value,Context context) throws IOException, InterruptedException{
		
		
		context.write(value, key);
		
	}
}