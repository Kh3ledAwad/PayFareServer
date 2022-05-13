package com.payment.payfareserver.dto;

import com.payment.payfareserver.utilities.SHA256Helper;

import java.util.logging.Logger;

public class BlockchainDTO {
    private static Logger logger = Logger.getLogger(BlockchainDTO.class.getName());

    private  Integer id;
    private  String hash;
    private  String previousHash;
    private  TripDTO trip;
    private  Integer nonce=0;

    private String data;

    public BlockchainDTO(Integer id, String hash, String previousHash, TripDTO trip) {
        this.id = id;
        this.hash = hash;
        this.previousHash = previousHash;
        this.trip = trip;
    }

    public BlockchainDTO() {
    }
    public void generateHash() {

        String dataToHash =  previousHash + Integer.toString(nonce) + data.toString();

        String hashValue = SHA256Helper.generateHash(dataToHash);

        this.hash = hashValue;

    }
    public void incrementNonce() {

        this.nonce++;
    }
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public TripDTO getTrip() {
        return trip;
    }


    public Integer getNonce() {
        return nonce;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public void setTrip(TripDTO trip) {
        this.trip = trip;
    }


    public void setNonce(Integer nonce) {
        this.nonce = nonce;
    }

    @Override
    public String toString() {
        return "BlockchainDto{" +
                "id=" + id +
                ", hash='" + hash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", trip=" + trip +
                ", nonce=" + nonce +
                '}';
    }
}
