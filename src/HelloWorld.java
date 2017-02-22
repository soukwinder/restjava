/**
 * Created by Singh on 19-2-2017.
 */
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import org.json.simple.JSONArray;

@Path("/api")
public class HelloWorld {
    MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
    DB db = mongoClient.getDB( "mydb" );
    DBCollection coll = db.getCollection("testCollection");
    JSONArray jsonarray = new JSONArray();

    @Path("data1")
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public String data1() throws IOException {

        DBCursor cursor = coll.find();
        JSON json =new JSON();
        String serialize = json.serialize(cursor);

        //return serialize;
        return "data1";
    }

    @Path("data2")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String data2() {
        return "data2";
    }
}



//    public void jsonObject() throws IOException{
//        FileReader reader = new FileReader("C:\\Users\\Singh\\Desktop\\data.json");
//    }