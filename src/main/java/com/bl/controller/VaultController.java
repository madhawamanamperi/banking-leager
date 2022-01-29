package com.bl.controller;

import com.bl.TransactionData;
import com.bl.service.VaultService;
import com.bl.util.JsonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class VaultController {
    private static final Logger LOG = LoggerFactory.getLogger(VaultController.class);

    @Autowired
    VaultService vaultService;

    /**
     * Receive money to the vault
     * @param transactionData
     * @return
     */
    @PostMapping("/receive-money")
    public ResponseEntity<?> receiveMoney(@Validated @RequestBody TransactionData transactionData){
        JsonResponse jsonResponse = null;
        try {
            jsonResponse = vaultService.receiveMoney(transactionData);
        }catch (Exception e){
            LOG.error("[receiveMoney] ",e);
            jsonResponse = new JsonResponse();
            jsonResponse.setValid(false);
            jsonResponse.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(jsonResponse);
    }

    /**
     * Send money from vault
     * @param transactionData
     * @return JsonResponse
     */
    @PostMapping("/send-money")
    public ResponseEntity<?> sendMoney(@Validated @RequestBody TransactionData transactionData){
        JsonResponse jsonResponse = null;
        try {
            jsonResponse = vaultService.sendMoney(transactionData);
        }catch (Exception e){
            LOG.error("[sendMoney] ",e);
            jsonResponse = new JsonResponse();
            jsonResponse.setValid(false);
            jsonResponse.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(jsonResponse);
    }

    /**
     * Get customer vaults
     * @param customerId
     * @return List<vault>
     */
    @GetMapping("/customer-vaults/{customerId}")
    public ResponseEntity<?> getCustomerVaults(@PathVariable Long customerId){
        JsonResponse jsonResponse = new JsonResponse();
        try {
            jsonResponse.setData(vaultService.getCustomerVaults(customerId));
            jsonResponse.setValid(true);

        }catch (Exception e){
            LOG.error("[getCustomerVaults] ",e);
            jsonResponse.setValid(false);
            jsonResponse.setMessage("System error");
        }
        return ResponseEntity.ok(jsonResponse);
    }

    /**
     * get a vault
     * @param vaultId
     * @return Vault
     */
    @GetMapping("/vault/{vaultId}")
    public ResponseEntity<?> getVault(@PathVariable Long vaultId){
        JsonResponse jsonResponse = new JsonResponse();
        try {
            jsonResponse.setData(vaultService.getVault(vaultId));
            jsonResponse.setValid(true);

        }catch (Exception e){
            LOG.error("[getVault] ",e);
            jsonResponse.setValid(false);
            jsonResponse.setMessage("System error");
        }
        return ResponseEntity.ok(jsonResponse);
    }

    /**
     * Get all transaction of a vault
     * @param vaultId
     * @return List<Transaction>>
     */
    @GetMapping("/transactions/{vaultId}")
    public ResponseEntity<?> getTransactions(@PathVariable Long vaultId){
        JsonResponse jsonResponse = new JsonResponse();
        try {
            jsonResponse.setData(vaultService.getVaultTransactions(vaultId));
            jsonResponse.setValid(true);

        }catch (Exception e){
            LOG.error("[getTransactions] ",e);
            jsonResponse.setValid(false);
            jsonResponse.setMessage("System error");
        }
        return ResponseEntity.ok(jsonResponse);
    }

    /**
     * get individual trnaaction
     * @param transactionId
     * @return Transaction
     */
    @GetMapping("/transaction/{transactionId}")
    public ResponseEntity<?> getTransaction(@PathVariable Long transactionId){
        JsonResponse jsonResponse = new JsonResponse();
        try {
            jsonResponse.setData(vaultService.getTransaction(transactionId));
            jsonResponse.setValid(true);

        }catch (Exception e){
            LOG.error("[getTransaction] ",e);
            jsonResponse.setValid(false);
            jsonResponse.setMessage("System error");
        }
        return ResponseEntity.ok(jsonResponse);
    }
}
