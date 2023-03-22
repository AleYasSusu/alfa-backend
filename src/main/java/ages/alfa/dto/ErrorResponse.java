package ages.alfa.dto;

import lombok.Data;

@Data
public class ErrorResponse<T> {

    private int statusCode;
    private T data;
    private long timeStamp;

    public ErrorResponse() {
        this.timeStamp = System.currentTimeMillis();
    }
}