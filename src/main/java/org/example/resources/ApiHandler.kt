package org.example.resources

import org.example.service.OrderService

import org.json.JSONObject
import java.util.*
import javax.ws.rs.*
import java.time.*
import javax.ws.rs.core.MediaType

@Path("/orders")
class ApiHandler {

//    var orderService = OrderService().startProcess()

    @GET
    @Path("/getOrders")
    @Produces(MediaType.APPLICATION_JSON)
    fun getOrders(): String {
        println("Hit...")
        val res = OrderService().startProcess()
        return res.toString()
    }

    @POST
    @Path("/postOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun postOrder(request: String): String {
        println("Hit..")
        println(request)
        return request
//        val res = OrderService().postOrder()
//        return res.toString()
    }


}


//@Path("/v1")
//class getData {
//
//    @POST
//    @Path("order/create")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    fun update(): Any {
//
//        val auth = "eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NzkzNzUwMDUsInVzZXJJZCI6ImM2YjBkYTA5LTk1NTItNDgzZC1iZGFhLTdlZDdjMDIwODdhMCIsImVtYWlsIjoidmlrcmFtLmJhZGVzYXJhQGZyZXRyb24uY29tIiwibW9iaWxlTnVtYmVyIjoiOTQ5OTQyNDMwNCIsIm9yZ0lkIjoiNDk1Yjg3MjgtYzc2MS00ZmE3LTgzZmUtZGI3NWE3ZDYzMjIxIiwibmFtZSI6IlZpa3JhbSBCYWRlc2FyYSIsIm9yZ1R5cGUiOiJGTEVFVF9PV05FUiIsImlzR29kIjp0cnVlLCJwb3J0YWxUeXBlIjoiYmFzaWMifQ.ym-k0l2m7ypWa3CNuPjecUY5dVfsuI0GhBknViIck5w"
//
//        // sample uuids to get consigner and consignee of demo account
//        val uuid = "a526709f-12a9-4627-a223-50ba85a0c683"
//        val uuid1 = "e3135818-3d6e-4d90-8243-379cb1fa0f69"
//
//        val consigner = businessPartner(uuid, auth)
//        val customer = businessPartner(uuid, auth)
//        val consignee = businessPartner(uuid1, auth)
//        val weight = "200"
//
//        val lineItems = JSONArray()
//        val lineItem1 = JSONObject()
//        lineItem1.put("consigner",consigner)
//                .put("consignee",consignee)
//                .put("loadInfo",JSONObject()
//                    .put("measurements",JSONArray())
//                    .put("standardMeasurement",JSONObject()
//                        .put("weight",JSONObject()
//                            .put("measurmentType","Weight")
//                            .put("unitOfMeasurment","Metric Tonnes")
//                            .put("netQuantity",weight)
//                            .put("grossQuantity",weight)
//                            .put("standardQuantity",weight)
//                            .put("frieghtDeductableQuantity",0)
//                            .put("claimQuantity",0)
//                        )
//                    )
//                )
//                .put("allowedTransitDays",0)
//                .put("mappings",JSONArray())
//                .put("status","PENDING")
//                .put("allowedLoadTypes",JSONArray())
//                .put("allowedCustomerLoadTypes",JSONArray())
//                .put("fuMappings",JSONArray())
//                .put("freightUnitLineItemIds",JSONArray())
//                .put("customFields",JSONArray())
//
//        lineItems.put(lineItem1)
//
//        val orderPayload = JSONObject()
//        orderPayload
//            .put("orderType","Order")
//            .put("customer",customer)
//            .put("lineItems",lineItems)
//            .put("purchaseOrders",JSONArray())
//            .put("orderDate",Calendar.getInstance().timeInMillis)
//            .put("customFields",JSONArray())
//            .put("allowedVehicleTypes", JSONArray())
//            .put("allowedExecutionProfiles", JSONArray())
//            .put("issues",JSONArray())
//            .put("alerts", JSONArray())
//            .put("attachments", JSONArray())
//            .put("quotationMode","")
//
//
//        val url = URL("https://apis.fretron.com/order-manager-v2/sales-orders/v1/order")
//        val connection = url.openConnection() as HttpURLConnection
//
//
//        connection.requestMethod = "POST"
//        connection.doOutput = true
//        connection.setRequestProperty("Authorization", "Bearer $auth")
//        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8")
//
//        val postData = (orderPayload.toString()).toByteArray(StandardCharsets.UTF_8)
//
//        connection.setRequestProperty("Content-Length", postData.size.toString())
//
//        connection.outputStream.write(postData)
//
//        val responseCode = connection.responseCode
//        println("Response Code : $responseCode")
//
//        val inputStream = connection.inputStream
//
//        val response = inputStream.bufferedReader().use { it.readText() }
//
//        println("Response : $response")
//
//        val data = JSONObject()
//            .put("data",response)
//            .put("error", "null")
//            .put("status",200)
//
//        return data.toString()
//
//    }
//
//
//    @GET
//    @Path("/data")
//    @Produces(MediaType.APPLICATION_JSON)
//    fun data(): Any {
//
//        val calender =  Calendar.getInstance()
//        calender.add(Calendar.WEEK_OF_YEAR, -1)
//        var from = calender.timeInMillis.toString()
//        var till = Calendar.getInstance().timeInMillis
//        var filter = URLEncoder.encode("""{"_shipmentStatus_":{"shipmentStatus":["Completed"]},"__version":2,"shipmentDate":{"isTillExpression":false,"isFromExpression":false,"from":${from},"till":${till}}} """)
//
//
//        val url = URL("""https://apis.fretron.com/shipment-view/shipments/v1?filters=${filter}&allFields=["shipmentNumber","fleetInfo.vehicle.vehicleRegistrationNumber","creationTime","fleetInfo.device","completionTime","shipmentStages.tripPoint.coveredDistance"]""")
//
//        val auth = "eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NzkzNzUwMDUsInVzZXJJZCI6ImM2YjBkYTA5LTk1NTItNDgzZC1iZGFhLTdlZDdjMDIwODdhMCIsImVtYWlsIjoidmlrcmFtLmJhZGVzYXJhQGZyZXRyb24uY29tIiwibW9iaWxlTnVtYmVyIjoiOTQ5OTQyNDMwNCIsIm9yZ0lkIjoiNDk1Yjg3MjgtYzc2MS00ZmE3LTgzZmUtZGI3NWE3ZDYzMjIxIiwibmFtZSI6IlZpa3JhbSBCYWRlc2FyYSIsIm9yZ1R5cGUiOiJGTEVFVF9PV05FUiIsImlzR29kIjp0cnVlLCJwb3J0YWxUeXBlIjoiYmFzaWMifQ.ym-k0l2m7ypWa3CNuPjecUY5dVfsuI0GhBknViIck5w"
//
//        //JSPL
////        val auth = "eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NzgzNDU5ODMsInVzZXJJZCI6ImM2YjBkYTA5LTk1NTItNDgzZC1iZGFhLTdlZDdjMDIwODdhMCIsImVtYWlsIjoidmlrcmFtLmJhZGVzYXJhQGZyZXRyb24uY29tIiwibW9iaWxlTnVtYmVyIjoiOTQ5OTQyNDMwNCIsIm9yZ0lkIjoiODIzOTQ3YTMtMDJjMC00ZTY1LThmNGUtMjFkYTM3MGVhNmNkIiwibmFtZSI6IlZpa3JhbSBCYWRlc2FyYSIsIm9yZ1R5cGUiOiJGTEVFVF9PV05FUiIsImlzR29kIjp0cnVlLCJwb3J0YWxUeXBlIjoiYmFzaWMifQ.08JNKxkaN2LDHVz2rYYMA94cMTSLaUG_of6d4s4jMwM"
//
//        val connection = url.openConnection() as HttpURLConnection
//        connection.requestMethod = "GET"
//        connection.setRequestProperty("Authorization", "Bearer $auth")
//        connection.setRequestProperty("Content-Type", "application/json")
//        val responseCode = connection.responseCode
//        if (responseCode == HttpURLConnection.HTTP_OK) {
//            val inputStream = connection.inputStream
//            var response =  inputStream.bufferedReader().readText()
//            val finalResponse = JSONArray()
//            val jsonArr = JSONArray(response)
//            jsonArr.forEach { it as JSONObject
//                val finalData = JSONObject()
//                val shNumber = if(it.isNull("shipmentNumber").not()) it.getString("shipmentNumber") else null
//                val createtime  = if(it.isNull("creationTime").not()) it.getBigInteger("creationTime") else null
//                val vehicleNumber = if(it.isNull("fleetInfo").not() && it.getJSONObject("fleetInfo").isNull("vehicle").not() && it.getJSONObject("fleetInfo").getJSONObject("vehicle").isNull("vehicleRegistrationNumber").not()) it.getJSONObject("fleetInfo").getJSONObject("vehicle").getString("vehicleRegistrationNumber") else null
//                val completionTime = if(it.isNull("completionTime").not()) it.getBigInteger("completionTime") else null
//
//                var coveredDistance = if(it.isNull("shipmentStages").not() &&
//                    it.getJSONArray("shipmentStages").isNull(it.getJSONArray("shipmentStages").length()-1).not() &&
//                    it.getJSONArray("shipmentStages").getJSONObject(it.getJSONArray("shipmentStages").length()-1).isNull("tripPoint").not() &&
//                    it.getJSONArray("shipmentStages").getJSONObject(it.getJSONArray("shipmentStages").length()-1).getJSONObject("tripPoint").isNull("coveredDistance").not()
//                ) it.getJSONArray("shipmentStages").getJSONObject(it.getJSONArray("shipmentStages").length()-1).getJSONObject("tripPoint").getInt("coveredDistance") else null
//
//                coveredDistance = if (coveredDistance?.div(1000) != null) {
//                    coveredDistance.div(1000)
//                } else null
//
//                finalData.put("shipmentNumber",shNumber)
//                finalData.put("creationTime",createtime)
//                finalData.put("vehicleNumber",vehicleNumber)
//                finalData.put("completionTime",completionTime)
//                finalData.put("coveredDistance",coveredDistance)
//                finalResponse.put(finalData)
//            }
//            val groupByData = finalResponse.groupBy { it as JSONObject
//                it.getString("vehicleNumber")
//            }
//            var calculatedData = JSONArray()
//
//            for((key, value) in groupByData){
//                // Iterate through all SHs for every vehicle ---->
//                var dataToPut = JSONObject()
//                val vehNo = key
//                val numberOfShipments = JSONArray(value).length()
//                var tripDuration = 0
//                var avgCoveredDist = 0
//                value.forEach { it as JSONObject
//
//                    val creationTime = it.getLong("creationTime")
//                    val completionTime = it.getLong("completionTime")
//
//                    tripDuration = (tripDuration + ((completionTime - creationTime) / 3600000)).toInt()  // in Hrs
//                    avgCoveredDist = if(it.getInt("coveredDistance") != null ) (avgCoveredDist + it.getInt("coveredDistance")) else 0
//                }
//                tripDuration /= numberOfShipments
//                avgCoveredDist /= numberOfShipments
//
//                dataToPut.put("VehicleNumber",vehNo)
//                dataToPut.put("AverageTripDuration(inHrs)",tripDuration)
//                dataToPut.put("AverageCoveredDistance", avgCoveredDist)
//                calculatedData.put(dataToPut)
//
//            }
////            println(calculatedData)
//
//            var data = JSONObject()
//            data.put("data",calculatedData)
//            data.put("error", "null")
//            data.put("status",200)
//            return data.toString()
//
//        } else {
//            var err = JSONObject()
//            err.put("data","null")
//            err.put("error","Some Server Error")
//            err.put("status","400")
//            return err.toString()
//        }
//    }
//
//
//    @POST
//    @Path("/shipment/update")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    fun updateSh(
//        request :String
//    ): Any {
//        println(request)
//        val auth = "Beaer eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NzkzNzUwMDUsInVzZXJJZCI6ImM2YjBkYTA5LTk1NTItNDgzZC1iZGFhLTdlZDdjMDIwODdhMCIsImVtYWlsIjoidmlrcmFtLmJhZGVzYXJhQGZyZXRyb24uY29tIiwibW9iaWxlTnVtYmVyIjoiOTQ5OTQyNDMwNCIsIm9yZ0lkIjoiNDk1Yjg3MjgtYzc2MS00ZmE3LTgzZmUtZGI3NWE3ZDYzMjIxIiwibmFtZSI6IlZpa3JhbSBCYWRlc2FyYSIsIm9yZ1R5cGUiOiJGTEVFVF9PV05FUiIsImlzR29kIjp0cnVlLCJwb3J0YWxUeXBlIjoiYmFzaWMifQ.ym-k0l2m7ypWa3CNuPjecUY5dVfsuI0GhBknViIck5w"
//        /**
//         * update/add CF to sh
//         * */
//
//        val request1 = JSONObject(request)
//        val shId = if(request1.isNull("shipmentId").not()) request1.getString("shipmentId") else null
//
//        if(shId == null){
//            val resObj = JSONObject()
//            resObj.put("data", "null")
//                .put("error", "Please enter shipmentId")
//                .put("status", 200)
//
//            println(resObj)
//            return resObj.toString()
//        }
//
//        val payload = request1
//
//        println(payload)
//
//        val url = URL("""https://apis.fretron.com/shipment/v1/shipment/bulk/sync""")
//
//        val connection = url.openConnection() as HttpURLConnection
//
//        connection.requestMethod = "POST"
//        connection.doOutput = true
//        connection.doInput = true
//        connection.setRequestProperty("Content-Type", "application/json")
//        connection.setRequestProperty("Authorization", auth)
//
//        val postData = payload.toString().toByteArray(StandardCharsets.UTF_8)
//        connection.outputStream.write(postData)
//
//        val responseCode = connection.responseCode
//        val responseMessage = connection.responseMessage
//
//        println("responseCode: $responseCode")
//        if (responseCode == HttpURLConnection.HTTP_OK) {
//            val inputStream = connection.inputStream
//            val response =  inputStream.bufferedReader().readText()
//            val finalResponse = JSONObject(response)
//
//            println(finalResponse)
//            return  finalResponse.toString()
//
//        } else {
//            val err = JSONObject()
//            err.put("data", "null")
//            err.put("error", responseMessage)
//            err.put("status", responseCode)
//            return err.toString()
//        }
//    }
//
//
//
//    // Helping Function to get Business Partners ----->
//    private fun businessPartner(uuid: String, auth: String): Any? {
//
//        val url = URL("https://apis.fretron.com/business-partners/v2/partner/$uuid")
//
//        val connection = url.openConnection() as HttpURLConnection
//        connection.requestMethod = "GET"
//        connection.setRequestProperty("Authorization", "Bearer $auth")
//        connection.setRequestProperty("Content-Type", "application/json")
//        val responseCode = connection.responseCode
//        return if (responseCode == HttpURLConnection.HTTP_OK) {
//            val inputStream = connection.inputStream
//            val response =  inputStream.bufferedReader().readText()
//            val data = JSONObject(response).getJSONObject("data")
//
//            data
//
//        } else null
//    }
//
//}
//

