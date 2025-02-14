package duke.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import duke.exception.DukeException;

public class DeadlineTest {
    @Test
    public void toString_validDateTime_success() throws DukeException {
        assertEquals("[D][ ] return book\n(by: Tue 02-09-2025 12:22)",
                new Deadline("return book /by 2025-09-02 12:22").toString());
    }

    @Test
    public void toString_invalidDateTime_dukeExceptionThrown() {
        try {
            assertEquals("[D][ ] return book\n(by: Tue 02-09-2025 12:22)",
                    new Deadline("return book /by 2025-09-02 12:22:33").toString());
            fail();
        } catch (DukeException e) {
            assertEquals("OOPS!!! Invalid datetime format.\n"
                            + "Please use yyyy-mm-dd HH:mm (E.g. 2019-10-15 18:00).\n",
                    e.getMessage());
        }
    }

    @Test
    public void getRawTask_noTestInput_success() throws DukeException {
        assertEquals("D ~ 0 ~ return book ~ 2025-09-02 12:22\n",
                new Deadline("return book /by 2025-09-02 12:22").getRawTask());
    }
}
