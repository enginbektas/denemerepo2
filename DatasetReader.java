import java.io.*;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.*;
import org.json.simple.parser.*;

//C:\Users\engin\Desktop\CES3063F20_LabelingProject_Input-1
public class DatasetReader {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader("C:\\Users\\engin\\Desktop\\CES3063F20_LabelingProject_Input-1.json"));
            JSONObject jsonObject = (JSONObject) obj;
            long id = (long) jsonObject.get("dataset id");
            String datasetName = (String) jsonObject.get("dataset name");
            long maxNumOfLabelsPerInstance = (long) jsonObject.get("maximum number of labels per instance");

            JSONArray jsonArray = (JSONArray) jsonObject.get("class labels");


            for (int i=0; i<jsonArray.size(); i++) {
                JSONObject obj2 = (JSONObject) jsonArray.get(i);
                long labelId = (long) obj2.get("label id");
                String labelText = (String) obj2.get("label text");
                System.out.println(labelText);
            }


            System.out.println(id);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

