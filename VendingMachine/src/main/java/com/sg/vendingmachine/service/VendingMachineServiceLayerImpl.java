
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
    
    @Override
    public void vendItem(Item itemCode)
            throws VendingMachineDataValidationException,
            VendingMachinePersistenceException {

        
        if (dao.getItem(itemCode.getItemCode()) != null) {
            throw new VendingMachinePersistenceException(
                    "ERROR: Could not vend.  Item"
                    + itemCode.getItemCode()
                    + " is sold out");
        } 
        validateItemData(itemCode);
        dao.addItem(itemCode.getItemCode(), itemCode); 
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
    ///maybe convert this to vend an item, by code
    @Override
    public Item removeItem(String itemName) 
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException {
        Item updatedItem = null;
        try {
            updatedItem = dao.updateItem(itemName);       
        } catch (VendingMachinePersistenceException e) {
            Logger.getLogger(VendingMachineServiceLayerImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return updatedItem;
    }
    
      private void validateItemData(Item item) throws
            VendingMachineDataValidationException,
            VendingMachineDataValidationException{

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
      
      public void purchaseItem(String itemCode){
          view.getItemCodeChoice();
          view.getItemCode();
          
      }
      
      public void refundMoney(BigDecimal refund){
          
      }
    }

