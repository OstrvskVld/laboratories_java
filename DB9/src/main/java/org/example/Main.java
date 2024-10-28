package org.example;

import com.mongodb.DBRef;
import com.mongodb.client.*;
import com.mongodb.client.model.*;
import org.bson.Document;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;


public class Main {
    public static void liner() {
        System.out.println("--------------------------------------------------");
    }
    public static void taskAggregate(MongoCollection<Document> collection) {
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$match", new Document("Contract_contract_type", "Lease")),
                new Document("$group", new Document("_id", "$Contract_Agency_id_agency")
                        .append("totalContracts", new Document("$sum", 1))
                        .append("avgContracts", new Document("$avg", 1))
                        .append("maxContracts", new Document("$max", 1))
                        .append("minContracts", new Document("$min", 1))
                ),
                new Document("$project", new Document("_id", 0)
                        .append("agency", "$_id")
                        .append("totalContracts", "$totalContracts")
                        .append("avgContracts", "$avgContracts")
                        .append("maxContracts", "$maxContracts")
                        .append("minContracts", "$minContracts")
                ),
                new Document("$sort", new Document("totalContracts", -1)),
                new Document("$limit", 10)
        ));


        for (Document doc : result) {
            System.out.println(doc);
        }
    }

    public static void taskRealEstateAggregate(MongoCollection<Document> collection) {
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$match", new Document("status", "Available")),
                new Document("$group", new Document("_id", "$Real_estate")
                        .append("totalProperties", new Document("$sum", 1))
                        .append("avgCost", new Document("$avg", new Document("$toDouble", "$cost")))
                        .append("maxRooms", new Document("$max", new Document("$toInt", "$rooms")))
                        .append("minRooms", new Document("$min", new Document("$toInt", "$rooms")))
                        .append("totalCost", new Document("$sum", new Document("$toDouble", "$cost")))
                ),
                new Document("$project", new Document("_id", 0)
                        .append("agency", "$_id")
                        .append("totalProperties", "$totalProperties")
                        .append("avgCost", "$avgCost")
                        .append("maxRooms", "$maxRooms")
                        .append("minRooms", "$minRooms")
                        .append("totalCost", "$totalCost")
                ),
                new Document("$sort", new Document("avgCost", -1)),
                new Document("$limit", 10)
        ));


        for (Document doc : result) {
            System.out.println(doc);
        }
    }

    public static void taskAgencyAggregate(MongoCollection<Document> collection) {

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$match", new Document("sales", new Document("$exists", true))),
                new Document("$project", new Document("name_agency", 1)
                        .append("sales", new Document("$toDouble", "$sales"))
                        .append("address", 1)
                ),
                new Document("$group", new Document("_id", null)
                        .append("totalSales", new Document("$sum", "$sales"))
                        .append("avgSales", new Document("$avg", "$sales"))
                        .append("maxSales", new Document("$max", "$sales"))
                        .append("minSales", new Document("$min", "$sales"))
                        .append("countAgencies", new Document("$sum", 1))
                ),
                new Document("$project", new Document("_id", 0)
                        .append("totalSales", 1)
                        .append("avgSales", 1)
                        .append("maxSales", 1)
                        .append("minSales", 1)
                        .append("countAgencies", 1)
                ),
                new Document("$sort", new Document("totalSales", -1))
        ));


        for (Document doc : result) {
            System.out.println(doc);
        }
    }

    public static void taskPersonalDataAggregate(MongoCollection<Document> collection) {
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$match", new Document("date_of_birth", new Document("$exists", true))),
                new Document("$project", new Document("surname", 1)
                        .append("name", 1)
                        .append("email", 1)
                        .append("contact_phone", 1)
                        .append("yearOfBirth", new Document("$toInt", "$date_of_birth"))
                ),
                new Document("$group", new Document("_id", "$yearOfBirth")
                        .append("count", new Document("$sum", 1))
                        .append("email", new Document("$push", "$email"))
                        .append("contacts", new Document("$push", "$contact_phone"))
                        .append("names", new Document("$push", new Document("name", "$name").append("surname", "$surname")))
                ),
                new Document("$sort", new Document("_id", 1)),
                new Document("$project", new Document("_id", 0)
                        .append("year", "$_id")
                        .append("count", 1)
                        .append("email", 1)
                        .append("contacts", 1)
                        .append("names", 1)
                )
        ));

        for (Document doc : result) {
            System.out.println(doc);
        }
    }

    public static void taskVendoorAccountingAggregate(MongoCollection<Document> collection) {
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$match", new Document("number_of_contracts", new Document("$exists", true))
                        .append("number_of_shows", new Document("$exists", true))),
                new Document("$project", new Document("personal_data_id", 1)
                        .append("success_of_agent", 1)
                        .append("number_of_contracts", new Document("$toInt", "$number_of_contracts"))
                        .append("number_of_shows", new Document("$toInt", "$number_of_shows"))),
                new Document("$group", new Document("_id", "$success_of_agent")
                        .append("totalContracts", new Document("$sum", "$number_of_contracts"))
                        .append("totalShows", new Document("$sum", "$number_of_shows"))
                        .append("averageContracts", new Document("$avg", "$number_of_contracts"))
                        .append("maxShows", new Document("$max", "$number_of_shows"))),
                new Document("$sort", new Document("totalContracts", -1)),
                new Document("$project", new Document("_id", 0)
                        .append("successLevel", "$_id")
                        .append("totalContracts", 1)
                        .append("totalShows", 1)
                        .append("averageContracts", 1)
                        .append("maxShows", 1))
        ));


        for (Document doc : result) {
            System.out.println(doc);
        }
    }


    public static void main(String[] args) {
    MongoClient mongoClient =MongoClients.create("mongodb://localhost:27017");
    MongoDatabase database = mongoClient.getDatabase("test");

    MongoCollection<Document> collectionAgency = database.getCollection("Agency");
    MongoCollection<Document> collectionContract_has_Real_estate = database.getCollection("Contract_has_Real_estate");
    MongoCollection<Document> collectionCustomer_accounting = database.getCollection("Customer_accounting");
    MongoCollection<Document> collectionReal_estate = database.getCollection("Real_estate");
    MongoCollection<Document> collectionPersonal_data = database.getCollection("Personal_data");
    MongoCollection<Document> collectionVendoor_accounting = database.getCollection("Vendoor_accounting");



        taskAggregate(collectionContract_has_Real_estate);
        liner();
        taskRealEstateAggregate(collectionReal_estate);
        liner();
        taskAgencyAggregate(collectionAgency);
        liner();
        taskPersonalDataAggregate(collectionPersonal_data);
        liner();
        taskVendoorAccountingAggregate(collectionVendoor_accounting);
        liner();
    }
}

