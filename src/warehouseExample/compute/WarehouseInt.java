package warehouseExample.compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Chiara Campagnoli on 11/04/2018.
 */
public interface WarehouseInt extends Remote {
    public double getPrice(String description) throws RemoteException;
}
