# Distributed-Computing-Systems-final

分布式编程模型与系统期末作业

**项目结构**

```
.
├── Join
│   ├── input
│   │   ├── dep_man.txt	部门-经理表
│   │   ├── emp_dep.txt	职员-部门表
│   │   └── generate.py	模拟生成两张表的程序
│   ├── out
│   │   └── artifacts
│   │       └── Join
│   │           └── Join.jar	打包好的jar包
│   ├── pom.xml
│   ├── src
│   │   ├── main
│   │   │   ├── java.cn.edu.ecnu.mapreduce.example.java.join
│   │   │   │   ├── MapJoin.java	mapjoin的主方法
│   │   │   │   ├── MapJoinMapper.java	mapjoin的map方法
│   │   │   │   ├── ReduceJoin.java	reducejoin的主方法
│   │   │   │   ├── ReduceJoinMapper.java	reducejoin的map方法
│   │   │   │   ├── ReduceJoinReducer.java	reducejoin的reduce方法
│   │   │   │   ├── ReduceJoinWriteable.java	reducejoin自定义的数据类型
│   │   │   │   └── Runner.java	join的主方法，根据传入的参数决定采用mapjoin还是reducejoin
│   │   │   └── resources
│   │   └── test
│   └── target
└── README.md
```



**运行说明**

1. 模拟生成职员-部门表和部门-经理表

```shell
cd Join/input/
python generate.py
```

2. 在yarn中运行jar包

mapjoin

```shell
yarn jar Join.jar mapjoin input/emp_dep.txt input/dep_man.txt output/mapjoinOutput
```

reducejoin

```shell
yarn jar Join.jar reducejoin input/emp_dep.txt input/dep_man.txt output/reducejoinOutput
```

