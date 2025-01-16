package LAB5;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AreaInterface extends Remote {
    public double calcArea(double radius) throws RemoteException;
    public String isRunning() throws RemoteException;
}
