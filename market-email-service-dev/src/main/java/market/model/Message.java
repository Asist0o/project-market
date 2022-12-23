package market.model;

public class Message {

    private String message;
    private Integer number;

    public Message() {
    }

    public Message(String message, Integer number) {
        this.message = message;
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", number=" + number +
                '}';
    }
}