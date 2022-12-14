package pojos.utilities;

import pojos.Registrant;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class TXTWriter {

    public static void saveUIRegistrantData(Registrant registrant){

        try{

           FileWriter fw = new FileWriter(ConfigReader.getProperty("applicant_data"), true);

           BufferedWriter bw = new BufferedWriter(fw);
           bw.append(registrant.toString() + "\n");
           bw.close();

        }catch (Exception e){
            e.printStackTrace();
        }



    }

    public static void saveUIRegistrantData(Registrant [] registrants){

        try{

            FileWriter fw = new FileWriter(ConfigReader.getProperty("applicants_api_data"), true);

            BufferedWriter bw = new BufferedWriter(fw);
            for(int i = 0; i<registrants.length;i++){
                bw.append(registrants[i].toString()+"\n");
            }
            bw.close();

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
