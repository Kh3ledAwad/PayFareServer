package com.payment.payfareserver.dto;

import java.io.Serializable;
import java.util.Objects;

public class QueueDto implements Serializable {
    private final Integer id;
    private final String driverCode;
    private final Integer queueNum;

    public QueueDto(Integer id, String driverCode, Integer queueNum) {
        this.id = id;
        this.driverCode = driverCode;
        this.queueNum = queueNum;
    }

    public Integer getId() {
        return id;
    }

    public String getDriverCode() {
        return driverCode;
    }

    public Integer getQueueNum() {
        return queueNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueueDto entity = (QueueDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.driverCode, entity.driverCode) &&
                Objects.equals(this.queueNum, entity.queueNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, driverCode, queueNum);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "driverCode = " + driverCode + ", " +
                "queueNum = " + queueNum + ")";
    }
}
