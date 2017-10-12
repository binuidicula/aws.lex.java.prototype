package com.netreally.aws.lex.quiz;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.lambda.runtime.Context;

import java.util.Arrays;
import java.util.List;

public class QuizScheduler {

    /**
     * Creates approved questions into slots for facebook
     *
     * @param myCount
     * @param context
     * @return
     */
    public String createQuestions(int myCount, Context context) {

        context.getLogger().log("Running the Handler");
        AWSCredentialsProvider awsCredentialsProvider = new EnvironmentVariableCredentialsProvider();
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().
                                      withCredentials(awsCredentialsProvider).
                                      withRegion(Regions.US_WEST_2).build();
        context.getLogger().log("got the dbclient for uswest2");
        List<String> tables = client.listTables().getTableNames();
        String[] tableString = new String[tables.size()];
        context.getLogger().log(Arrays.toString(tableString));
        return String.valueOf(Arrays.toString(tableString));
    }

}
