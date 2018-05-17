package warehouseExample.engine;

import warehouseExample.compute.WarehouseInt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 * Created by Chiara Campagnoli on 11/04/2018.
 */
public class WarehouseImpl extends UnicastRemoteObject implements WarehouseInt {
    private HashMap<String, Double> products;

    public WarehouseImpl() throws RemoteException {
        products = new HashMap<String, Double>();
        products.put("Tostapane", 25.0);
        products.put("Microonde", 100.0);
    }

    @Override
    public double getPrice(String description) throws RemoteException {
        Double price = products.get(description);
        if (price != null)
            return price;
        else
            return 0;
    }
}
