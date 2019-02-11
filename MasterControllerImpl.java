import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class MasterControllerImpl extends UnicastRemoteObject implements MasterController{
    int po1=0;
    int po2=0;
    int po3=0;
    int po4= 0;
    int masterClock = 0;

    int po1Offset=0;
    int po2Offset=0;
    int po3Offset=0;
    int po4Offset=0;

    public MasterControllerImpl() throws RemoteException{
    }

    @Override
    public int connect() throws RemoteException {
        return 1;
    }

    @Override
    public void setMasterClock(int clockValue) throws RemoteException {
        masterClock = clockValue;
    }

    @Override
    public int getMasterClock() throws RemoteException {
        return masterClock;
    }


    @Override
    public void setPO1(int clockValue) throws RemoteException {
        po1 = clockValue;
    }

    @Override
    public void setPO2(int clockValue) throws RemoteException {
        po2 = clockValue;
    }

    @Override
    public void setPO3(int clockValue) throws RemoteException {
        po3 = clockValue;
    }

    @Override
    public void setPO4(int clockValue) throws RemoteException {
        po4 = clockValue;
    }

    @Override
    public int getPO1() throws RemoteException {
        return po1;
    }

    @Override
    public int getPO2() throws RemoteException {
        return po2;
    }

    @Override
    public int getPO3() throws RemoteException {
        return po3;
    }

    @Override
    public int getPO4() throws RemoteException {
        return po4;
    }

    @Override
    public void setPO1Offset(int offsetValue) throws RemoteException {
        po1Offset = offsetValue;
    }

    @Override
    public void setPO2Offset(int offsetValue) throws RemoteException {
        po2Offset = offsetValue;
    }

    @Override
    public void setPO3Offset(int offsetValue) throws RemoteException {
        po3Offset = offsetValue;
    }

    @Override
    public void setPO4Offset(int offsetValue) throws RemoteException {
        po4Offset = offsetValue;
    }

    @Override
    public int getPO1Offset() throws RemoteException {
        return po1Offset;
    }

    @Override
    public int getPO2Offset() throws RemoteException {
        return po2Offset;
    }

    @Override
    public int getPO3Offset() throws RemoteException {
        return po3Offset;
    }

    @Override
    public int getPO4Offset() throws RemoteException {
        return po4Offset;
    }
}
