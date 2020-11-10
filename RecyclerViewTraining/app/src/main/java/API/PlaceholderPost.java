package API;

import java.util.Date;

public class PlaceholderPost {
    private String access_key = "2620f9d9d3160d3ef23a5aefc633e22d";
    private boolean success;
    private String base;
    private int rates;
    private Date timeStamp;

    public String getAccess_key() {
        return access_key;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getBase() {
        return base;
    }

    public int getRates() {
        return rates;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }
}
