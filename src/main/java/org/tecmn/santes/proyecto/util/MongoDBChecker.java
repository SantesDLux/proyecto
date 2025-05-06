package org.tecmn.santes.proyecto.util;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.List;

/**
 * Utilidad para verificar conexiones MongoDB y listar colecciones
 */
public class MongoDBChecker {
    
    private static final String URI = "mongodb+srv://santes:YemKwrUECCVTSgHB@cluster0.zho6yle.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    
    /**
     * Verifica la conexión a MongoDB y lista las bases de datos disponibles
     * @return Lista de nombres de bases de datos
     */
    public static List<String> listarBases() {
        List<String> bases = new ArrayList<>();
        
        try (MongoClient mongoClient = createMongoClient()) {
            mongoClient.listDatabaseNames().forEach(bases::add);
            System.out.println("Conexión exitosa. Bases encontradas: " + bases.size());
        } catch (Exception e) {
            System.err.println("Error al listar bases de datos: " + e.getMessage());
            e.printStackTrace();
        }
        
        return bases;
    }
    
    /**
     * Lista las colecciones en una base de datos específica
     * @param dbName Nombre de la base de datos
     * @return Lista de nombres de colecciones
     */
    public static List<String> listarColecciones(String dbName) {
        List<String> colecciones = new ArrayList<>();
        
        try (MongoClient mongoClient = createMongoClient()) {
            MongoDatabase database = mongoClient.getDatabase(dbName);
            database.listCollectionNames().forEach(colecciones::add);
            System.out.println("Colecciones encontradas en '" + dbName + "': " + colecciones.size());
        } catch (Exception e) {
            System.err.println("Error al listar colecciones: " + e.getMessage());
            e.printStackTrace();
        }
        
        return colecciones;
    }
    
    /**
     * Cuenta los documentos en una colección específica
     * @param dbName Nombre de la base de datos
     * @param collectionName Nombre de la colección
     * @return Número de documentos en la colección
     */
    public static long contarDocumentos(String dbName, String collectionName) {
        try (MongoClient mongoClient = createMongoClient()) {
            MongoDatabase database = mongoClient.getDatabase(dbName);
            MongoCollection<Document> collection = database.getCollection(collectionName);
            long count = collection.countDocuments();
            System.out.println("Documentos encontrados en '" + dbName + "." + collectionName + "': " + count);
            return count;
        } catch (Exception e) {
            System.err.println("Error al contar documentos: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }
    
    /**
     * Muestra una muestra de los documentos en la colección (máximo 5)
     * @param dbName Nombre de la base de datos
     * @param collectionName Nombre de la colección
     * @return Lista de documentos en formato String
     */
    public static List<String> mostrarDocumentos(String dbName, String collectionName) {
        List<String> documentos = new ArrayList<>();
        
        try (MongoClient mongoClient = createMongoClient()) {
            MongoDatabase database = mongoClient.getDatabase(dbName);
            MongoCollection<Document> collection = database.getCollection(collectionName);
            
            collection.find().limit(5).forEach(doc -> {
                documentos.add(doc.toJson());
                System.out.println(doc.toJson());
            });
        } catch (Exception e) {
            System.err.println("Error al mostrar documentos: " + e.getMessage());
            e.printStackTrace();
        }
        
        return documentos;
    }
    
    /**
     * Crea un cliente MongoDB con la configuración necesaria
     * @return Cliente MongoDB configurado
     */
    private static MongoClient createMongoClient() {
        ConnectionString connectionString = new ConnectionString(URI);
        
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            pojoCodecRegistry
        );
        
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
                
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(serverApi)
                .codecRegistry(codecRegistry)
                .build();
                
        return MongoClients.create(settings);
    }
}