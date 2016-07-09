package pl.com.bottega.documentmanagement.api;

/**
 * Created by Beata Iłowiecka on 18.06.2016.
 */
public class SignUpResultDTO {

    private String failureReason;
    private boolean success;

    public SignUpResultDTO() {
        success = true;
    }

    public SignUpResultDTO(String failureReason) {
        this.failureReason = failureReason;
        success = false;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}