package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() throws UnknownHostException {
        String hostname = InetAddress.getLocalHost().getHostName();
        return String.format("""
            <!DOCTYPE html>
            <html>
              <head>
                <title>Spring Boot Server</title>
                <style>
                  body { font-family: Arial, sans-serif; margin: 50px; text-align: center; }
                  .container { background-color: #e8f5e9; padding: 30px; border-radius: 8px; }
                  h1 { color: #388e3c; }
                  p { font-size: 18px; color: #333; }
                  .info { background-color: #fff; padding: 15px; margin-top: 20px; border-left: 4px solid #388e3c; }
                </style>
              </head>
              <body>
                <div class="container">
                  <h1>👋 Hello from Spring Boot Server!</h1>
                  <p>This is the Spring Boot backend server</p>
                  <div class="info">
                    <p><strong>Server Hostname:</strong> %s</p>
                    <p><strong>Technology:</strong> Java + Spring Boot</p>
                    <p><strong>Port:</strong> 8080</p>
                  </div>
                </div>
              </body>
            </html>
            """, hostname);
    }

    @GetMapping("/api/health")
    public Map<String, String> health() throws UnknownHostException {
        Map<String, String> response = new HashMap<>();
        response.put("status", "healthy");
        response.put("server", "springboot");
        response.put("hostname", InetAddress.getLocalHost().getHostName());
        return response;
    }

}
