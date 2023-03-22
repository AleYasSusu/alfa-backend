//package ages.alfa.config;
//
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//@Configuration
//public class FirebaseConfig {
//
//    Logger logger = LoggerFactory.getLogger(FirebaseConfig.class);
//
//    public FirebaseConfig() throws IOException {
//        this.configure();
//    }
//
//    public void configure() throws IOException {
//
//        FileInputStream serviceAccount =
//                new FileInputStream("C:\\Users\\Mauricio\\Desktop\\alfatest-e8e11-a067a0c58703.json");
//
//        FirebaseOptions options =
//                new FirebaseOptions.Builder()
//                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                        .build();
//
//        FirebaseApp.initializeApp(options);
//        logger.info(FirebaseApp.getInstance().getName());
//    }
//}
