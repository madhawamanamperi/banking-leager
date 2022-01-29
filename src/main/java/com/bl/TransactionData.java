package com.bl;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionData {
    private String vaultId;
    private Float amount;
    private String memo;
}
