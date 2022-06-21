package cn.edu.ecnu.mapreduce.example.java.join;

import org.apache.hadoop.util.ToolRunner;

public class Runner {
    public static void main(String[] args) throws Exception {
        if (args[0].equals("mapjoin")) {
            int exitCode = ToolRunner.run(new MapJoin(), args);
            System.exit(exitCode);
        } else if (args[0].equals("reducejoin")) {
            int exitCode = ToolRunner.run(new ReduceJoin(), args);
            System.exit(exitCode);
        }
    }
}
