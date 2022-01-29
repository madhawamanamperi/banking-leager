package com.bl.model;

import com.bl.enums.TransactionType;
import com.bl.model.AbstractAudiTable;
import com.bl.model.Vault;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "transaction")
@Audited
public class Transaction extends AbstractAudiTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Vault vault;
    private LocalDateTime valueDate;
    private Float amount;
    private Float currentBalance;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private TransactionType transactionType;
    @Column(length = 500)
    private String memo;
}
