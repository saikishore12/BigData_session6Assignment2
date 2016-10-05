package com.acadgild.extend;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class Partitioner1 extends Partitioner<IntWritable, Text> {

	@Override
	public int getPartition(IntWritable key, Text values, int numPartitions) {
		Configuration conf = new Configuration();
		int minUnits = conf.getInt("minUnits", 0);
		int maxUnits = conf.getInt("maxUnits", 10);
		IntWritable units = key;
		int avg = (minUnits + maxUnits) / 2;
		IntWritable averageunits = new IntWritable(avg);
		IntWritable minunits1 = new IntWritable(minUnits);
		if (units.compareTo(minunits1) > 0 && units.compareTo(averageunits) < 0)
			return 0;
		else {
			return 1;
		}
	}

}