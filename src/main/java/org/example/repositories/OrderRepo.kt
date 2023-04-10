package org.example.repositories

import org.example.models.RequestDbFormat

import com.google.gson.Gson
import com.mongodb.BasicDBObject
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.bson.Document
import org.json.JSONArray
import org.json.JSONObject
import java.util.UUID
import javax.inject.Singleton

@Singleton
class OrderRepo {

    var data = RequestDbFormat()
//    var data = JSONObject().put("uuid", UUID.randomUUID().toString())
//        .put("orderNumber", "2001")
//        .put("xlist", JSONArray().put("item1").put("item2"))
//        .put("consigner", "Viky")


    private val mapper = gson()
    private val collectionName = "testing"
    fun gson(): Gson {
        return Gson().newBuilder().serializeNulls().create()
    }

    val client: MongoClient = MongoClients.create("mongodb://localhost:27017")
    val database = client.getDatabase("testing")
    var collection = database.getCollection("testing")


    init {
        collection.createIndex(BasicDBObject().append("uuid", 1))
        collection.createIndex(BasicDBObject().append("orderNumber", 1))
        collection.createIndex(BasicDBObject().append("xlist", 1))
        collection.createIndex(BasicDBObject().append("consigner", 1))
    }

    fun getRequestFromDb(): String? {
        try {
            println("In Fun: getRequestFromDb")
            val cursor = collection.find().iterator()
            if (cursor.hasNext()) {
                val doc = cursor.next()
                doc.remove("_id")
                val json = JSONObject(doc.toJson())
                val dataset = mapper.fromJson(json.toString(), RequestDbFormat::class.java)
                return dataset.toString()
            }

        } catch (err: Exception) {
            println("Caught error in getRequestFromDb: ${err.localizedMessage}")
        }
        return null
    }

    fun postRequestToDb(): String? {
        try {
            println("In Fun: getRequestFromDb")
            val cursor = collection.find().iterator()
            collection.insertOne(Document.parse(Gson().toJson(data.toString())))
            if (cursor.hasNext()) {
                val doc = cursor.next()
                doc.remove("_id")
                val json = JSONObject(doc.toJson())
                val dataset = mapper.fromJson(json.toString(), RequestDbFormat::class.java)
                println("dataset: $dataset")
                return null
                return dataset.toString()
            }

        } catch (err: Exception) {
            println("Caught error in getRequestFromDb: ${err.localizedMessage}")
        }
        return null
    }

//    private val order1 = ""
//    private val order2 = ""
//    private val o1 = gson().fromJson(order1, SalesOrder::class.java)
//    private val o2 = gson().fromJson(order2, SalesOrder::class.java)
//
//    private val orders = mutableListOf<SalesOrder>(o1, o2)
//    fun createOrder(order: SalesOrder) {
//        orders.add(order)
//    }

//    Document -> _id = order.uuid
//    val doc = Document.parse(orders.toString())
//    collection.insertOne(doc)

}


//data class