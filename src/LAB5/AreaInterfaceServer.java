package LAB5;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class AreaInterfaceServer extends UnicastRemoteObject implements AreaInterface {
    public AreaInterfaceServer() throws RemoteException{
        super();
    }
    public static void main(String[] args) {
        try {
            AreaInterfaceServer obj = new AreaInterfaceServer();
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("AreaInterfaceServer", obj);
            System.out.println("Object registered");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public double calcArea(double radius) throws RemoteException {
        return Math.pow(radius,2) * Math.PI;
    }
    public String isRunning() throws RemoteException{
        return "The server is Running\n";
    }
}
