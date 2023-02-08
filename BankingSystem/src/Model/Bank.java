package Model;

public class Bank {
    String bankName;
    String address;
    String branchName;
    String IFSC;

    public Bank() {}

    public Bank(String bankName, String address, String branchName, String IFSC) {
        this.bankName = bankName;
        this.address = address;
        this.branchName = branchName;
        this.IFSC = IFSC;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIFSC() {
        return IFSC;
    }

    public void setIFSC(String IFSC) {
        this.IFSC = IFSC;
    }
}
