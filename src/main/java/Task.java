import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a Task added by the user. It has a description attached to it and a isDone status.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks task as done.
     */
    public void mark() {
        this.isDone = true;
    }

    /**
     * Unmarks task as undone.
     */
    public void unmark() {
        this.isDone = false;
    }

    /**
     * Marks done task with X.
     */
    public char getStatusIcon() {
        return (isDone ? 'X' : ' ');
    }

    /**
     * Returns the String representation of a Task.
     *
     * @return  String representation of a Task in this format: [<status>] <description>.
     */
    @Override
    public String toString() {
        return String.format("[%c] %s", this.getStatusIcon(), this.description);
    }

    public LocalDateTime parseDatetime(String input) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime deadline = LocalDateTime.parse(input, formatter);
        return deadline;
    }

    public String getStringDatetime(LocalDateTime datetime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E dd-MM-yyyy HH:mma");
        return datetime.format(formatter);
    }
}
