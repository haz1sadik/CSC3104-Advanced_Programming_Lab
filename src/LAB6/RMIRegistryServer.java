package LAB6;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIRegistryServer {
    public static void main(String[] args) throws RemoteException {
        LocateRegistry.createRegistry(1099);
        while (true) ;
    }
}