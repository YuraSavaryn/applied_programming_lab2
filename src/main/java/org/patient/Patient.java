package org.patient;

public class Patient {
    private int id;
    private String surname;
    private String first_name;
    private String middle_name;
    private String address;
    private String telephone;
    private int medicalCardCode;
    private String diagnosis;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public Patient() {}

    public Patient(int id, String surname, String first_name, String middle_name, String address,
                   String telephone, int medical_card_code, String diagnosis) {
        this.id = id;
        this.surname = surname;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.address = address;
        this.telephone = telephone;
        this.medicalCardCode = medical_card_code;
        this.diagnosis = diagnosis;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setMedical_card_code(int medical_card_code) {
        this.medicalCardCode = medical_card_code;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public int getMedical_card_code() {
        return medicalCardCode;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public String toString() {
        return "Patient { "
                + "id: " + getId()
                + " fullName: " + getSurname() + " " + getFirst_name() + " " + getMiddle_name() + " "
                + "address: " + getAddress()
                + " telephone: " + ANSI_BLUE + getTelephone() + ANSI_RESET + " "
                + "medical card code: " + ANSI_RED + getMedical_card_code() + ANSI_RESET
                + " diagnosis: " + ANSI_GREEN + getDiagnosis() + ANSI_RESET
                + " }";
    }
}