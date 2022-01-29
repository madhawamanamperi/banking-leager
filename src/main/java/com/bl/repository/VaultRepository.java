package com.bl.repository;

import com.bl.model.Vault;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.List;

@Repository
public interface VaultRepository extends JpaRepository<Vault, Long> {

    @Lock(LockModeType.PESSIMISTIC_READ)
    Vault getVaultByVaultId(String vaultId);

    List<Vault> getVaultsByCustomer_Id(Long customerId);
}
