package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    VendingMachineDao dao;
    VendingMachineView view;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineView view) {
        this.dao = dao;
        this.view = view;

    }

    public void purchaseItem() throws VendingMachineInsufficientFundsException,
            VendingMachinePersistenceException, VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {
        ///should this method's purpose allow it to be here / or int he controller
        String itemCode = null;
        String itemPrice = null;
        BigDecimal bigPrice;
        view.getItemCode();
        if (dao.getItem(view.getItemCode()) != null) {
            throw new VendingMachinePersistenceException(
                    "ERROR: Could not vend.  Item"
                    + view.getItemCode()
                    + " code is invalid");
        }
        //should I really handle this exception here? 
        //and if not here, then where?
        BigDecimal itemPaid = view.getPayment();
        bigPrice = new BigDecimal(itemPrice);
        if(itemPaid == bigPrice) {
            vendItem(itemCode);           
        }else if (itemPaid != bigPrice) {
            if (itemPaid < bigPrice) {
                throw new VendingMachineInsufficientFundsException(
                        "ERROR: Could not vend.  Money"
                        + view.getPayment()
                        + " paid was not sufficient");
            } else if (itemPaid > bigPrice) {
                refundMoney(itemPaid, itemPrice);
            }        
        }
    }

    //use to update inventory and vend
    @Override
    public void vendItem(String itemCode)
            throws VendingMachineDataValidationException,
            VendingMachinePersistenceException, VendingMachineNoItemInInventoryException {
        int itemInventory;
        view.displayVendItemBanner();

        dao.updateItem(itemCode);

        if (itemInventory == 0) {
            throw new VendingMachineNoItemInInventoryException(
                    "ERROR: Could not vend.  Item"
                    + view.getItemCode()
                    + " is sold out");
        } else if (itemInventory > 0) {
            itemInventory = itemInventory - 1;
            /* validateItemData(itemCode);
        dao.addItem(itemCode.getItemCode(), itemCode);   */
            
            view.displayItem(itemCode);
            view.displayVendSuccessBanner();
        }
    }

    @Override
    public List<Item> getAllItems()
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException {
        try {
            //validateItemData(itemCode);
            dao.getAllItems();

        } catch (VendingMachinePersistenceException e) {
            Logger.getLogger(VendingMachineServiceLayerImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return dao.getAllItems();
    }

    @Override
    public Item getItem(String itemCode)
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException {

        try {
            Item getItem;
            getItem = dao.getItem(itemCode);

        } catch (VendingMachinePersistenceException e) {
            Logger.getLogger(VendingMachineServiceLayerImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return dao.getItem(itemCode);
    }
   

    private void validateItemData(Item item) throws
            VendingMachineDataValidationException,
            VendingMachineDataValidationException {

        /* if (item.getItemName() == null
                || item.getItemName().trim().length() == 0
                || item.getItemPrice() == null
                || item.getItemPrice().trim().length() == 0
                || item.getItemInventory() == null
                || item.getItemInventory().trim().length() == 0
                || item.getItemCode() == null
                || item.getItemCode().trim().length() == 0) {   */
        throw new VendingMachineDataValidationException(
                "");
    }

    public void refundMoney(BigDecimal itemPaid, String itemPrice) {

    }

    @Override
    public void getMoneyInMachine(BigDecimal itemPaid) {
        BigDecimal allMoneyStored;
        BigDecimal storeCash;

    }
}
