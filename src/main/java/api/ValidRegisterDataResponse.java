package api;

public class ValidRegisterDataResponse {
    private boolean type;
    private String text;

    public ValidRegisterDataResponse() {
    }

    public ValidRegisterDataResponse(boolean type, String text) {
        this.type = type;
        this.text = text;
    }

    public boolean isType() {
        return type;
    }

    public String getText() {
        return text;
    }
}
