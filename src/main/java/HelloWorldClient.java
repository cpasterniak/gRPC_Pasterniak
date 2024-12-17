import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * Ist der Client, der sich mit dem Server verbindet und einen Request schickt
 */
public class HelloWorldClient {

    public static void main(String[] args) {
        //channel ist die Verbindung zu dem Server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        //stub ist die Nachricht, die übermittelt wird
        HelloWorldServiceGrpc.HelloWorldServiceBlockingStub stub = HelloWorldServiceGrpc.newBlockingStub(channel);

        //Die Response wird in helloResponse gespeichert
        Hello.HelloResponse helloResponse = stub.hello(Hello.HelloRequest.newBuilder() //erstellt einen helloRequest
                .setFirstname("Max")
                .setLastname("Mustermann")
                .build());
        System.out.println( helloResponse.getText() ); //gibt die Response aus
        channel.shutdown(); // schließt die Verbindung

    }

}
