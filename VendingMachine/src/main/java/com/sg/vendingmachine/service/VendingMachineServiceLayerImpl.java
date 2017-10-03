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
    Change change;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineView view) {
        this.dao = dao;
        this.view = view;
        this.change = change;

    }

    @Override
    public int vendItem(String itemCode)
            throws VendingMachineDataValidationException,
            VendingMachinePersistenceException, VendingMachineNoItemInInventoryException {
        Item currentItem;
        int itemInventory = 0;
        currentItem = getItem(itemCode);
            /* validateItemData(itemCode);
            
        dao.addItem(itemCode.getItemCode(), itemCode);   */         
        return itemInventory;
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
}
