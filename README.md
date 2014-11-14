# Running The Application

To test the example application run the following commands.

* To package the example run.

        mvn package

* To setup the h2 database run.

        java -jar target/store-dropwizard-0.0.1-SNAPSHOT.jar db migrate server.yml

* To run the server run.

        java -jar target/store-dropwizard-0.0.1-SNAPSHOT.jar server example.yml

* To hit the Store Example (hit refresh a few times).

	http://localhost:8080/visits
* To post data into the application.

	curl -H "Content-Type: application/json" -X POST -d '{"userId":22, "beaconId":"11E44F09-4EC4-407E-9203-CF57A50FBCE1","major":0, "minor":1755, "rssi":-95, "proximity":3, "timestamp":1415990420796 }' http://localhost:8080/visits
	open http://localhost:8080/visits
