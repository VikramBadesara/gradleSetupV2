package org.example

import org.example.resources.ApiHandler
import org.example.service.OrderService
import org.glassfish.grizzly.http.server.HttpServer
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import org.glassfish.jersey.server.ResourceConfig
import java.net.URI
import javax.ws.rs.core.UriBuilder
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


fun main() {
    try {
        println("\n\n_____________________Starting Server..._____________________\n\n")

        var a = -20
        println(a::class.simpleName)

        var baseUri: URI = UriBuilder.fromUri("http://localhost").port(8000).build()
        var config: ResourceConfig = ResourceConfig(ApiHandler::class.java)

        var server: HttpServer = GrizzlyHttpServerFactory.createHttpServer(baseUri, config)

        val currentDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val formattedDateTime = currentDateTime.format(formatter)
        println("Server Started at $formattedDateTime")

    } catch (err: Exception) {
        println("Error starting server: ${err.localizedMessage}")
    }
}

