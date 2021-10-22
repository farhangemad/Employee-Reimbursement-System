package org.example.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * The request entity is established
 */

@Entity
@Table(name="requests")
public class RequestModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    @Column(name="employee_id")
    private Integer employee_id;

    @Column(name="amount")
    private Double amount;

    @Column(name="reason")
    private String reason;

    @CreationTimestamp
    @Column(name="timecreated")
    private Timestamp timecreated;

    @Column(name="approved")
    private Boolean approved;

    @Column(name="approverid")
    private Integer approverid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Timestamp getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(Timestamp timecreated) {
        this.timecreated = timecreated;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Integer getApproverid() {
        return approverid;
    }

    public void setApproverid(Integer approverid) {
        this.approverid = approverid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", employee_id='" + employee_id + '\'' +
                ", amount='" + amount + '\'' +
                ", reason='" + reason + '\'' +
                ", timecreated='" + timecreated + '\'' +
                ", approved='" + approved + '\'' +
                ", approverid=" + approverid +
                '}';
    }
}
