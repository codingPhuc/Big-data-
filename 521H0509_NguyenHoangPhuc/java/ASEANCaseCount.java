package com;


import java.io.IOException;




import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class ASEANCaseCount {


    public static class TokenizerMapper
            extends Mapper<Object, Text, Text, LongWritable>{


        private LongWritable cases = new LongWritable() ;
        private Text word = new Text();
        private  static  int currentRow = 0;
        // the text is tsv(tab seperated value )
        // key is all the WHO region col flied
        // value is the total Cases - cumulative total col
        // split the data by row and assign to variable rows(rows contain a list of row that was split)
        // split the  data in each row
        //      region assign row region
        //      cases_total assign row  cumulative total col
        // create the pair (region,cases_total)
        public void map(Object key, Text value, Context context
        ) throws IOException, InterruptedException {

//            one = new LongWritable(1);
//            StringTokenizer itr = new StringTokenizer(value.toString());
//            while (itr.hasMoreTokens()) {
//                System.out.println("hello"+word);
//                word.set(itr.nextToken());
//                context.write(word, one);
//            }

                // check if it is in the two null row
                if (currentRow < 2) {
                    currentRow++;
                    return  ;
                }


                // Now process each subsequent row

                String[] columns = value.toString().split("\t");

                String region = columns[1];


                String casesTotalStr = columns[2].replace(",","")
                        .replace(".","");

                Long longcasesTotalStr = Long.parseLong(casesTotalStr) ;

                System.out.println(region + " "  +casesTotalStr + " \n");

                try {

                    word.set(region);
                    cases.set(longcasesTotalStr);
                    context.write(word, cases);
                } catch (NumberFormatException e) {


                }
            }

        }




    public static class IntSumReducer extends Reducer<Text,LongWritable,Text,LongWritable> {
        private LongWritable result = new LongWritable();


        public void reduce(Text key, Iterable<LongWritable> values,
                           Context context
        ) throws IOException, InterruptedException {
            int sum = 0;
            for (LongWritable val : values) {
                sum += val.get();
            }
            result.set(sum);
            context.write(key, result);
        }
    }



    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "word count");
        job.setJarByClass(ASEANCaseCount.class);
        job.setMapperClass(TokenizerMapper.class);
        job.setCombinerClass(IntSumReducer.class);
        job.setReducerClass(IntSumReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
