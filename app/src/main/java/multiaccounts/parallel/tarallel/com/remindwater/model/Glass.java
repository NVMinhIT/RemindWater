package multiaccounts.parallel.tarallel.com.remindwater.model;

/**
 * Created by oanhnov .
 * On 7/15/2019.
 */
public class Glass {
    private int idImage;
    private String Amount;

    public Glass(int idImage, String amount) {
        this.idImage = idImage;
        Amount = amount;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }
}
