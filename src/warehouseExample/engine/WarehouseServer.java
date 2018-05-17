package warehouseExample.engine;

import warehouseExample.compute.WarehouseInt;
import warehouseExample.engine.WarehouseImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Chiara Campagnoli on 11/04/2018.
 */
public class WarehouseServer {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        System.out.println("Constructing new server implementation");
        WarehouseInt server = new WarehouseImpl();


        System.out.println("Binding server implementation to registry");
        Registry registry = null;
        try {
            registry = LocateRegistry.createRegistry(1689);
            //
            //
        } catch (Exception e){
            registry = LocateRegistry.getRegistry(1689);
        }
        //String hostname = "0.0.0.0";

        //String bindLocation = "//" + hostname + ":" + 1689 + "/warehouse";

        registry.bind("warehouse", server);
        //UnicastRemoteObject.exportObject(server, 1689);

        System.out.println("Waiting for invocations from client");
    }
}
