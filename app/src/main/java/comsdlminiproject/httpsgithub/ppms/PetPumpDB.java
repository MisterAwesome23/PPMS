package comsdlminiproject.httpsgithub.ppms;

public class PetPumpDB
{
    String petrolSold, dieselSold, petrolEarn, dieselEarn, totalEarn, date, petrolPrice, dieselPrice;

    public PetPumpDB()
    {

    }

    public PetPumpDB(String petrolSold, String petrolPrice, String dieselSold, String dieselPrice, String petrolEarn, String dieselEarn, String totalEarn, String date)
    {
        this.petrolSold = petrolSold;
        this.petrolPrice = petrolPrice;
        this.dieselSold = dieselSold;
        this.dieselPrice = dieselPrice;
        this.petrolEarn = petrolEarn;
        this.dieselEarn = dieselEarn;
        this.totalEarn = totalEarn;
        this.date = date;
    }


    public String getPetrolSold() {
        return petrolSold;
    }

    public void setPetrolSold(String petrolSold) {
        this.petrolSold = petrolSold;
    }

    public String getDieselSold() {
        return dieselSold;
    }

    public void setDieselSold(String dieselSold) {
        this.dieselSold = dieselSold;
    }

    public String getPetrolEarn() {
        return petrolEarn;
    }

    public void setPetrolEarn(String petrolEarn) {
        this.petrolEarn = petrolEarn;
    }

    public String getDieselEarn() {
        return dieselEarn;
    }

    public void setDieselEarn(String dieselEarn) {
        this.dieselEarn = dieselEarn;
    }

    public String getTotalEarn() {
        return totalEarn;
    }

    public void setTotalEarn(String totalEarn) {
        this.totalEarn = totalEarn;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPetrolPrice() {
        return petrolPrice;
    }

    public void setPetrolPrice(String petrolPrice) {
        this.petrolPrice = petrolPrice;
    }

    public String getDieselPrice() {
        return dieselPrice;
    }

    public void setDieselPrice(String dieselPrice) {
        this.dieselPrice = dieselPrice;
    }
}
