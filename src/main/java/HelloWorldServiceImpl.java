import io.grpc.stub.StreamObserver;

/**
 * Der Service der Anfragen verarbeitet
 */
public class HelloWorldServiceImpl extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

    /**
     * Die Methode die von Client aufgerufen wird
     */
    @Override
    public void hello( Hello.HelloRequest request, StreamObserver<Hello.HelloResponse> responseObserver) {

        //gibt die Parameter des Requests aus
        System.out.println("Handling hello endpoint: " + request.toString());

        // Erstellt einen Text aus den Daten von dem Request
        String text = "Hello World, " + request.getFirstname() + " " + request.getLastname();
        //Erstellt eine Response aus dem Text
        Hello.HelloResponse response = Hello.HelloResponse.newBuilder().setText(text).build();

        //schickt den Request
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}