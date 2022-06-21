package cn.edu.ecnu.mapreduce.example.java.join;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ReduceJoinWriteable implements Writable {
    private String data;
    private String tag;

    public static final String EMPLOYEE = "1";
    public static final String DEPARTMENT = "2";


    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(tag);
        dataOutput.writeUTF(data);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        tag = dataInput.readUTF();
        data = dataInput.readUTF();
    }

    public String getData() {
        return data;
    }

    public String getTag() {
        return tag;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
