package com.gua.fk;


import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/**
 * 下面是一个Apache Flink的Java语言示例代码，该代码将从本地的文本文件中读取行，并在本地控制台上打印每个单词及其出现次数：
 */
public class WordCount {

    public static void main(String[] args) throws Exception {

        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        DataSet<String> text = env.readTextFile("C:\\Users\\86188\\Desktop\\1.txt");

        DataSet<Tuple2<String, Integer>> counts =
                text.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
                            @Override
                            public void flatMap(String value, Collector<Tuple2<String, Integer>> out) {
                                String[] words = value.toLowerCase().split("\\W+");
                                for (String word : words) {
                                    if (word.length() > 0) {
                                        out.collect(new Tuple2<>(word, 1));
                                    }
                                }
                            }
                        })
                        .groupBy(0)
                        .sum(1);

        counts.print();
    }
}

