package warehouseExample.client;

import warehouseExample.compute.WarehouseInt;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Chiara Campagnoli on 11/04/2018.
 */
public class WarehouseClient {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(1689);

        System.out.println("Registry bindings:");
        String[] e = registry.list();
        for (int i = 0; i<e.length; i++)
            System.out.println(e[i]);

        String remoteObjectName = "warehouse";
        WarehouseInt centralWarehouse = (WarehouseInt) registry.lookup(remoteObjectName);

        String descr = "Tostapane";
        double price = centralWarehouse.getPrice(descr);
        System.out.println(descr +": " + price);


    }
}
