import java.io.*;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.*;
import org.json.simple.parser.*;

//C:\Users\engin\Desktop\CES3063F20_LabelingProject_Input-1
public class DatasetReader {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser(); // create JSON parser
        try {

            Object obj = parser.parse(new FileReader("C:\\Users\\engin\\Desktop\\CES3063F20_LabelingProject_Input-1.json"));
            JSONObject jsonObject = (JSONObject) obj; //assign the parsed version of our file to a JSONObject

            long id = (long) jsonObject.get("dataset id");
            String datasetName = (String) jsonObject.get("dataset name");
            long maxNumOfLabelsPerInstance = (long) jsonObject.get("maximum number of labels per instance");

            JSONArray jsonArray = (JSONArray) jsonObject.get("class labels");
            Label[] labels = new Label[jsonArray.size()]; // create labels array

            for (int i=0; i<jsonArray.size(); i++) { //assigns the given labels in the input to the labels array
                JSONObject obj2 = (JSONObject) jsonArray.get(i);
                long labelId = (long) obj2.get("label id");
                String labelText = (String) obj2.get("label text");
                labels[i] = new Label(labelId, labelText);
            }
            System.out.println(labels[2].text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Label {
    public long id;
    public String text;
    public Label(long id, String text) {
        this.id = id;
        this.text = text;
    }

}



