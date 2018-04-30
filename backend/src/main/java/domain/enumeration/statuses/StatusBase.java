package domain.enumeration.statuses;

public abstract class StatusBase {
    /**
     * Status
     */
    public Status status;

    public static final class Status implements IStatusCodes {
        private final String text;
        private final int code;


        public Status(String text, int code) {
            this.text = text;
            this.code = code;
        }

        /**
         * Status code
         * @return Code
         */
        public int code() {
            return this.code;
        }

        /**
         * Status code
         * @return Code
         */
        public String text() {
            return this.text;
        }
    }
}