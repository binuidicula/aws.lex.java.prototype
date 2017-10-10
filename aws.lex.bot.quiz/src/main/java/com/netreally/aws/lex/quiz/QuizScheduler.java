package com.netreally.aws.lex.quiz;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.lambda.runtime.Context;

import java.util.Arrays;

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
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        String tables = Arrays.toString(client.listTables().getTableNames().toArray());
        return String.valueOf(tables);
    }

}
