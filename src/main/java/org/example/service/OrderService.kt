package org.example.service

import  org.example.repositories.OrderRepo
import com.google.gson.Gson
import org.apache.log4j.MDC
import javax.ws.rs.core.MediaType
import java.util.*

class OrderService {
//    val orderRepo = OrderService()

    fun gson(): Gson {
        return Gson().newBuilder().serializeNulls().create()
    }

    fun processRequestFromDb(): String {
        var isTraceIdSet = false
        try {
            if (MDC.get("traceID") == null) {
                MDC.put("traceID", UUID.randomUUID().toString())
                isTraceIdSet = true
            }
            println("traceID: ${MDC.get("traceID")}")

            val dataSet = OrderRepo().getRequestFromDb()

            var processed: Boolean = false
            var orderNumber = null
            if (dataSet != null) {
                try {
                    println("dataSet: \n$dataSet")
                    return dataSet.toString()
                } catch (err: Exception) {
                    println("Caught some error in dataset: ${err.localizedMessage}")
                }
            } else {
                println("dataSet is null")
                return "dataSet is null"
            }

        } catch (err: Exception) {
            println("Caught error in processRequestFromDb: ${err.localizedMessage}")
            return "Caught error in processRequestFromDb: ${err.localizedMessage}"
        }
        return "Caught error in getting dataset"
    }

    fun getFromDbAndProcess(): String {
        println("Hit2..")
        var limit = 1
        val process = processRequestFromDb()
//            {
//            while (limit != 2) {
//                processRequestFromDb()
//                limit += 1
//            }
//        }
        println("process: $process")
        val thread = Thread(process)
        thread.start()
        return process.toString()
    }

    fun startProcess(): Any? {
        println("Hit1.0..")
        try {
            println("Hit1..")
            val res = getFromDbAndProcess()
            return res.toString()
        } catch (err: Exception) {
            println("Caught Error in startProcess: ${err.localizedMessage}")
        }
        return null
    }


    fun processRequestToDb(): String {
        var isTraceIdSet = false
        try {
            if (MDC.get("traceID") == null) {
                MDC.put("traceID", UUID.randomUUID().toString())
                isTraceIdSet = true
            }
            println("traceID: ${MDC.get("traceID")}")

            val dataSet = OrderRepo().postRequestToDb()

            var processed: Boolean = false
            var orderNumber = null
            if (dataSet != null) {
                try {
                    println("dataSet: \n$dataSet")
                    return dataSet.toString()
                } catch (err: Exception) {
                    println("Caught some error in dataset: ${err.localizedMessage}")
                }
            } else {
                println("dataSet is null")
                return "dataSet is null"
            }

        } catch (err: Exception) {
            println("Caught error in processRequestToDb: ${err.localizedMessage}")
            return "Caught error in processRequestToDb: ${err.localizedMessage}"
        }
        return "Caught error in posting dataset"
    }

    fun postToDbAndProcess() {
        println("Hit2..")
        val process = {
            while (true) {
                val processedData = processRequestToDb()
                println("processedData: $processedData")

            }
        }
        println("process: $process")
        val thread = Thread(process)
        thread.start()
    }

    fun postOrder(): Any? {
        println("Hit2.0..")
        try {
            println("Hit1..")
            val postRes = postToDbAndProcess()
//            val res = getFromDbAndProcess()
//            return res.toString()
        } catch (err: Exception) {
            println("Caught Error in postOrder: ${err.localizedMessage}")
            return null
        }
        return null
    }
}
