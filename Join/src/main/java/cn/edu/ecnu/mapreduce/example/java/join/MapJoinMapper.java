package cn.edu.ecnu.mapreduce.example.java.join;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class MapJoinMapper extends Mapper<LongWritable, Text, Text, NullWritable> {
    private Map<String, String> table1 = new HashMap<String, String>();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if(table1.isEmpty()){
            URI uri = context.getCacheFiles()[0];
            FileSystem fs = FileSystem.get(uri, new Configuration());
            BufferedReader reader = new BufferedReader(new InputStreamReader(fs.open(new Path(uri))));
            String content;
            while ((content=reader.readLine())!=null){
                String[] datas = content.split(",");
                table1.put(datas[0], datas[1]);
            }
        }

        String[] datas = value.toString().split(",");
        String joinKey = datas[1];
        if(table1.containsKey(joinKey)){
            context.write(new Text(value.toString() + "," + table1.get(joinKey)), NullWritable.get());
        }

    }
}
