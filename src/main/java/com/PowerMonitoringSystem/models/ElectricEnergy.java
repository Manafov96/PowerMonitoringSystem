package com.PowerMonitoringSystem.models;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Entity
@Table(name = "electricEnergy")
public class ElectricEnergy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private String sensorID;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;

    private double I1;
    private double I2;
    private double I3;

    private double U1;
    private double U2;
    private double U3;

    private double P;
    private double Q;
    private double F;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getI1() {
        return I1;
    }

    public void setI1(double i1) {
        I1 = i1;
    }

    public String getSensorID() {
        return sensorID;
    }

    public void setSensorID(String sensorID) {
        this.sensorID = sensorID;
    }

    public String getDatetime() {
        Date newDate = new Date(datetime.getTime() - TimeUnit.HOURS.toMillis(3));
        return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(newDate);
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public double getI2() {
        return I2;
    }

    public void setI2(double i2) {
        I2 = i2;
    }

    public double getI3() {
        return I3;
    }

    public void setI3(double i3) {
        I3 = i3;
    }

    public double getU1() {
        return U1;
    }

    public void setU1(double u1) {
        U1 = u1;
    }

    public double getU2() {
        return U2;
    }

    public void setU2(double u2) {
        U2 = u2;
    }

    public double getU3() {
        return U3;
    }

    public void setU3(double u3) {
        U3 = u3;
    }

    public double getP() {
        return P;
    }

    public void setP(double p) {
        P = p;
    }

    public double getQ() {
        return Q;
    }

    public void setQ(double q) {
        Q = q;
    }

    public double getF() {
        return F;
    }

    public void setF(double f) {
        F = f;
    }
}
