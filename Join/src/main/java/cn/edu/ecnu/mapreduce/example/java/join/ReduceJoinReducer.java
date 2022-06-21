package cn.edu.ecnu.mapreduce.example.java.join;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReduceJoinReducer extends Reducer<Text, ReduceJoinWriteable, Text, NullWritable> {
    @Override
    protected void reduce(Text key, Iterable<ReduceJoinWriteable> values, Context context) throws IOException, InterruptedException {
        List<String> employees = new ArrayList<>();
        List<String> departments = new ArrayList<>();

        for(ReduceJoinWriteable value:values){
            String tag = value.getTag();
            if (tag.equals(ReduceJoinWriteable.EMPLOYEE)){
                employees.add(value.getData());
            }else if(tag.equals(ReduceJoinWriteable.DEPARTMENT)){
                departments.add(value.getData());
            }
        }

        for(String employee:employees){
            for(String department: departments){
                String[] datas = department.split(",");
                String result = employee + "," + datas[1];
                context.write(new Text(result), NullWritable.get());
            }
        }

    }
}
