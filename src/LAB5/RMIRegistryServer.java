package LAB5;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIRegistryServer {
    public static void main(String[] args) throws RemoteException {
        LocateRegistry.createRegistry(1099);
        System.out.println("RMI Registry Server Running");
        while (true) ;
    }
}