package com.bl.service;

import com.bl.TransactionData;
import com.bl.enums.TransactionType;
import com.bl.model.Transaction;
import com.bl.model.Vault;
import com.bl.repository.TransactionRepository;
import com.bl.repository.VaultRepository;
import com.bl.util.JsonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VaultService {
    private static final Logger LOG = LoggerFactory.getLogger(VaultService.class);

    @Autowired
    VaultRepository vaultRepository;
    @Autowired
    TransactionRepository transactionRepository;

    @Transactional
    public JsonResponse receiveMoney(TransactionData transactionData) throws Exception{
        try{
            JsonResponse jsonResponse = new JsonResponse();

            //Validate Transaction amount
            if(transactionData.getAmount() < 0){
                jsonResponse.setValid(false);
                jsonResponse.setMessage("Invalid transaction amount");
            }else{
                //Get vault from vault ID
                Vault vault = vaultRepository.getVaultByVaultId(transactionData.getVaultId());
                if(vault== null){
                    throw new Exception("Invalid vault");
                }else{
                    vault.setBalance(vault.getBalance() + transactionData.getAmount());
                    vaultRepository.save(vault);
                    // Insert transaction details
                    Transaction transaction = new Transaction();
                    transaction.setAmount(transactionData.getAmount());
                    transaction.setCurrentBalance(vault.getBalance());
                    transaction.setMemo(transactionData.getMemo());
                    transaction.setTransactionType(TransactionType.RECEIVE);
                    transaction.setValueDate(LocalDateTime.now());
                    transaction.setVault(vault);
                    transactionRepository.save(transaction);

                    jsonResponse.setValid(true);
                    jsonResponse.setMessage("transaction succeed");
                    jsonResponse.setData(transaction.getId());

                }

            }

            return jsonResponse;

        }catch(Exception e){
            LOG.error(e.getMessage());
            throw e;
        }
    }

    @Transactional
    public JsonResponse sendMoney(TransactionData transactionData) throws Exception{
        try{
            JsonResponse jsonResponse = new JsonResponse();

            //Validate Transaction amount
            if(transactionData.getAmount() < 0){
                jsonResponse.setValid(false);
                jsonResponse.setMessage("Invalid transaction amount");
            }else{
                //Get vault from vault ID
                Vault vault = vaultRepository.getVaultByVaultId(transactionData.getVaultId());
                if(vault== null){
                    throw new Exception("Invalid vault");
                }else if(vault.getBalance() < transactionData.getAmount()){
                    throw new Exception("Insufficient amount");
                }else{
                    vault.setBalance(vault.getBalance() - transactionData.getAmount());
                    vaultRepository.save(vault);
                    // Insert transaction details
                    Transaction transaction = new Transaction();
                    transaction.setAmount(transactionData.getAmount());
                    transaction.setCurrentBalance(vault.getBalance());
                    transaction.setMemo(transactionData.getMemo());
                    transaction.setTransactionType(TransactionType.SEND);
                    transaction.setValueDate(LocalDateTime.now());
                    transaction.setVault(vault);
                    transactionRepository.save(transaction);

                    jsonResponse.setValid(true);
                    jsonResponse.setMessage("transaction succeed");
                    jsonResponse.setData(transaction.getId());

                }

            }

            return jsonResponse;

        }catch(Exception e){
            LOG.error(e.getMessage());
            throw e;
        }
    }

    public List<Vault> getCustomerVaults(long customerId) throws Exception{
        try{
           return vaultRepository.getVaultsByCustomer_Id(customerId);
        }catch(Exception e){
            LOG.error(e.getMessage());
            throw e;
        }
    }

    public Vault getVault(long vaultId) throws Exception{
        try{
            return vaultRepository.getById(vaultId);
        }catch(Exception e){
            LOG.error(e.getMessage());
            throw e;
        }
    }

    public List<Transaction> getVaultTransactions(long vaultId){
        try{
            return transactionRepository.getTransactionsByVault_Id(vaultId);
        }catch(Exception e){
            LOG.error(e.getMessage());
            throw e;
        }
    }

    public Transaction getTransaction(long transactionId){
        try{
            return transactionRepository.getById(transactionId);
        }catch(Exception e){
            LOG.error(e.getMessage());
            throw e;
        }
    }
}
