import java.rmi.*;
import java.util.Random;

public class Master {
    private static final long serialVersionUID = 1L;
    public static void main(String args[]){
        try{
            System.out.println("Creating a RMI Server!");
            MasterController controller = new MasterControllerImpl();
            Naming.rebind("//10.234.136.55:2018/Master", controller);
            System.out.println("Server Ready!");

            MasterController masterController= (MasterController) Naming.lookup("//10.234.136.55:2018/Master");
            if(masterController.connect() == 1){
                int po1=0;
                int po2=0;
                int po3=0;
                int po4= 0;
                int masterClock = 0;

                int po1Offset=0;
                int po2Offset=0;
                int po3Offset=0;
                int po4Offset=0;

                String bizentineFailure = args[0];
                int i = 0;
                do{
                    Thread.sleep(1000);
                    int randomEvent = new Random().nextInt(3);
                    if(randomEvent == 0){
                        int randomFailure = new Random().nextInt(5);
                        if(bizentineFailure.equalsIgnoreCase("y")){
                            if(randomFailure ==  3){
                                masterClock += 20;
                            }
                           else{
                                masterClock++;
                            }
                        }else{
                            masterClock++;
                        }
                    }else if(randomEvent == 1){

                        masterClock = ((masterClock + po1 + po2 + po3 + po4)/5)+1;
                        po1Offset = masterClock - po1;
                        po2Offset = masterClock - po2;
                        po3Offset = masterClock - po3;
                        po4Offset = masterClock - po4;

                        masterController.setMasterClock(masterClock+1);

                        masterController.setPO1Offset(po1Offset);
                        masterController.setPO2Offset(po2Offset);
                        masterController.setPO3Offset(po3Offset);
                        masterController.setPO4Offset(po4Offset);

                    }else{
                        po1 = masterController.getPO1();
                        po2 = masterController.getPO2();
                        po3 = masterController.getPO3();
                        po4 = masterController.getPO4();
                    }

                    System.out.println("Master: " + i +": " +masterClock);
                    i++;
                }while(true);
            }

        }catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
