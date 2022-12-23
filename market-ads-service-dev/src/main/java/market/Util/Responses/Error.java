package market.Util.Responses;

import org.apache.http.HttpStatus;

public class Error {
    private Integer code;
    private String text;

    public Error() {
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
