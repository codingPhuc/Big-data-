public  class TokenizerMapper
            extends Mapper<Object, Text, Text, IntWritable>{


        private   IntWritable cases = new IntWritable() ;
        private Text word = new Text();

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

//            one = new IntWritable(1);
//            StringTokenizer itr = new StringTokenizer(value.toString());
//            while (itr.hasMoreTokens()) {
//                System.out.println("hello"+word);
//                word.set(itr.nextToken());
//                context.write(word, one);
//            }


            BufferedReader reader = new BufferedReader(new StringReader(value.toString()));
            String line;


            int currentRow = 0;

            System.out.println("help");
            System.out.println("help");
            while ( (line = reader.readLine() )!=null )  {
                // check if it is in the two null row
                if (currentRow < 2) {
                    currentRow++;
                    continue;
                }
                System.out.println(currentRow+ " \n");
                // Now process each subsequent row
                String[] columns = line.split("\t");

                String region = columns[1];
                String casesTotalStr = columns[2];


                System.out.println(region + " "  +casesTotalStr + " \n");

                try {

                    word.set(region);
                    cases.set(Integer.parseInt(casesTotalStr));
                    context.write(word, cases);
                } catch (NumberFormatException e) {


                }
            }
            reader.close();
        }
        }