package com.pblgllgs.emailnotification.entity;
/*
 *
 * @author pblgl
 * Created on 08-07-2024
 *
 */

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="processed-events")
public class ProcessedEventEntity implements Serializable {

    private static final long serialVersionUID = 3687553269742697084L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false, unique=true)
    private String messageId;

    @Column(nullable=false)
    private String productId;


    public ProcessedEventEntity() {
    }

    public ProcessedEventEntity(String messageId, String productId) {
        this.messageId = messageId;
        this.productId = productId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }



}
