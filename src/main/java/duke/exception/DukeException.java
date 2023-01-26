package duke.exception;

/**
 * Provides duke.duke class an Exception.
 */
public class DukeException extends Exception {
    public DukeException(String errMsg) {
        super("☹ OOPS!!! " + errMsg + "\n");
    }
}