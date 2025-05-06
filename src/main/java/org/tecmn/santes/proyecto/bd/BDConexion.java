package org.tecmn.santes.proyecto.bd;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.tecmn.santes.proyecto.model.MaterialPrestado;

public class BDConexion {

    private static final String URI = "mongodb+srv://santes:YemKwrUECCVTSgHB@cluster0.zho6yle.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private static final String DB_NAME = "proyecto";
    private static final String COLLECTION_NAME = "materiales";

    private static MongoCollection<MaterialPrestado> collection;

    public static MongoCollection<MaterialPrestado> getCollection() {
        if (collection == null) {
            ConnectionString connectionString = new ConnectionString(URI);

            ServerApi serverApi = ServerApi.builder()
                    .version(ServerApiVersion.V1)
                    .build();

            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connectionString)
                    .serverApi(serverApi)
                    .build();

            try {
                MongoClient mongoClient = MongoClients.create(settings);
                MongoDatabase database = mongoClient.getDatabase(DB_NAME);
                collection = database.getCollection(COLLECTION_NAME, MaterialPrestado.class);

                // Verificamos conexión (opcional)
                database.runCommand(new Document("ping", 1));
                System.out.println("Conexión exitosa a MongoDB Atlas");
            } catch (MongoException e) {
                System.err.println("Error de conexión a MongoDB: " + e.getMessage());
            }
        }
        return collection;
    }
}
