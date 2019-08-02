package exceptions;

public class TrackAlreadyExistExceptions extends Exception {

    private String message;

    public TrackAlreadyExistExceptions() {
    }

    public TrackAlreadyExistExceptions(String message) {
        super(message);
        this.message = message;
                

        }
    }

        




