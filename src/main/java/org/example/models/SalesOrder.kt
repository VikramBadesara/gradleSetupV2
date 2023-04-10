package org.example.models

import com.google.gson.GsonBuilder
import org.json.JSONObject

data class getFormat(
    var uuid: String?,
    var orderNumber: String?,
    var xList: MutableList<Int>?,
    var consigner: JSONObject?
) {
    constructor() : this(null, null, null, null)

    override fun toString(): String {
        return GsonBuilder().serializeNulls().create().toJson(this)
    }
}

data class RequestDbFormat(
    var uuid: String?,
    var data: getFormat?,
    var requestTime: Long?,
    var isProcessed: Boolean?
) {
    constructor() : this(null, null, null, null)

    override fun toString(): String {
        return GsonBuilder().serializeNulls().create().toJson(this)
    }
}

//
//import org.json.JSONArray
//import org.json.JSONObject
//
//data class SalesOrder(
//    var uuid :String?,
//    var orgId : String?,
//    var orderNumber :String?,
//    var xList : MutableList<Int>,
//    var consigner :BP?
//) {
//    constructor():this(uuid=null, orgId=null, orderNumber=null, xList= mutableListOf(),consigner= null)
//
//    override fun toString(): String {
//        return JSONObject()
//            .put("uuid",this.uuid ?: JSONObject.NULL)
//            .put("consigner",if(this.consigner== null) JSONObject.NULL else JSONObject(this.consigner.toString()))
//            .put("xList",JSONArray(this.xList.toString()))
//            .toString()
//    }
//
//}
//
