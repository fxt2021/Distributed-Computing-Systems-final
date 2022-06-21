package cn.edu.ecnu.mapreduce.example.java.join;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class ReduceJoinMapper extends Mapper<LongWritable, Text, Text, ReduceJoinWriteable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        FileSplit split = (FileSplit)context.getInputSplit();
        String path = split.getPath().toString();
        ReduceJoinWriteable writeable = new ReduceJoinWriteable();
        writeable.setData(value.toString());
        String[] datas = value.toString().split(",");
        if (path.contains("emp_dep")) {
            writeable.setTag(ReduceJoinWriteable.EMPLOYEE);
            context.write(new Text(datas[1]), writeable);
        } else if (path.contains("dep_man")) {
            writeable.setTag(ReduceJoinWriteable.DEPARTMENT);
            context.write(new Text(datas[0]), writeable);
        }
    }
}
