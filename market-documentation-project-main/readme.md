### Swagger common documentation:  
### http://127.0.0.1:8888/swagger-ui.html

###you have to add this part of settings to main yaml or properties

### yaml settings:
<pre>
eureka:
  instance:
    appname: market-&lt;app-name&gt;
  client:
    enabled: true
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone:http://localhost:8761/eureka
</pre>

### properties settings:

<pre>
eureka.instance.appname=market-&lt;app-name&gt;
eureka.client.enabled=true
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
eureka.client.service-url.defaultZone=http://localhost:8761/eureka
</pre>