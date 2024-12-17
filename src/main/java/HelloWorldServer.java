import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * Ein Server der auf Port 50051 läuft
 */
public class HelloWorldServer {

    private static final int PORT = 50051;
    private Server server;

    /**
     * der Server wird auf einen Port gesetzt und ein Service wird hinzugefügt
     */
    public void start() throws IOException {
        server = ServerBuilder.forPort(PORT)
                .addService(new HelloWorldServiceImpl())
                .build()
                .start();
    }

    /**
     * Verarbeitet, wenn der Server herunterfährt
     */
    public void blockUntilShutdown() throws InterruptedException {
        if (server == null) {
            return;
        }
        server.awaitTermination();
    }

    /**
     * erstellt eine Instanz von this und startet den Server
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        HelloWorldServer server = new HelloWorldServer();
        System.out.println( "HelloWorld Service is running!");
        server.start();
        server.blockUntilShutdown();
    }

}
