package LAB6;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface getScoreInterface extends Remote {
    String getScore(String name) throws RemoteException;
}
