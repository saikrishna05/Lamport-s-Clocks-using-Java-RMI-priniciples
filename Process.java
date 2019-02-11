import java.rmi.*;
import java.util.Random;
import java.util.Scanner;

public class Process {

    public static void main(String args[]){

        String poId = args[0];
        String bizentineFailure = args[1];

        try {
            Scanner in = new Scanner(System.in);
            MasterController controller= (MasterController) Naming.lookup("//10.234.136.55:2018/Master");
            int connectionStatus = controller.connect();

            if(connectionStatus == 1){
                System.out.println("Connected to server....");
            }
            int clock = 0;

            int i = 0;
            do{
                Thread.sleep(1000);
                int randomEvent = new Random().nextInt(3);
                if(randomEvent == 0){
                    if(bizentineFailure.equalsIgnoreCase("y")){
                        clock += 20;
                    }else{
                        clock++;
                    }
                }else if(randomEvent == 1){
                    if(poId.equalsIgnoreCase("1")){
                        controller.setPO1(clock);
                    }else if(poId.equalsIgnoreCase("2")){
                        controller.setPO2(clock);
                    }else if(poId.equalsIgnoreCase("3")){
                        controller.setPO3(clock);
                    }else if(poId.equalsIgnoreCase("4")){
                        controller.setPO4(clock);
                    }
                    clock++;
                }else{
                    if(poId.equalsIgnoreCase("1")){
                        clock += controller.getPO1Offset();
                        controller.setPO1(clock);
                        controller.setPO1Offset(0);
                    }else if(poId.equalsIgnoreCase("2")){
                        clock += controller.getPO2Offset();
                        controller.setPO2(clock);
                        controller.setPO2Offset(0);
                    }else if(poId.equalsIgnoreCase("3")){
                        clock += controller.getPO3Offset();
                        controller.setPO3(clock);
                        controller.setPO3Offset(0);
                    }else if(poId.equalsIgnoreCase("4")){
                        clock += controller.getPO4Offset();
                        controller.setPO4(clock);
                        controller.setPO4Offset(0);
                    }
                    clock++;
                }
                System.out.println("PO"+poId+": " + i + ": " + clock);
                i++;
            }while(true);



        } catch(Exception e){
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }


    }
}
