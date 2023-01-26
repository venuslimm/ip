package duke.task;

import duke.exception.DukeException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents an duke.Event, which is a type of duke.Task that starts at a specific date/time and ends at a specific date/time.
 */
public class Event extends Task {
    protected LocalDateTime startDatetime;
    protected LocalDateTime endDatetime;

    public Event(String description) throws DukeException {
        super(description.split(" /from ")[0]);
        try {
            String datetimes = description.split(" /from ")[1];
            this.startDatetime = parseDatetime(datetimes.split(" /to ")[0]);
            this.endDatetime = parseDatetime(datetimes.split(" /to ")[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("☹ I'm sorry, but Fake duke.duke doesn't know what that means :-(");
        } catch (DateTimeParseException dtpe) {
            throw new DukeException("Invalid datetime format. Please use yyyy-mm-dd HH:mm (E.g. 2019-10-15 18:00).");
        }
    }

    /**
     * Returns the String representation of an duke.Event.
     *
     * @return  String representation of an duke.Event in this format: [E][<status>] <description> (from: <start date/time>
     * to: <end date/time>).
     */
    @Override
    public String toString() {
        return String.format("[E][%c] %s (from: %s to: %s)", this.getStatusIcon(), this.description
                , this.getStringDatetime(this.startDatetime), this.getStringDatetime(this.endDatetime));
    }

    @Override
    public String getRawTask() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return String.format("E ~ %d ~ %s ~ %s ~ %s\n", isDone ? 1 : 0, this.description,
                dtf.format(this.startDatetime), dtf.format(this.endDatetime));
    }
}