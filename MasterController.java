import java.rmi.RemoteException;

public interface MasterController extends java.rmi.Remote{
    public int connect() throws RemoteException;

    public void setMasterClock(int clockValue) throws RemoteException;
    public int getMasterClock() throws RemoteException;

    public void setPO1(int clockValue) throws RemoteException;
    public void setPO2(int clockValue) throws RemoteException;
    public void setPO3(int clockValue) throws RemoteException;
    public void setPO4(int clockValue) throws RemoteException;

    public int getPO1() throws RemoteException;
    public int getPO2() throws RemoteException;
    public int getPO3() throws RemoteException;
    public int getPO4() throws RemoteException;

    public void setPO1Offset(int clockValue) throws RemoteException;
    public void setPO2Offset(int clockValue) throws RemoteException;
    public void setPO3Offset(int clockValue) throws RemoteException;
    public void setPO4Offset(int clockValue) throws RemoteException;

    public int getPO1Offset() throws RemoteException;
    public int getPO2Offset() throws RemoteException;
    public int getPO3Offset() throws RemoteException;
    public int getPO4Offset() throws RemoteException;

}
